package com.qzzo.popularmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MovieDetail extends AppCompatActivity {

    TextView title,popularity,votecount,adult,language,votAvg,re_Date,overview;
    ImageView poster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        getSupportActionBar().setTitle("Movie Details");
        title = findViewById(R.id.title);
        popularity = findViewById(R.id.popularity);
        votecount = findViewById(R.id.votecount);
        overview = findViewById(R.id.overview);
        adult = findViewById(R.id.adult);
        language = findViewById(R.id.lang);
        votAvg = findViewById(R.id.voteAvg);
        re_Date =findViewById(R.id.re_date);
        poster = findViewById(R.id.moviePoster);
        Intent i = getIntent();

        String title_name = i.getStringExtra("title");
        String PosterPath = i.getStringExtra("poster");
        String pop = i.getStringExtra("pop");
        String ovr = i.getStringExtra("overview");
        String voc = i.getStringExtra("voc");
        String voa = i.getStringExtra("voa");
        String adlt = i.getStringExtra("adlt");
        String lan = i.getStringExtra("lan");
        String realDate = i.getStringExtra("realDate");

        title.setText(title_name);
        popularity.setText("Popularity: "+pop);
        votecount.setText("Vote Count: "+voc);
        adult.setText("Adult: "+adlt);
        language.setText("Language: "+lan);
        votAvg.setText("Vote Average: "+voa);
        re_Date.setText("Released Date: "+realDate);
        overview.setText("Overview: "+ovr);

        Glide
                .with(this)
                .load(PosterPath)
                .override(450,1000)
                .fitCenter()
                .into(poster);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}