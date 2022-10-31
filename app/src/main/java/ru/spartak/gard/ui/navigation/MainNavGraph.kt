package ru.spartak.gard.ui.navigation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.spartak.gard.ui.navigation.content.gamesContentComposable
import ru.spartak.gard.ui.root_screen.main_screen.games_tab.games_screen.GamesScreen
import ru.spartak.gard.ui.root_screen.main_screen.home_tab.home_screen.HomeScreen

@Composable
fun MainNavGraph(
    navController: NavHostController,
    startDestination: String,
    rootNavController: NavController,
    modifier: Modifier=Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = BottomScreen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = BottomScreen.GamesScreen.route) {
            GamesScreen(navController = navController)
        }
        composable(route = BottomScreen.TasksScreen.route) {
        }
        composable(route = BottomScreen.ShopScreen.route) {
        }
        homeContentComposable(rootNavController = rootNavController, mainNavController = navController)
        gamesContentComposable(rootNavController = rootNavController, mainNavController = navController)
    }
}


fun NavController.navigate(
    route: String,
    params: Bundle?,
    builder: NavOptionsBuilder.() -> Unit = {}
) {
    this.currentBackStackEntry?.arguments?.putAll(params)
    navigate(route, builder)
}