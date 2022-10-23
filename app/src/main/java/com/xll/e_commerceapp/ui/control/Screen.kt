package com.xll.e_commerceapp.ui.control

import com.xll.e_commerceapp.ui.Activity.MainActivity

sealed class Screen(val  idScreen :String){
    object Main : Screen("Main")
    object Home : Screen("Home")
}
