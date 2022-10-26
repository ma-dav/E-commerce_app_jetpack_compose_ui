package com.xll.e_commerceapp.ui.control

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.xll.e_commerceapp.ui.Activity.Home
import com.xll.e_commerceapp.ui.Activity.MainActivity
import com.xll.e_commerceapp.ui.Activity.MainUI

@Composable
fun NavigatingControl(context: Context) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Main.idScreen) {
        composable(Screen.Main.idScreen) {
            MainUI{it->
                navController.navigate(it)
            }
        }
        composable(Screen.Home.idScreen) {
            Home(context = context, action = {navController.navigate(it)})
        }

    }

}
