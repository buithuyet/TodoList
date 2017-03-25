package com.nowocode.doit.model.util;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * He who thinks he can and he who thinks he can't
 * are both usually right
 */

public class FontSetter {


    public static void setRobotoThin(TextView v, Context context){
        try {
            Typeface tf = Typeface.createFromAsset(context.getAssets(),"fonts/Roboto-Thin.ttf");
            v.setTypeface(tf);

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
