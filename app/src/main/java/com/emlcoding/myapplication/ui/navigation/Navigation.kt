package com.emlcoding.myapplication.ui.navigation

import android.content.res.Configuration
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.emlcoding.myapplication.ui.screens.detail.DetailScreen
import com.emlcoding.myapplication.ui.screens.main.MainDetailScreen
import com.emlcoding.myapplication.ui.screens.main.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavItem.Main.route) {
        composable(NavItem.Main) {
            /*
            // Esto sirve para saber la orientacion del dispositivo
            if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT) {
                Text("Vertical")
            } else {
                Text("Horizontal")
            }*/

            // Este componente da el ancho y alto de la pantalla que ocupa el componente. Como es el componente de arranque da las dimensiones de la pantalla del dispositivo
            BoxWithConstraints {
                // Este when es como un if
                when {
                    maxWidth <= 600.dp -> {
                        MainScreen { mediaItem ->
                            navController.navigate(NavItem.Detail.createNavRoute(mediaItem.id))
                        }
                    }

                    else -> {
                        MainDetailScreen()
                    }
                }
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