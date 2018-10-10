package com.example.jiraiya.recycler;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;


public class AnimationUtils {

    public static void animate(RecyclerView.ViewHolder holder,boolean goesdown){

        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(holder.itemView,"translationY",goesdown?400:-400,0);
        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(holder.itemView,"translationX",-15,15,-10,10,-5,5,0);
        objectAnimatorX.setDuration(1000);
        objectAnimatorY.setDuration(1200);

        animatorSet.playTogether(objectAnimatorX,objectAnimatorY);
        animatorSet.start();


    }
    public static void animate2(RecyclerView.ViewHolder holder,boolean goesdown){

        //AnimatorSet animatorSet = new AnimatorSet();
        //ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(holder.itemView,"translationY",goesdown?400:-400,0);
        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(holder.itemView,"translationX",goesdown?400:-400,0);
        objectAnimatorX.setDuration(1000);
        objectAnimatorX.start();
       // objectAnimatorY.setDuration(1200);

       // animatorSet.playTogether(objectAnimatorX,objectAnimatorY);
        //animatorSet.start();


    }
}
