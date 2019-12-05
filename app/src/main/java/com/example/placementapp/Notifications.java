package com.example.placementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Notifications extends AppCompatActivity {

    TextView notificationText;
    EditText notification;
    Button addNotifications;

    String notifications;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        notificationText=findViewById(R.id.notificationText);
        notification=findViewById(R.id.notification);
        addNotifications=findViewById(R.id.addNotifications);

        firebaseDatabase=FirebaseDatabase.getInstance();
        myRef=firebaseDatabase.getReference();
        myRef=myRef.child("Notifications");

        addNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                notifications=notification.getText().toString();

                myRef.setValue(notification);

            }
        });



    }
}
