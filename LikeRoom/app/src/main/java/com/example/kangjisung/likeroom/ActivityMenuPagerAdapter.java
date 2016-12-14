package com.example.kangjisung.likeroom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.kangjisung.likeroom.FragmentItem.FragmentItemMain;
import com.example.kangjisung.likeroom.FragmentPoint.FragmentPointMain;
import com.example.kangjisung.likeroom.FragmentUser.FragmentUserMain;

public class ActivityMenuPagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public ActivityMenuPagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
    public Fragment getItem(int position)
    {
        switch (position) {
            case 0:
                FragmentItemMain tab1 = new FragmentItemMain();
                return tab1;
            case 1:
                FragmentUserMain tab2 = new FragmentUserMain();
                return tab2;
            case 2:
                FragmentPointMain tab3 = new FragmentPointMain();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}