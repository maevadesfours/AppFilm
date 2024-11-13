package com.example.myapplicationtp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.test.services.storage.file.PropertyFile.Column
import coil.compose.AsyncImage
import com.example.myapplicationtp.ui.theme.MyBlue
import com.example.myapplicationtp.ui.theme.MyGrey


@Composable
fun CollectionsScreen(
    viewModel: MainViewModel

) {
    val collections by viewModel.collections.collectAsState()
    var text by rememberSaveable { mutableStateOf("") }
    var isSearchActive by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(Unit)
    {
        viewModel.getCollections()
    }

    LazyVerticalGrid(columns = GridCells.Fixed(2),
        modifier = Modifier.padding(top = 130.dp),

        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)) {

        items(collections) { collection ->
            CollectionItem(collection = collection)
        }

    }
    leTitre()
}

@Composable
fun CollectionItem(collection : UneCollection ){

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top){


    TitreCo(collection)
        LesImagesCo(collection)
    }
}

@Composable
fun leTitre(){
    Text(
        text = "Les collections" ,
        color = MyBlue,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
    )
}


@Composable
fun TitreCo(collection: UneCollection){
    Text(
        text = collection.name,
        color = MyGrey,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
}

@Composable
fun LesImagesCo(collection: UneCollection){
    AsyncImage(
        model = "https://image.tmdb.org/t/p/w780${collection.poster_path}",
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxHeight()
            .width(250.dp)
    )
}

