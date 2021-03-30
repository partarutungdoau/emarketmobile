package com.example.user.aplikasipar33.Pedagang;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.user.aplikasipar33.R;
import com.example.user.aplikasipar33.SplashActivity;


public class FragmentHome extends Fragment {
    LinearLayout b1;
    LinearLayout b2;
    LinearLayout b3;
    LinearLayout b4;
    LinearLayout b5;
    LinearLayout b6;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_pedagang, container, false);


        b1 = v.findViewById(R.id.katSayur);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DaftarProduk.class
                ));
            }
        });
        b2 = v.findViewById(R.id.katLauk);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), KatLauk.class
                ));
            }
        });
        b3 = v.findViewById(R.id.katBuah);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), KatBuah.class
                ));
            }
        });
        b4 = v.findViewById(R.id.katRempah);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), KatRempah.class
                ));
            }
        });
        b5 = v.findViewById(R.id.katBumbu);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), katBumbu.class
                ));
            }
        });
        b6 = v.findViewById(R.id.katSembako);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), katSembako.class
                ));
            }
        });
        return v;
    }

//
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.mainLogout, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    public boolean onOptionsItemSelected(MenuItem item){
//        int id = item.getItemId();
//        switch (id) {
//
//            case R.id.tambah:
//                startActivity(new Intent(getActivity(),SplashActivity.class
//                ));
//                break;
//
//        }
//        return super.onOptionsItemSelected(item);
//    }

    }

