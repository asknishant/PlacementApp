package com.example.placementapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.net.URI;

import android.content.Intent;
import android.widget.Toast;

public class Papers extends AppCompatActivity {


    TextView text;
    Button upload,choose;
    private StorageReference mStorageRef;

    public static final int PICK_FILE_REQUEST=234;

    private Uri filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papers);

        mStorageRef=FirebaseStorage.getInstance().getReference();

        text=findViewById(R.id.PapersText);
        upload=findViewById(R.id.uploadBtn);
        choose=findViewById(R.id.choose);


        mStorageRef=mStorageRef.child("Uploaded Data");


        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent();
                intent.setType("application/pdf");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select a File"),PICK_FILE_REQUEST);


            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==PICK_FILE_REQUEST && resultCode==RESULT_OK && data!=null && data.getData()!=null)
        {
            filePath=data.getData();
            Uri file = filePath;

            mStorageRef.child("pdf");
            mStorageRef.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    Toast.makeText(Papers.this,"Upload Successful",Toast.LENGTH_SHORT).show();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Papers.this, "Upload Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
