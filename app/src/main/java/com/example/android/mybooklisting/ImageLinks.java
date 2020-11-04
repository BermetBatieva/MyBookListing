package com.example.android.mybooklisting;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageLinks {

    @SerializedName("thumbnail")
    @Expose
    public String thumbnail;

    public String getThumbnail() {
        return thumbnail;
    }


    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
