package com.android.zetflix.network

import com.android.zetflix.model.Movie
import retrofit2.http.GET
import retrofit2.http.Query

interface CinemaApi {

    @GET("movie/76341")
    suspend fun getMovies(@Query("api_key") apiKey: String): Movie

}