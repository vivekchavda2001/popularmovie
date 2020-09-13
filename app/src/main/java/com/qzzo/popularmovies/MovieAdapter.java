package com.qzzo.popularmovies;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.lang.annotation.Target;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewholder>{
    private Context context;
    private List<Result> items;

    public MovieAdapter(Context context,List<Result> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull

    @Override
    public MovieViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.movie_view,parent,false);
        return new MovieViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewholder holder, int position) {
        final Result item = items.get(position);
        holder.movieTitle.setText(item.getTitle());
        Glide
                .with(context)
                .load(item.getPosterPath())
                .override(500,1000)
                .fitCenter()
                .into(holder.movieImage);
        holder.movieImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,MovieDetail.class);
                i.putExtra("title",item.getTitle());
                i.putExtra("poster",item.getPosterPath());
                i.putExtra("pop",item.getPopularity().toString());
                i.putExtra("voa",item.getVoteAverage().toString());
                i.putExtra("voc",item.getVoteCount().toString());
                i.putExtra("adlt",item.getAdult().toString());
                i.putExtra("realDate",item.getReleaseDate());
                i.putExtra("lan",item.getOriginalLanguage());
                i.putExtra("overview",item.getOverview());
                context.startActivity(i);
            }
        });



    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MovieViewholder extends RecyclerView.ViewHolder{
        ImageView movieImage;
        TextView movieTitle;
        public MovieViewholder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.movieImage);
            movieTitle = itemView.findViewById(R.id.movieTitle);

        }
    }
}
