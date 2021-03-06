package ps.ns.just_click_and_eat.feature.favorites;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import java.util.Objects;

import ps.ns.just_click_and_eat.feature.mainHome.view.MainActivity;
import ps.ns.just_click_and_eat.R;
import ps.ns.just_click_and_eat.databinding.ActivityFavoritesBinding;
import ps.ns.just_click_and_eat.feature.favorites.adapter.SectionsPagerAdapter;
import ps.ns.just_click_and_eat.feature.myAccount.view.MyAccountActivity;
import ps.ns.just_click_and_eat.utils.AppSharedMethod;

import static ps.ns.just_click_and_eat.utils.ConstantApp.FROM_WHERE;

public class Favorites extends AppCompatActivity implements View.OnClickListener{
    private ActivityFavoritesBinding binding;

    public static Intent newInstance(Activity mActivity, int fromWhere) {
        Intent intent = new Intent(mActivity, Favorites.class);
        intent.putExtra(FROM_WHERE, fromWhere);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFavoritesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        AppSharedMethod.statusBarLight(this);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        listenerView();


    }


    private void listenerView(){
        binding.ibBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int CODE = Objects.requireNonNull(getIntent().getExtras()).getInt("CODE");
        if (v.getId() == R.id.ib_back){
            if (CODE == 1){
                startActivity(new Intent(Favorites.this, MyAccountActivity.class));
            }else {
                startActivity(new Intent(Favorites.this, MainActivity.class));
            }
            finish();

        }
    }
}