package com.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 1/31/11
 * Time: 10:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class ViewAnimationClipped extends Activity
{
    private Handler handler;
    private View animButton;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_animation_clipped);

        handler = new Handler();

        animButton = findViewById(R.id.animButton);
        animButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                handler.post(new Runnable()
                {
                    public void run()
                    {
                        Toast.makeText(ViewAnimationClipped.this, "Clicked", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        findViewById(R.id.rotate).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                animButton.startAnimation(AnimationUtils.loadAnimation(ViewAnimationClipped.this, R.anim.view_animation_rotate));
            }
        });

        findViewById(R.id.alpha).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                animButton.startAnimation(AnimationUtils.loadAnimation(ViewAnimationClipped.this, R.anim.view_animation_alpha));
            }
        });

        findViewById(R.id.scale).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                animButton.startAnimation(AnimationUtils.loadAnimation(ViewAnimationClipped.this, R.anim.view_animation_scale));
            }
        });


    }

    public static void callMe(Context c)
    {
        c.startActivity(new Intent(c, ViewAnimationClipped.class));
    }
}