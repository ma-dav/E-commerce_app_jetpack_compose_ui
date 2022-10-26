package com.xll.e_commerceapp.ui.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.xll.e_commerceapp.ui.control.NavigatingControl


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(Modifier.fillMaxSize()) {
                NavigatingControl(this@MainActivity)
            }
        }
    }
}

