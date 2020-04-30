package fr.point.meetndrink;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignupActivity extends AppCompatActivity {

    EditText username;
    EditText email;
    EditText password;
    EditText confirmpwd;
    Button signup;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        password.setTransformationMethod(new PasswordTransformationMethod());
        confirmpwd = findViewById(R.id.confirmpwd);
        confirmpwd.setTransformationMethod(new PasswordTransformationMethod());
        email = findViewById(R.id.email);
        signup = findViewById(R.id.btnValid);


        firebaseAuth = FirebaseAuth.getInstance();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("") || password.getText().toString().equals("") || confirmpwd.getText().toString().equals("") || email.getText().toString().equals(""))
                {
                    Toast.makeText(SignupActivity.this, "You have to fill all properties", Toast.LENGTH_LONG).show();
                }
                else if(!password.equals(confirmpwd)) {
                    Toast.makeText(SignupActivity.this, "Your passwords must be the same", Toast.LENGTH_LONG).show();
                    email.setText("");
                    password.setText("");
                    confirmpwd.setText("");
                    username.setText("");
                }else if(password.length()<6)
                {
                    Toast.makeText(SignupActivity.this, "Your password needs to be at least 6 characters long !", Toast.LENGTH_LONG).show();
                    email.setText("");
                    password.setText("");
                    confirmpwd.setText("");
                    username.setText("");
                }
                else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches())
                {
                    Toast.makeText(SignupActivity.this,"You must enter a valid Email adress !", Toast.LENGTH_LONG).show();
                }
                else
                {
                    firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(SignupActivity.this, "Registered successfully", Toast.LENGTH_LONG).show();
                                        email.setText("");
                                        password.setText("");
                                        confirmpwd.setText("");
                                        username.setText("");
                                    } else {

                                        Toast.makeText(SignupActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }

            }
        });


    }


}
