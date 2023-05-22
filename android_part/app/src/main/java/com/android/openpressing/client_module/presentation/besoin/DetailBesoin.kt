package com.android.openpressing.client_module.presentation.besoin

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.openpressing.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun Detal(){
    Scaffold(
        topBar ={
            TopAppBar(
                elevation = 10.dp,
                modifier = Modifier
                    .fillMaxWidth(),
                title = {
                    Text("Detail Besoin")
                },
                backgroundColor = MaterialTheme.colors.primarySurface,
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                },


                )},
        content = {
            contenu()
            picture()

        }
    )}


//data class Donnees (
//    val Nom : String,
//    val Description : String,
//    val Qte : Int
//    )


@Composable
fun contenu(){
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .padding(start = 64.dp),
        contentAlignment = Alignment.Center
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Text(
                text = "Nombres de Vetements",
                style = MaterialTheme.typography.h5,
                color = Color.Black
            )
            Text(
                text = "5 Vetements",
                style = MaterialTheme.typography.body2,
                color = Color.Black
            )
            Text(
                text = "Intitule Du Service:",
                style = MaterialTheme.typography.h5,
                color = Color.Black
            )
            Text(
                text = "Voici du texte center dans un interface",
                style = MaterialTheme.typography.body2,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Categorie du Service:",
                style = MaterialTheme.typography.h5,
                color = Color.Black
            )
            Text(
                text = "Voici du texte center dans un interface",
                style = MaterialTheme.typography.body2,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Intitule Du Linge:",
                style = MaterialTheme.typography.h5,
                color = Color.Black
            )
            Text(
                text = "Voici du texte center dans un interface",
                style = MaterialTheme.typography.body2,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Categorie De Linge:",
                style = MaterialTheme.typography.h5,
                color = Color.Black
            )
            Text(
                text = "Voici du texte center dans un interface",
                style = MaterialTheme.typography.body2,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Quantité:",
                style = MaterialTheme.typography.h5,
                color = Color.Black
            )
            Text(
                text = "Voici du texte center dans un interface",
                style = MaterialTheme.typography.body2,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Prix Unitaire:",
                style = MaterialTheme.typography.h5,
                color = Color.Black
            )
            Text(
                text = "Voici du texte center dans un interface",
                style = MaterialTheme.typography.body2,
                color = Color.Black
            )
        }
    }

}

@Composable
fun picture(){
    Row(modifier = Modifier.padding(start =64.dp)){

        Image(painter = painterResource(R.drawable.ele),
            contentDescription = "",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .border(1.6.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.height(height = 64.dp))
        Text(
            text = "Mes Besoins",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .fillMaxWidth()
                .padding( end = 64.dp)
        )



    }

}

