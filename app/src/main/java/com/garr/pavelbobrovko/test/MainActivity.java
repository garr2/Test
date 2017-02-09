package com.garr.pavelbobrovko.test;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;


public class MainActivity extends Activity {

    public final static String LOG_TAG="log_tag";

    private DrawerLayout dlMain;
    private ListView lvDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private Adapter adapter;
    private Intent intent;
    private FrameLayout flContent;

    private FragmentTransaction ft;
    private FragmentMain fragmentMain;
    private FragmentNews fragmentNews;
    private FragmentCalendar fragmentCalendar;
    private FragmentTablet fragmentTablet;
    private FragmentTeem fragmentTeem;
    private FragmentPhoto fragmentPhoto;
    private FragmentTV fragmentTV;
    private FragmentTickets fragmentTickets;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragmenets();
        intent=new Intent(this,SettingsActivity.class);

        lvDrawer=(ListView)findViewById(R.id.lvDrawer);
        dlMain=(DrawerLayout)findViewById(R.id.dlMain);
        flContent=(FrameLayout)getLastNonConfigurationInstance();
        if (flContent==null) {
            flContent=(FrameLayout)findViewById(R.id.flContent);
            setFragment(fragmentMain);
        }
        adapter=new Adapter(this);

        lvDrawer.setAdapter(adapter);
        lvDrawer.setOnItemClickListener(clickListener);
        drawerToggle=new ActionBarDrawerToggle(this,dlMain,R.drawable.ic_drawer,R.string.drawer_open,
                R.string.drawer_close);

        dlMain.setDrawerListener(drawerToggle);
    }

    private void initFragmenets(){
        fragmentMain=new FragmentMain();
        fragmentNews=new FragmentNews();
        fragmentCalendar=new FragmentCalendar();
        fragmentTablet=new FragmentTablet();
        fragmentTeem=new FragmentTeem();
        fragmentPhoto=new FragmentPhoto();
        fragmentTV=new FragmentTV();
        fragmentTickets=new FragmentTickets();
    }

    private void setFragment(Fragment fragment){
        ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.flContent,fragment);
        ft.commit();
    }

    private ListView.OnItemClickListener clickListener= new ListView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position){
                case 0:
                    setFragment(fragmentMain);
                    break;
                case 1:
                    setFragment(fragmentNews);
                    break;
                case 2:
                    setFragment(fragmentCalendar);
                    break;
                case 3:
                    setFragment(fragmentTablet);
                    break;
                case 4:
                    setFragment(fragmentTeem);
                    break;
                case 5:
                    setFragment(fragmentPhoto);
                    break;
                case 6:
                    setFragment(fragmentTV);
                    break;
                case 7:
                    setFragment(fragmentTickets);
                    break;
                case 8:
                    startActivity(intent);
                    break;
            }
            dlMain.closeDrawer(lvDrawer);
        }
    };

    @Override
    public final Object onRetainNonConfigurationInstance() {
        return flContent;
    }

    public static class FragmentMain extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.d(LOG_TAG, "onCreateView");
            View v = inflater.inflate(R.layout.main_fragment, null);
            return v;
        }
    }
    public static class FragmentNews extends Fragment{

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.d(LOG_TAG, "onCreateView");
            View v = inflater.inflate(R.layout.news_fragment, null);
            return v;
        }
    }

    public static class FragmentCalendar extends Fragment{

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.d(LOG_TAG, "onCreateView");
            View v = inflater.inflate(R.layout.calendar_fragment, null);
            return v;
        }
    }

    public static class FragmentTablet extends Fragment{

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.d(LOG_TAG, "onCreateView");
            View v = inflater.inflate(R.layout.tablet_fragment, null);
            return v;
        }
    }

    public static class FragmentTeem extends Fragment{

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.d(LOG_TAG, "onCreateView");
            View v = inflater.inflate(R.layout.teem_fragment, null);
            return v;
        }
    }

    public static class FragmentPhoto extends Fragment{

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.d(LOG_TAG, "onCreateView");
            View v = inflater.inflate(R.layout.photo_fragment, null);
            return v;
        }
    }

    public static class FragmentTV extends Fragment{

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.d(LOG_TAG, "onCreateView");
            View v = inflater.inflate(R.layout.tv_fragment, null);
            return v;
        }
    }

    public static class FragmentTickets extends Fragment{

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.d(LOG_TAG, "onCreateView");
            View v = inflater.inflate(R.layout.tickets_fragment, null);
            return v;
        }
    }
}
