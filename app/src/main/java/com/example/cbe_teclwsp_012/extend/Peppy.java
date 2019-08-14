package com.example.cbe_teclwsp_012.extend;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

public class Peppy  {


    public static void buttonReveal(final View view) {
        ValueAnimator animator = ValueAnimator.ofInt(0, view.getMeasuredWidth());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                view.setVisibility(View.VISIBLE);
                int values = (int) animation.getAnimatedValue();
                ViewGroup.LayoutParams params = view.getLayoutParams();
                params.width = values;
                view.requestLayout();

            }
        });

        animator.setDuration(2000);
        animator.start();
    }

}
