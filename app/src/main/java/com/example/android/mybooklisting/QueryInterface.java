package com.example.android.mybooklisting;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;
public interface QueryInterface {
    @GET
    Call<Book> getBooks(@Url String Url);
}
