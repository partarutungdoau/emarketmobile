package com.example.user.aplikasipar33.API;

import com.example.user.aplikasipar33.Modul.DataProduk;
import com.example.user.aplikasipar33.Modul.ImageClass;
import com.example.user.aplikasipar33.Modul.ItemUser;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by User on 2/13/2020.
 */

public interface ApiService {
    @FormUrlEncoded
    @POST("layanan/login.php")
    Call<ItemUser> Login (@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("layanan/register.php")
    Call<ResponseBody> RegisterUser (@Field("nama") String nama,
                                     @Field("alamat") String alamat,
                                     @Field("email") String email,
                                     @Field("no_telepon") String no_telepon,
                                     @Field("role") String role,
                                     @Field("username") String username,
                                     @Field("password") String password);

    @FormUrlEncoded
    @POST("layanan/register_pedagang.php")
    Call<ResponseBody> RegisterUser1 (@Field("nama") String nama,
                                     @Field("alamat") String alamat,
                                     @Field("email") String email,
                                     @Field("no_telepon") String no_telepon,
                                     @Field("role") String role,
                                     @Field("username") String username,
                                     @Field("password") String password);


    @FormUrlEncoded
    @POST("layanan/Pedagang/tambah_data.php")
    Call<DataProduk> tambahProduk (
                                      @Field("nama_produk") String nama_produk,
                                      @Field("kategori_produk") String kategori_produk,
                                      @Field("harga") String harga,
                                      @Field("stok_produk") String stok_produk,
                                      @Field("gambar") String gambar,
                                      @Field("image") String image);


    @FormUrlEncoded
    @POST("layanan/Pedagang/edit_data.php")
    Call<ResponseBody> editProduk ( @Field("id_produk") String id_produk,
                                    @Field("nama_produk") String nama_produk,
                                     @Field("kategori_produk") String kategori_produk,
                                     @Field("harga") String harga,
                                     @Field("deskripsi") String deskripsi,
                                     @Field("gambar") String gambar);

    @FormUrlEncoded
    @POST("layanan/Pedagang/hapus_data.php")
    Call<ResponseBody> hapusProduk ( @Field("id_produk") String id_produk);

    @GET("layanan/Pedagang/lihat_data.php")
    Call<List<DataProduk>> getSemuaProduk();

    @GET("layanan/Pedagang/single_data.php")
    Call<List<DataProduk>> getSingleData(@Query("id_produk") String id_produk);

    @GET("layanan/Pembeli/lihat_data_sayur.php")
    Call<List<DataProduk>> getSemuaProdukSayur();
    @GET("layanan/Pembeli/lihat_data_lauk.php")
    Call<List<DataProduk>> getSemuaProdukLauk();
    @GET("layanan/Pembeli/lihat_data_buah.php")
    Call<List<DataProduk>> getSemuaProdukBuah();
    @GET("layanan/Pembeli/lihat_data_rempah.php")
    Call<List<DataProduk>> getSemuaProdukRempah();
    @GET("layanan/Pembeli/lihat_data_bumbu.php")
    Call<List<DataProduk>> getSemuaProdukBumbu();
    @GET("layanan/Pembeli/lihat_data_sembako.php")
    Call<List<DataProduk>> getSemuaProdukSembako();

    @FormUrlEncoded
    @POST("layanan/Pembeli/pesan_produk.php")
    Call<ResponseBody> pesanProduk ( @Field("id_beli") Integer id_beli,
                                     @Field("id_user") Integer id_user,
                                    @Field("tanggal_beli") String tanggal_beli,
                                    @Field("alamat_beli") String alamat_beli,
                                    @Field("total_beli") String total_beli,
                                    @Field("gambar") Boolean gambar);



}
