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
public class YearlyFragment extends AbstractTaskFragment {

    public YearlyFragment(TaskActivity taskActivity) {
        super(yearly_fragment, taskActivity);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}
