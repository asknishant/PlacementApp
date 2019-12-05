package com.example.placementapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminAddsTpo extends AppCompatActivity {


    TextView textAddTpo;
    EditText addTpoName,addTpoId,addTpoPassword;
    Button adminAddTpo;


    String name,id,password;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_adds_tpo);

        textAddTpo=findViewById(R.id.textAddTpo);
        addTpoName=findViewById(R.id.addTpoName);
        addTpoId=findViewById(R.id.addTpoId);
        addTpoPassword=findViewById(R.id.addTpoPassword);

        adminAddTpo=findViewById(R.id.btnAddTPO);
        firebaseDatabase=FirebaseDatabase.getInstance();
        myRef=firebaseDatabase.getReference();

        mAuth=FirebaseAuth.getInstance();


        adminAddTpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=addTpoName.getText().toString();
                id=addTpoId.getText().toString();
                password=addTpoPassword.getText().toString();


                if(name.isEmpty())
                {
                    addTpoName.setError("Enter Name");
                    addTpoName.requestFocus();
                    return;
                }
                if(id.isEmpty())
                {
                    addTpoName.setError("Enter Id");
                    addTpoName.requestFocus();
                    return;
                }
                if(password.isEmpty())
                {
                    addTpoName.setError("Enter Password");
                    addTpoName.requestFocus();
                    return;
                }

                myRef=myRef.child("TPO").child(name);

                TpoDetails tpoDetails=new TpoDetails();
                tpoDetails.setId(id);
                tpoDetails.setPassword(password);

                myRef.setValue(tpoDetails);



                mAuth.createUserWithEmailAndPassword(id,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(AdminAddsTpo.this,"User create Successful",Toast.LENGTH_SHORT).show();

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
