package com.android.openpressing.client_module.presentation.client

import android.net.Uri
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.LocalLaundryService
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Reorder
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.android.openpressing.R
import com.android.openpressing.client_module.presentation.CardContent
import com.android.openpressing.client_module.presentation.profile.ListBox
import com.android.openpressing.client_module.presentation.profile.id
import com.android.openpressing.data.models.annonce.AnnounceAttributes
import com.android.openpressing.data.models.annonce.AnnounceData
import com.android.openpressing.data.models.pressing.Pressing
import com.android.openpressing.data.models.pressing.PressingData
import com.android.openpressing.ui.theme.*
import com.android.openpressing.utils.BASE_URL
import com.android.openpressing.utils.Screen
import com.android.openpressing.viewmodels.Annonce.AnnonceViewModel
import com.android.openpressing.viewmodels.pressing.PressingViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn


@Composable
fun LesAnnonces(
    isIdSelected : Int,
    navController: NavHostController,
    //pressingData: PressingData
    //viewModel : AnnonceViewModel = hiltViewModel()
){
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    //viewModel.getAll()
    Scaffold(
        scaffoldState = scaffoldState,

        topBar = { AppBar(
            id,
            navController,
            //pressingData
        )},

        content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                modifier = Modifier
                    .fillMaxHeight(),
            ) {

                item {
                    ContainerBox(navController)
                }
            }
        },

        bottomBar = { BottomBar(navController) }
    )






}


@Composable
fun AppBar(
    isIdSelected : Int,
    navController: NavHostController,
    //pressingData: PressingData,
    pressingviewModel : PressingViewModel = hiltViewModel()
) { //navController: NavHostController

    val pressing = remember{
            mutableStateOf<Pressing?>(null)
    }
    LaunchedEffect(key1 = isIdSelected){
        pressingviewModel.getById(isIdSelected)
            .flowOn(Dispatchers.IO)
            .collect{
                pressing.value = it
            }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(height = 10.dp, width = 230.dp) /////taille du box bleue/////
            .clip(
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomEnd = 10.dp,
                    bottomStart = 10.dp
                )
            )//////forme arrondie de la box/////
            .background(color = primaryPrimeColor)
        //shape=RoundedCornerShape(32.dp)
    ){
        Column() {
            /////Ligne de l'icone de notification/////
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(85.dp),
                verticalAlignment = Alignment.CenterVertically

            ){
                IconButton(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Icon(
                        Icons.Rounded.NavigateBefore,
                        contentDescription = stringResource(R.string.previewPage),
                        tint = Color.White
                    )
                }

                Row(
                    modifier = Modifier
                        .padding( horizontal = 25.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){

                    Spacer(Modifier.height(5.dp))
                    ////logo de location/////
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text ="Welcome to ",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                        )

                        Text(
                            text = "",
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            color = Color.White,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }

                }
            }

            Row() {
                Icon(
                    Icons.Rounded.LocationOn,
                    contentDescription = stringResource(R.string.location),
                    tint = secondaryColor
                )
                Text(
                    text = "On " ,                  //announceData.attributes.description
                    color = primaryColor,
                    style = MaterialTheme.typography.body1.copy(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Text(
                    text = "Quartier " ,                  //announceData.attributes.description
                    color = primaryColor,
                    style = MaterialTheme.typography.body1.copy(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
            }
            }
        }
    }



@Composable
fun ContainerBox(
    navController: NavHostController
){
    val announceData: AnnounceData
    val defaultImage = painterResource(id = R.drawable.satis1)
    Card(
        elevation = 5.dp,
        contentColor = Orange,
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .padding(15.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 5.dp),
        ) {

            Image(
                /*rememberAsyncImagePainter(
                    model = BASE_URL + announceData.attributes.image
                        .data
                        .attributes
                        .url
                ) ,*/
                painter = defaultImage ,
                contentDescription = null,
                modifier = Modifier
                    .clip(
                        shape = RoundedCornerShape(
                            topEnd = 10.dp,
                            topStart = 10.dp
                        )
                    )
                    .fillMaxWidth()
                    .height(120.dp),

                contentScale = ContentScale.Crop
            )

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(horizontal = 60.dp)

            ) {
                Text(
                    text = "Description" ,                  //announceData.attributes.description
                    color = primaryColor,
                    style = MaterialTheme.typography.body1.copy(
                        fontSize = 22.sp,
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
            Row(
                horizontalArrangement = Arrangement.spacedBy(50.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(15.dp)

            ) {
                Text(
                    text =  "Service2",
                    color = black,
                    style = MaterialTheme.typography.body1.copy(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                    )
                )

                Spacer(Modifier.width(10.dp))
                IconButton(onClick = {
                    navController.navigate(Screen.ListPromo.road)
                }) {
                    Icon(
                        Icons.Rounded.Star,
                        contentDescription = stringResource(R.string.nextPage),
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(primaryPrimeColor)
                            .padding(5.dp),
                        tint = primaryColor
                    )
                }

            }
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 2.dp,
        backgroundColor = blanc
    ) {
        Column(
            modifier=Modifier.weight(0.5f)
        ){
            Row( modifier = Modifier
                .padding(start = 5.dp, end = 5.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
                        ){

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.LocalLaundryService, "", tint = Purple500)
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
                navController.navigate(Screen.AddService.road)
                selectedIndex.value = 2
            })

                Text(
                    text = "jui",   //offer.lingee.nom +"(FCFA)"
                    color = Color.DarkGray,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(end = 5.dp)

                )
            }
        }
        Column(modifier=Modifier.weight(0.5f)){
            Row( modifier = Modifier
                .padding(start = 5.dp, end = 5.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically){
                Text(
                    text = "offre", //offer.unitPrice.toString()
                    color = Color.DarkGray,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.width(75.dp)

                )
            }
        }



    }
}



@Composable
fun OffreView(


) {
    //val pressingData = mutableListOf<PressingData>()
    val navController = rememberNavController()

    //val announceData = AnnounceData(id  = Int, attributes = AnnounceAttributes())
    LesAnnonces(id,navController)
}