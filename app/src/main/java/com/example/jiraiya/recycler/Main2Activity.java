package com.example.jiraiya.recycler;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;


public class Main2Activity extends AppCompatActivity {

    private CustomProgressTry customView;
    Button b1;
    float i=0;
    Runnable runnable;
    Handler handler= new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //b1 = (Button)findViewById(R.id.button);
        //final LoadingProgressDialog loadingProgressDialog = new LoadingProgressDialog(Main2Activity.this);

//        loadingProgressDialog.setOnClickListener(new LoadingProgressDialog.OnClickListener() {
//            @Override
//            public void onResult(boolean result) {
//                if(i==0) {
//                    loadingProgressDialog.setText("This is Zero");
//                    Toast.makeText(Main2Activity.this, loadingProgressDialog.getText(), Toast.LENGTH_SHORT).show();
//                    i=1;
//                }
//                else {
//                    loadingProgressDialog.setText("This is One");
//                    Toast.makeText(Main2Activity.this, loadingProgressDialog.getText(), Toast.LENGTH_SHORT).show();
//                    i=0;
//                }
//            }
//        });

        customView = (CustomProgressTry) findViewById(R.id.custom);

        runnable = new Runnable() {
            @Override
            public void run() {
                if(i>10 && i<15)
                    i+=20;
                if(i>30 && i<45)
                 i+=50;


                customView.setButtomText("Completed " + (int)i + "%");
                customView.animate_to(i);
                i++;
                if(i<101)
                    update();
            }
        };

    }

    void update(){
        handler.postDelayed(runnable,1000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        update();
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }
}
