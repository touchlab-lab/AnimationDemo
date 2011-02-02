package com.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 1/31/11
 * Time: 9:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class ActivityTransition extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        findViewById(R.id.rotate).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                callMe(ActivityTransition.this);
            }
        });
    }

    public static void callMe(Activity c)
    {
        c.startActivity(new Intent(c, ActivityTransition.class));
        c.overridePendingTransition(R.anim.scale_in, R.anim.rotate);
    }
}
