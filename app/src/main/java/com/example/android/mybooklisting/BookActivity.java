package com.example.android.mybooklisting;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import android.os.Bundle;
import android.net.Uri;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.Callback;
import  androidx.annotation.NonNull;
import retrofit2.Response;
import android.view.View;
import android.widget.Toast;
import retrofit2.converter.gson.GsonConverterFactory;


public class BookActivity extends AppCompatActivity {
    RecyclerView rvBooks;
    ArrayList<Book> bookList = new ArrayList<>();
    BookAdapter adapter;
    public static final String URL = "https://www.googleapis.com/books/v1/volumes?q=";
    public String searchName = "";
    QueryInterface service;
    Uri baseUri, finalUri;
    Uri.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Intent intent = getIntent();
        searchName = intent.getStringExtra("SearchBook").replace(' ', '+');
        rvBooks = findViewById(R.id.rvBooks);
        rvBooks.setHasFixedSize(true);
        LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        rvBooks.setLayoutManager(manager);

        adapter = new BookAdapter(clickListener);

        rvBooks.setAdapter(adapter);

        String baseUrl = "https://www.googleapis.com/books/v1/";
        baseUri = Uri.parse(URL);
        finalUri = Uri.parse(URL + searchName);
        builder = finalUri.buildUpon();
        searchName = builder.toString();

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create(gson)).build();
        service = retrofit.create(QueryInterface.class);

        getBooksQuery();
    }

    BookAdapter.OnItemClickListener clickListener = new BookAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(Book book) {
            String url = book.volumeInfo.getPreviewLink();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }
    };

    private void getBooksQuery() {

        Call<Book> call = service.getBooks(searchName);
        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(@NonNull Call<Book> call, @NonNull Response<Book> response) {
                if (response.isSuccessful()) {
                    Book book = response.body();
                    assert book != null;
                    adapter.setData(book.books);
                }
            }

            @Override
            public void onFailure(@NonNull Call<Book> call, @NonNull Throwable t) {
                rvBooks.setVisibility(View.INVISIBLE);
                Toast.makeText(BookActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
