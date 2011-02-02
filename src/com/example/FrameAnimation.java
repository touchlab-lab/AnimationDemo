package com.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2/1/11
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class FrameAnimation extends Activity
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_animation);

        findViewById(R.id.startAni).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                final ImageView ani = (ImageView) findViewById(R.id.ani);


                ani.setBackgroundResource(R.drawable.frame_animation);
                final AnimationDrawable animationDrawable = (AnimationDrawable) ani.getBackground();
                animationDrawable.start();
            }
        });
    }

    public static void callMe(Context c)
    {
        c.startActivity(new Intent(c, FrameAnimation.class));
    }
}