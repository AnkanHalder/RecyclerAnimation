package com.example.jiraiya.recycler;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
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
    private int animationDuration;
    private float startValue;
    private float endValue;
    private float animateToValue;
    private float difference;
    private float updateText;
    private Shader linearGradientShader;
    private Interpolator interpolator;


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
            textSize = a.getFloat(R.styleable.CustomView_textSize,50*(float)0.5);
            animationDuration = a.getInt(R.styleable.CustomView_animationDuration,2000);
            startValue = a.getFloat(R.styleable.CustomView_startValue,0f);
            endValue = a.getFloat(R.styleable.CustomView_endValue,100f);
            animateToValue = a.getFloat(R.styleable.CustomView_animateToValue,75f);

        }finally {
            a.recycle();
        }

    }

    private void setUpPaint() {
        setupCirclePaint();
        setUpArcPaint();
        setUpText();
        difference =(endValue-startValue);
        Log.d(TAG,":"+difference);
        interpolator = new AccelerateDecelerateInterpolator();
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
        //arcPaint.setColor(progressColor);
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setStrokeCap(Paint.Cap.ROUND);
        arcPaint.setStrokeWidth(progressStroke);
      //  Log.d(TAG,"setUpArcPaint");

    }

    void getRadius(){
        width = this.getMeasuredWidth()/2 ;
        height = this.getMeasuredHeight()/2 ;

        if(width>height)
            radius=height;
        else
            radius=width;
        radius-=60;

        linearGradientShader =new LinearGradient(width -radius,height-radius,width+radius, height+radius,
                Color.BLUE, Color.RED, Shader.TileMode.MIRROR);
        arcPaint.setShader(linearGradientShader);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        getRadius();
        canvas.drawCircle(width,height,radius,circlePaint);
        canvas.drawText("Completed ", width, height-(height*(float) 0.1), drawText);
        canvas.drawText((int)updateText+"%", width, height+(height*(float) 0.2), drawText);
        canvas.drawArc(width-radius,height-radius,width+radius,
                height+radius,-90,
                sweepAngle,false,arcPaint);
    }

    void animation(){

        ValueAnimator animator = ValueAnimator.ofFloat(startValue,animateToValue);
        animator.setDuration(animationDuration);
        animator.setInterpolator(interpolator);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                updateText =(float) animation.getAnimatedValue();
                sweepAngle = completed(updateText);
                invalidate();
            }
        });
        animator.start();
    }


    private float completed(float status){
        return (status-startValue)*(float)(360.0/difference);
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
