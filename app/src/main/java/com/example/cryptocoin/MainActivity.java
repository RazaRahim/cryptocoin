package com.example.cryptocoin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);


        bottomNavigationView.setOnNavigationItemSelectedListener(navlistner);

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new home())
                    .commit();

        }
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navlistner = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment slectedFragment = null;
            switch (item.getItemId()){
                case R.id.home:
                    slectedFragment =new home();
                    break;
                case R.id.dashboard:
                    slectedFragment =new dashboard();
                    break;
                case R.id.arrow:
                    slectedFragment =new arrow();
                    break;
                case R.id.price:
                    slectedFragment =new price();
                    break;
                case R.id.config:
                    slectedFragment =new config();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,slectedFragment).commit();
            return true;
        }
    };
}