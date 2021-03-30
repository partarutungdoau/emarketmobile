package com.example.user.aplikasipar33.Pembeli;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.user.aplikasipar33.API.ApiUrl;
import com.example.user.aplikasipar33.Modul.DataProduk;
import com.example.user.aplikasipar33.API.ApiService;
import com.example.user.aplikasipar33.Adapter.ListArrayAdapter;
import com.example.user.aplikasipar33.Pedagang.TambahProduk;
import com.example.user.aplikasipar33.R;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class KatSayurPem extends AppCompatActivity implements AdapterView.OnItemClickListener {


    ArrayList<DataProduk> dataproduk = new ArrayList<DataProduk>();
    ListView listview;
    ListArrayAdapter adapter;

    LinearLayout layout_loading;
    TextView text_load;
    ImageView icon_load;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kat_sayur_pem);



        layout_loading = (LinearLayout) findViewById(R.id.layout_loading);

        text_load = (TextView) findViewById(R.id.text_load);
        icon_load = (ImageView) findViewById(R.id.icon_load);

        listview = (ListView) findViewById(R.id.listProdukSayur);
        listview.setOnItemClickListener(KatSayurPem.this);
        listview.setDividerHeight(0);
        setup();
//
//        FloatingActionButton btnAdd = (FloatingActionButton) findViewById(R.id.btn_add);
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent goAdd = new Intent(KatSayurPem.this, TambahProduk.class);
//                startActivity(goAdd);
//            }
//        });

    }

    public void setup() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);

        Call<List<DataProduk>> call = service.getSemuaProdukSayur();
        call.enqueue(new Callback<List<DataProduk>>() {
            @Override
            public void onResponse(Call<List<DataProduk>> call, Response<List<DataProduk>> response) {

                // tambahkan
                dataproduk.clear();

                if (response.isSuccessful()) {
                    int jumlah = response.body().size();

                    for (int i = 0; i < jumlah; i++) {

                        DataProduk data = new DataProduk(
                                response.body().get(i).getIdProduk(),
                                response.body().get(i).getIdPedagang(),
                                response.body().get(i).getNamaProduk(),
                                response.body().get(i).getKategoriProduk(),
                                response.body().get(i).getHargaProduk(),
                                response.body().get(i).getStokProduk(),
                                response.body().get(i).getGambarProduk()
                        );
                        dataproduk.add(data);
                        Log.d("RESPON", "onResponse: " + response.body().get(i).getIdProduk());

                    }
                    listview.setVisibility(View.VISIBLE);
                    adapter = new ListArrayAdapter(KatSayurPem.this, R.layout.row_produk, dataproduk);
                    listview.setAdapter(adapter);

                    if (adapter.getCount() < 1 ) {
                        layout_loading.setVisibility(View.VISIBLE);
                        String error = "Daftar Produk Kosong";
                        text_load.setText(error);
                        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_data_kosong);
                        icon_load.setImageBitmap(icon);
                    } else {
                        layout_loading.setVisibility(View.GONE);
                    }
                } else {
                    String error = "Error Retrive Data from Server !!!";
                    text_load.setText(error);
                    Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_network);
                    icon_load.setImageBitmap(icon);

                }

            }

            @Override
            public void onFailure(Call<List<DataProduk>> call, Throwable t) {
                String error = "Error Retrive Data from Server wwaau!!!\n" + t.getMessage();
                text_load.setText(error);
                Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_network);
                icon_load.setImageBitmap(icon);
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView ids = (TextView) view.findViewById(R.id.listProdukSayur);
        Intent intent = new Intent(KatSayurPem.this, DetailProdukSayurPem.class);
        intent.putExtra(DataProduk.id_produk, ids.getText().toString());
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            adapter.clear();
            setup();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        dataproduk.clear();
        adapter = new ListArrayAdapter(KatSayurPem.this, R.layout.row_produk, dataproduk);
//        adapter.clear();
        listview.setAdapter(adapter);

        //Toast.makeText(this, "HEMM", Toast.LENGTH_SHORT).show();
        setup();
    }
}
