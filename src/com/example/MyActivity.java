package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

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


    }
}
