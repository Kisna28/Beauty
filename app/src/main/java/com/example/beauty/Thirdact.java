package com.example.beauty;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.google.android.material.tabs.TabLayout;

public class Thirdact extends TabActivity {
    TabHost TabHostWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdact);
        TabHostWindow = (TabHost)findViewById(android.R.id.tabhost);
        TabHost.TabSpec TabMenu1 = TabHostWindow.newTabSpec("First Tab");
        TabHost.TabSpec TabMenu2 = TabHostWindow.newTabSpec("Second Tab");

        TabMenu1.setIndicator("Women'S");
        TabMenu2.setIndicator("Men'S");

        TabMenu1.setContent(new Intent(this,Womenact.class));
        TabMenu2.setContent(new Intent(this,Menact.class));

        TabHostWindow.addTab(TabMenu1);
        TabHostWindow.addTab(TabMenu2);
    }
}