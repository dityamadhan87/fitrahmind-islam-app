package com.bignerdranch.fitrahmind_app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bignerdranch.fitrahmind_app.R
import androidx.compose.runtime.setValue
import com.bignerdranch.fitrahmind_app.ui.theme.FitrahmindappTheme

class MainActivity : ComponentActivity() {
//    private val repository = SuratRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitrahmindappTheme {
                MainScreen()
            }
//            repository.uploadSurat()
//            repository.uploadAyat()
        }
    }
}


sealed class Screen (val route: String, val icon: Int){
    object Home : Screen("home", R.drawable.fluent_home_32_regular)
    object Article : Screen("fitrahArticle", R.drawable.hugeicons_quran_01)
    object Quran : Screen("quran", R.drawable.hugeicons_quran_01)
    object Profile : Screen("profile", R.drawable.iconamoon_profile)
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        Screen.Home,
        Screen.Article,
        Screen.Quran,
        Screen.Profile
    )

    NavigationBar(
        containerColor = Color(0xFFE9EFEC),
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(painterResource(id = screen.icon), contentDescription = screen.route) },
                label = { Text(text = screen.route) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    var showSplash by remember { mutableStateOf(true) }

    if (showSplash) {
        splashScreen(
            onSplashEnd = {
                showSplash = false
            }
        )
    } else {
        Scaffold(
            bottomBar = {
                if (currentRoute in
                    listOf(
                        Screen.Home.route,
                        Screen.Profile.route,
                        Screen.Article.route,
                        Screen.Quran.route
                    )
                ) {
                    BottomNavigationBar(navController)
                }
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Screen.Quran.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(Screen.Home.route) { HomePage() }
//                composable(Screen.Profile.route) { ProfileScreen() }
//                composable(Screen.Article.route) { ArticleScreen() }
                composable(Screen.Quran.route) { QuranScreen(navController) }
                composable("surat/{idSurat}") { backStackEntry ->
                    val idSurat = backStackEntry.arguments?.getString("idSurat") ?: ""
                    QuranDetailsScreen(idSurat)
                }
            }
        }
    }
}