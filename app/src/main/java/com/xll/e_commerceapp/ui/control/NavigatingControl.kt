package com.xll.e_commerceapp.ui.control

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.xll.e_commerceapp.ui.Activity.Home
import com.xll.e_commerceapp.ui.Activity.MainActivity

@Composable
fun NavigatingControl() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Main.idScreen) {
        composable(Screen.Main.idScreen) {
            MainActivity()
        }
        composable(Screen.Home.idScreen) {
            Home { navController.navigate( Screen.Main.idScreen) }

        }

    }

}
