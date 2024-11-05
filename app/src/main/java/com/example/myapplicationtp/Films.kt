package com.example.myapplicationtp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplicationtp.ui.theme.MyBlue
import com.example.myapplicationtp.ui.theme.MyGrey

import coil.compose.AsyncImage

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
    Column (Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
     Text(
        text = "Les films" ,
        color = MyBlue,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,

     )
        Spacer(modifier = Modifier.height(16.dp)) }


            LazyVerticalGrid(columns = GridCells.Fixed(2),
                modifier = Modifier.padding(top = 30.dp),

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

    Column (Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center){

    LesImages(movie)
    Titre(movie, navController)
    Date(movie, navController)
    }
}

@Composable
fun Titre(movie: UnFilm,
         navController: NavController){
    Text(
        text = movie.title,
        color = MyBlue,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
}

@Composable
fun Date(movie: UnFilm,
         navController: NavController){
    Text(
        text = movie.release_date,
        color = MyGrey,
        fontSize = 12.sp
    )
}

@Composable
fun LesImages(movie: UnFilm){
    AsyncImage(
    model = "https://image.tmdb.org/t/p/w780${movie.poster_path}",
    contentDescription = null,
    contentScale = ContentScale.Crop,
    modifier = Modifier.fillMaxHeight()
            .width(250.dp)
    )
}




