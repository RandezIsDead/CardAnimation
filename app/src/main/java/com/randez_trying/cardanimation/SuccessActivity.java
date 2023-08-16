package com.randez_trying.cardanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class SuccessActivity extends AppCompatActivity implements FlipAnimation.FlipEnd {

    private ImageView payImg;
    private ImageView paySuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        payImg = findViewById(R.id.anim_status);
        paySuccess = findViewById(R.id.success);
        update();
    }

    private void update() {
        Runnable runnable = () -> new FlipAnimation(SuccessActivity.this, false, payImg);
        new Handler().postDelayed(runnable, 1000);
    }

    @Override
    public void flipEnd(ImageView img) {
        payImg.setVisibility(View.GONE);
        paySuccess.setVisibility(View.VISIBLE);

        if (paySuccess.getDrawable() instanceof AnimatedVectorDrawable) {
            AnimatedVectorDrawable adv = (AnimatedVectorDrawable) paySuccess.getDrawable();
            adv.start();
        }
    }
}