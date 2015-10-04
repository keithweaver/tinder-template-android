package com.weaverprojects.opentinder.View.Adapters.TabsAdapter;




import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.weaverprojects.opentinder.View.Fragments.Convo.ConvoFragment;
import com.weaverprojects.opentinder.View.Fragments.Home.ConvoListFragment;
import com.weaverprojects.opentinder.View.Fragments.Home.HomeFragment;
import com.weaverprojects.opentinder.View.Fragments.Home.MomentsFragment;

/**
 * Created by Keith on 2015-10-03.
 */
public class HomeTabsAdapter extends FragmentPagerAdapter {
    public HomeTabsAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int index)
    {
        switch (index)
        {
            case 0:
                return new HomeFragment();
            case 1:
                return new ConvoListFragment();
            case 2:
                return new MomentsFragment();
        }

        return null;
    }

    @Override
    public int getCount()
    {
        return 3;
    }
}