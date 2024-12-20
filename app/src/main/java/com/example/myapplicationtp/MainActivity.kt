package com.example.myapplicationtp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavController

import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.myapplicationtp.ui.theme.MyApplicationTPTheme
import kotlinx.serialization.Serializable

import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.example.myapplicationtp.ui.theme.MyBlue

@kotlinx.serialization.Serializable
class Films
@Serializable
class Series
@Serializable
class Acteurs
@Serializable
class Home
@Serializable
class Collections

@Serializable
class FilmDetails(val id: Int)
@Serializable
class SeriesDetails(val id: Int)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            val viewModel : MainViewModel = viewModel()
            val startDestination = "home"


            Scaffold(

                bottomBar = {
                    if (currentDestination?.hasRoute<Home>()==false) {
                        when (windowSizeClass.windowWidthSizeClass) {
                            WindowWidthSizeClass.COMPACT -> {
                                NavigationBar {
                                    NavigationBarItem(
                                        icon = {
                                            Icon(
                                                painterResource(id = R.drawable.baseline_movie_24),
                                                contentDescription = "film icon"
                                            )},
                                        label = { Text("Films") },
                                        selected = currentDestination?.hasRoute<Films>() == true,
                                        onClick = { navController.navigate(Films()) })
                                    NavigationBarItem(
                                        icon = {  Icon(
                                            painterResource(id = R.drawable.baseline_local_movies_24),
                                            contentDescription = "serie icon"
                                        )},
                                        label = { Text("Séries") },
                                        selected = currentDestination?.hasRoute<Series>() == true,
                                        onClick = { navController.navigate(Series()) })

                                    NavigationBarItem(
                                        icon = {Icon(
                                            painterResource(id = R.drawable.baseline_person_24),
                                            contentDescription = "acteur icon"
                                        )},
                                        label = { Text("Acteurs") },
                                        selected = currentDestination?.hasRoute<Acteurs>() == true,
                                        onClick = { navController.navigate(Acteurs()) })

                                    NavigationBarItem(
                                        icon = {Icon(
                                            painterResource(id = R.drawable.baseline_collections_bookmark),
                                            contentDescription = "collections icon"
                                        )},
                                        label = { Text("Collections") },
                                        selected = currentDestination?.hasRoute<Collections>() == true,
                                        onClick = { navController.navigate(Collections()) })


                                }
                            }
                        }
                    }
                },
            )



            { innerPadding ->

                Row( modifier = Modifier.fillMaxSize().padding(innerPadding) ) {
                    if (currentDestination?.hasRoute<Home>() == false
                        && windowSizeClass.windowWidthSizeClass != WindowWidthSizeClass.COMPACT
                    ) {

                        NavigationRail(
                            modifier = Modifier.fillMaxHeight()){

                        NavigationRailItem(
                            icon = {
                                Icon(
                                    painterResource(id = R.drawable.baseline_movie_24),
                                    contentDescription = "film icon"
                                )},
                            label = { Text("Films") },
                            selected = currentDestination?.hasRoute<Films>() == true,
                            onClick = { navController.navigate(Films()) })

                        NavigationRailItem(
                            icon = {  Icon(
                                painterResource(id = R.drawable.baseline_local_movies_24),
                                contentDescription = "serie icon"
                            )},
                            label = { Text("Séries") },
                            selected = currentDestination?.hasRoute<Series>() == true,
                            onClick = { navController.navigate(Series()) })

                        NavigationRailItem(
                            icon = {Icon(
                                painterResource(id = R.drawable.baseline_person_24),
                                contentDescription = "film icon"
                            )},
                            label = { Text("Acteurs") },
                            selected = currentDestination?.hasRoute<Acteurs>() == true,
                            onClick = { navController.navigate(Acteurs()) })
                    }
                }
            }



        Column {
            NavHost(modifier = Modifier.padding(innerPadding),
                navController= navController,
                startDestination = Home()
            ) {

                composable<Films> { FilmsScreen( viewModel, navController) }
                composable<Series> { SeriesScreen(viewModel, navController) }
                composable<Acteurs> { ActeursScreen(viewModel, navController) }
                composable<Collections> { CollectionsScreen(viewModel) }
                composable<Home> { Screen(windowSizeClass, navController)}

                composable<FilmDetails> { navBackStackEntry ->
                    val filmDetails : FilmDetails = navBackStackEntry.toRoute()
                    ScreenFilmsDetails(
                        viewModel,
                        //windowClass,
                        filmDetails.id
                    )
                }
                composable<SeriesDetails> { navBackStackEntry ->
                    val serieDetails : SeriesDetails = navBackStackEntry.toRoute()
                    ScreenSeriesDetails(
                        viewModel,
                        //windowClass,
                        serieDetails.id
                    )
                }
            }
        }
    }

        }
    }
}




