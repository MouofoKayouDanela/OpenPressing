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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.android.openpressing.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyScreen(navController: NavHostController) {
    Scaffold(
        topBar = { MyTopBar() }
    ) {
        MyRecyclerView()
    }
}

@Composable
fun MyTopBar() {
    TopAppBar(
        title = { Text(text = "Qui somme-nous") },
        //backgroundColor = Color.Blue,
        navigationIcon = { IconButton(onClick = {  }) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Back")

        }

        }
    )
}
@Composable
fun MyRecyclerView() {
    val items = listOf("FAQs", "Terme & condition", "Item 3")

    LazyColumn {
        items(items) { item ->
            MyCardView(item)
        }
    }
}


@Composable
fun MyCardView(title: String) {


    Card(
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        //backgroundColor = Color.White
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.width(30.dp))

            Icon(
                painter = painterResource(R.drawable.ele3),
                contentDescription = null,
                modifier = Modifier.padding(25.dp)
            )
        }
    }
}



@Composable
fun MyScreenPreview(navController: NavHostController    ) {

    MyScreen(navController= navController)
}