package com.example.user.aplikasipar33.Pedagang;

import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.user.aplikasipar33.API.ApiService;
import com.example.user.aplikasipar33.API.ApiUrl;
import com.example.user.aplikasipar33.Modul.DataProduk;
import com.example.user.aplikasipar33.Modul.ImageClass;
import com.example.user.aplikasipar33.R;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TambahProduk extends AppCompatActivity {

    String ID_MAHASISWA, ID_PEDAGANG;
    EditText et_id, namaProduk, katProduk, harProduk,stokProduk, img_title;
    ImageView gamProduk;
    private Bitmap bitmap;
    private Uri filepath;
    private static final int IMG_REQUEST = 777;


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_produk);




        ID_MAHASISWA = getIntent().getStringExtra(DataProduk.id_produk);
         ID_PEDAGANG = getIntent().getStringExtra(DataProduk.id_pedagang);
        namaProduk = (EditText) findViewById(R.id.nama_produk);
        katProduk = (EditText) findViewById(R.id.kat_produk);
        harProduk = (EditText) findViewById(R.id.harga_produk);
        stokProduk = (EditText) findViewById(R.id.stok_produk);
        img_title = (EditText) findViewById(R.id.image_title);
        gamProduk = (ImageView) findViewById(R.id.gambar_produk);



         Button buttonpilih =(Button) findViewById(R.id.buttonPilihPoto);
         buttonpilih.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                selectImage();
             }
         });



        Button btnAdd = (Button) findViewById(R.id.simpan);
        btnAdd.setOnClickListener(
                new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onClick(View view) {
                       uploadImage();
                        Intent goAdd = new Intent(TambahProduk.this, DaftarProduk.class);
                        startActivity(goAdd);
                    }
                });
    }
    private void uploadImage(){
        String Image = imageToString();
        String sNamaProduk = namaProduk.getText().toString();
        String sKatProduk = namaProduk.getText().toString();
        String sHarProduk = namaProduk.getText().toString();
        String sstokProduk = namaProduk.getText().toString();
        String sgambar = img_title.getText().toString();
        ApiService apiService = ApiUrl.getClient().create(ApiService.class);


        Call<DataProduk> call = apiService.tambahProduk(sNamaProduk, sKatProduk, sHarProduk, sstokProduk , sgambar, Image);
        call.enqueue(new Callback<DataProduk>() {
            @Override
            public void onResponse(Call<DataProduk> call, Response<DataProduk> response) {
                DataProduk dataProduk =response.body();
                Toast.makeText(TambahProduk.this,"server response "+dataProduk.getResponse(),Toast.LENGTH_SHORT).show();
                gamProduk.setVisibility(View.GONE);
                img_title.setVisibility(View.GONE);
                img_title.setText("");
            }

            @Override
            public void onFailure(Call<DataProduk> call, Throwable t) {
                Toast.makeText(TambahProduk.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    private String imageToString(){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100, byteArrayOutputStream);
        byte[] imgByte = byteArrayOutputStream.toByteArray();

        return Base64.encodeToString(imgByte, Base64.DEFAULT);
    }




    public void selectImage(){
         Intent intent = new Intent();
         intent.setType("image/*");
         intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMG_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == IMG_REQUEST && resultCode ==RESULT_OK && data != null){
            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);

                gamProduk.setImageBitmap(bitmap);

            }

            catch (IOException e){
                e.printStackTrace();
            }
        }
    }


}