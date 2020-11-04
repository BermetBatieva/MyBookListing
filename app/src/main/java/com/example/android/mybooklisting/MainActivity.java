package com.example.android.mybooklisting;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Search(View view) {
        EditText editText = findViewById(R.id.search_field);
        if (editText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Search field is empty", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, BookActivity.class);
            intent.putExtra("SearchBook", editText.getText().toString());
            startActivity(intent);
        }
    }

}
