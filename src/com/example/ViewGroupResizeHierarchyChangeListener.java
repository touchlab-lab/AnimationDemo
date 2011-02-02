package com.example;

import android.os.Handler;
import android.util.Log;
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
    public ViewGroupResizeHierarchyChangeListener(View parent, int duration)
    {
        super(parent, duration);
    }

    public void onChildViewAdded(View parent, View child)
    {
        final int addingHeight = findViewHeight(child);
        runAnimation(getToHeight() + addingHeight);
    }

    public void onChildViewRemoved(View parent, View child)
    {
        final int addingHeight = findViewHeight(child);
        runAnimation(getToHeight() - addingHeight);
    }

    private int findViewHeight(View child)
    {
        if(child.getMeasuredHeight() == 0)
        {
            child.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        }

        return child.getMeasuredHeight();
    }
}
