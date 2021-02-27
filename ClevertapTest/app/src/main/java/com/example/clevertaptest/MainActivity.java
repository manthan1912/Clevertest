package com.example.clevertaptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.clevertap.android.sdk.CleverTapAPI;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText email;
    private Button login;
    private Button test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CleverTapAPI clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());
        CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.DEBUG);   //Set Log level to DEBUG log warnings or other important messages

        name = (EditText) findViewById(R.id.uName);
        email = (EditText) findViewById(R.id.uEmail);
        login = (Button) findViewById(R.id.btnLogin);
        test = (Button) findViewById(R.id.btnTest);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              clevertapProfile();

            }
        });
    }
    private void clevertapProfile(){
        // each of the below mentioned fields are optional
        CleverTapAPI clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());
        HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
        profileUpdate.put("Name", "Silver");
        profileUpdate.put("Email", "English");

        clevertapDefaultInstance.pushEvent(String.valueOf(profileUpdate));

    }
}