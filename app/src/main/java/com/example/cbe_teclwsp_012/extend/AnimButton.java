package com.example.cbe_teclwsp_012.extend;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;

import com.example.cbe_teclwsp_012.animi.R;
import com.example.cbe_teclwsp_012.animi.Register;
import com.example.cbe_teclwsp_012.animi.databinding.AnimButtonBinding;

public abstract class AnimButton extends AppCompatActivity {

    public AnimButtonBinding binding;


    public void animateButtonWidth() {
        ValueAnimator animator = ValueAnimator.ofInt(binding.signIn.getMeasuredWidth(), getfinalWidth());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                int values = (int) animation.getAnimatedValue();
                ViewGroup.LayoutParams params = binding.signIn.getLayoutParams();
                params.width = values;
                binding.signIn.requestLayout();

            }
        });

        animator.setDuration(250);
        animator.start();
        fadeoutText();
    }

    private void fadeoutText() {

        binding.textView.animate().alpha(0f).setDuration(250).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                progressBar();
                nextAction();

            }
        }).start();
    }


    private void progressBar() {

        binding.progressBar.getIndeterminateDrawable().setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_IN);
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    private void nextAction() {

        new Handler().postDelayed(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void run() {
                revealButton();
                fadeoutProgressBar();
                nextActivitydelay();

            }
        }, 1000);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void revealButton() {

        binding.signIn.setElevation(0f);
        binding.revealView.setVisibility(View.VISIBLE);
        int x = binding.revealView.getWidth();
        int y = binding.revealView.getHeight();
        int startX = (int) (getfinalWidth() / 2 + binding.signIn.getX());
        int startY= (int) (getfinalWidth() / 2 + binding.signIn.getY());
        float radius = Math.max(x, y) * 1.2f;
        Animator reveal = ViewAnimationUtils.createCircularReveal(binding.revealView, startX, startY, getfinalWidth(), radius);
        reveal.setDuration(1000);
        reveal.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                finish();
            }
        }); reveal.start();

    }

    public void fadeoutProgressBar()
    {
        binding.progressBar.animate().alpha(0f).setDuration(250).start();
    }

    private void nextActivitydelay() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        }, 100);
    }


    public int getfinalWidth() {
        return (int) getResources().getDimension(R.dimen.get_width);
    }

}
