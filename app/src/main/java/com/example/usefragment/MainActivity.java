package com.example.usefragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView btnNav;
    private Fragment selectedFragment = new HeroesFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNav = findViewById(R.id.activitymain_bottom);

        btnNav.setOnNavigationItemSelectedListener(this);

        loadFragment(selectedFragment);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menu_hero :
                selectedFragment = new HeroesFragment();
                break;

            case R.id.menu_profile :
                selectedFragment = new ProfileFragment();
                break;
        }
        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if (selectedFragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activitymain_container,selectedFragment)
                    .commit();
            return true;
        }else
            return false;
    }
}
