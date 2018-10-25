package com.example.jiraiya.recycler;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomProgressTry extends FrameLayout {

    private CustomView customView;
    private TextView leftTextView = null;
    private TextView rightTextView = null;
    private String topText;
    private String buttomText;


    public CustomProgressTry(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup(context,attrs);
    }

    public CustomProgressTry(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(context,attrs);
    }

    public CustomProgressTry(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setup(context,attrs);
    }

    void setup(Context context,AttributeSet attrs){


        inflate(getContext(), R.layout.custom_text, this);
        customView = (CustomView) findViewById(R.id.circleProgress);
        leftTextView = (TextView) findViewById(R.id.left_text);
        rightTextView = (TextView) findViewById(R.id.right_text);
        leftTextView.setText("ABCD");
        rightTextView.setText("LMNOP");
        if(context == null){
            Log.d("ID ","Context is NULL");
        }
        else
            Log.d("ID ","Context is NOT NULL");
        customView.setup(context,attrs);
        log();

    }

    void log(){
        Log.d("ID ","ID CustomView "+customView);
        Log.d("ID ","ID leftTextView "+leftTextView);
        Log.d("ID ","ID rightTextView "+rightTextView);
    }

    public void animate_to(float val){
        customView.setAnimateToValue(val);
    }


    public String getTopText() {
        return topText;
    }

    public void setTopText(String topText) {
        this.topText = topText;
    }

    public String getButtomText() {
        return buttomText;
    }

    public void setButtomText(String buttomText) {
        this.buttomText = buttomText;
        rightTextView.setText(buttomText);
    }
}
