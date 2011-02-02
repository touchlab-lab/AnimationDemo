package com.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 1/29/11
 * Time: 4:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class FormAnimation extends Activity
{
    public static final int VIEW_ID = 987777;
    public static final int VIEW_ID2 = 987778;
    private Handler handler;
    private ViewGroup formBlock;
    private long startTime;
    private Runnable runnable;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_animation);

//        ((LinearLayout)findViewById(R.id.formBlock)).startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));

        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_view);
//        animation.setAnimationListener(new Animation.AnimationListener()
//        {
//            public void onAnimationStart(Animation animation)
//            {
//                findViewById(R.id.password).setVisibility(View.VISIBLE);
//            }
//
//            public void onAnimationEnd(Animation animation)
//            {
//
//            }
//
//            public void onAnimationRepeat(Animation animation)
//            {
//
//            }
//        });
//        findViewById(R.id.password).startAnimation(animation);

        handler = new Handler();

        formBlock = (ViewGroup)findViewById(R.id.formBlock);

        handler.postDelayed(new Runnable()
        {
            public void run()
            {
                final ViewGroupResizeHierarchyChangeListener resizeAnimation = new ViewGroupResizeHierarchyChangeListener(formBlock, 700);
        resizeAnimation.setInterpolator(new AccelerateInterpolator());
        formBlock.setOnHierarchyChangeListener(resizeAnimation);

        handler.postDelayed(new Runnable()
        {
            public void run()
            {
                formBlock.removeView(findViewById(VIEW_ID));
            }
        }, 3500);

        handler.postDelayed(new Runnable()
        {
            public void run()
            {
                final EditText editText = new EditText(FormAnimation.this);
                editText.setId(VIEW_ID);
                formBlock.addView(editText, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            }
        }, 500);

                handler.postDelayed(new Runnable()
        {
            public void run()
            {
                final EditText editText = new EditText(FormAnimation.this);
                editText.setId(VIEW_ID2);
                formBlock.addView(editText, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            }
        }, 800);
            }
        }, 100);




//        startTime = System.currentTimeMillis();
//
//        runnable = new Runnable()
//        {
//            public void run()
//            {
//                if(System.currentTimeMillis() - startTime < 5000)
//                {
//                    formBlock.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, formBlock.getHeight() + 10));
//                    handler.postDelayed(runnable, 200);
//                }
//            }
//        };
//        handler.postDelayed(runnable, 3000);
    }

    public static void callMe(Context c)
    {
        c.startActivity(new Intent(c, FormAnimation.class));
    }
}