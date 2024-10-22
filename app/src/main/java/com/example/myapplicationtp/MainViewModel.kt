package com.example.myapplicationtp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {

    val api_key = "b57151d36fecd1b693da830a2bc5766f"


    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build();

    val api = retrofit.create(Api::class.java)

    val movies = MutableStateFlow<List<UnFilm>>(listOf())

    fun getMovies() {
        viewModelScope.launch {
            movies.value = api.lastmovies(api_key).results
    }
}
}
