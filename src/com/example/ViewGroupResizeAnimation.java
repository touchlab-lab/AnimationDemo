package com.example;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 1/30/11
 * Time: 11:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class ViewGroupResizeAnimation
{
    int guesstimatedSize;
    protected int duration;
    protected Handler handler;
    protected ViewGroup.LayoutParams layoutParams;
    private Interpolator interpolator;
    private View parent;

    public ViewGroupResizeAnimation(View parent, int duration, int guesstimatedSize)
    {
        this.parent = parent;
        layoutParams = parent.getLayoutParams();
        this.duration = duration;
        this.guesstimatedSize = guesstimatedSize;
        handler = new Handler();
    }

    public void runAnimation(boolean adding)
    {
        handler.post(new ResizeRunnable(parent, adding));
    }

    public Interpolator getInterpolator()
    {
        return interpolator;
    }

    public void setInterpolator(Interpolator interpolator)
    {
        this.interpolator = interpolator;
    }

    protected class ResizeRunnable implements Runnable
    {
        private long startTime;
        private long refreshTime = 50;
        private View parent;
        private boolean adding;
        private int startHeight;


        protected ResizeRunnable(View parent, boolean adding)
        {
            this.parent = parent;
            this.adding = adding;
            startTime = System.currentTimeMillis();
            startHeight = parent.getHeight();

            parent.setLayoutParams(new LinearLayout.LayoutParams(layoutParams.width, parent.getHeight()));
        }

        public void run()
        {
            final long elapsed = System.currentTimeMillis() - startTime;
            if(elapsed >= duration)
            {
                parent.setLayoutParams(layoutParams);
                return;//Done
            }

            float timelinePoint = (float) elapsed / (float) duration;
            if(interpolator != null)
                timelinePoint = interpolator.getInterpolation(timelinePoint);


            final int newHeight = adding ? (startHeight + (int) (timelinePoint * guesstimatedSize)) : (startHeight - (int) (timelinePoint * guesstimatedSize));
            parent.setLayoutParams(new LinearLayout.LayoutParams(layoutParams.width, newHeight));
            handler.postDelayed(this, refreshTime);
        }
    }
}
