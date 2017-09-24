package com.nowocode.doit.view.create.fragment;

import android.annotation.SuppressLint;
import android.support.v7.widget.CardView;

import com.nowocode.doit.R;
import com.nowocode.doit.view.create.CreateTaskView;
import com.nowocode.doit.view.create.TaskReceiver;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Nowocode
 *         23.09.2017.
 */

@SuppressLint("ValidFragment")
public class ChooseTypeFragment extends AbstractCreateTaskFragment {
    CreateTaskView taskView;
    @BindView(R.id.dailyCard)
    CardView dailyCard;

    @OnClick(R.id.dailyCard)
    public void onDailyClick() {
        receiver.setData(TaskReceiver.TYPE, "daily");
        next();
    }

    @OnClick(R.id.weeklyCard)
    public void onWeeklyClick() {
        receiver.setData(TaskReceiver.TYPE, "weekly");
        next();
    }

    @OnClick(R.id.monthlyCard)
    public void onMonthlyClick() {
        receiver.setData(TaskReceiver.TYPE, "monthly");
        next();
    }

    @OnClick(R.id.yearlyCard)
    public void onYearlyClick() {
        receiver.setData(TaskReceiver.TYPE, "yearly");
        next();
    }

    public ChooseTypeFragment(TaskReceiver receiver) {
        super(receiver, TYPE);
    }

}
