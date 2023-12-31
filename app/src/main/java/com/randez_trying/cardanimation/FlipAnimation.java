package com.randez_trying.cardanimation;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class FlipAnimation implements Animation.AnimationListener {
    private Animation animation1;
    private Animation animation2;
    private boolean isBackOfCardShowing = true;
    private ImageView img;
    private Context ctx;
    private FlipEnd flipped;
    private boolean isErr;

    public interface FlipEnd {
        void flipEnd(ImageView img);
    }

    FlipAnimation(Context ctx, boolean isErr, ImageView img) {
        this.img = img;
        this.isErr = isErr;
        this.ctx = ctx;
        flipped = (FlipEnd) ctx;
        animation1 = AnimationUtils.loadAnimation(ctx, R.anim.flip_to_middle);
        animation1.setAnimationListener(this);
        animation2 = AnimationUtils.loadAnimation(ctx, R.anim.flip_from_middle);
        animation2.setAnimationListener(this);

        img.clearAnimation();
        img.setAnimation(animation1);
        img.startAnimation(animation1);
    }

    @Override
    public void onAnimationStart(Animation animation) {}

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == animation1) {
            if (isBackOfCardShowing) {
                if (!isErr) img.setImageResource(R.drawable.check_bg);
                else img.setImageResource(R.drawable.baseline_error_outline_24);
                flipped.flipEnd(img);
            } else img.setImageResource(R.drawable.pay);
            img.clearAnimation();
            img.setAnimation(animation2);
            img.startAnimation(animation2);
        } else isBackOfCardShowing = !isBackOfCardShowing;
    }

    @Override
    public void onAnimationRepeat(Animation animation) {}
}