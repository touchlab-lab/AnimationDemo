package com.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 1/29/11
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class ListAnimation extends Activity
{
    private ListView listView;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_animation);

        final String[] vals = {"Red", "Green", "Blue", "Sneakers"};
        final ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, new ArrayList(Arrays.asList(vals)));
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(stringArrayAdapter);

        findViewById(R.id.addRow).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                final ArrayAdapter<String> adapter = (ArrayAdapter) listView.getAdapter();

//                listView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(ListAnimation.this, R.anim.layout_animation_table));
                final ArrayAdapter adapter1 = (ArrayAdapter) listView.getAdapter();
                adapter1.add(Long.toString(System.currentTimeMillis()));
                adapter1.notifyDataSetChanged();
            }
        });
    }

    public static void callMe(Context c)
    {
        c.startActivity(new Intent(c, ListAnimation.class));
    }
}