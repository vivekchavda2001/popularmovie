package com.qzzo.popularmovies;

import android.graphics.Movie;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class FetchMovie {
    private static final String KEY  = "YOUR_API_KEY";
    private static final String URL  = "https://api.themoviedb.org/3/movie/popular/";
    public static MovieService movieService = null;
    public static MovieService getMovieService(){
        if(movieService ==  null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            movieService = retrofit.create(MovieService.class);

        }
        return  movieService;
    }
    public interface MovieService{
        @GET("?api_key="+KEY)
        Call<MovieList> getMovieList();
    }

}
