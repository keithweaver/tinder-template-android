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
public class HomeActivity extends Activity{
    public static final String TAG = "";

    //Tabs

    private ActionBar actionBar;
    private HomeTabsAdapter mHomeTabsAdapter;

    //Home Activity
    private ArrayList<String> cardsList;
    private ArrayAdapter<String> mArrayAdapter;
    private int i;
    SwipeFlingAdapterView flingContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_home);

        getActionBar().setDisplayHomeAsUpEnabled(false);

        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);

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
}
