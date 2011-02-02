package com.example;

import android.os.Handler;
import android.util.Log;
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
    int toHeight;
    protected int duration;
    protected Handler handler;
    protected ViewGroup.LayoutParams layoutParams;
    private Interpolator interpolator;
    private View parent;
    private ResizeRunnable runnable;

    public ViewGroupResizeAnimation(View parent, int duration)
    {
        this.parent = parent;
        layoutParams = parent.getLayoutParams();
        this.duration = duration;
        toHeight = parent.getHeight();
        handler = new Handler();
    }

    public synchronized void runAnimation(int toSize)
    {
        this.toHeight = toSize;

        if(runnable == null)
        {
            runnable = new ResizeRunnable();
            handler.post(runnable);
        }
        else
        {
            runnable.init();
        }
    }

    public int getToHeight()
    {
        return toHeight;
    }

    private synchronized void closeAnimation()
    {
        parent.setLayoutParams(layoutParams);
        runnable = null;
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
        private int startHeight;

        public void init()
        {
            startTime = System.currentTimeMillis();
            startHeight = parent.getHeight();
        }

        protected ResizeRunnable()
        {
            parent.setLayoutParams(new LinearLayout.LayoutParams(layoutParams.width, parent.getHeight()));
            init();
        }

        public void run()
        {
            final long elapsed = System.currentTimeMillis() - startTime;
            if(elapsed >= duration)
            {
                closeAnimation();
                return;//Done
            }

            float timelinePoint = (float) elapsed / (float) duration;
            if(interpolator != null)
                timelinePoint = interpolator.getInterpolation(timelinePoint);

            int guesstimatedSize = toHeight - startHeight;
//            final int newHeight = adding ? (startHeight + (int) (timelinePoint * guesstimatedSize)) : (startHeight - (int) (timelinePoint * guesstimatedSize));

            final int newHeight = startHeight + (int) (timelinePoint * guesstimatedSize);
            Log.i("asdf", "guesstimatedSize: "+ guesstimatedSize +"/timelinePoint: "+ timelinePoint +"/newHeight: "+ newHeight);

            parent.setLayoutParams(new LinearLayout.LayoutParams(layoutParams.width, newHeight));
            handler.postDelayed(this, refreshTime);
        }
    }
}
