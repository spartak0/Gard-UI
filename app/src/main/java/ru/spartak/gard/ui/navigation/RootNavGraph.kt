package ru.spartak.gard.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.spartak.gard.ui.confirmation_screen.ConfirmationScreen
import ru.spartak.gard.ui.level_up_screen.LevelUpScreen
import ru.spartak.gard.ui.main_screen.MainScreen

@Composable
fun RootNavGraph(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        route = Graphs.Root,
        modifier = modifier
    ) {
        composable(route = Graphs.Main) {
            MainScreen(rootNavController = navController)
        }
        composable(route = RootScreen.LevelUpScreen.route) {
            LevelUpScreen(
                navController = navController,)
        }
        composable(route = RootScreen.Confirmation.route) {
            ConfirmationScreen(
                navController = navController,)
        }
    }
}