package com.randez_trying.cardanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class ErrorActivity extends AppCompatActivity implements FlipAnimation.FlipEnd {

    private ImageView payImg;
    private ImageView payError;
    private TextView textStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        payImg = findViewById(R.id.anim_status);
        payError = findViewById(R.id.error);
        textStatus = findViewById(R.id.text_status);
        update();
    }

    private void update() {
        Runnable runnable = () -> new FlipAnimation(ErrorActivity.this, true, payImg);
        new Handler().postDelayed(runnable, 1000);
    }

    @Override
    public void flipEnd(ImageView img) {
        textStatus.setVisibility(View.VISIBLE);
        payImg.setVisibility(View.GONE);
        payError.setVisibility(View.VISIBLE);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
        payError.clearAnimation();
        payError.setAnimation(animation);
        payError.startAnimation(animation);
    }
}