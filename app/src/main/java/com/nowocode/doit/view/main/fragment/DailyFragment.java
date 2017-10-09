package com.nowocode.doit.view.main.fragment;

import android.annotation.SuppressLint;

import com.nowocode.doit.view.main.TaskActivity;

/**
 * Created by Nowocode.
 * /|     |\
 * /  |     | \
 * /  x |     | x\
 * /______|     |___\
 */

@SuppressLint("ValidFragment")
public class DailyFragment extends AbstractTaskFragment {
    private static DailyFragment instance;



    public DailyFragment(TaskActivity taskActivity) {
        super(daily_fragment, taskActivity);
    }

    @Override
    public void onResume() {
        super.onResume();
        taskActivity.getDailyTasks();
    }

}
