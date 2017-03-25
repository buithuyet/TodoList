package com.nowocode.doit.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.nowocode.doit.R;
import com.nowocode.doit.model.Constants;
import com.nowocode.doit.model.util.FontSetter;
import com.nowocode.doit.view.main.MainActivity;

/**
 * Created by Nowocode.
 * /|     |\
 * /  |     | \
 * /  x |     | x\
 * /______|     |___\
 */

public class SplashScreen extends AppCompatActivity{
    private TextView poweredBy,title,subtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // checking if first launch
        if(!getSharedPreferences(Constants.PREF_TAG,MODE_PRIVATE).getBoolean(Constants.PREF_FIRST_LAUNCH,true))
            skipToMainScreen();
        setFirstLaunch();
        setContentView(R.layout.splashscreen);
        poweredBy = (TextView) findViewById(R.id.splashText);
        title = (TextView) findViewById(R.id.splashTitle);
        subtitle = (TextView) findViewById(R.id.splashSubTitle);
        FontSetter.setRobotoThin(poweredBy,this);
        FontSetter.setRobotoThin(title,this);
        FontSetter.setRobotoThin(subtitle,this);
        SystemClock.sleep(3000);
        skipToMainScreen();
    }

    private void skipToMainScreen(){
        startActivity(new Intent(this,MainActivity.class));
    }
    /**
     * Quick & dirty.. No need to create a Presenter for the SplashScreen
     */
    private void setFirstLaunch(){
        getSharedPreferences(Constants.PREF_TAG,MODE_PRIVATE)
                .edit().putBoolean(Constants.PREF_FIRST_LAUNCH,false).apply();
    }
}
