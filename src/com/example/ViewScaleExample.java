package com.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 1/31/11
 * Time: 11:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class ViewScaleExample extends Activity
{
    private View scaleMe;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_scale_example);
        scaleMe = findViewById(R.id.scaleMe);

        findViewById(R.id.showNext).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {

                final Animation ani = AnimationUtils.loadAnimation(ViewScaleExample.this, R.anim.view_scale_example_scale_in);
                ani.setAnimationListener(new Animation.AnimationListener()
                {
                    public void onAnimationStart(Animation animation)
                    {
                        scaleMe.setVisibility(View.VISIBLE);
                    }

                    public void onAnimationEnd(Animation animation)
                    {

                    }

                    public void onAnimationRepeat(Animation animation)
                    {

                    }
                });

                scaleMe.startAnimation(ani);
            }
        });

        scaleMe.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                final View animButton = findViewById(R.id.animButton);
                animButton.startAnimation(AnimationUtils.loadAnimation(ViewScaleExample.this, R.anim.view_scale_example_frame_example));
            }
        });
    }

    public static void callMe(Context c)
    {
        c.startActivity(new Intent(c, ViewScaleExample.class));
    }
}