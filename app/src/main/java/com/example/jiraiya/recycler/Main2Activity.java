package com.example.jiraiya.recycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private CustomView customView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        customView = (CustomView) findViewById(R.id.custom);


    }
}
