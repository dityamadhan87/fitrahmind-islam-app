package com.bignerdranch.fitrahmind_app.view

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
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bignerdranch.fitrahmind_app.R
import com.bignerdranch.fitrahmind_app.ui.theme.FitrahmindappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitrahmindappTheme {
                MainScreen()
            }
        }
    }
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
    var showSplash by remember { mutableStateOf(true) }

    if (showSplash){
        splashScreen(
            onSplashEnd = {
                showSplash = false
            }
        )
    }

    else{
        Scaffold(
            bottomBar = { BottomNavigationBar(navController) }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(Screen.Home.route) { HomePage() }
                composable(Screen.Profile.route) { ProfileScreen() }
                composable(Screen.Article.route) { ArticleScreen() }
                composable(Screen.Quran.route) { QuranScreen() }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    FitrahmindappTheme {
        MainScreen()
    }
}

sealed class Screen (val route: String, val icon: Int){
    object Home : Screen("Home", R.drawable.fluent_home_32_regular)
    object Article : Screen("Fitrah Article", R.drawable.hugeicons_quran_01)
    object Quran : Screen("Al-Qur'an", R.drawable.hugeicons_quran_01)
    object Profile : Screen("Profile", R.drawable.iconamoon_profile)
}