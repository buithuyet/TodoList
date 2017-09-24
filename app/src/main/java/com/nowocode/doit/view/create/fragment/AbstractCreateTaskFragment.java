package com.nowocode.doit.view.create.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nowocode.doit.R;
import com.nowocode.doit.view.create.TaskReceiver;

import butterknife.ButterKnife;

/**
 * @author Nowocode
 *         23.09.2017.
 */

public abstract class AbstractCreateTaskFragment extends Fragment {
    protected TaskReceiver receiver;
    protected int fragmentType;
    protected static int TYPE = 0;
    protected static int CATEGORY = 1;
    protected static int CONTENT = 2;

    AbstractCreateTaskFragment(TaskReceiver receiver, int fragmentTypeg) {
        this.receiver = receiver;
        this.fragmentType = fragmentTypeg;
    }

    void setContent(int type, String content) {
        receiver.setData(type, content);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutId = fragmentType == TYPE ? R.layout.create_fragment_type :
                fragmentType == CATEGORY ? R.layout.create_fragment_category : 0;
        View v = inflater.inflate(layoutId, container, false);
        ButterKnife.bind(this,v);
        return v;
    }

    void showToast(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }
}
