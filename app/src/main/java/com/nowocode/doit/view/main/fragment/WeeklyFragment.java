package com.nowocode.doit.view.main.fragment;

import android.widget.Toast;

/**
 * Created by Nowocode.
 * /|     |\
 * /  |     | \
 * /  x |     | x\
 * /______|     |___\
 */

public class WeeklyFragment extends AbstractTaskFragment {
    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(), "Weekly", Toast.LENGTH_SHORT).show();

    }

}
