package com.example.user.aplikasipar33;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.aplikasipar33.API.ApiService;
import com.example.user.aplikasipar33.API.ApiUrl;
import com.example.user.aplikasipar33.Modul.ItemUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    String id_pembeli;
    EditText et_id,edNama, edAlamat,edEmail,edNo_telepon, edUsername, edPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        id_pembeli = getIntent().getStringExtra(ItemUser.id_user);

        //et_id = (EditText) findViewById(R.id.edit_id);
        edNama = (EditText) findViewById(R.id.nama);
        edAlamat =(EditText) findViewById(R.id.alamat);
        edEmail =(EditText) findViewById(R.id.email);
        edNo_telepon =(EditText) findViewById(R.id.no_telepon);
        edUsername =(EditText) findViewById(R.id.username);
        edPassword =(EditText) findViewById(R.id.password);
        Button btnRegister = (Button) findViewById(R.id.register);
        Button btnRegister1 = (Button) findViewById(R.id.register1);



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sNama = String.valueOf(edNama.getText());
                String sAlamat = String.valueOf(edAlamat.getText());
                String sEmail = String.valueOf(edEmail.getText());
                String sNo_telepon = String.valueOf(edNo_telepon.getText());
                String sRole = "Pembeli";
                String sUsername = String.valueOf(edUsername.getText());
                String sPassword = String.valueOf(edPassword.getText());
                RegisterUser(sNama, sAlamat, sEmail,sNo_telepon, sRole,sUsername,sPassword);
                Intent goMain = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(goMain);
                finish();


            }
        });

        btnRegister1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sNama = String.valueOf(edNama.getText());
                String sAlamat = String.valueOf(edAlamat.getText());
                String sEmail = String.valueOf(edEmail.getText());
                String sNo_telepon = String.valueOf(edNo_telepon.getText());
                String sRole = "Pedagang";
                String sUsername = String.valueOf(edUsername.getText());
                String sPassword = String.valueOf(edPassword.getText());
                RegisterUser1(sNama, sAlamat, sEmail,sNo_telepon, sRole,sUsername,sPassword);
                Intent goMain = new Intent(RegisterActivity.this,LoginPedagangActivity.class);
                startActivity(goMain);
                finish();


            }
        });

    }
    public void RegisterUser(String nama, String alamat,String email, String no_telepon, String role,
                             String username, String password){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);

        Call<ResponseBody> call = service.RegisterUser(nama, alamat, email,no_telepon, role,username, password);
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

                Toast.makeText(RegisterActivity.this, respon, Toast.LENGTH_SHORT).show();
                finish();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void RegisterUser1(String nama, String alamat,String email, String no_telepon, String role,
                             String username, String password){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);

        Call<ResponseBody> call = service.RegisterUser1(nama, alamat, email,no_telepon, role,username, password);
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

                Toast.makeText(RegisterActivity.this, respon, Toast.LENGTH_SHORT).show();
                finish();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
