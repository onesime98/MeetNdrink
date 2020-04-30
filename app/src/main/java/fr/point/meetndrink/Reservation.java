package fr.point.meetndrink;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Reservation extends AppCompatActivity {
    String nomBar;
    EditText nom, numeroEditText, nbPersEditText, date, heure;
    Button reserve;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        nom = findViewById(R.id.name);
        numeroEditText = findViewById(R.id.numero);
        nbPersEditText = findViewById(R.id.nbrepersonne);
        date = findViewById(R.id.date);
        heure = findViewById(R.id.heure);
        reserve = findViewById(R.id.reservation);
        try {
            Bundle bundle = getIntent().getExtras();
            if (bundle.containsKey("nombar"))
                nomBar = bundle.getString("nombar");

        } catch (NullPointerException e) {
        }


        heure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(Reservation.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                heure.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);

                timePickerDialog.show();

            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(Reservation.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {


                                date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);


                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();
            }
        });

        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                booking(nom.getText().toString().trim(),numeroEditText.getText().toString().trim(),nbPersEditText.getText().toString().trim(),date.getText().toString().trim(),heure.getText().toString().trim());

            }
        });
    }


    private void booking(String name, String numero, String nbPers, String dateBooking, String heureBooking) {
        if (!name.isEmpty() && !numero.isEmpty() && !nbPers.isEmpty() && !dateBooking.isEmpty() && !heureBooking.isEmpty()) {

            FirebaseFirestore db = FirebaseFirestore.getInstance();

            Map<String,Object> reservation = new HashMap<>();
            reservation.put("client",name);
            reservation.put("nombar",nomBar);
            reservation.put("nbpers",nbPers);
            reservation.put("telephone",numero);
            reservation.put("date",dateBooking);
            reservation.put("heure",heureBooking);

            db.collection("reservations").add(reservation)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(getApplicationContext(),"Réservation bien effectuée",Toast.LENGTH_LONG).show();
                            nom.getText().clear();
                            numeroEditText.getText().clear();
                            nbPersEditText.getText().clear();
                            date.getText().clear();
                            heure.getText().clear();


                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(),"Réservation non effectuée, Veuillez réessayer !",Toast.LENGTH_LONG).show();
                    nom.getText().clear();
                    numeroEditText.getText().clear();
                    nbPersEditText.getText().clear();
                    date.getText().clear();
                    heure.getText().clear();

                }
            });

        } else {
            Toast.makeText(getApplicationContext(), "Tous les champs doivent être remplis !", Toast.LENGTH_LONG).show();

        }

    }
}
