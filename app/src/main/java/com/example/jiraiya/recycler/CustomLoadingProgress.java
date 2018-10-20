package com.example.jiraiya.recycler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CustomLoadingProgress extends View {

    private Paint arcPaint;
    private float width;
    private float height;
    private float radius;
    private float change = (float) 50.0;
    private  boolean i= false;

    public CustomLoadingProgress(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setUpPaint();
    }

    public CustomLoadingProgress(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setUpPaint();
    }

    public CustomLoadingProgress(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setUpPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getRadius();
        canvas.drawCircle(width,height,change,arcPaint);
        Log.d("WORKING","Inside Radius <"+ change);
        if(change >= 100.0){
            change--;
            i= true;
        }
        else if( change >= 0.0 && change <= 100.0){
            if(i)
                change--;
            else
                change++;
        }
        else if(change <= 0.0){
            change++;
            i = false;
        }

        postInvalidate();
    }

    void setUpPaint(){
        arcPaint = new Paint();
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setStrokeCap(Paint.Cap.ROUND);
        arcPaint.setStrokeWidth(20f);

    }
    void getRadius(){
        width = this.getMeasuredWidth()/2 ;
        height = this.getMeasuredHeight()/2 ;

        if(width>height)
            radius=height;
        else
            radius=width;
    }
}
