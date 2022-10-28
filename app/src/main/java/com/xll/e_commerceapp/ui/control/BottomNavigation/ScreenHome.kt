package com.xll.e_commerceapp.ui.control.BottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.xll.e_commerceapp.R


sealed class ScreenHome(
    var id :String, val title :String, val icon :ImageVector = Icons.Outlined.Home, var iconInt : Int = 0
) {
    object Home :ScreenHome("home","Home",Icons.Outlined.Home)
    object Heart :ScreenHome("Heart","Heart", iconInt =  R.drawable.heart)
    object Basket :ScreenHome("Basket","Basket",Icons.Outlined.ShoppingCart)
    object Profile :ScreenHome("Profile","Profile",Icons.Outlined.Person)
    object Items{
        val list= listOf(Home,Heart,Basket,Profile)
    }
}