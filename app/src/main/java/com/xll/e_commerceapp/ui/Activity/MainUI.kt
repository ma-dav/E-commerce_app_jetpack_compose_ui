package com.xll.e_commerceapp.ui.Activity

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.xll.e_commerceapp.R
import com.xll.e_commerceapp.ui.control.Screen


@Composable
fun MainUI(action: (id: String) -> Unit) {
    var isScreen by remember { mutableStateOf(true) }
    val start = listOf<EnterTransition>(slideInVertically())
    val end = listOf<ExitTransition>(slideOutHorizontally())
//    val Image1 = painterResource(id = R.drawable.image1)
    Box(
        modifier = Modifier.fillMaxSize(), Alignment.BottomEnd
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedVisibility(visible = isScreen) { screen(1) }
            AnimatedVisibility(
                visible = !isScreen,
                enter = start.random(),
                exit = end.random()
            ) { screen(2) }
            Spacer(modifier = Modifier.padding(60.dp))
        }
        next {
            if (isScreen == false) action(Screen.Home.idScreen) else isScreen = false
        }
    }
}

@Composable
fun next(update: () -> Unit) {
    Column(
        modifier =
        Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFF3F3F3)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 30.dp, start = 30.dp, top = 20.dp, bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Skip",
                color = Color(0xFFB4B6BA),
                modifier = Modifier.padding(start = 5.dp),
                style = TextStyle(fontSize = 20.sp)
            )
            Box() {}
            Button(
                onClick = {
                    update()
//                    action(Screen.Home.idScreen)
                },
                modifier = Modifier, shape = RoundedCornerShape(20),
                contentPadding = PaddingValues(
                    end = 40.dp,
                    start = 40.dp,
                    top = 20.dp,
                    bottom = 20.dp
                ),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
            ) {
                Text(
                    text = "Next",
                    color = Color.White,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
            }
        }
    }
}

@Composable
private fun screen(state: Int) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (state == 1) {
            image(R.drawable.image1)
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(3.dp),
//                .border(2.dp, shape = RoundedCornerShape(20.dp), color = Color.Black),
                horizontalAlignment = Alignment.Start
            ) {
                TextB("No more\n" + "boring things")
                TextC("Picking up accessories from \n" + "popular European brands.")
            }
        } else if (state == 2) {
            image(R.drawable.image2)
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(3.dp),
//                .border(2.dp, shape = RoundedCornerShape(20.dp), color = Color.Black),
                horizontalAlignment = Alignment.Start
            ) {
                TextB("Exploring the\n" + "fashion trends")
                TextC("We form assortment that\n" + "follows fashion trends")
            }
        }

    }
}

@Composable
private fun TextB(text: String) {
    Text(
        modifier = Modifier.padding(end = 30.dp, start = 30.dp, top = 20.dp, bottom = 5.dp),
        text = text,
        style = TextStyle(
            color = Color.Black,
            fontSize = 35.sp,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Medium
        )
    )
}

@Composable
private fun TextC(text: String) {
    Text(
        modifier = Modifier.padding(end = 30.dp, start = 30.dp, top = 5.dp, bottom = 20.dp),
        text = text,
        style = TextStyle(
            color = Color(0xFF848688),
            fontSize = 20.sp,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Light, lineHeight = 30.sp
        )
    )
}

@Composable
private fun image(id: Int) {
    AnimatedVisibility(visible = true) {
        AsyncImage(
            modifier = Modifier.size(400.dp),
            model = id,
            contentDescription = "TopImage"
        )
    }
}
