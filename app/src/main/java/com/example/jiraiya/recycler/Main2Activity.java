package com.example.jiraiya.recycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

//    private CustomView customView;
    Button b1;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        b1 = (Button)findViewById(R.id.button);
        final LoadingProgressDialog loadingProgressDialog = new LoadingProgressDialog(Main2Activity.this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressDialog.show();
            }
        });

        loadingProgressDialog.setOnClickListener(new LoadingProgressDialog.OnClickListener() {
            @Override
            public void onResult(boolean result) {
                if(i==0) {
                    loadingProgressDialog.setText("This is Zero");
                    Toast.makeText(Main2Activity.this, loadingProgressDialog.getText(), Toast.LENGTH_SHORT).show();
                    i=1;
                }
                else {
                    loadingProgressDialog.setText("This is One");
                    Toast.makeText(Main2Activity.this, loadingProgressDialog.getText(), Toast.LENGTH_SHORT).show();
                    i=0;
                }
            }
        });




//        customView = (CustomView) findViewById(R.id.custom);
//        customView.setText("Success");
//        customView.setInterpolator(new FastOutSlowInInterpolator());
//        customView.setStartValue(0);
//        customView.setEndValue(100);
//        customView.setAnimateToValue(90);
//        customView.setGradient_color2(Color.CYAN);
//        customView.setGradient_color1(Color.DKGRAY);

    }
}
