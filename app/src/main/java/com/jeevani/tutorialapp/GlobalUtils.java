package com.jeevani.tutorialapp;

import android.view.View;

/**
 * Created by Jeevani on 5/9/2017.
 */

public class GlobalUtils {

    public interface ItemClikListener {
        void onItemClick(View view, int itemType, int position);
    }

    public static final int TYPE_ADD = 1;

    public interface ButtonClickListener {
        void onButtonClick(View view, int position);
    }
}
