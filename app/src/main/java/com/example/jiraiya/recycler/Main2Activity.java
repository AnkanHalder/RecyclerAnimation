package com.example.jiraiya.recycler;

import android.graphics.Color;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
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
        customView.setText("Success");
        customView.setInterpolator(new FastOutSlowInInterpolator());
        customView.setStartValue(0);
        customView.setEndValue(100);
        customView.setAnimateToValue(90);
        customView.setGradient_color2(Color.CYAN);
        customView.setGradient_color1(Color.DKGRAY);

    }
}
