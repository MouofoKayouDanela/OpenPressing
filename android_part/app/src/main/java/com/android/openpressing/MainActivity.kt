package com.android.openpressing

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.tooling.preview.Preview
import com.android.openpressing.ui.theme.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.android.openpressing.client_module.presentation.Default
//import com.android.openpressing.client_module.presentation.FormScreen
//import com.android.openpressing.client_module.presentation.PageScreen
//import com.android.openpressing.client_module.presentation.form


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpenPressingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DefaultPreview()

                        //PageScreen()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OpenPressingTheme {
        //PageScreen()
        //FormScreen()
        //form()
        //Default()
    }
}