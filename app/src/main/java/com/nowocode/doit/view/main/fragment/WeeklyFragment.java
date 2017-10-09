package com.nowocode.doit.view.main.fragment;

import android.annotation.SuppressLint;
import android.widget.Toast;

import com.nowocode.doit.view.main.TaskActivity;

/**
 * Created by Nowocode.
 * /|     |\
 * /  |     | \
 * /  x |     | x\
 * /______|     |___\
 */

@SuppressLint("ValidFragment")
public class WeeklyFragment extends AbstractTaskFragment {

    public WeeklyFragment(TaskActivity taskActivity) {
        super(weekly_fragment, taskActivity);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

}
