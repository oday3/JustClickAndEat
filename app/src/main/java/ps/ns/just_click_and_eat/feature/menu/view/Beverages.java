package ps.ns.just_click_and_eat.feature.menu.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ps.ns.just_click_and_eat.databinding.FragmentBeveragesBinding;
import ps.ns.just_click_and_eat.feature.mealsDetails.view.MealsDetailsActivity;
import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.feature.menu.adapter.MenuAdapter;
import ps.ns.just_click_and_eat.network.asp.model.meals.Meals;


public class Beverages extends Fragment implements MenuAdapter.ListItemClickListener {
    private MenuAdapter adapter;
    private ArrayList<Meals> list;
    private View view;
    private FragmentBeveragesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBeveragesBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        initViews();
        return view;
    }

    private void initViews() {
        list = new ArrayList<>();
        getBeveragesData();
    }

    private void getBeveragesData() {
//        list.add(new MenuModel("https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimg1.cookinglight.timeinc.net%2Fsites%2Fdefault%2Ffiles%2F1530030147%2Fchicken-and-bulgur-salad-with-peaches-1808-p17.jpg","Braised Fish Head","2x tuna sahimi, 3x vegetables ","$15.00"));
//        list.add(new MenuModel("https://www.samaa.tv/wp-content/uploads/2017/09/meals.jpg","Salad Fritters","2x tuna sahimi, 3x vegetables","$4.90"));
//        list.add(new MenuModel("https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimg1.cookinglight.timeinc.net%2Fsites%2Fdefault%2Ffiles%2F1530030147%2Fchicken-and-bulgur-salad-with-peaches-1808-p17.jpg","Braised Fish Head","2x tuna sahimi, 3x vegetables ","$15.00"));
//        list.add(new MenuModel("https://www.samaa.tv/wp-content/uploads/2017/09/meals.jpg","Salad Fritters","2x tuna sahimi, 3x vegetables","$4.90"));

        binding.rvBeverages.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter= new MenuAdapter(getContext(), list, this);
        binding.rvBeverages.setAdapter(adapter);
    }

    @Override
    public void onListItemClicked(int position, int viewId) {
        switch (viewId){
            case R.id.ll_menu:
                startActivity(new Intent(getActivity(), MealsDetailsActivity.class));
        }
    }
}