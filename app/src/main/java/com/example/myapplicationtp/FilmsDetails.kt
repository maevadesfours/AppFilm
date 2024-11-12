package com.example.myapplicationtp

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.painterResource
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

    LazyVerticalGrid(columns = GridCells.Fixed(1),
        modifier = Modifier.padding(top = 10.dp),

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

    Column (Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ){

        //LesImages(movie)
        LeTitre(movie)
        Spacer(modifier= Modifier.height(40.dp))

        Row (Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Absolute.Center){

            LesAffiches(movie)
            Description(movie)
        }

        Spacer(modifier= Modifier.height(30.dp))
        Synopsis(movie)

        Spacer(modifier= Modifier.height(30.dp))
        Acteurs(movie)

        //Spacer(modifier= Modifier.height(40.dp))

    }
}

@Composable
fun LeTitre(movie: UnFilm){
    Text(
        text = movie.title,
        color = MyBlue,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    )
}

@Composable
fun Description(movie: UnFilm){
    Column (Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom){

    Spacer(modifier= Modifier.height(20.dp))

    Text(
        text = "Date de sortie :",
        color = MyGrey,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )

    Text(
        text = movie.release_date,
        color = MyGrey,
        fontSize = 18.sp
    )

        Spacer(modifier= Modifier.height(25.dp))

    Text(
        text = "Genres :",
        color = MyGrey,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )

        movie.genres?.forEach { genre ->
            Text(text = genre.name,
                color = MyGrey,
                fontSize = 18.sp)
        }

        Spacer(modifier= Modifier.height(25.dp))

        Text(
            text = "Nationalité :",
            color = MyGrey,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        movie.origin_country.forEach { country ->
            Text(text = country,
                color = MyGrey,
                fontSize = 18.sp)
        }
    }
}


@Composable
fun LesAffiches(movie: UnFilm){
    AsyncImage(
        model = "https://image.tmdb.org/t/p/w780${movie.poster_path}",
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxHeight()
            .width(200.dp)
            .padding(20.dp)
    )
}


@Composable
fun Synopsis(movie: UnFilm){
    Column (Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom){

    Text(
        text = "Synopsis",
        color = MyBlue,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp
    )

    Spacer(modifier= Modifier.height(20.dp))

    Text(
        text = movie.overview,
        color = MyGrey,
        fontSize = 18.sp
    )
}
}

@Composable
fun Acteurs(movie: UnFilm){
    Column (Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom){

        Text(
            text = "Acteurs",
            color = MyBlue,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )

        Spacer(modifier= Modifier.height(20.dp))

        val lesActeurs = movie.credits?.cast?.take(5) ?: emptyList()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        ) {

            lesActeurs.forEach { unActeur ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(4.dp)
                ) {


                    AsyncImage(
                        model = "https://image.tmdb.org/t/p/w500${unActeur.profile_path}",
                        contentDescription = unActeur.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(200.dp)
                            .padding(20.dp)
                    )


                        Text(
                            text = unActeur.name,
                            modifier = Modifier.padding(top = 8.dp),
                            color = MyGrey,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )


            }
        }

    }
    }
}




