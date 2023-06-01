package com.android.openpressing.client_module.presentation.client

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.LocalLaundryService
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Reorder
import androidx.compose.material.icons.rounded.NavigateBefore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.android.openpressing.R
import com.android.openpressing.ui.theme.Orange
import com.android.openpressing.ui.theme.blanc
import com.android.openpressing.ui.theme.primaryColor
import com.android.openpressing.ui.theme.secondaryColor
import com.android.openpressing.utils.Screen


@Composable
fun ListPromotion(
    navController: NavHostController
){

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    //viewModel.getAll()
    Scaffold(
        scaffoldState = scaffoldState,

        topBar = { TopAppBar()},

        content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                modifier = Modifier
                    .fillMaxHeight(),
            ) {

                item {
                    OfferCard()
                }
            }
        },

        bottomBar = { BottomNavBar(navController) }
    )
}

@Composable
fun TopAppBar() { //navController: NavHostController
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(height = 50.dp, width = 230.dp) /////taille du box bleue/////
            .clip(
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomEnd = 10.dp,
                    bottomStart = 10.dp
                )
            )//////forme arrondie de la box/////
            .background(color = primaryColor)
        //shape=RoundedCornerShape(32.dp)
    ){
        Column() {
            /////Ligne de l'icone de notification/////
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(35.dp),
                verticalAlignment = Alignment.CenterVertically

            ){
                IconButton(
                    onClick = {
                        //navController.navigate(Screen.Home.road)
                    }
                ) {
                    Icon(
                        Icons.Rounded.NavigateBefore,
                        contentDescription = stringResource(R.string.previewPage),
                        tint = Color.White
                    )
                }

                Text(
                    text = "Offers & Promotions",
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

}


@Composable
fun OfferCard(
    titleService : String = "",
    titleOffer : String = "",
    price : String = ""
){
        Column() {

            Column {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 18.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Service1" ,                  //announceData.attributes.description
                        color = secondaryColor,
                        style = MaterialTheme.typography.body1.copy(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )
                }
                Canvas(modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 18.dp)
                ) {
                    drawLine(
                        color = Color.Black,
                        alpha = 0.5f,
                        start = Offset(3f, 3f),
                        end = Offset(size.width, size.height / 2),
                        strokeWidth = 1.dp.toPx()
                    )
                }
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(10) { index ->
                        Card(
                            Modifier
                                .width(150.dp)
                                .height(60.dp),
                            elevation = 10.dp,
                            shape = RoundedCornerShape(5.dp),
                            backgroundColor = Color.LightGray
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier .padding(horizontal = 1.dp)
                            ){
                                Text(
                                    "Robe en soie",
                                    Modifier
                                        .padding(8.dp)
                                        .weight(0.5f)
                                )
                                Text(
                                    "800Fcfa",
                                    Modifier
                                        .weight(0.5f)
                                )
                            }
                        }
                    }
                }
            }


            Column {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 18.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Service1" ,                  //announceData.attributes.description
                        color = secondaryColor,
                        style = MaterialTheme.typography.body1.copy(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )
                }
                Canvas(modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 18.dp)
                ) {
                    drawLine(
                        color = Color.Black,
                        alpha = 0.5f,
                        start = Offset(3f, 3f),
                        end = Offset(size.width, size.height / 2),
                        strokeWidth = 1.dp.toPx()
                    )
                }
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(10) { index ->
                        Card(
                            Modifier
                                .width(150.dp)
                                .height(60.dp),
                            elevation = 10.dp,
                            shape = RoundedCornerShape(5.dp),
                            backgroundColor = Color.LightGray
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier .padding(horizontal = 1.dp)
                            ){
                                Text(
                                    "Robe en soie",
                                    Modifier
                                        .padding(8.dp)
                                        .weight(0.5f)
                                )
                                Text(
                                    "800Fcfa",
                                    Modifier
                                        .weight(0.5f)
                                )
                            }
                        }
                    }
                }
            }
        }

    
}

@Composable
fun BottomNavBar(navController: NavHostController) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 2.dp,
        backgroundColor = blanc
    ) {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.LocalLaundryService, "", tint = primaryColor)
        },
            label = { Text(text = "Laundry") },
            selected = (selectedIndex.value == 0),
            onClick = {
                navController.navigate(Screen.Home.road)
                selectedIndex.value = 0
            })
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Reorder, "")
        },
            label = { Text(text = "Order") },
            selected = (selectedIndex.value == 1),
            onClick = {
                navController.navigate(Screen.ListCommande.road)
                selectedIndex.value = 1
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Chat, "")
        },
            label = { Text(text = "Manager") },
            selected = (selectedIndex.value == 2),
            onClick = {
                navController.navigate(Screen.AddBesoin.road)
                selectedIndex.value = 2
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Person, "")
        },
            label = { Text(text = "Profile") },
            selected = (selectedIndex.value == 3),
            onClick = {
                navController.navigate(Screen.Profile.road)
                selectedIndex.value = 3
            })
    }
}

@Preview
@Composable
fun PromotionView() {
    val navController = rememberNavController()
    //val announceData = AnnounceData(id  = Int, attributes = AnnounceAttributes())
    ListPromotion(navController)
}