package com.logixspace.entrylogapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class LoggedPage extends AppCompatActivity {
AppCompatButton b1,b2;
EditText e1,e2,e3,e4;
//api url implementation from backend link
String apiUrl="http://10.0.4.16:3000/api/students";
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
                SharedPreferences p = getSharedPreferences("Log",MODE_PRIVATE);
                SharedPreferences.Editor editor = p.edit();
                editor.clear();
                editor.apply();
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
                //creating JSON object.
                JSONObject student=new JSONObject();
                try {
                    student.put("name",name);
                    student.put("admission_number",admi);
                    student.put("system_number",sysno);
                    student.put("department",deptname);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                //JSON object request creation
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.POST,
                        apiUrl,
                        student,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject jsonObject) {
                                Toast.makeText(getApplicationContext(),"API successfull", Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                Toast.makeText(getApplicationContext(),"API Unsuccessfull", Toast.LENGTH_LONG).show();

                            }
                        }

                );
                //Request queue

                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(jsonObjectRequest);
            }
        });
    }
}