package com.devanshu.instagramproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.bottomNavigationView2);
        replacefragement(new Fragment_one());
        view.getSelectedItemId();
        view.setOnItemSelectedListener(item ->  {
                switch (item.getItemId()){

                    case R.id.home :
                        replacefragement(new Fragment_one());
                        break;
                    case R.id.search:
                        replacefragement(new Fragment_three());
                        break;
                    case R.id.profile:
                        replacefragement(new Fragment_two());
                        break;
                    case R.id.notify:
                        replacefragement(new Fragment_notify());
                        break;
                    case R.id.addpost:
                        replacefragement(new Fragment_four());
                        break;
                }

                return false;
        });
    }

    private void replacefragement(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction() ;
        fragmentTransaction.replace(R.id.framelayout,fragment);
        fragmentTransaction.commit();
    }
}