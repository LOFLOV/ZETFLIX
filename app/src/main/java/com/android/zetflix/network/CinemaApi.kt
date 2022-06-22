package com.android.zetflix.network

import com.android.zetflix.model.MovieExample
import com.android.zetflix.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CinemaApi {

    @GET("movie/76341")
    suspend fun getMoviesExample(@Query("api_key") apiKey: String): MovieExample

    @GET("discover/movie")
    suspend fun getMovies(@Query("api_key") apiKey: String): MovieResponse
}
