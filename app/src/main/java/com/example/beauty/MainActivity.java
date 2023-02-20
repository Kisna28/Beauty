package com.example.beauty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread th=new Thread()
        {
            public void run()
            {
                try {
                    Thread.sleep(2000);
                }
                catch (Exception e)
                {

                }
                finally {
                    Intent in=new Intent(MainActivity.this,SecondAct.class);
                    startActivity(in);
                }
            }
        };
        th.start();
    }
}