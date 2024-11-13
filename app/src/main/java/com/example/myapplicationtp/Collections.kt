package com.example.myapplicationtp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplicationtp.ui.theme.MyBlue


@Composable
fun CollectionsScreen(
    viewModel: MainViewModel,
    navController: NavController

) {
        leTitre()
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
