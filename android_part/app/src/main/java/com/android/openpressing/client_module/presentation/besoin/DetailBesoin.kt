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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.openpressing.R
import com.android.openpressing.client_module.presentation.agence.utils.laundries
import com.android.openpressing.data.models.client.ClientData
import com.android.openpressing.data.models.laundry.Laundries
import com.android.openpressing.data.models.laundry.Laundry
import com.android.openpressing.data.models.laundry.LaundryData
import com.android.openpressing.data.models.requirement.RequirementData
import com.android.openpressing.data.models.service.ServiceData
import com.android.openpressing.viewmodels.client.ClientViewModel
import com.android.openpressing.viewmodels.laundries.LaundryViewModel
import com.android.openpressing.viewmodels.requirement.RequirementViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun Detal(
    rdViewModel: RequirementViewModel = hiltViewModel(),
    clientViewModel: ClientViewModel = hiltViewModel(),
    laundryViewModel: LaundryViewModel = hiltViewModel(),
    serviceViewModel: ClientViewModel = hiltViewModel()
){

     val userID =4


    val clients = remember(userID){ mutableStateOf<MutableList<ClientData>?>(null) }
    val client = remember(userID){ mutableStateOf<ClientData?>(null) }

    val rdkey = "allrdkey"
    val requirements = remember(rdkey) { mutableStateOf<MutableList<RequirementData>?>(null) }

    val laundryID = 4

    val Laundries = remember(laundryID){ mutableStateOf<MutableList<LaundryData>?>(null) }
    val Laundry = remember(laundryID){ mutableStateOf<LaundryData?>(null) }
    
    val serviceID = 4
    val services = remember(serviceID){ mutableStateOf<MutableList<ServiceData>?>(null) }
    val service = remember(serviceID){ mutableStateOf<ServiceData?>(null) }



    /*LaunchedEffect(key1 = userID){
        clientViewModel.getAll()
            .flowOn(Dispatchers.IO)
            .collect{ clients.value = it }
    }*/

    if (Laundries.value != null){

        //Laundry.value = Laundries.value!!.find { it.attributes.requirements.data.id == userID }

        LaunchedEffect(key1 = rdkey) {
            rdViewModel.findAll()
                .flowOn(Dispatchers.IO)
                .collect { requirements.value = it }
        }
    }







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
                .padding(end = 64.dp)
        )



    }

}

