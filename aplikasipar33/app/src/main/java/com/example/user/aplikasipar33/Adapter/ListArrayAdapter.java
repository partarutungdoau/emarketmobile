package com.example.user.aplikasipar33.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.user.aplikasipar33.Modul.DataProduk;
import com.example.user.aplikasipar33.R;

import java.io.InputStream;
import java.util.ArrayList;


public class ListArrayAdapter extends ArrayAdapter<DataProduk> {

    private ArrayList<DataProduk> list;
    private LayoutInflater inflater;
    private int res;
    Bitmap bitmap;

    public ListArrayAdapter(Context context, int resource, ArrayList<DataProduk> list) {
        super(context, resource, list);
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.res = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        MyHolder holder = null;


        if (convertView == null) {

            convertView = inflater.inflate(res, parent, false);

            holder = new MyHolder();

            holder.Gambar = (ImageView) convertView.findViewById(R.id.listGambarProduk);
//            holder.ID =(TextView) convertView.findViewById(R.id.listGambarProduk);
//            holder.IDPUSH = (TextView) convertView.findViewById(R.id.listGambarProduk);
            holder.Nama = (TextView) convertView.findViewById(R.id.listNamaProduk);
            holder.Harga = (TextView) convertView.findViewById(R.id.listHargaProduk);

            convertView.setTag(holder);

        } else {

            holder = (MyHolder) convertView.getTag();
        }
        Glide.with(getContext()).load("http://192.168.43.152/layanan/PhotoUploads/Uploads/" +
                list.get(position).getGambarProduk()).thumbnail(1).crossFade().diskCacheStrategy(
                DiskCacheStrategy.ALL).
                into(holder.Gambar);

        holder.Nama.setText("Nama Produk: "+list.get(position).getNamaProduk());
        holder.Harga.setText("Harga : "+list.get(position).getHargaProduk());

        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public void remove(DataProduk object) {
        super.remove(object);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    static class MyHolder {

//        TextView ID;
//        TextView IDPUSH;
        TextView Nama;
        TextView Harga;
        ImageView Gambar;


    }

}
