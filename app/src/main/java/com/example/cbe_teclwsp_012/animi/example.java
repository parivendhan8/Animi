package com.example.cbe_teclwsp_012.animi;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.example.cbe_teclwsp_012.animi.databinding.ActivityExampleBinding;
import com.tooltip.Tooltip;

public class example extends AppCompatActivity {

    private ActivityExampleBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_example);

    }


    public void animateButtonWidth() {
        ValueAnimator animator = ValueAnimator.ofInt(5, binding.button.getMeasuredWidth());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                binding.button.setVisibility(View.VISIBLE);
                int values = (int) animation.getAnimatedValue();
                ViewGroup.LayoutParams params = binding.button.getLayoutParams();
                params.width = values;
                binding.button.requestLayout();

            }
        });

        animator.setDuration(800);
        animator.start();
    }


    public void button(View view) {

        new Tooltip.Builder(binding.button)
                .setText("Hiiii..!")
                .setGravity(Gravity.NO_GRAVITY)
                .setBackgroundColor(getResources().getColor(R.color.material_teal_400))
                .show();
    }

    public void parent(View view) {
        animateButtonWidth();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, Register.class));
        finish();

    }
}
