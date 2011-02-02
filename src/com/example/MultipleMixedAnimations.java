package com.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2/1/11
 * Time: 12:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class MultipleMixedAnimations extends Activity
{
    private View button;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiple_mixed_animations);

        button = findViewById(R.id.movingButton);

        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                button.setOnClickListener(null);
                button.startAnimation(AnimationUtils.loadAnimation(MultipleMixedAnimations.this, R.anim.multiple_mixed_animations));
            }
        });

    }

    public static void callMe(Context c)
    {
        c.startActivity(new Intent(c, MultipleMixedAnimations.class));
    }
}