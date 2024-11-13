package com.example.myapplicationtp

import retrofit2.http.GET
import retrofit2.http.Path
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

    @GET("search/collection?")
    suspend fun lescollections(
        @Query("api_key")  api_key: String,
        @Query("language") language: String,
        @Query("query") query: String
    ): ListeCollections




    @GET("movie/{id}?append_to_response=credits")
    suspend fun moviedetails(
        @Path("id") idFilm: Int,
        @Query("api_key")  api_key: String,
        @Query("language") language: String
    ): UnFilm

    @GET("tv/{id}?append_to_response=credits")
    suspend fun serieedetails(
        @Path("id") idSerie: Int,
        @Query("api_key")  api_key: String,
        @Query("language") language: String
    ): UneSerie

}

