package com.example.user.aplikasipar33;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.aplikasipar33.API.ApiService;
import com.example.user.aplikasipar33.API.ApiUrl;
import com.example.user.aplikasipar33.Modul.ItemUser;
import com.example.user.aplikasipar33.Pembeli.HalamanUtama;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private EditText edUsername, edPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername =(EditText) findViewById(R.id.username_pem);
        edPassword =(EditText) findViewById(R.id.password_pem);
        Button btnLogin =(Button) findViewById(R.id.login_pem);
        Button btnRegister = (Button) findViewById(R.id.register_pem);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = String.valueOf(edUsername.getText());
                String password = String.valueOf(edPassword.getText());

                if(username.equals("")) {
                    edUsername.setError("Username Anda Kosong");
                } else if (password.equals("")) {
                    edPassword.setError("Password Anda Kosong");
                } else{
                       sendTokenToServer(username,password);
                    }

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goRegister = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(goRegister);
                finish();

            }
        });

    }
    public void sendTokenToServer (String username, String password){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);

        Call<ItemUser> call = service.Login(username,password);
        call.enqueue(new Callback<ItemUser>() {
            @Override
            public void onResponse(Call<ItemUser> call, Response<ItemUser> response) {
                if(response.isSuccessful()){
                   Boolean status = response.body().getStatus();
                    if(status){
                        String message = response.body().getMessage();
                        String username = response.body().getUsername();
                        String error ="Sukses" +message;
                        Toast.makeText(LoginActivity.this,error, Toast.LENGTH_SHORT).show();

                        finish();
                        Intent goMain = new Intent(LoginActivity.this,HalamanUtama.class);
                        goMain.putExtra("username", username);
                        startActivity(goMain);
                        finish();

                    }
                    else {
                        String message = response.body().getMessage();
                        String error ="Gagal" +message;
                        Toast.makeText(LoginActivity.this,error, Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    String error ="ERROORRR";
                    Toast.makeText(LoginActivity.this,error, Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<ItemUser> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"ERROR TRY", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
