package com.example.placementapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import android.content.Intent;
import android.widget.Toast;

public class TPO extends AppCompatActivity {


    TextView LoginTextTPO;
    EditText emailTpo,passwordTpo;
    Button submitTpo;

    FirebaseAuth mAuth;

    String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpo);

        LoginTextTPO=findViewById(R.id.loginTextTpo);
        emailTpo=findViewById(R.id.emailTpo);
        passwordTpo=findViewById(R.id.passwordTpo);


        submitTpo=findViewById(R.id.submitTpo);




        mAuth=FirebaseAuth.getInstance();



        submitTpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email=emailTpo.getText().toString();
                password=passwordTpo.getText().toString();

                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        if(email.isEmpty())
                        {
                            emailTpo.setError("Enter Email");
                            emailTpo.requestFocus();
                            return;
                        }
                        if(password.isEmpty())
                        {
                            passwordTpo.setError("Enter Password");
                            passwordTpo.requestFocus();
                            return;
                        }


                        if(task.isSuccessful())
                        {
                            Intent intent= new Intent(TPO.this,TPOWork.class);
                            startActivity(intent);
                        }else
                        {
                            Toast.makeText(TPO.this,"incorrect credentials",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }
}
