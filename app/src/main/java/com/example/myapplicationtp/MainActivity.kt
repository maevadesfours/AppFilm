package com.example.myapplicationtp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.myapplicationtp.ui.theme.MyApplicationTPTheme
import kotlinx.serialization.Serializable

import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplicationtp.ui.theme.MyBlue

@kotlinx.serialization.Serializable
class Films
@Serializable
class Series
@Serializable
class Acteurs

@Serializable
class Profil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination


            Scaffold(

                bottomBar = {
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
                            contentDescription = "film icon"
                        )},
                        label = { Text("Acteurs") },
                        selected = currentDestination?.hasRoute<Acteurs>() == true,
                        onClick = { navController.navigate(Acteurs()) })
                }
                })
            { innerPadding ->
                NavHost(modifier = Modifier.padding(innerPadding),
                    navController= navController,
                    startDestination = Profil()
                ) {

                    composable<Films> { FilmsScreen(windowSizeClass) }
                    composable<Series> { SeriesScreen(windowSizeClass) }
                    composable<Acteurs> { ActeursScreen(windowSizeClass) }
                    composable<Profil> { Screen(windowSizeClass)}
                }
            }

        }
    }
 }

@Composable
fun Profil(windowClass: WindowSizeClass) {

}

@Composable

fun Screen(windowClass: WindowSizeClass) {
    when (windowClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> {
            MyApplicationTPTheme {
                Home()
            }
        }
        else -> {
            MyApplicationTPTheme {
                HomeHorizontal("Android")
            }
        }
    }
}

@Composable
fun Films(windowClass: WindowSizeClass) {

            }
@Composable
fun FilmsScreen(windowClass: WindowSizeClass) {
    when (windowClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> {
            MyApplicationTPTheme {
                PageFilms()
            }
        }
        else -> {
            MyApplicationTPTheme {
                HomeHorizontal("Android")
            }
        }
    }

}


@Composable
fun Series(windowClass: WindowSizeClass) {
}

@Composable
fun SeriesScreen(windowClass: WindowSizeClass) {
    when (windowClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> {
            MyApplicationTPTheme {
                PageSeries()
            }
        }
        else -> {
            MyApplicationTPTheme {
                HomeHorizontal("Android")
            }
        }
    }

}

@Composable
fun Acteurs(windowClass: WindowSizeClass) {

}
@Composable
fun ActeursScreen(windowClass: WindowSizeClass) {
    when (windowClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> {
            MyApplicationTPTheme {
                PageActeurs()
            }
        }
        else -> {
            MyApplicationTPTheme {
                HomeHorizontal("Android")
            }
        }
    }

}

@Composable
fun PageFilms(){
    Text(
        text = "Les films",
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        color = MyBlue,
        fontSize = 30.sp,
        modifier = Modifier.padding(80.dp)
    )
}

@Composable
fun PageSeries(){
    Text(
        text = "Les séries",
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        color = MyBlue,
        fontSize = 30.sp,
        modifier = Modifier.padding(80.dp)
    )
}

@Composable
fun PageActeurs(){
    Text(
        text = "Les acteurs",
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        color = MyBlue,
        fontSize = 30.sp,
        modifier = Modifier.padding(80.dp)
    )
}



