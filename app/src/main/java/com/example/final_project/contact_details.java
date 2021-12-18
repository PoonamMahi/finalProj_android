package com.example.final_project;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class contact_details extends AppCompatActivity {

    //creating variables for imageView and textView
    private String contactName, contactNumber;
    private TextView contactTV, nameTV;
    private ImageView contactIV, callIV, messageIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_details);

        contactName = getIntent().getStringExtra("name");
        contactNumber = getIntent().getStringExtra("contact");

        //initializing views
        nameTV = findViewById(R.id.TVName);
        contactIV = findViewById(R.id.IVContact);
        contactTV = findViewById(R.id.TVPhone);
        nameTV.setText(contactName);
        contactTV.setText(contactNumber);
        callIV = findViewById(R.id.IVCall);
        messageIV = findViewById(R.id.IVMessage);

        //adding click listener for calling imageView
        callIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //method to make a call
                makeCall(contactNumber);
            }
        });

        //adding onclick listener for message imageView
        messageIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //method to send message
                sendMessage(contactNumber);
            }
        });
    }

    private void sendMessage(String contactNumber) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + contactNumber));
        intent.putExtra("sms_body", "Enter your messaage");
        startActivity(intent);
    }

    private void makeCall(String contactNumber) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + contactNumber));
        if (ActivityCompat.checkSelfPermission(contact_details.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent);
    }
}


