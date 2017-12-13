package com.example.tablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

/**
 * Created by usuario on 13/12/17.
 */

class ViewPagerAdapter extends FragmentPagerAdapter {

    private int pageCount;

    public ViewPagerAdapter(FragmentManager fragmentManager)
    {
        super(fragmentManager);
    }

    public ViewPagerAdapter(FragmentManager fragmentManager, int pageCount)
    {
        super(fragmentManager);
        this.pageCount = pageCount;
    }

    @Override
    public Fragment getItem(int position) {

        DummyFragment dummyFragment = null;
        Bundle args = new Bundle();

        switch (position)
        {
            case 0:
                args.putString(DummyFragment.KEY_MSG, "Frag 1");
                dummyFragment = DummyFragment.newInstance(args);
                break;
            case 1:
                args.putString(DummyFragment.KEY_MSG, "Frag 2");
                dummyFragment = DummyFragment.newInstance(args);
                break;
            case 2:
                args.putString(DummyFragment.KEY_MSG, "Frag 3");
                dummyFragment = DummyFragment.newInstance(args);
                break;
            case 3:
                args.putString(DummyFragment.KEY_MSG, "Frag 4");
                dummyFragment = DummyFragment.newInstance(args);
                break;
            case 4:
                args.putString(DummyFragment.KEY_MSG, "Frag 5");
                dummyFragment = DummyFragment.newInstance(args);
                break;
        }

        return dummyFragment;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
