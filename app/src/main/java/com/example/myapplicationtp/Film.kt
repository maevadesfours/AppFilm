package com.example.myapplicationtp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.myapplicationtp.ui.theme.MyApplicationTPTheme

import java.nio.file.WatchEvent

@Composable
fun FilmsScreen(
    viewModel: MainViewModel,
    navController: NavController

) {
    val movies by viewModel.movies.collectAsState()


    LaunchedEffect(Unit)
    {
        viewModel.getMovies()
    }

    //when (windowClass.windowWidthSizeClass) {
       // WindowWidthSizeClass.COMPACT -> {
            LazyVerticalGrid(columns = GridCells.Fixed(2),
                modifier = Modifier.padding(16.dp),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)) {

                items(movies) { movie ->
                    MovieItem(movie = movie, navController = navController)
                }
                /* }
             }
             else -> {
                 MyApplicationTPTheme {
                     HomeHorizontal("Android")
                 }
             }*/
    }

}

@Composable
fun MovieItem(movie: UnFilm,
              navController: NavController) {

    Text(
        text = movie.title
    )

}



