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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActeursScreen(
    viewModel: MainViewModel,
    navController: NavController

) {
    val acteurs by viewModel.acteurs.collectAsState()
    var text by rememberSaveable { mutableStateOf("") }
    var isSearchActive by rememberSaveable { mutableStateOf(false) }


    LaunchedEffect(Unit)
    {
        viewModel.getActeurs()
    }

    //when (windowClass.windowWidthSizeClass) {
    // WindowWidthSizeClass.COMPACT -> {
    Column (Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top){

        Text(
            text = "Les acteurs" ,
            color = MyBlue,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
        )

        SearchBar(
            query = text,
            onQueryChange = { text = it },
            onSearch = { isSearchActive = false; viewModel.getSearchActeurs(text) },
            placeholder = { Text("Chercher") },
            active =  isSearchActive,
            onActiveChange = { isSearchActive = it },

            ) {
        }
    }

    LazyVerticalGrid(columns = GridCells.Fixed(2),
        modifier = Modifier.padding(top = 130.dp),

        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)) {

        items(acteurs) { acteur ->
            ActeurItem(acteur = acteur, navController = navController)
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
fun ActeurItem(acteur: UnActeur,
              navController: NavController) {

    Column (Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center){

        LesImages(acteur)
        Titre(acteur, navController)
        Date(acteur, navController)
    }
}

@Composable
fun Titre(acteur: UnActeur,
          navController: NavController){
    Text(
        text = acteur.name,
        color = MyBlue,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
}

@Composable
fun Date(acteur: UnActeur,
         navController: NavController){

    /*Text(
        text = acteur.birthday.toString(),
        color = MyBlue,
        fontWeight = FontWeight.Bold,
    )*/
}

@Composable
fun LesImages(acteur: UnActeur){
    AsyncImage(
        model = "https://image.tmdb.org/t/p/w780${acteur.profile_path}",
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxHeight()
            .width(250.dp)
    )
}




