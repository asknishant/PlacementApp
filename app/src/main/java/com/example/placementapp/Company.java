package com.example.placementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Company extends AppCompatActivity {

    TextView addCompanyText;
    EditText companyName;
    Button addcompany;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;

    String company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);

        addCompanyText=findViewById(R.id.addCompanyText);
        companyName=findViewById(R.id.companyName);
        addcompany=findViewById(R.id.addCompany);

        firebaseDatabase=FirebaseDatabase.getInstance();
        myRef=firebaseDatabase.getReference();

        myRef=myRef.child("Company");

        addcompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                company=companyName.getText().toString();
                myRef.setValue(company);

            }
        });
    }
}
