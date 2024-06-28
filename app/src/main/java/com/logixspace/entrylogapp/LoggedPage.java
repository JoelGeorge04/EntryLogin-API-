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

public class LoggedPage extends AppCompatActivity {
AppCompatButton b1,b2;
EditText e1,e2,e3,e4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_logged_page);
        b1=(AppCompatButton) findViewById(R.id.logout);
        b2=(AppCompatButton) findViewById(R.id.add);
        e1=(EditText) findViewById(R.id.name);
        e2=(EditText) findViewById(R.id.adnum);
        e3=(EditText) findViewById(R.id.sysnum);
        e4=(EditText) findViewById(R.id.dept);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=e1.getText().toString();
                String admi=e2.getText().toString();
                String sysno=e3.getText().toString();
                String deptname=e4.getText().toString();
                Toast.makeText(getApplicationContext(),name+" "+admi+" "+sysno+" "+deptname,Toast.LENGTH_LONG).show();
            }
        });
    }
}