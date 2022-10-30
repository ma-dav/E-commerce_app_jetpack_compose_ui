package com.xll.e_commerceapp.ui.Activity

import android.content.Context
import android.view.LayoutInflater
import android.widget.EditText
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import coil.compose.AsyncImage
import com.xll.e_commerceapp.R
import com.xll.e_commerceapp.ui.Activity.xml.adpter.HomeAdpter
import com.xll.e_commerceapp.ui.Activity.xml.adpter.data
import com.xll.e_commerceapp.ui.control.BottomNavigation.CustomBottomNavigation
import com.xll.e_commerceapp.ui.control.BottomNavigation.ScreenHome

@Composable
fun Home(action: (id: String) -> Unit, context: Context) {

    var currentScreen by remember{
        mutableStateOf<ScreenHome>(ScreenHome.Home)
    }
   Box {

       LazyColumn {
           item { SearchXml() }
           item { topMenu() }
           item { offShoes() }
           item { NewItemText() }
           item { RecyclerViewXml(context)}
           listItem()

       }
       Row(modifier = Modifier.fillMaxSize() , verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Center) {
           CustomBottomNavigation(currentScreenId = currentScreen.id,){ id->
               currentScreen = id
           }
       }
   }




}


@Stable
fun  LazyListScope.listItem(){
    items(10){

    }
}
@Composable
fun NewItemText() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "New Items",
            style = TextStyle(
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.Light
            )
        )
    }
}
@Composable
fun topMenu() {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        itemMenu(R.drawable.grid, "All")
        itemMenu(R.drawable.hawaiian_shirt, "Clothing")
        itemMenu(R.drawable.accessories, "Accessories")
        itemMenu(R.drawable.shopping, "bags")
    }
}

@Composable
fun offShoes() {
    Card(
        shape = RoundedCornerShape(20.dp), modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .background(shape = RoundedCornerShape(20.dp), color = Color(0xFFF3F3F3))
                ) {
                    AsyncImage(
                        model = R.drawable.discount, contentDescription = "", modifier = Modifier
                            .size(80.dp)
                            .padding(15.dp)
                    )
                }
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "50% OFF", style = TextStyle(fontSize = 25.sp))
                    Text(text = "on cll women's shoes", style = TextStyle(fontSize = 15.sp))
                }
            }
            Box {}
            Icon(
                Icons.Filled.KeyboardArrowRight, contentDescription = "", modifier = Modifier
                    .size(40.dp)
                    .padding(end = 20.dp)
            )
        }
    }
}


@Composable
fun itemMenu(icon: Int, text: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp)
    ) {
        Card(shape = RoundedCornerShape(250.dp), modifier = Modifier.size(70.dp)) {
            AsyncImage(modifier = Modifier.padding(20.dp), model = icon, contentDescription = text)
        }
        Text(text = text, modifier = Modifier.padding(7.dp))
    }
}

@Composable
fun SearchXml() {
    AndroidView(modifier = Modifier.fillMaxWidth(),
        factory = { context ->
            val view = LayoutInflater.from(context).inflate(R.layout.layout, null, false)
            val editText = view.findViewById<EditText>(R.id.edittext)

            // do whatever you want...
            view // return the view
        },
        update = {
            // Update the view
        }
    )
}

@Composable
fun RecyclerViewXml(context: Context) {
    AndroidView(modifier = Modifier.fillMaxWidth(),
        factory = { context ->
            var GridLayout = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            val view = LayoutInflater.from(context).inflate(R.layout.recyclerviewxml, null, false)
            val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
            var adapter = HomeAdpter(context)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = GridLayout
            data.d1(adapter)
            // do whatever you want...
            view // return the view
        },
        update = {
            // Update the view
        }
    )
}