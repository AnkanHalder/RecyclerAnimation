package com.example.jiraiya.recycler;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;


public class CustomView extends View {

    private int progressBackground;
    private int progressColor;
    private int textColor;
    private String text="Completed";
    private Paint circlePaint;
    private Paint arcPaint;
    private Paint drawText;
    private float sweepAngle=0;
    private float progressBackgroundStroke;
    private float progressStroke;
    private float textSize;
    private float width;
    private float height;
    private float radius ;
    private final String TAG ="CUSTOM_VIEW";
    int change;


    public CustomView(Context context, AttributeSet attrs){
        super(context,attrs);
        applyAttributes(context,attrs);
        setUpPaint();
    }


    private void applyAttributes(Context context,AttributeSet attributeSet) {
        TypedArray a= context.getTheme()
                .obtainStyledAttributes(attributeSet,R.styleable.CustomView,0,0);
        try {
            text = a.getString(R.styleable.CustomView_text);
            progressBackground = a.getColor(R.styleable.CustomView_progressBackgroundColor,Color.GRAY);
            progressColor = a.getColor(R.styleable.CustomView_progressColor,Color.YELLOW);
            textColor = a.getColor(R.styleable.CustomView_textColor,Color.BLUE);
            progressBackgroundStroke = a.getFloat(R.styleable.CustomView_progressBackgroundStroke,50f);
            progressStroke = a.getFloat(R.styleable.CustomView_progressStroke,50);
            textSize = a.getFloat(R.styleable.CustomView_textSize,50*(float)0.4);
          //  Log.d(TAG,"applyAttributes");

        }finally {
            a.recycle();
        }

    }

    private void setUpPaint() {
        setupCirclePaint();
        setUpArcPaint();
        setUpText();
        animation();
     //   Log.d(TAG,"setUpPaint");
    }

    private void setUpText() {
        drawText = new Paint();
        drawText.setColor(textColor);
        drawText.setTextAlign(Paint.Align.CENTER);
        drawText.setTextSize(textSize);
        drawText.setFakeBoldText(true);
      //  Log.d(TAG,"setUpText");

    }

    private void setupCirclePaint() {
        circlePaint = new Paint();
        circlePaint.setColor(progressBackground);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeWidth(progressBackgroundStroke);
      //  Log.d(TAG,"setupCirclePaint");
    }

    private void setUpArcPaint() {
        arcPaint = new Paint();
        arcPaint.setColor(progressColor);
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setStrokeCap(Paint.Cap.ROUND);
        arcPaint.setStrokeWidth(progressStroke);
      //  Log.d(TAG,"setUpArcPaint");

    }

    void getRadius(){
      //  Log.d(TAG,"getRadius");
        width = this.getMeasuredWidth()/2 ;
        height = this.getMeasuredHeight()/2;
      //  Log.d(TAG,"Width "+width);
     //   Log.d(TAG,"Height "+height);
        if(width>height)
            radius=height;
        else
            radius=width;
        radius-=30;
        textSize =radius*(float)0.2;
        drawText.setTextSize(textSize);
      //  Log.d(TAG,"Radius "+radius);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        text = "Completed";
        getRadius();
        canvas.drawCircle(width,height,radius,circlePaint);
        canvas.drawText(text+" "+(int)completed(sweepAngle) +"%", width, height, drawText);
        canvas.drawArc(width-radius,height-radius,width+radius,
                height+radius,-90,
                sweepAngle,false,arcPaint);

//        if(sweepAngle <360){
//            sweepAngle++;
//            invalidate();
//
//        }
       // Log.d(TAG,"onDraw ");

    }

    void animation(){
      //  Log.d(TAG,"CALLING Animation IN");
        ValueAnimator animator = ValueAnimator.ofFloat(0, 320);
        animator.setDuration(3000);
        animator.setInterpolator(new OvershootInterpolator(1f));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                sweepAngle = (float) animation.getAnimatedValue();
                Log.d(TAG,"Changing "+sweepAngle);
                invalidate();

            }
        });
        animator.start();
    }

    private float completed(float status){
        return status*(float)(100.0/360.0);
    }

    public int getProgressBackground() {
        return progressBackground;
    }

    public void setProgressBackground(int progressBackground) {
        this.progressBackground = progressBackground;
        invalidate();
        requestLayout();
    }

    public int getProgressColor() {
        return progressColor;
    }

    public void setProgressColor(int progressColor) {
        this.progressColor = progressColor;
        invalidate();
        requestLayout();
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
        invalidate();
        requestLayout();
    }

    public String getText() {
        return text;
    }

    public float getProgressBackgroundStroke() {
        return progressBackgroundStroke;
    }

    public void setProgressBackgroundStroke(float progressBackgroundStroke) {
        this.progressBackgroundStroke = progressBackgroundStroke;
        invalidate();
        requestLayout();
    }

    public float getProgressStroke() {
        return progressStroke;
    }

    public void setProgressStroke(float progressStroke) {
        this.progressStroke = progressStroke;
        invalidate();
        requestLayout();
    }

    public float getTextSize() {
        return textSize;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
        invalidate();
        requestLayout();
    }

    public void setWidth(float width) {
        this.width = width;
        invalidate();
        requestLayout();
    }

    public void setHeight(float height) {
        this.height = height;
        invalidate();
        requestLayout();
    }

    public void setText(String text) {
        this.text = text;
        invalidate();
        requestLayout();
    }

}
