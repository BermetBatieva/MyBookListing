package com.example.android.mybooklisting;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class Book {
    @SerializedName("volumeInfo")
    @Expose
    public VolumeInfo volumeInfo;
    @SerializedName("title")
    @Expose
    private String mTitle;
    @SerializedName("authors")
    @Expose
    private String mAuthor;
    @SerializedName("thumbnail")
    @Expose
    private ImageLinks mThumbnailUrl;
    @SerializedName("averageRating")
    @Expose
    private String mRate;
    @SerializedName("publishedDate")
    @Expose
    private String mDate;
    @SerializedName("pageCount")
    @Expose
    private String mPages;
    @SerializedName("previewLink")
    @Expose
    private String mLink;
    @SerializedName("items")
    @Expose
    public ArrayList<Book> books = new ArrayList<>();


    public Book(String Title, String Author, ImageLinks thumbnailUrl, String Rate, String Date, String Pages, String Link) {

        mTitle = Title;
        mAuthor = Author;
        mThumbnailUrl = thumbnailUrl;
        mRate = Rate;
        mDate = Date;
        mPages = Pages;
        mLink = Link;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getRate() {
        return mRate;
    }

    public void setRate(String mRate) {
        this.mRate = mRate;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }

    public String getPages() {
        return mPages;
    }

    public void setPages(String mPages) {
        this.mPages = mPages;
    }

    public ImageLinks getThumbnailUrl() {
        return mThumbnailUrl;
    }

    public void setThumbnailUrl(ImageLinks mThumbnailUrl) {
        this.mThumbnailUrl = mThumbnailUrl;
    }

    public String getLink() {
        return mLink;
    }

    public void setLink(String mLink) {
        this.mLink = mLink;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo mVolumeInfo) {
        this.volumeInfo = mVolumeInfo;
    }
    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

}