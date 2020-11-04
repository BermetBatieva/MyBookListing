package com.example.android.mybooklisting;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.ArrayList;

public class VolumeInfo {

    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("authors")
    @Expose
    public List<String> authors = new ArrayList<String>();

    @SerializedName("publishedDate")
    @Expose
    public String publishedDate;
    @SerializedName("pageCount")
    @Expose
    public String pageCount;

    @SerializedName("averageRating")
    @Expose
    public String averageRating;
    @SerializedName("imageLinks")
    @Expose
    public ImageLinks imageLinks;

    @SerializedName("previewLink")
    @Expose
    public String previewLink;

    public String getPreviewLink() {
        return previewLink;
    }
}
