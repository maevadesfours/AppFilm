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
fun ScreenSeriesDetails(ViewModel: MainViewModel,
    //windowClass: WindowSizeClass
                       idSerie: Int
) {

    val serie by ViewModel.serieById.collectAsState()


    LaunchedEffect(idSerie)
    {
        ViewModel.getSeriebyId(idSerie)
    }

    LazyVerticalGrid(columns = GridCells.Fixed(1),
        modifier = Modifier.padding(top = 10.dp),

        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)) {

        serie?.let{laSerie ->
            item {
                SerieDetailsItem(laSerie)
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
fun SerieDetailsItem(laSerie: UneSerie) {

    Column (Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ){


        LeTitreSerie(laSerie)
        Spacer(modifier= Modifier.height(40.dp))

        Row (Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Absolute.Center){

            LesAffichesSerie(laSerie)
            DescriptionSerie(laSerie)
        }

        Spacer(modifier= Modifier.height(30.dp))
        SynopsisSerie(laSerie)

        Spacer(modifier= Modifier.height(30.dp))
        ActeursSerie(laSerie)

        //Spacer(modifier= Modifier.height(40.dp))

    }
}

@Composable
fun LeTitreSerie(laSerie: UneSerie){
    Text(
        text = laSerie.name,
        color = MyBlue,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    )
}

@Composable
fun DescriptionSerie(laSerie: UneSerie){
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
            text = laSerie.first_air_date,
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

        laSerie.genres?.forEach { genre ->
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
        laSerie.origin_country?.forEach { country ->
            Text(text = country,
                color = MyGrey,
                fontSize = 18.sp)
        }
    }
}


@Composable
fun LesAffichesSerie(laSerie: UneSerie){
    AsyncImage(
        model = "https://image.tmdb.org/t/p/w780${laSerie.poster_path}",
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxHeight()
            .width(200.dp)
            .padding(20.dp)
    )
}


@Composable
fun SynopsisSerie(laSerie: UneSerie){
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
            text = laSerie.overview,
            color = MyGrey,
            fontSize = 18.sp
        )
    }
}

@Composable
fun ActeursSerie(laSerie: UneSerie){
    Column (Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom){

        Text(
            text = "Acteurs",
            color = MyBlue,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )

        Spacer(modifier= Modifier.height(20.dp))

        val lesActeurs = laSerie.credits?.cast?.take(5) ?: emptyList()

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




