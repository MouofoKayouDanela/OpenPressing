package com.android.openpressing.client_module.presentation.besoin

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.android.openpressing.client_module.presentation.besoin.component.uil.MessagesLength
import com.android.openpressing.client_module.presentation.components.BottomBar
import com.android.openpressing.data.models.client.ClientData
import com.android.openpressing.data.models.requirement.RequirementData
import com.android.openpressing.data.models.requirement_detail.RequirementDetailData
import com.android.openpressing.ui.theme.*
import com.android.openpressing.utils.Screen
import com.android.openpressing.viewmodels.client.ClientViewModel
import com.android.openpressing.viewmodels.requirement.RequirementViewModel
import com.android.openpressing.viewmodels.requirement_detail.RequirementDetailViewModel
import com.github.marlonlom.utilities.timeago.TimeAgo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

@Composable
fun MyNeed(
    userID: Int,
    navController: NavController,
    rdViewModel: RequirementViewModel = hiltViewModel(),
    clientViewModel: ClientViewModel= hiltViewModel()
){

    val clients = remember(userID){ mutableStateOf<MutableList<ClientData>?>(null) }
    val client = remember(userID){ mutableStateOf<ClientData?>(null) }

    val rdkey = "allrdkey"
    val requirements = remember(rdkey) { mutableStateOf<MutableList<RequirementData>?>(null) }

    LaunchedEffect(key1 = userID){
        clientViewModel.findAll()
            .flowOn(Dispatchers.IO)
            .collect{ clients.value = it }
    }

    if (clients.value != null){

        client.value = clients.value!!.find { it.attributes.user.data.id == userID }

        LaunchedEffect(key1 = rdkey) {
            rdViewModel.findAll()
                .flowOn(Dispatchers.IO)
                .collect { requirements.value = it }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(navController)
            },
        content= { innerPadding ->

            if (client.value != null && requirements.value != null){
                Stock(
                    contenu = requirements.value!!
                        .filter { it.attributes.client.data.id == client.value!!.id }
                        .sortedByDescending { it.attributes.createdAt },
                    innerPadding = innerPadding,
                    navController = navController
                )
            }

        },
        bottomBar= {BottomBar(2,navController)},
        floatingActionButton = {
            FloatingActionButton(
                    onClick = { navController.navigate(Screen.AddBesoin.road) },
                    shape = CircleShape,
                    backgroundColor = primaryColor
            ) {
                Icon(
                        Icons.Default.Add,
                        "Add",
                        tint = secondaryPrimeColor,
                        modifier = Modifier
                            .size(32.dp)
                )
            }
        }
    )
}

@Composable
private fun TopAppBar( navController: NavController) {
    Column {
        Row(
                Modifier
                    /*.clip(
                        RoundedCornerShape(
                            bottomStart = 10.dp,
                            bottomEnd = 10.dp
                        )
                    )*/
                    .fillMaxWidth()
                    .background(primaryColor)
                    .padding(
                            horizontal = 16.dp ,
                            vertical = 8.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                    onClick = {
                        navController.navigate(Screen.AddService.road)
                    },
                    modifier = Modifier.weight(0.1f)
            ) {
                Icon(
                        Icons.Rounded.KeyboardArrowLeft ,
                        contentDescription = null ,
                        tint = Color.White,
                        modifier = Modifier
                            .size(48.dp)
                )
            }

            Row(
                    modifier = Modifier.weight(0.9f),
                    horizontalArrangement = Arrangement.Center
            ){
                Text(
                        "My needs"  ,
                        style = MaterialTheme.typography.h6.copy(
                                color = Color.White,
                                fontWeight = FontWeight.Normal
                        )
                )
            }
        }
    }
}


@Composable
fun Stock(
    contenu: List<RequirementData> ,
    innerPadding: PaddingValues ,
    navController: NavController
){
    LazyColumn(contentPadding = innerPadding) {
        items(contenu) {
            Consult(it, navController)
        }
    }

}

@Composable
fun Consult(
    affiche: RequirementData ,
    navController: NavController ,
    requiremenDetailsViewModel: RequirementDetailViewModel = hiltViewModel() ,
) {

    val requirementId= affiche.id!!

    val allRd= remember(requirementId) {
        mutableStateOf<List<RequirementDetailData>?>(null)
    }

    LaunchedEffect(key1 = allRd){
        requiremenDetailsViewModel.getAll()
            .flowOn(Dispatchers.IO)
            .collect{
                allRd.value = it.filter { oneOfAllRd ->
                    affiche.attributes.requirement_details.data.any { wantedRd ->
                        wantedRd.id == oneOfAllRd.id
                    }
                }
            }
    }

    Card(
            elevation = 3.dp,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(
                        vertical = 8.dp ,
                        horizontal = 16.dp
                )
    ) {
        Column(
                modifier = Modifier
                    .background(secondaryPrimeColor)
                    .padding(16.dp)
        ) {

            Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp) ,
                    verticalAlignment = Alignment.CenterVertically
            ){
                var messagesLength = MessagesLength.NoMessages
                Text(
                        if (affiche.attributes.messages!!.data.isNullOrEmpty()) {
                            "0 answer"
                        } else {
                            val messages = affiche.attributes.messages!!.data.size
                            if (messages <= 1) {
                                messagesLength = MessagesLength.BetweenOneAndFive
                                "0$messages answer"
                            } else {
                                if (messages > 5) messagesLength = MessagesLength.MoreThanFive
                                "$messages answers"
                            }
                        } ,
                        color = when (messagesLength) {
                            MessagesLength.NoMessages -> thirdPrimeColor
                            MessagesLength.BetweenOneAndFive -> secondaryColor
                            else -> primaryColor
                        } ,
                        /*modifier = Modifier
                            .clip(CircleShape)
                            .background(
                                    when (messagesLength) {
                                        MessagesLength.NoMessages -> thirdPrimeColor
                                        MessagesLength.BetweenOneAndFive -> secondaryColor
                                        else -> primaryColor
                                    }
                            )
                            .padding(4.dp)*/

                )
            }

            Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalArrangement = Arrangement.Center
            ){
                if (allRd.value != null) {

                    Row {
                        Text(
                                "Laundries",
                                modifier = Modifier.weight(0.45f)
                        )

                        Text(
                                ":",
                                modifier = Modifier.weight(0.1f)
                        )

                        var quantity = 0
                        allRd.value!!.forEach { quantity += it.attributes.quantity }
                        Text(
                                text = if (quantity < 10) "0$quantity"
                                else quantity.toString() ,
                                modifier = Modifier.weight(0.45f) ,
                                fontWeight = FontWeight.SemiBold
                        )
                    }

                    Row{
                        Text(
                                "price",
                                modifier = Modifier.weight(0.45f)
                        )

                        Text(
                                ":",
                                modifier = Modifier.weight(0.1f)
                        )

                        var price = 0.0
                        allRd.value!!.forEach { price += it.attributes.unitPrice * it.attributes.quantity }
                        Text(
                                text = "$price Fcfa" ,
                                modifier = Modifier.weight(0.45f),
                                fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp) ,
                    verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                        text = TimeAgo.using(affiche.attributes.createdAt.time),
                        modifier = Modifier.weight(0.9f)
                )

                IconButton(
                        onClick = { navController.navigate("${Screen.DetailBesoin.road}/${affiche.id!!}") },
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(fourthColor)
                ) {
                    Icon(
                            Icons.Default.KeyboardArrowRight,
                            contentDescription = null,
                    )
                }
            }
        }
    }
}