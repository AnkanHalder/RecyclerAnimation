package com.example.jiraiya.recycler;


import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


import java.util.ArrayList;


public class CustomLoadingProgress2 extends View {

    private Paint rect;
    private float width10,width1,width2,width3,width4,width5,width6,width7,width8,width9,width;
    private float height;
    private ArrayList<Float> list = new ArrayList<Float>();
    private int index=0;
    private boolean i=false,i1=false,i2=false,i3=false,i4=false,rad = true;
    private int index1=36,index2=30,index3=20,index4=10;



    public CustomLoadingProgress2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setUpPaint();
        animation();
    }

    public CustomLoadingProgress2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setUpPaint();
        animation();
    }

    public CustomLoadingProgress2(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setUpPaint();
        animation();
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(rad)
        getRadius();


        if(list.size() > 37) {

            //-------------one--------------
            if(index1 >= list.size()-1){
                index1--;
                i1= true;
            }
            else if( index1 > 0 && index1 < list.size()-1){

                if(i1)
                    index1--;
                else
                    index1++;
            }
            else if(index1 <= 0){

                index1++;
                i1 = false;
            }

            //-------------two--------------
            if(index2 >= list.size()-1){
                index2--;
                i2= true;
            }
            else if( index2 > 0 && index2 < list.size()-1){

                if(i2)
                    index2--;
                else
                    index2++;
            }
            else if(index2 <= 0){

                index2++;
                i2 = false;
            }

            //-------------three--------------

            if(index3 >= list.size()-1){
                index3--;
                i3= true;
            }
            else if( index3 > 0 && index3 < list.size()-1){

                if(i3)
                    index3--;
                else
                    index3++;
            }
            else if(index3 <= 0){

                index3++;
                i3 = false;
            }

            //-------------four--------------

            if(index4 >= list.size()-1){
                index4--;
                i4= true;
            }
            else if( index4 > 0 && index4 < list.size()-1){

                if(i4)
                    index4--;
                else
                    index4++;
            }
            else if(index4 <= 0){

                index4++;
                i4 = false;
            }

            //-------------five--------------
            if(index >= list.size()-1){
                index--;
                i= true;
            }
            else if( index > 0 && index < list.size()-1){

                if(i)
                    index--;
                else
                    index++;
            }
            else if(index <= 0){

                index++;
                i = false;
            }


            canvas.drawRect(width1, height - height *  list.get(index1), width6, height + height *  list.get(index1), rect);
            canvas.drawRect(width2, height - height *  list.get(index2), width7, height + height *  list.get(index2), rect);
            canvas.drawRect(width3, height - height *  list.get(index3), width8, height + height *  list.get(index3), rect);
            canvas.drawRect(width4, height - height *  list.get(index4), width9, height + height *  list.get(index4), rect);
            canvas.drawRect(width5, height - height *  list.get(index), width10, height + height *  list.get(index), rect);


        }
        else{
            canvas.drawRect(width1, height - height *  (float)0.4, width6, height + height *  (float)0.4, rect);
            canvas.drawRect(width2, height - height *  (float)0.35, width7, height + height *  (float)0.35, rect);
            canvas.drawRect(width3, height - height *  (float)0.3, width8, height + height *  (float)0.3, rect);
            canvas.drawRect(width4, height - height *  (float)0.25, width9, height + height *  (float)0.25, rect);
            canvas.drawRect(width5, height - height *  (float)0.2, width10, height + height *  (float)0.2, rect);
        }
        postInvalidate();
    }

    void animation(){
        ValueAnimator animator = ValueAnimator.ofFloat((float)0.2,(float)0.6);
        animator.setDuration(800);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                list.add((float)animation.getAnimatedValue());
            }
        });
        animator.start();
    }

    void setUpPaint(){
        rect = new Paint();
        rect.setColor(Color.GREEN);
        rect.setStrokeWidth(20f);

    }
    void getRadius(){
        width = this.getMeasuredWidth()/2 ;
        height = this.getMeasuredHeight()/2 ;

        width1 = width - width * (float) 0.7;
        width2 = width - width * (float) 0.4;
        width3 = width - width * (float) 0.1;
        width4 = width + width * (float) 0.2;
        width5 = width + width * (float) 0.5;

        width6 = width - width * (float) 0.5;
        width7 = width - width * (float) 0.2;
        width8 = width + width * (float) 0.1;
        width9 = width + width * (float) 0.4;
        width10 = width + width * (float) 0.7;


        rad = false;
    }
}
