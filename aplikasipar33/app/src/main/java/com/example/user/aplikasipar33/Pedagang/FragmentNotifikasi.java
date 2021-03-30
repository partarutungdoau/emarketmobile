package com.example.user.aplikasipar33.Pedagang;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.aplikasipar33.R;

/**
 * Created by User on 3/6/2020.
 */

public class FragmentNotifikasi extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notifikasi_pedagang, container, false);
    }
}
