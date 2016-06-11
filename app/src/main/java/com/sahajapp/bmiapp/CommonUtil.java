package com.sahajapp.bmiapp;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Created by abhijitdc on 6/9/16.
 */
public class CommonUtil {

    public static void showToastMessage(String msg,Context context) {
//        Context context = view.getContext().getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, msg, duration);
        toast.show();
    }
}
