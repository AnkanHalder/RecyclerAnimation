package com.example.jiraiya.recycler;


import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;



public class AnimationAlert {

    public static ObjectAnimator fade(View view){

        //Fade IN or OUT
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view,"alpha",0.0f,1.0f);
        alpha.setInterpolator(new FastOutSlowInInterpolator());
        return alpha;

    }

    public static ObjectAnimator scale(View view){

        //Scale
        ObjectAnimator scale = ObjectAnimator.ofPropertyValuesHolder(view,
                PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f),
                PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f));
        scale.setInterpolator(new FastOutSlowInInterpolator());
        return scale;

    }

    public static ObjectAnimator from_left(View view){

        //Left
        ObjectAnimator left = ObjectAnimator.ofPropertyValuesHolder(view,
                PropertyValuesHolder.ofFloat("translationX", -1500,0 ));
        left.setInterpolator(new AnticipateOvershootInterpolator(3f));
        return left;

    }

    public static ObjectAnimator from_right(View view){

        //Right
        ObjectAnimator right = ObjectAnimator.ofPropertyValuesHolder(view,
                PropertyValuesHolder.ofFloat("translationX", 1500,0 ));
        right.setInterpolator(new AnticipateOvershootInterpolator(3f));
        return right;

    }


}
