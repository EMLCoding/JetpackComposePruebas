package com.emlcoding.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.emlcoding.myapplication.ui.screens.detail.DetailScreen
import com.emlcoding.myapplication.ui.screens.main.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavItem.Main.route) {
        composable(NavItem.Main) {
            MainScreen { mediaItem ->
                navController.navigate(NavItem.Detail.createNavRoute(mediaItem.id))
            }
        }
        composable(NavItem.Detail) { backStackEntry ->
            DetailScreen(
                mediaId = backStackEntry.findArg(NavArg.MediaId),
                onUpClick = { navController.popBackStack() }
            )
        }
    }
}

// Es una funcion de extension
private fun NavGraphBuilder.composable(
    navItem: NavItem,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = navItem.route,
        arguments = navItem.args
    ) {
        content(it)
    }
}

private inline fun <reified T> NavBackStackEntry.findArg(arg: NavArg): T {
    val value = arguments?.get(arg.key)
    // Desde este punto el id se trata como valor no opcional
    requireNotNull(value)
    return value as T
}