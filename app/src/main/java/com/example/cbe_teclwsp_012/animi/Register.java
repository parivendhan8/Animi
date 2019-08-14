package com.example.cbe_teclwsp_012.animi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.cbe_teclwsp_012.animi.databinding.AnimRegisterBinding;
import com.example.cbe_teclwsp_012.extend.Peppy;

public class Register extends AppCompatActivity {

    ImageView plus;
    Animation rotate, layout_2_anim;
    LinearLayout layout_1,layout_2 ;
    private AnimRegisterBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anim_register);
        binding = DataBindingUtil.setContentView(this, R.layout.anim_register);

        plus = (ImageView) findViewById(R.id.plus);
        layout_2 = (LinearLayout) findViewById(R.id.layout_2);

        //Animation
        rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        layout_2_anim = AnimationUtils.loadAnimation(Register.this, R.anim.layout_2_anim);


    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void animi() {

        plus.startAnimation(rotate);
        layout_2.startAnimation(layout_2_anim);
        revealButton();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void revealButton() {

        int x = binding.layout2.getWidth();
        int y = binding.layout2.getHeight();
        int startX = (int) (56 / 2 + binding.plus.getX());
        int startY= (int) (56 / 2 + binding.plus.getY());

        float radius = Math.max(x, y) * 1.2f;
        Animator reveal = ViewAnimationUtils.createCircularReveal(binding.layout2, startX, startY, 0, radius);
        reveal.setDuration(1000);
        reveal.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        }); reveal.start();

        layout_2.setVisibility(View.VISIBLE);

    }



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void plus(View view) {
        animi();
    }


    public void register(View view) {
        Peppy.buttonReveal(binding.done);




    }

    public void done(View view) {
        startActivity(new Intent(this, example.class));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, Button_AnimButton.class));
        finish();

    }

    public void buttonLayout(View view) {
    }
}
