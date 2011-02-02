package com.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2/1/11
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class FormLayoutAnimation extends Activity
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.form_layout_animation);

        findViewById(R.id.showPassword).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                findViewById(R.id.password).setVisibility(View.VISIBLE);
            }
        });


        findViewById(R.id.addRemovePassword).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                final View pview = findViewById(R.id.password);
                pview.setVisibility(View.VISIBLE);

                final ViewGroup viewGroup = (ViewGroup) findViewById(R.id.formBlock);
                viewGroup.removeView(pview);

                new Handler().postDelayed(new Runnable()
                {
                    public void run()
                    {
                        viewGroup.addView(pview);
                    }
                }, 1000);
            }
        });


    }

    public static void callMe(Context c)
    {
        c.startActivity(new Intent(c, FormLayoutAnimation.class));
    }
}