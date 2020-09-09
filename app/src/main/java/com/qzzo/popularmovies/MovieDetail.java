package com.qzzo.popularmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MovieDetail extends AppCompatActivity {
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        title = findViewById(R.id.title);
        Intent i = getIntent();
        String title_name = i.getStringExtra("title");
        title.setText("Title:"+title_name);

    }
}