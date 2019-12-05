package com.example.placementapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Admin extends AppCompatActivity {

    TextView LoginTextAdmin;
    EditText emailAdmin, passwordAdmin;
    Button submitAdmin,signupAdmin;

    String email,password;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        LoginTextAdmin = findViewById(R.id.loginTextAdmin);
        emailAdmin = findViewById(R.id.emailAdmin);
        passwordAdmin = findViewById(R.id.passwordAdmin);

        submitAdmin = findViewById(R.id.submitAdmin);
        signupAdmin=findViewById(R.id.signUpAdmin);
        mAuth = FirebaseAuth.getInstance();

        submitAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email=emailAdmin.getText().toString();
                password=passwordAdmin.getText().toString();

                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful())
                        {
                            Intent intent= new Intent(Admin.this,AdminWork.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(Admin.this,"Email not verified",Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });

        signupAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Admin.this,AdminSignUp.class);
                startActivity(intent);
            }
        });
    }


}

