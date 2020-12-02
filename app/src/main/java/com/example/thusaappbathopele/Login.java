package com.example.thusaappbathopele;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText Username, Password;
    TextView NewUser;
    Button LoginIn;
    Spinner user ;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Username = findViewById(R.id.emailAddress);
        Password = findViewById(R.id.password);
        user = findViewById(R.id.userType);

        NewUser = findViewById(R.id.createAccount);
        LoginIn = findViewById(R.id.sign_in);
        firebaseAuth = FirebaseAuth.getInstance();


        LoginIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = Username.getText().toString().trim();
                String password = Password.getText().toString().trim();


                if (TextUtils.isEmpty(email)) {
                    Username.setError("Email is Required!");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Password.setError("Password is Required");
                } else if (password.length() <= 7) {
                    Password.setError("Incorrect password Details");
                }
                user.getSelectedItem().toString();

                if(user.getSelectedItem().equals("Parent")){
                    firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Login.this, "You Have Logged Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),StudentPortal.class));
                            } else {
                                Toast.makeText(Login.this, "Wrong User Email or Password Please try Again", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }
                else if(user.getSelectedItem().equals("Teacher")){
                    firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Login.this, "You Have Logged Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),TeacherPortal.class));
                            } else {
                                Toast.makeText(Login.this, "Wrong User Email or Password Please try Again", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }
            }
        });
        NewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Registration.class));
            }
        });

    }
}