package com.nowocode.doit.view.create.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.nowocode.doit.R;
import com.nowocode.doit.model.repository.database.task.Task;
import com.nowocode.doit.view.create.TaskReceiver;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.nowocode.doit.model.repository.database.task.Task.CATEGORY.*;

/**
 * @author Nowocode
 *         23.09.2017.
 */

@SuppressLint("ValidFragment")
public class ChooseCategoryFragment extends AbstractCreateTaskFragment {
    @BindView(R.id.healthBlock)
    LinearLayout healthBlock;
    @BindView(R.id.studyBlock)
    LinearLayout studyBlock;
    @BindView(R.id.financeBlock)
    LinearLayout financeBLock;
    @BindView(R.id.loveBlock)
    LinearLayout loveBlock;

    @OnClick(R.id.healthBlock)
    void onSelectHealth() {
        setContent(CATEGORY, HEALTH);
        next();
    }

    @OnClick(R.id.financeBlock)
    void onSelectFinance() {
        setContent(CATEGORY, FINANCE);
        next();
    }

    @OnClick(R.id.studyBlock)
    void onSelectEducation() {
        setContent(CATEGORY, EDU);
        next();
    }

    @OnClick(R.id.loveBlock)
    void onSelectLove() {
        setContent(CATEGORY, LOVE);
        next();
    }

    public ChooseCategoryFragment(TaskReceiver receiver) {
        super(receiver, CATEGORY);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        v.setOnClickListener(new CategoryClicklistener());
        return v;
    }

    class CategoryClicklistener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            System.out.println("CategoryClicklistener.onClick " + view.getId());
            switch (view.getId()) {
                case R.id.healthBlock:
                    receiver.setData(TaskReceiver.CATEGORY, Task.CATEGORY.HEALTH);
                    break;
                case R.id.financeBlock:
                    receiver.setData(TaskReceiver.CATEGORY, Task.CATEGORY.FINANCE);
                    break;
                case R.id.studyBlock:
                    receiver.setData(TaskReceiver.CATEGORY, Task.CATEGORY.EDU);
                    break;
                case R.id.loveBlock:
                    receiver.setData(TaskReceiver.CATEGORY, Task.CATEGORY.LOVE);
                    break;
            }

        }
    }
}
