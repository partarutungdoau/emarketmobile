package com.example.user.aplikasipar33.Pembeli;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.user.aplikasipar33.Pedagang.DaftarProduk;
import com.example.user.aplikasipar33.Pembeli.KatBuahPem;
import com.example.user.aplikasipar33.Pembeli.KatLaukPem;
import com.example.user.aplikasipar33.Pembeli.KatRempahPem;
import com.example.user.aplikasipar33.Pembeli.KatSayurPem;
import com.example.user.aplikasipar33.Pembeli.katBumbuPem;
import com.example.user.aplikasipar33.Pembeli.katSembakoPem;
import com.example.user.aplikasipar33.R;

/**
 * Created by User on 3/6/2020.
 */

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
        View v = inflater.inflate(R.layout.fragment_home_pembeli, container, false);


        b1 = v.findViewById(R.id.katSayurPem);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DaftarProduk.class
                ));
            }
        });
        b2 = v.findViewById(R.id.katLaukPem);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), KatLaukPem.class
                ));
            }
        });
        b3 = v.findViewById(R.id.katBuahPem);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), KatBuahPem.class
                ));
            }
        });
        b4 = v.findViewById(R.id.katRempahPem);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), KatRempahPem.class
                ));
            }
        });
//        b5 = v.findViewById(R.id.katBumbuPem);
//        b5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getActivity(), katBumbuPem.class
//                ));
//            }
//        });
//        b6 = v.findViewById(R.id.katSembakoPem);
//        b6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getActivity(), katSembakoPem.class
//                ));
//            }
//        });
        return v;
    }


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


