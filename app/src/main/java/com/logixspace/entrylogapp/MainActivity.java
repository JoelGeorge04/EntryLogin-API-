package com.logixspace.entrylogapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
AppCompatButton b1;
EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        b1=(AppCompatButton) findViewById(R.id.login);
        e1=(EditText)findViewById((R.id.uname));
        e2=(EditText)findViewById((R.id.pass));
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = e1.getText().toString();
                String passw = e2.getText().toString();
                if(userName.equals("admin") && passw.equals("1234")) {
                    Intent i=new Intent(getApplicationContext(), LoggedPage.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Wrong Password or Username!!",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}