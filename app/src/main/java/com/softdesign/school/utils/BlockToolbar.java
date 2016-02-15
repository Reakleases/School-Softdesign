package com.softdesign.school.utils;

import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;

public class BlockToolbar {
    public static void setDrag(boolean isDrag, AppBarLayout appBar){
        final boolean drag = isDrag;
        /*((CoordinatorLayout.LayoutParams) appBar.getLayoutParams()).setBehavior(new AppBarLayout.Behavior() {});
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) appBar.getLayoutParams();
        AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) lp.getBehavior();
        behavior.setDragCallback(new AppBarLayout.Behavior.DragCallback() {
            @Override
            public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                return drag;
            }
        });*/
        if (ViewCompat.isLaidOut(appBar)) {
            CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBar.getLayoutParams();
            AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) params.getBehavior();
            behavior.setDragCallback(new AppBarLayout.Behavior.DragCallback() {
                @Override
                public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                    return drag;
                }
            });
        }


    }
}