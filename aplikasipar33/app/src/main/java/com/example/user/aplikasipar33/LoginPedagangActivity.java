package com.example.user.aplikasipar33;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.aplikasipar33.API.ApiService;
import com.example.user.aplikasipar33.API.ApiUrl;
import com.example.user.aplikasipar33.Modul.ItemUser;
import com.example.user.aplikasipar33.Pedagang.BerandaActivity;
import com.example.user.aplikasipar33.Pedagang.DaftarProduk;
import com.example.user.aplikasipar33.Pedagang.HalamanUtama;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginPedagangActivity extends AppCompatActivity {

    private EditText edUsername, edPassword;
  //  SharedPrefManager sharedPrefManager;
//    Context mContext;
//    ApiService mApiService;
//    ProgressDialog loading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pedagang);

        edUsername =(EditText) findViewById(R.id.username);
        edPassword =(EditText) findViewById(R.id.password);
        Button btnLogin =(Button) findViewById(R.id.login);
        Button btnRegister = (Button) findViewById(R.id.register);
//        sharedPrefManager = new SharedPrefManager(this);
//        mContext = this;
//        mApiService = ApiUrl.getAPIService();


//        if (sharedPrefManager.getSPSudahLogin()){
//            startActivity(new Intent(LoginPedagangActivity.this, MainActivity.class)
//                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
//            finish();
//        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = String.valueOf(edUsername.getText());
                String password = String.valueOf(edPassword.getText());

                if(username.equals("")) {
                    edUsername.setError("Username Anda Kosong");
                } else if (password.equals("")) {
                    edPassword.setError("Password Anda Kosong");
                } else {

                    sendTokenToServer(username, password);
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goRegister = new Intent(LoginPedagangActivity.this, RegisterActivity.class);
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
                        Toast.makeText(LoginPedagangActivity.this,error, Toast.LENGTH_SHORT).show();

                        finish();
                        Intent goMain = new Intent(LoginPedagangActivity.this,DaftarProduk.class);
                        goMain.putExtra("username", username);
                        startActivity(goMain);
                        finish();

                    }
                    else {
                        String message = response.body().getMessage();
                        String error ="Gagal" +message;
                        Toast.makeText(LoginPedagangActivity.this,error, Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    String error ="ERROORRR";
                    Toast.makeText(LoginPedagangActivity.this,error, Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<ItemUser> call, Throwable t) {
                Toast.makeText(LoginPedagangActivity.this,"ERROR TRY", Toast.LENGTH_SHORT).show();

            }
        });
    }
//    private void requestLogin(){
//        mApiService.Login(edUsername.getText().toString(), edPassword.getText().toString())
//               .enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                        if (response.isSuccessful()){
//                            loading.dismiss();
//                            try {
//                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
//                                if (jsonRESULTS.getString("error").equals("false")){
//                                    // Jika login berhasil maka data nama yang ada di response API
//                                    // akan diparsing ke activity selanjutnya.
//                                    Toast.makeText(mContext, "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
//                                    String username = jsonRESULTS.getJSONObject("user").getString("nama");
//                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_USERNAME, username);
//                                    // Shared Pref ini berfungsi untuk menjadi trigger session login
//                                    sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);
//                                    startActivity(new Intent(mContext, MainActivity.class)
//                                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
//                                    finish();
//                                } else {
//                                    // Jika login gagal
//                                    String error_message = jsonRESULTS.getString("error_msg");
//                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
//                                }
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        } else {
//                            loading.dismiss();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        Log.e("debug", "onFailure: ERROR > " + t.toString());
//                        loading.dismiss();
//                    }
//                });
//    }
}
