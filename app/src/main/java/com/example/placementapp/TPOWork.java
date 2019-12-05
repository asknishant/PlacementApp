package com.example.placementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class TPOWork extends AppCompatActivity {

    TextView tpoWork;
    Button addCompany,addNotification,addPapers,addStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpowork);

        tpoWork=findViewById(R.id.tpoWorkPage);
        addCompany=findViewById(R.id.addCompany);
        addNotification=findViewById(R.id.addNotifications);
        addPapers=findViewById(R.id.addPapers);
        addStudents=findViewById(R.id.showSelectedStudents);

        addCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TPOWork.this,Company.class);
                startActivity(intent);
            }
        });

        addNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TPOWork.this,Notifications.class);
                startActivity(intent);
            }
        });

        addPapers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TPOWork.this,Papers.class);
                startActivity(intent);

            }
        });

        addStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TPOWork.this,AddedStudents.class);
                startActivity(intent);
            }
        });


    }
}
