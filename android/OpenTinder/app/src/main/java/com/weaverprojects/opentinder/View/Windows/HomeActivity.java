package com.weaverprojects.opentinder.View.Windows;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;
import com.weaverprojects.opentinder.R;
import com.weaverprojects.opentinder.View.Adapters.TabsAdapter.HomeTabsAdapter;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Keith on 2015-10-03.
 */
public class HomeActivity extends FragmentActivity implements ActionBar.TabListener{
    public static final String TAG = "";

    //Tabs
    private ViewPager viewPager;
    private ActionBar actionBar;
    private HomeTabsAdapter mHomeTabsAdapter;

    //Home Activity
    private ArrayList<String> cardsList;
    private ArrayAdapter<String> mArrayAdapter;
    private int i;
    @InjectView(R.id.frame) SwipeFlingAdapterView flingContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_home);

        getActionBar().setDisplayHomeAsUpEnabled(false);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        //Add profile button and settings button
        actionBar.addTab(actionBar.newTab().setText("HOME").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("CHATS").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("MOMENTS").setTabListener(this));
        actionBar.setTitle("tinder");
        mHomeTabsAdapter = new HomeTabsAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mHomeTabsAdapter);

        //Home Swipeable cards
        ButterKnife.inject(this);
        cardsList = new ArrayList<>();
        cardsList.add("Card 1");
        cardsList.add("Card 2");
        cardsList.add("Card 3");
        cardsList.add("Card 4");
        cardsList.add("Card 5");
        cardsList.add("Card 6");

        mArrayAdapter = new ArrayAdapter<>(this, R.layout.cards_item, R.id.helloText, cardsList);

        flingContainer.setAdapter(mArrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                cardsList.remove(0);
                mArrayAdapter.notifyDataSetChanged();
            }
            @Override
            public void onLeftCardExit(Object o) {
                Toast.makeText(HomeActivity.this, "Left", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onRightCardExit(Object o) {
                Toast.makeText(HomeActivity.this, "Right", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAdapterAboutToEmpty(int i) {
                cardsList.add("XML ".concat(String.valueOf(i)));
                mArrayAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                i++;
            }
            @Override
            public void onScroll(float v) {
                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(v < 0 ? -v : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(v > 0 ? v : 0);
            }
        });


    }
    @Override
    protected void onPause(){
        super.onPause();
    }
    @Override
    protected void onResume(){
        super.onResume();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
    //---- Tab
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft)
    {
        viewPager.setCurrentItem(tab.getPosition());

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {

            @Override
            public void onPageSelected(int position)
            {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2)
            {
            }

            @Override
            public void onPageScrollStateChanged(int arg0)
            {
            }
        });
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
