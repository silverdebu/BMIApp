package com.sahajapp.bmiapp;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by abhijitdc on 6/9/16.
 */
public class CommonUtil {

    private static final double lbtokgRate = 0.453592;
    private static final double kgtolbRate = 2.20462;
    private static final double inchtocmRate = 2.54;
    private static final double cmtoinchRate =0.393701;

    public static void showToastMessage(String msg, Context context) {
//        Context context = view.getContext().getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, msg, duration);
        toast.show();
    }

    public static double lbtokg(double lb) {
        return lb * lbtokgRate;
    }

    public static double kgtolb(double kg) {
        return kg * kgtolbRate;
    }

    public static int fttoinch(int ft, int inch) {
        inch = inch + (ft * 12);
        return inch;
    }

    public static double inchtocm(double inch){
        return inch*inchtocmRate;
    }

    public static double cmtoinch(double cm){
            return cm*cmtoinchRate;
    }
}
