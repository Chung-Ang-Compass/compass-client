package com.example.compass;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    // Count number of tabs
    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount){
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position){

        //Returning the current tabs
        switch(position){
            case 0:
                PackageSaleTabFragment fragmentEvaluateBoard = new PackageSaleTabFragment();
                return fragmentEvaluateBoard;

            case 1:
                ChattingTabFragment fragmentRecommendBoard = new ChattingTabFragment();
                return fragmentRecommendBoard;

            case 2:
                StreamingTabFragment streamingTabFragment = new StreamingTabFragment();
                return streamingTabFragment;
            case 3:
                ProfileTabFragment infoTabFragment = new ProfileTabFragment();
                return infoTabFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount(){
        return tabCount;
    }

}
