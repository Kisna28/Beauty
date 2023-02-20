package com.example.beauty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Singup extends AppCompatActivity {
    Button btnsin2;
    EditText edfirst,edlast,edphone,edemail,edpass,edcpass;
    String first=null,last=null,phone=null,email=null,pass=null,cpass=null;
    SharedPreferences ses=null;
    public static String sessionName="data";
    StringBuffer str;
    CheckBox chmen,chwomen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        btnsin2 =findViewById(R.id.btnsin2);
        edfirst=findViewById(R.id.edfirst);
        edlast=findViewById(R.id.edlast);
        edphone=findViewById(R.id.edphone);
        edemail=findViewById(R.id.edemail);
        edpass=findViewById(R.id.edpass);
        edcpass=findViewById(R.id.edcpass);
        ses=getSharedPreferences(sessionName,MODE_PRIVATE);
        btnsin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                first=edfirst.getText().toString();
                last=edlast.getText().toString();
                email=edemail.getText().toString();
                phone=edphone.getText().toString();
                pass=edpass.getText().toString();
                cpass=edcpass.getText().toString();
                if(first.equals(""))
                {
                    edfirst.setError("Pls Enter Value");
                }
                if(last.equals(""))
                {
                    edlast.setError("Pls Enter Phone");
                }
                if(email.equals(""))
                {
                    edemail.setError("Pls Enter Value");
                }
                if(phone.equals(""))
                {
                    edphone.setError("Pls Enter Phone");
                }
                if(pass.equals(""))
                {
                    edpass.setError("Pls Enter Value");
                }
                if(cpass.equals(""))
                {
                    edcpass.setError("Pls Enter Value");
                }

                else {
                    SharedPreferences.Editor obj = ses.edit();
                    obj.putString("keyname", first);
                    obj.putString("keyname", last);
                    obj.putString("keyname", email);
                    obj.putString("keyname", phone);
                    obj.putString("keyname", pass);
                    obj.putString("keyname", cpass);
                    obj.commit();
                    Toast.makeText(Singup.this, "Save into Session", Toast.LENGTH_SHORT).show();
                    edfirst.setText("");
                    edlast.setText("");
                    edemail.setText("");
                    edphone.setText("");
                    edpass.setText("");
                    edcpass.setText("");
                    Intent in=new Intent(Singup.this,Thirdact.class);
                    startActivity(in);
                    btnsin2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(chmen.isChecked()){
                                str.append(chmen.getText().toString()+",");
                            }
                            if(chwomen.isChecked())
                            {
                                str.append(chwomen.getText().toString()+",");

                            }

                        }
                    });
                }
            }
        });
    }
}