package com.example.myapplicationtp

import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.grid.items
import androidx.navigation.NavController
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myapplicationtp.ui.theme.MyBlue
import com.example.myapplicationtp.ui.theme.MyGrey


@Composable
fun ScreenFilmsDetails(ViewModel: MainViewModel,
                        //windowClass: WindowSizeClass
                       idFilm: Int
) {

    val film by ViewModel.movieById.collectAsState()


    LaunchedEffect(idFilm)
    {
        ViewModel.getFilmbyId(idFilm)
    }

    LazyVerticalGrid(columns = GridCells.Fixed(2),
        modifier = Modifier.padding(top = 130.dp),

        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)) {

        film?.let{movie ->
    item {
        FilmDetailsItem(movie)
    }
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
fun FilmDetailsItem(movie: UnFilm) {

    Column (Modifier.fillMaxSize()
        ,
        verticalArrangement = Arrangement.Center
    ){

        LesImages(movie)
        Titre(movie)

    }
}

@Composable
fun oTitre(movie: UnFilm,
          navController: NavController){
    Text(
        text = movie.title,
        color = MyBlue,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
}

@Composable
fun oDate(movie: UnFilm,
         navController: NavController){
    Text(
        text = movie.release_date,
        color = MyGrey,
        fontSize = 12.sp
    )
}

@Composable
fun oLesImages(movie: UnFilm){
    AsyncImage(
        model = "https://image.tmdb.org/t/p/w780${movie.poster_path}",
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxHeight()
            .width(250.dp)
    )
}


@Composable
fun Titre(movie: UnFilm){
    Text(
        text = movie.title,
        color = MyBlue,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
}




