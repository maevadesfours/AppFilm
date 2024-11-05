package com.example.myapplicationtp

import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") api_key: String): ListeFilms

    @GET("trending/tv/week")
    suspend fun lastseries(@Query("api_key") api_key: String): ListeSeries


    @GET("search/movie")
    suspend fun requestedmovies(
        @Query("api_key")  api_key: String,
        @Query("language") language: String,
        @Query("query") query: String
    ): ListeFilms
}
