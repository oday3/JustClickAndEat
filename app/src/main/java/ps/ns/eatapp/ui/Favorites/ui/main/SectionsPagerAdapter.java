package ps.ns.eatapp.ui.Favorites.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import ps.ns.eatapp.ui.Favorites.MealsFavorites;
import ps.ns.eatapp.ui.Favorites.RestaurantsFavorites;


public class SectionsPagerAdapter extends FragmentPagerAdapter {


    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new MealsFavorites();
                break;
            case 1:
                fragment = new RestaurantsFavorites();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "Meals";
            case 1:
                return "Restaurants";
        }
        return null;
    }

    @Override
    public int getCount() {

        return 2;
    }
}