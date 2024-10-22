package com.example.myapplicationtp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.jvm.internal.Intrinsics.Kotlin

class MainViewModel : ViewModel() {

    val movies = MutableStateFlow<List<UnFilm>>(listOf())

    val api_key = "b57151d36fecd1b693da830a2bc5766f"


    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build();

    val api = retrofit.create(Api::class.java)


    fun getMovies() {
        viewModelScope.launch {
            movies.value = api.lastmovies(api_key).results
    }
}
}
