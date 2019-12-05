package com.example.placementapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class AdminSignUp extends AppCompatActivity {

    TextView signUpAdminText;
    EditText signUpemailAdmin,signUpPasswordAdmin;
    Button loginAdminBtn,signupAdminBtn;

    String email,password;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_up);

        signUpAdminText=findViewById(R.id.adminSignUpPage);
        signUpemailAdmin=findViewById(R.id.signupEmail);
        signUpPasswordAdmin=findViewById(R.id.signupPassword);
        loginAdminBtn=findViewById(R.id.loginBtn);
        signupAdminBtn=findViewById(R.id.signupBtn);

        mAuth=FirebaseAuth.getInstance();



        loginAdminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminSignUp.this,Admin.class);
                startActivity(intent);
            }
        });


        signupAdminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email=signUpemailAdmin.getText().toString();
                password=signUpPasswordAdmin.getText().toString();

                if(email.isEmpty())
                {
                    signUpemailAdmin.setError("Enter Email");
                    signUpemailAdmin.requestFocus();
                    return;
                }
                if(password.isEmpty())
                {
                    signUpPasswordAdmin.setError("Enter Email");
                    signUpPasswordAdmin.requestFocus();
                    return;
                }
                if(password.length()<6)
                {
                    Toast.makeText(AdminSignUp.this,"Password should be minimum of 6 characters",Toast.LENGTH_SHORT).show();

                }


                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(AdminSignUp.this,"User create Successful",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(AdminSignUp.this, AdminWork.class);
                                startActivity(intent);

                            }
                            else{
                                if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                    Toast.makeText(getApplicationContext(),"User already exist",Toast.LENGTH_SHORT).show();
                                }
                                else
                                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();

                            }

                        }
                    });


            }
        });



    }

}
