package com.example;

import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MyActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViewById(R.id.listAnim).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                ListAnimation.callMe(MyActivity.this);
            }
        });

        findViewById(R.id.formAnim).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                FormAnimation.callMe(MyActivity.this);
            }
        });

        findViewById(R.id.formLayoutAnim).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                FormLayoutAnimation.callMe(MyActivity.this);
            }
        });

        findViewById(R.id.startTransition).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                final ImageView img = (ImageView) findViewById(R.id.transitionImage);
                TransitionDrawable drawable = (TransitionDrawable) img.getDrawable();
                drawable.startTransition(500);
            }
        });

        findViewById(R.id.activityTransition).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                ActivityTransition.callMe(MyActivity.this);
            }
        });

        findViewById(R.id.viewAnimation).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                ViewAnimation.callMe(MyActivity.this);
            }
        });

        findViewById(R.id.viewAnimationClipped).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                ViewAnimationClipped.callMe(MyActivity.this);
            }
        });

        findViewById(R.id.viewScaleExample).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                ViewScaleExample.callMe(MyActivity.this);
            }
        });

        findViewById(R.id.multipleMixed).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                MultipleMixedAnimations.callMe(MyActivity.this);
            }
        });

        findViewById(R.id.frameAnimation).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                FrameAnimation.callMe(MyActivity.this);
            }
        });


    }
}
