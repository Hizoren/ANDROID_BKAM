package com.example.hichampc.bkam_android.ma.bkam.android;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hichampc.bkam_android.R;

import Tabs.SlidingTabLayout;

public class PolitiqueMonetique extends ActionBarActivity {


    private Toolbar toolbar;
    private ViewPager mPager;
    private SlidingTabLayout mTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_politique_monetique);

        toolbar = (Toolbar) findViewById(R.id.app_bar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
            drawerFragment.setUp(R.id.fragment_navigation_drawer,(DrawerLayout)findViewById(R.id.drawer_layout),toolbar);

            mPager = (ViewPager) findViewById(R.id.pager_politique);
            mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
            mTabs = (SlidingTabLayout) findViewById(R.id.politique_sections);
            mTabs.setDistributeEvenly(true);
            mTabs.setCustomTabView(R.layout.custom_tab_view,R.id.tabText);

            mTabs.setBackgroundColor(getResources().getColor(R.color.primaryColor));
            mTabs.setSelectedIndicatorColors(getResources().getColor(R.color.accentColor));
            mTabs.setViewPager(mPager);
        }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_poletique_monetique, menu);
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

    class MyPagerAdapter extends FragmentPagerAdapter {

        String tabText[]; //= getResources().getStringArray(R.array.bkam_sections);;
        /*int tabIcon[] = {R.drawable.actu,R.drawable.agenda,R.drawable.chart};*/

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            tabText = getResources().getStringArray(R.array.politique_sections);

        }

        @Override
        public Fragment getItem(int position) {
            MyFragment myFragment = MyFragment.getInstance(position);
            return myFragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
           /* Drawable drawable = getResources().getDrawable(tabIcon[position]);
            drawable.setBounds(0,0,80,80);
            ImageSpan imageSpan = new ImageSpan(drawable);
            SpannableString spannableString = new SpannableString(" ");
            spannableString.setSpan(imageSpan,0,spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);*/

            return tabText[position];
        }

        @Override
        public int getCount() {
            return 5;
        }
    }

    public static class MyFragment extends Fragment {
        TextView textView;

        public static MyFragment getInstance(int position) {
            MyFragment myFragment = new MyFragment();
            Bundle args = new Bundle();
            args.putInt("position", position);
            myFragment.setArguments(args);
            return myFragment;
        }

        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.fragment_my, container, false);
            textView = (TextView) layout.findViewById(R.id.position);
            Bundle bundle = getArguments();
            if (bundle!=null){
                textView.setText("La page sélectionnée est "+bundle.getInt("position"));
            }
            return layout;
        }
    }

}
