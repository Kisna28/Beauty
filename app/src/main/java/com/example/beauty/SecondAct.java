package com.example.beauty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.se.omapi.Session;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class SecondAct extends AppCompatActivity {
    Button btnlog,btnfor,btnsin;
    EditText edemail,edps;
    String email=null,ps=null;
    SharedPreferences ses=null;
    public static String sessionName="data";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnlog =findViewById(R.id.btnlog);
        btnsin=findViewById(R.id.btnsin);
        btnsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(SecondAct.this,Singup.class);
                startActivity(in);
            }
        });
        edemail=findViewById(R.id.edemail);
        edps=findViewById(R.id.edps);
        ses=getSharedPreferences(sessionName,MODE_PRIVATE);
        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email=edemail.getText().toString();
                ps=edps.getText().toString();
                if(email.equals(""))
                {
                    edemail.setError("Pls Enter Email");
                }
                else if(ps.equals(""))
                {
                    edps.setError("Pls Enter Password");
                }

                else {
                    SharedPreferences.Editor obj = ses.edit();
                    obj.putString("keyname", email);
                    obj.putString("keyphone", ps);
                    obj.commit();
                    Toast.makeText(SecondAct.this, "Save into Session", Toast.LENGTH_SHORT).show();
                    edemail.setText("");
                        edps.setText("");

                        Intent in=new Intent(SecondAct.this,Thirdact.class);
                        startActivity(in);



                    }
                    }
        });

    }
}