package com.example.myapplicationtp

import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") api_key: String): ListeFilms

    @GET("trending/tv/week")
    suspend fun lastseries(@Query("api_key") api_key: String): ListeSeries

    @GET("trending/person/week")
    suspend fun lastacteurs(@Query("api_key") api_key: String): ListeActeurs

    @GET("search/movie")
    suspend fun requestedmovies(
        @Query("api_key")  api_key: String,
        @Query("language") language: String,
        @Query("query") query: String
    ): ListeFilms

    @GET("search/tv")
    suspend fun requestedseries(
        @Query("api_key")  api_key: String,
        @Query("language") language: String,
        @Query("query") query: String
    ): ListeSeries

    @GET("search/person")
    suspend fun requestedacteurs(
        @Query("api_key")  api_key: String,
        @Query("language") language: String,
        @Query("query") query: String
    ): ListeActeurs
}
