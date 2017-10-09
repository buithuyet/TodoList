package com.nowocode.doit.view.create;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nowocode.doit.R;
import com.nowocode.doit.presenter.PresenterBuilder;
import com.nowocode.doit.presenter.create.CreateTaskPresenter;
import com.nowocode.doit.view.create.fragment.ChooseCategoryFragment;
import com.nowocode.doit.view.create.fragment.ChooseContentFragment;
import com.nowocode.doit.view.create.fragment.ChooseTypeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Nowocode
 *         18.09.2017.
 */

public class CreateTaskViewImpl extends AppCompatActivity implements CreateTaskView, TaskReceiver {

    private CreateTaskPresenter presenter;
    @BindView(R.id.container) FrameLayout container;
    @BindView(R.id.progress) TextView progress;
    private Fragment currentFragment, previousFragment, chooseTypeFragment, chooseCategoryFragment, setContentFragment;
    private int currentPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_view);
        ButterKnife.bind(this);
        PresenterBuilder presenterBuilder = PresenterBuilder.createWith(this);
        presenter = (CreateTaskPresenter) presenterBuilder.build();
        chooseTypeFragment = new ChooseTypeFragment(this);
        chooseCategoryFragment = new ChooseCategoryFragment(this);
        setContentFragment = new ChooseContentFragment(this);
        setChooseTypeFragment();
        drawUi();
    }

    private void drawUi() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, currentFragment
        ).commit();

        progress.setText(currentPage + "/3");
    }

    @Override
    public void onBackPressed() {
        if (previousFragment != null) {
            currentFragment = previousFragment;
            if (currentFragment == chooseCategoryFragment)
                setChooseCategoryFragment();
            else if (currentFragment == setContentFragment)
                setChooseContentFragment();
            else if (currentFragment == chooseTypeFragment)
                setChooseTypeFragment();
            drawUi();
        } else
            super.onBackPressed();

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void nextPage() {
        if (currentFragment == chooseTypeFragment) {
            setChooseCategoryFragment();
        } else if (currentFragment == chooseCategoryFragment) {
            currentFragment = setContentFragment;
            previousFragment = chooseCategoryFragment;
            currentPage = 3;
        }
        drawUi();
    }

    void setChooseTypeFragment() {
        currentFragment = chooseTypeFragment;
        previousFragment = null;
        currentPage = 1;
    }

    void setChooseCategoryFragment() {
        currentFragment = chooseCategoryFragment;
        previousFragment = chooseTypeFragment;
        currentPage = 2;
    }

    void setChooseContentFragment() {
        currentFragment = setContentFragment;
        previousFragment = chooseCategoryFragment;
        currentPage = 3;
    }

    @Override
    public void prevPage() {
        if (currentFragment == chooseTypeFragment) {
            previousFragment = null;
            onBackPressed();
            return;
        } else if (currentFragment == chooseCategoryFragment) {
            currentFragment = chooseTypeFragment;
            currentPage = 1;
        }

        drawUi();
    }

    @Override
    public void createTask() {
        presenter.createTask();
    }

    @Override
    public void onTaskCreated() {
        currentFragment = null;
        previousFragment = null;
        onBackPressed();
    }

    @Override
    public void setData(int type, String content) {
        switch (type) {
            case TaskReceiver.CATEGORY:
                presenter.setCategory(content);
                break;
            case TaskReceiver.DESCRIPTION:
                presenter.setDescription(content);
                break;
            case TaskReceiver.TITLE:
                presenter.setTitle(content);
                break;
            case TaskReceiver.TYPE:
                presenter.setType(content);
                break;
        }
    }
}
