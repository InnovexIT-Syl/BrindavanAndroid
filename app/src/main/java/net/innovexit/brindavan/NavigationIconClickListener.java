package net.innovexit.brindavan;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ImageView;

import androidx.annotation.Nullable;


public class NavigationIconClickListener implements View.OnClickListener {

    private final AnimatorSet animatorSet = new AnimatorSet();
    private Context context;
    private View sheet, scrollMenu;
    private Interpolator interpolator;
    private int height;
    private boolean backdropShown = false;
    private Drawable openIcon;
    private Drawable closeIcon;



    public NavigationIconClickListener(
            Context context, View sheet, View scrollMenu, @Nullable Interpolator interpolator,
            @Nullable Drawable openIcon, @Nullable Drawable closeIcon) {
        this.context = context;
        this.sheet = sheet;
        this.scrollMenu = scrollMenu;
        this.interpolator = interpolator;
        this.openIcon = openIcon;
        this.closeIcon = closeIcon;

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
    }

    @Override
    public void onClick(View view) {
        backdropShown = !backdropShown;


        // Cancel the existing animations
        animatorSet.removeAllListeners();
        animatorSet.end();
        animatorSet.cancel();

        updateIcon(view);

        final int translateY = height -
                context.getResources().getDimensionPixelSize(R.dimen.shr_product_grid_reveal_height);

        ObjectAnimator animator = ObjectAnimator.ofFloat(sheet, "translationY", backdropShown ? translateY : 0);
        animator.setDuration(500);
        if (interpolator != null) {
            animator.setInterpolator(interpolator);
        }
        animatorSet.play(animator);
        animator.start();
    }


    private void updateIcon(View view) {
        if (openIcon != null && closeIcon != null) {
            if (!(view instanceof ImageView)) {
                throw new IllegalArgumentException("updateIcon() must be called on an ImageView");
            }
            if (backdropShown) {
                ((ImageView) view).setImageDrawable(closeIcon);
                scrollMenu.setVisibility(View.VISIBLE);
            } else {
                ((ImageView) view).setImageDrawable(openIcon);
                scrollMenu.setVisibility(View.GONE);
            }
        }
    }
}
