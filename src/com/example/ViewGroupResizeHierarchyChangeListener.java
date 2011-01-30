package com.example;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 1/30/11
 * Time: 10:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class ViewGroupResizeHierarchyChangeListener extends ViewGroupResizeAnimation implements ViewGroup.OnHierarchyChangeListener
{
    public ViewGroupResizeHierarchyChangeListener(int guesstimatedSize, int duration, View parent)
    {
        super(parent, duration, guesstimatedSize);
    }

    public void onChildViewAdded(View parent, View child)
    {
        runAnimation(true);
    }

    public void onChildViewRemoved(View parent, View child)
    {
        runAnimation(false);
    }
}
