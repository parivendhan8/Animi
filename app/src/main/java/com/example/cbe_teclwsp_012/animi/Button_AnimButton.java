package com.example.cbe_teclwsp_012.animi;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.cbe_teclwsp_012.extend.AnimButton;


public class Button_AnimButton extends AnimButton {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anim_button);
        binding  = DataBindingUtil.setContentView(this, R.layout.anim_button);

    }
    public void signIn(View view) {
        animateButtonWidth();

    }

}
