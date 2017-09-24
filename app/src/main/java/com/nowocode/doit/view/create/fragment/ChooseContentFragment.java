package com.nowocode.doit.view.create.fragment;

import android.annotation.SuppressLint;

import com.nowocode.doit.view.create.TaskReceiver;

/**
 * @author Nowocode
 *         24.09.2017.
 */

@SuppressLint("ValidFragment")
public class ChooseContentFragment extends AbstractCreateTaskFragment {

    public ChooseContentFragment(TaskReceiver receiver) {
        super(receiver, CONTENT);
    }
}
