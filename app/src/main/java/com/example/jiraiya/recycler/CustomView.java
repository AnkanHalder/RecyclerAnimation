package com.example.jiraiya.recycler;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View {

    private int circleColor,arcColor;
    private String text;
    private Paint circlePaint;
    private Paint arcPaint;
    int sweepAngle=0;


    public CustomView(Context context, AttributeSet attrs){
        super(context,attrs);

        applyAttributes(context,attrs);
        setUpPaint();
    }


    private void applyAttributes(Context context,AttributeSet attributeSet) {
        TypedArray a= context.getTheme()
                .obtainStyledAttributes(attributeSet,R.styleable.CustomView,0,0);
        try {
            text = a.getString(R.styleable.CustomView_circleLable);
            circleColor = a.getInteger(R.styleable.CustomView_circleColor, 0);//0 is default
            arcColor = a.getInteger(R.styleable.CustomView_lableColor, 0);
        }finally {
            a.recycle();
        }

    }

    private void setUpPaint() {
        setupCirclePaint();
        setUpArcPaint();
    }

    private void setupCirclePaint() {
        circlePaint = new Paint();
        circlePaint.setColor(circleColor);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeWidth(70f);
    }

    private void setUpArcPaint() {
        arcPaint = new Paint();
        arcPaint.setColor(arcColor);
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setStrokeCap(Paint.Cap.ROUND);
        arcPaint.setStrokeWidth(40f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = this.getMeasuredWidth()/2;
        int height = this.getMeasuredHeight()/2;

        int radius ;
        if(width>height)
            radius=height-10;
        else
            radius=width-50;

        canvas.drawCircle(width,height,radius,circlePaint);
        canvas.drawArc(width-radius,height-radius,width+radius,
                height+radius,-90,
                sweepAngle,false,arcPaint);

        if(sweepAngle <350){
            sweepAngle++;
            invalidate();
        }

    }

    public int getCircleColor() {
        return circleColor;
    }

    public String getText() {
        return text;
    }

    public int getArcColor() {
        return arcColor;
    }

    public void setLabelColor(int arcColor) {
        this.arcColor = arcColor;
        invalidate();
        requestLayout();
    }

    public void setCircleColor(int circleColor) {
        this.circleColor = circleColor;
        invalidate();
        requestLayout();
    }

    public void setText(String text) {
        this.text = text;
        invalidate();
        requestLayout();
    }

}
