package com.android.openpressing.client_module.presentation.profile

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.android.openpressing.R
import com.android.openpressing.utils.Screen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyScreen(navController: NavHostController) {
    Scaffold(
        topBar = { MyTopBar(navController) }
    ) {
        MyCardView()
    }
}

@Composable
fun MyTopBar(navController: NavHostController) {
    TopAppBar(
        title = { Text(text = "Qui somme-nous") },
        //backgroundColor = Color.Blue,
        navigationIcon = { IconButton(onClick = {navController.navigate(Screen.Profile.road)}) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Back")

        }

        }
    )
}


@Composable
fun MyCardView() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            //.border( Color.Gray, RoundedCornerShape(16.dp))
            .padding(10.dp),
        contentAlignment = Alignment.Center

    ) {
        Card(
            modifier = Modifier.padding(16.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = 4.dp,
            //backgroundColor = Color.White
        ) {



            Row(modifier = Modifier
                .fillMaxWidth()
            ) {
                Text(
                    text = "FAQS",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(16.dp)
                )
                Spacer(modifier = Modifier.width(30.dp))


                Icon(
                    painter = painterResource(R.drawable.go),
                    contentDescription = null,
                    modifier = Modifier.padding(16.dp)
                )

                Spacer( modifier = Modifier.padding(16.dp))

            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Terme & condition ",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(16.dp)
                )
                Spacer(modifier = Modifier.width(30.dp))


                Icon(
                    painter = painterResource(R.drawable.go),
                    contentDescription = null,
                    modifier = Modifier.padding(16.dp)
                )

                Spacer( modifier = Modifier.padding(16.dp))

            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Terme & condition ",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(16.dp)
                )
                Spacer(modifier = Modifier.width(30.dp))

                Icon(
                    painter = painterResource(R.drawable.go),
                    contentDescription = null,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

    }
}


@Composable
fun MyScreenPreview(navController: NavHostController) {
    MyScreen(navController )
}