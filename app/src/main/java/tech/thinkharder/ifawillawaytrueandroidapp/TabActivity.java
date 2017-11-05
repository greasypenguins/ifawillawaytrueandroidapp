package tech.thinkharder.ifawillawaytrueandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class TabActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(3, false);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tab, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    public static class MealsFragment extends Fragment {

        public MealsFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static MealsFragment newInstance(int position) {
            MealsFragment fragment = new MealsFragment();
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tab_records_meals, container, false);
            return rootView;
        }
    }

    public static class InsulinFragment extends Fragment {

        public InsulinFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static InsulinFragment newInstance(int position) {
            InsulinFragment fragment = new InsulinFragment();
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tab_records_insulin, container, false);
            return rootView;
        }
    }

    public static class BloodSugarFragment extends Fragment {

        public BloodSugarFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static BloodSugarFragment newInstance(int position) {
            BloodSugarFragment fragment = new BloodSugarFragment();
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tab_records_blood_sugar, container, false);
            return rootView;
        }
    }

    public static class MainFragment extends Fragment {

        public MainFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static MainFragment newInstance(int position) {
            MainFragment fragment = new MainFragment();
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tab_main, container, false);

            final Button buttonBloodSugar = rootView.findViewById(R.id.log_blood_sugar);
            buttonBloodSugar.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), AaronMainActivity.class);
                    startActivity(intent);
                }
            });

            final Button buttonBolus = rootView.findViewById(R.id.log_bolus);
            buttonBolus.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), AaronMainActivity.class);
                    startActivity(intent);
                }
            });

            final Button buttonMeal = rootView.findViewById(R.id.log_meal);
            buttonMeal.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), AaronMainActivity.class);
                    startActivity(intent);
                }
            });

            return rootView;
        }
    }

    public static class AlertsFragment extends Fragment {

        public AlertsFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static AlertsFragment newInstance(int position) {
            AlertsFragment fragment = new AlertsFragment();
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_tab_alerts, container, false);

            final Button buttonSetAlarm = rootView.findViewById(R.id.set_alert);
            buttonSetAlarm.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    TimePicker timePicker = rootView.findViewById(R.id.time_picker);
                    String hour = Integer.toString(timePicker.getCurrentHour());
                    String minute = Integer.toString(timePicker.getCurrentMinute());
                    String alertTime = hour + ":" + minute;
                    Snackbar snackbarAlarmSet = Snackbar.make(v, "Alarm set for " + alertTime, Snackbar.LENGTH_SHORT);
                    snackbarAlarmSet.setAction("Action", null);
                    snackbarAlarmSet.show();
                }
            });

            return rootView;
        }
    }

    public static class ContactsFragment extends Fragment {

        public ContactsFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static ContactsFragment newInstance(int position) {
            ContactsFragment fragment = new ContactsFragment();
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tab_contacts, container, false);
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position)
            {
                case 0:
                    return MealsFragment.newInstance(position);
                case 1:
                    return InsulinFragment.newInstance(position);
                case 2:
                    return BloodSugarFragment.newInstance(position);
                case 3:
                    return MainFragment.newInstance(position);
                case 4:
                    return AlertsFragment.newInstance(position);
                case 5:
                    return ContactsFragment.newInstance(position);
                default:
                    return MainFragment.newInstance(position);
            }
        }

        @Override
        public int getCount() {
            // Show 6 total pages.
            return 6;
        }
    }
}
