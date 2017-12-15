package com.example.tablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;

/**
 * ViewPagerAdapterrrrrrr, para mostrar paginas flamas
 */

class ViewPagerAdapter extends FragmentPagerAdapter {

    private int pageCount;
    private ArrayList<String> titulos;

    public ViewPagerAdapter(FragmentManager fragmentManager)
    {
        super(fragmentManager);
    }

    public ViewPagerAdapter(FragmentManager fragmentManager, int pageCount, ArrayList<String> titulos)
    {
        super(fragmentManager);
        this.pageCount = pageCount;
        this.titulos = titulos;
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
        return pageCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return titulos.get(position);
    }
}
