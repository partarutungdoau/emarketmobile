package com.example.user.aplikasipar33.Modul;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 2/22/2020.
 */

public class DataProduk {

    public DataProduk(){};
    @SerializedName("id_produk")
    @Expose
    private String idProduk;

    @SerializedName("id_pedagang")
    @Expose
    private String idPedagang;

    @SerializedName("nama_produk")
    @Expose
    private String namaProduk;

    @SerializedName("kategori_produk")
    @Expose
    private String kategoriProduk;

    @SerializedName("harga")
    @Expose
    private String hargaProduk;

    @SerializedName("stok_produk")
    @Expose
    private String stokProduk;

    @SerializedName("gambar")
    @Expose
    private String gambarProduk;

    @SerializedName("response")
    private String response;

    @SerializedName("image")
    @Expose



    private String Image;
   public static final String id_produk = "ID_PRODUK";
    public static final String id_pedagang = "ID_PEDAGANG";


    public String getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(String idProduk) {
        this.idProduk = idProduk;
    }

    public String getIdPedagang() {
        return idPedagang;
    }

    public void setIdPedagang(String idPedagang) {
        this.idPedagang = idPedagang;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getKategoriProduk() {
        return kategoriProduk;
    }

    public void setKategoriProduk(String kategoriProduk) {
        this.kategoriProduk = kategoriProduk;
    }

    public String getHargaProduk() {
        return hargaProduk;
    }

    public void setHargaProduk(String hargaProduk) {
        this.hargaProduk = hargaProduk;
    }

    public String getStokProduk() {
        return stokProduk;
    }

    public void setStokProduk(String stokProduk) {
        this.stokProduk = stokProduk;
    }

    public String getGambarProduk() {
        return gambarProduk;
    }

    public void setGambarProduk(String gambarProduk) {
        this.gambarProduk = gambarProduk;
    }



    public DataProduk(String idProduk,String idPedagang,String namaProduk, String kategoriProduk, String hargaProduk, String stokProduk, String gambarProduk) {
        this.idProduk = idProduk;
        this.idPedagang = idPedagang;
        this.namaProduk = namaProduk;
        this.kategoriProduk = kategoriProduk;
        this.hargaProduk = hargaProduk;
        this.stokProduk = stokProduk;
        this.gambarProduk = gambarProduk;



    }

    public String getResponse() {
        return response;
    }
}
