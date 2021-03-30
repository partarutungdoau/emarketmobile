package com.example.user.aplikasipar33.Pedagang;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.user.aplikasipar33.LoginActivity;
import com.example.user.aplikasipar33.Pedagang.FragmentNotifikasi;
import com.example.user.aplikasipar33.R;
import com.example.user.aplikasipar33.RegisterActivity;

public class BerandaActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new FragmentHome();
                    break;

                case R.id.navigation_dashboard:
                    selectedFragment = new FragmentProduk();

                    break;

                case R.id.navigation_notifications:
                    selectedFragment = new FragmentNotifikasi();
                    break;
                case R.id.navigation_akun:
                    selectedFragment = new FragmentAkun();
                    break;
            }
           getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
