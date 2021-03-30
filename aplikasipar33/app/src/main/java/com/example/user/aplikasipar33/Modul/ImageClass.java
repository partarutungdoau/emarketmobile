package com.example.user.aplikasipar33.Modul;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 3/4/2020.
 */

public class ImageClass
{
    @SerializedName("title")
    private String Title;

    @SerializedName("image")
    private String Image;

    @SerializedName("response")
    private String Response;

    public String getResponse() {
        return Response;
    }
}
