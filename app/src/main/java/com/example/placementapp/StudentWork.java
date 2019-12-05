package com.example.placementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class StudentWork extends AppCompatActivity {

    Button btnNotifications,btnCompanies,btnPapers,btnSelectedStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_work);

        btnNotifications=findViewById(R.id.btnNotifications);
        btnCompanies=findViewById(R.id.btnCompanies);
        btnSelectedStudents=findViewById(R.id.btnSelectedStudents);
        btnPapers=findViewById(R.id.btnPapers);

        btnSelectedStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentWork.this,AddedStudents.class);
                startActivity(intent);
            }
        });

    }
}
