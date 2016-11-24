package com.caiodev.diario.diariolivreoficial.Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caiodev.diario.diariolivreoficial.Fragment.Fragment.FavoriteFragment;
import com.caiodev.diario.diariolivreoficial.Fragment.Home.HomeFragment;
import com.caiodev.diario.diariolivreoficial.R;

/**
 * Created by CaioSChristino on 14/10/16.
 */

public class TabPageAdapter extends Fragment {
    private static TabLayout tabLayout;
    private static ViewPager viewPager;
    private static int int_items = 2;
    private static MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View x = inflater.inflate(R.layout.tabs_layout, null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);
        adapter = new MyAdapter(getChildFragmentManager());
        if (adapter != null) {
            viewPager.setAdapter(adapter);
            tabLayout.post(new Runnable() {
                @Override
                public void run() {
                    tabLayout.setupWithViewPager(viewPager);
                }
            });
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 1) {
                    viewPager.setCurrentItem(tab.getPosition());

                    LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(getContext());
                    Intent i = new Intent("TAG_REFRESH");
                    lbm.sendBroadcast(i);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return x;
    }

    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 1:
                    return new FavoriteFragment();
                default:
                    return new HomeFragment();
            }
        }

        @Override
        public int getCount() {
            return int_items;
        }

        /**
         * This method returns the title of the tab according to the position.
         */
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 1:
                    return "Favoritos";
                default:
                    return "Documentos";
            }
        }
    }
}