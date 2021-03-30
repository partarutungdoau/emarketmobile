package com.example.user.aplikasipar33.Pedagang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.user.aplikasipar33.API.ApiUrl;
import com.example.user.aplikasipar33.R;
import com.example.user.aplikasipar33.API.ApiService;
import com.example.user.aplikasipar33.Modul.DataProduk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EditProduk extends AppCompatActivity {

    String ID_PRODUK;
    EditText et_id, et_nama_produk, et_kat_produk, et_har_produk, et_des_produk;
    ImageButton et_gam_produk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_produk);

        ID_PRODUK = getIntent().getStringExtra(DataProduk.id_produk);

        et_id = (EditText) findViewById(R.id.edit_id);
        et_nama_produk = (EditText) findViewById(R.id.edit_nama_produk);
        et_kat_produk = (EditText) findViewById(R.id.edit_kat_produk);
        et_har_produk = (EditText) findViewById(R.id.edit_harga_produk);
        et_des_produk = (EditText) findViewById(R.id.edit_des_produk);
        et_gam_produk = (ImageButton) findViewById(R.id.edit_gambar_produk);

        bindData();

        Button btnUbah = (Button) findViewById(R.id.edit);
        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sId = String.valueOf(et_id.getText());
                String sNamaProduk = String.valueOf(et_nama_produk.getText());
                String sKatProduk = String.valueOf(et_kat_produk.getText());
                String sHarProduk = String.valueOf(et_har_produk.getText());
                String sDesProduk = String.valueOf(et_des_produk.getText());
                String sGamProduk = String.valueOf(et_gam_produk.getImageMatrix());

                if (sId.equals("")){
                    Toast.makeText(EditProduk.this, "Jangan Rubah ID", Toast.LENGTH_SHORT).show();
                } else if (sNamaProduk.equals("")){
                    Toast.makeText(EditProduk.this, "Silahkan isi Nama Produk", Toast.LENGTH_SHORT).show();
                } else if (sKatProduk.equals("")){
                    Toast.makeText(EditProduk.this, "Silahkan isi Kategori Produk", Toast.LENGTH_SHORT).show();
                } else if (sHarProduk.equals("")){
                    Toast.makeText(EditProduk.this, "Silahkan isi Harga Produk", Toast.LENGTH_SHORT).show();
                } else if (sDesProduk.equals("")){
                    Toast.makeText(EditProduk.this, "Silahkan isi Deskripsi Produk", Toast.LENGTH_SHORT).show();
                } else if (sGamProduk.equals("")){
                    Toast.makeText(EditProduk.this, "Silahkan isi Gambar Produk", Toast.LENGTH_SHORT).show();
                } else {
                    editProduk(sId, sNamaProduk, sKatProduk, sHarProduk, sDesProduk, sGamProduk);
                }
            }
        });

        Button btnDel = (Button) findViewById(R.id.hapus);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hapusProduk(ID_PRODUK);
            }
        });

        // ditambahkan
        Button btnBatal = (Button) findViewById(R.id.batal);
        btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void bindData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);

        Call<List<DataProduk>> call = service.getSingleData(ID_PRODUK);
        call.enqueue(new Callback<List<DataProduk>>() {
            @Override
            public void onResponse(Call<List<DataProduk>> call, Response<List<DataProduk>> response) {

                if (response.isSuccessful()) {

                    for (int i = 0; i < response.body().size(); i++) {

                        et_id.setText(response.body().get(i).getIdProduk());
                        et_nama_produk.setText(response.body().get(i).getNamaProduk());
                        et_kat_produk.setText(response.body().get(i).getKategoriProduk());
                        et_har_produk.setText(response.body().get(i).getHargaProduk());
                        et_des_produk.setText(response.body().get(i).getStokProduk());
                       // et_gam_produk.setImageMatrix(response.body().get(i).getGambarProduk());

                    }

                }

            }

            @Override
            public void onFailure(Call<List<DataProduk>> call, Throwable t) {

            }
        });
    }

    public void editProduk(String id, String namaProduk, String katProduk, String harProduk, String desProduk, String gamProduk) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ApiService service = retrofit.create(ApiService.class);

        Call<ResponseBody> call = service.editProduk(id, namaProduk, katProduk, harProduk, desProduk, gamProduk);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                BufferedReader reader = null;
                String respon = "";

                try {
                    reader = new BufferedReader(new InputStreamReader(response.body().byteStream()));
                    respon = reader.readLine();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                Toast.makeText(EditProduk.this, respon, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }

    public void hapusProduk(String id_produk) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ApiService service = retrofit.create(ApiService.class);

        Call<ResponseBody> call = service.hapusProduk(id_produk);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                BufferedReader reader = null;
                String respon = "";

                try {
                    reader = new BufferedReader(new InputStreamReader(response.body().byteStream()));
                    respon = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Toast.makeText(EditProduk.this, respon, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }
}
