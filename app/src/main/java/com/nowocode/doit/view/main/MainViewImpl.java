package com.nowocode.doit.view.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.nowocode.doit.R;
import com.nowocode.doit.model.repository.database.task.Task;
import com.nowocode.doit.presenter.MainPresenter;
import com.nowocode.doit.presenter.PresenterBuilder;
import com.nowocode.doit.view.create.CreateTaskViewImpl;
import com.nowocode.doit.view.main.fragment.DailyFragment;
import com.nowocode.doit.view.main.fragment.WeeklyFragment;
import com.nowocode.doit.view.main.fragment.YearlyFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/**
 * Created by Nowocode.
 * /|     |\
 * /  |     | \
 * /  x |     | x\
 * /______|     |___\
 */

public class MainViewImpl extends AppCompatActivity implements MainView {
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.container)
    ViewPager mViewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.createTaskFab)
    FloatingActionButton fab;
    private TaskFragment dailyFragment;
    private TaskFragment weeklyFragment;
    private TaskFragment yearlyFragment;
    SectionsPagerAdapter mSectionsPagerAdapter;
    private MainPresenter presenter;

    @OnClick(R.id.createTaskFab)
    void onNewTask() {
        startActivity(new Intent(this, CreateTaskViewImpl.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawUi();
        PresenterBuilder presenterBuilder = PresenterBuilder.createWith(this);
        presenter = (MainPresenter) presenterBuilder.build();
    }

    @Override
    public void drawUi() {
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // todo set TaskFragments

        mSectionsPagerAdapter.addFragment(new DailyFragment(), "Day");
        mSectionsPagerAdapter.addFragment(new WeeklyFragment(), "Week");
        mSectionsPagerAdapter.addFragment(new YearlyFragment(), "Year");
        // Set up the ViewPager with the sections adapter.
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onTaskRemove() {

    }

    @Override
    public void onTaskClicked() {

    }

    @Override
    public Context getContext() {
        return getContext();
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getDailyTasks() {
        presenter.getDailyTasks().subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Task>() {
                    @Override
                    public void accept(Task task) throws Exception {
                        dailyFragment.addTaskToDisplay(task);
                    }
                });
    }

    @Override
    public void getWeeklyTasks() {
        presenter.getWeeklyTasks().subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Task>() {
                    @Override
                    public void accept(Task task) throws Exception {
                        weeklyFragment.addTaskToDisplay(task);
                    }
                });
    }

    @Override
    public void getYearlyTasks() {
        presenter.getYearlyTasks().subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Task>() {
                    @Override
                    public void accept(Task task) throws Exception {
                        yearlyFragment.addTaskToDisplay(task);
                    }
                });
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private ArrayList<Fragment> fragmentArrayList;
        private ArrayList<String> titleList;

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
            fragmentArrayList = new ArrayList<>();
            titleList = new ArrayList<>();
        }

        void addFragment(Fragment fragment, String title) {
            fragmentArrayList.add(fragment);
            titleList.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return fragmentArrayList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }

}
