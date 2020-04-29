package fr.point.meetndrink;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class Reservation extends AppCompatActivity {
    private FirebaseFirestore db= FirebaseFirestore.getInstance();
    private CollectionReference reservationsRef = db.collection("reservations");

    private Reservation2Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage_reservation);

        setUpRecyclerView();
    }
    private void setUpRecyclerView(){
        Query query = reservationsRef.orderBy("heure",Query.Direction.DESCENDING );

        FirestoreRecyclerOptions<Reservation2> options = new FirestoreRecyclerOptions.Builder<Reservation2>()
                .setQuery(query,Reservation2.class)
                .build();

        adapter = new Reservation2Adapter(options);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
    @Override
    protected  void onStart() {
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
