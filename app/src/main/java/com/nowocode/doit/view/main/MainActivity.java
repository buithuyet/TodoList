package com.nowocode.doit.view.main;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.nowocode.doit.R;
import com.nowocode.doit.presenter.PresenterBuilder;
import com.nowocode.doit.presenter.MainPresenter;

import java.util.ArrayList;

/**
 * Created by Nowocode.
 * /|     |\
 * /  |     | \
 * /  x |     | x\
 * /______|     |___\
 */

public class MainActivity extends AppCompatActivity implements MainView{
    private TabLayout tabLayout;
    private ViewPager mViewPager;
    private Toolbar toolbar;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private MainPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawUi();
    }

    @Override
    public void drawUi() {
        setContentView(R.layout.main_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("MobileJobr - Balance: $0");
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mSectionsPagerAdapter.addFragment(new Fragment(), "Day");
        mSectionsPagerAdapter.addFragment(new Fragment(), "Week");
        mSectionsPagerAdapter.addFragment(new Fragment(), "Year");
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);

        PresenterBuilder presenterBuilder = PresenterBuilder.createWith(this);
        presenter = (MainPresenter) presenterBuilder.build();
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
