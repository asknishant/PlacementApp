package com.example.placementapp;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    TextView welcome;
    RadioButton rbStudent,rbTPO,rbAdmin;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome=findViewById(R.id.welcomeText);

        rbStudent=findViewById(R.id.rbStudent);
        rbTPO=findViewById(R.id.rbTPO);
        rbAdmin=findViewById(R.id.rbAdmin);

        login=findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(rbAdmin.isChecked())
                {
                    Intent intent= new Intent(MainActivity.this,AdminSignUp.class);
                    startActivity(intent);
                }
                if(rbTPO.isChecked())
                {
                    Intent intent= new Intent(MainActivity.this,TPO.class);
                    startActivity(intent);
                }
                if(rbStudent.isChecked())
                {
                    Intent intent= new Intent(MainActivity.this,Student.class);
                    startActivity(intent);
                }

            }
        });



    }
}

