package com.example.placementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdminWork extends AppCompatActivity {


    TextView adminPage;
    Button addTpo,addStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_work);

        adminPage=findViewById(R.id.adminPage);
        addTpo=findViewById(R.id.addTpo);
        addStudent=findViewById(R.id.addStudent);

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminWork.this,AdminAddsStudent.class);
                startActivity(intent);
            }
        });

        addTpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminWork.this,AdminAddsTpo.class);
                startActivity(intent);
            }
        });



    }
}
