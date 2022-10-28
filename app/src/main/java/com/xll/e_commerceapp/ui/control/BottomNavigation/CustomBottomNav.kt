package com.xll.e_commerceapp.ui.control.BottomNavigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomBottomNavigation(currentScreenId:String,onItemSelected:(ScreenHome)->Unit) {
        val items = ScreenHome.Items.list
      Row(
          modifier = Modifier
              .background(
              shape = RoundedCornerShape(topEnd = 50.dp, topStart = 50.dp), color = MaterialTheme.colors.background
              )
              .padding(8.dp)
              .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
      , verticalAlignment = Alignment.CenterVertically
      ) {

       items.forEach { item->
           CustomBottomNavigationItem(item = item, isSelected = item.id ==currentScreenId ){
               onItemSelected(item)
           }
       }

      }
}

@Composable
fun CustomBottomNavigationItem(item :ScreenHome,isSelected:Boolean ,onClick :()->Unit) {
    val background = if(isSelected) MaterialTheme.colors.primary.copy(alpha = 0.1f) else Color.Transparent
    val contentColor = if(isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground


    Box(modifier = Modifier
        .clip(CircleShape)
        .background(background)
        .clickable { onClick() }) {
      Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {


          if (item.id == "Heart" ) Icon(painter = painterResource(id = item.iconInt), modifier = Modifier.size(25.dp), contentDescription = null, tint = contentColor) else Icon(imageVector =item.icon, modifier = Modifier.size(25.dp),  contentDescription = null, tint = contentColor)
          AnimatedVisibility(visible = isSelected) {
              Text(text = item.title, color = contentColor)
          }
      }
    }
}
@Composable
@Preview
fun prev1(){
    CustomBottomNavigation(currentScreenId = ScreenHome.Home.id){

    }
}
@Composable
@Preview
fun prev2(){
    CustomBottomNavigationItem(item = ScreenHome.Home,isSelected = true){

    }
}