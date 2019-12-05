package com.example.placementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminAddsStudent extends AppCompatActivity {

    TextView textAdd;
    EditText studentName,studentId,studentPercentage,studentBranch;
    Button addStudent;

    String name,id,percentage,branch;

    FirebaseDatabase database;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_adds_student);

        studentName=findViewById(R.id.studentName);
        studentId=findViewById(R.id.studentId);
        studentPercentage=findViewById(R.id.studentPercentage);
        studentBranch=findViewById(R.id.studentBranch);

        textAdd=findViewById(R.id.textAdd);
        addStudent=findViewById(R.id.buttonAddStudent);

        database=FirebaseDatabase.getInstance();
        myRef=database.getReference();



        addStudent.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {



                name=studentName.getText().toString();
                id=studentId.getText().toString();
                percentage=studentPercentage.getText().toString();
                branch=studentBranch.getText().toString();



                if(name.isEmpty())
                {
                    studentName.setError("Enter Student Name");
                    studentName.requestFocus();
                }
                if(id.isEmpty())
                {
                    studentId.setError("Enter ID");
                    studentId.requestFocus();
                }
                if(percentage.isEmpty())
                {
                    studentPercentage.setError("Enter Percentage");
                    studentPercentage.requestFocus();
                }
                if(branch.isEmpty())
                {
                    studentPercentage.setError("Enter Branch");
                    studentPercentage.requestFocus();
                }

                myRef=myRef.child("Students Added").child(name);

                StudentDetails studentDetails=new StudentDetails();
                studentDetails.setName(name);
                studentDetails.setId(id);
                studentDetails.setBranch(branch);
                studentDetails.setPercentage(Float.parseFloat(percentage));

                myRef.setValue(studentDetails);

                Toast.makeText(AdminAddsStudent.this,"Student added",Toast.LENGTH_SHORT).show();

            }
        });


    }

}

