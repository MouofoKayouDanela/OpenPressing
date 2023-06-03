package com.android.openpressing.client_module.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.material.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalLaundryService
import androidx.compose.material.icons.filled.Notes
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Reorder
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.openpressing.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.android.openpressing.client_module.presentation.requirement.details.components.DeliveryArea
import com.android.openpressing.ui.theme.*
import com.android.openpressing.utils.Screen


@Composable
fun ProfileScreen(navController: NavHostController) {

    Scaffold(
        topBar = {BlueSection(navController)
        },

        content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                modifier = Modifier
                    .fillMaxHeight(),
            ) {

                item {
                    ListeSoustitre(navController)
                }
            }
        },

        bottomBar = {NavBottomBar(navController)}
    )
}



@Composable
fun BlueSection(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(height = 60.dp, width = 230.dp) /////taille du box bleue/////
            .clip(
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomEnd = 10.dp,
                    bottomStart = 10.dp
                )
            )//////forme arrondie de la box/////
            .background(color = primaryColor)
    ){
        Column() {
            /////Ligne de l'icone de notification/////
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween

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

                Text(
                    text = "Paramètres",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        Icons.Rounded.Notifications,
                        contentDescription = stringResource(R.string.notifications),
                        tint = thirdPrimeColor
                    )
                }
            }
        }
    }
}

@Composable
fun ListeSoustitre(navController: NavHostController) {

    Column(
        modifier = Modifier.padding(vertical = 45.dp, horizontal = 5.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        ///////*******LIGNE DE SOUS PAGE*********//////
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp) ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Rounded.Person,
                contentDescription = stringResource(R.string.nextPage),
                tint = Color.Green
            )
            Spacer(Modifier.width(6.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Informations sur le compte",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )
                Text(
                    "Nom, Email, Adresse, ...",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Grey,
                )
            }
            Spacer(Modifier.width(10.dp))
            IconButton(onClick = {
                navController.navigate(Screen.EditScreen.road)
            }) {
                Icon(
                    Icons.Rounded.NavigateNext,
                    contentDescription = stringResource(R.string.nextPage),
                    tint = primaryColor
                )
            }

        }


        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 5.dp) ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Rounded.List,
                contentDescription = stringResource(R.string.liste),
                tint = Purple500
            )
            Spacer(Modifier.width(10.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Historique des commandes",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )
                Text(
                    "par jour, par semaine,...",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Grey,
                )
            }
            Spacer(Modifier.width(10.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Rounded.NavigateNext,
                    contentDescription = stringResource(R.string.nextPage),
                    tint = primaryColor
                )
            }
        }


        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 1.dp) ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Rounded.Launch,
                contentDescription = stringResource(R.string.liste),
                tint = Teal200
            )
            Spacer(Modifier.width(10.dp))
            Column(

            ) {
                Text(
                    "Mes besoins",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )
                Text(
                    "Mes demandes datées ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Grey,
                )
            }
            Spacer(Modifier.width(45.dp))
            IconButton(onClick = { }) {
                Icon(
                    Icons.Rounded.NavigateNext,
                    contentDescription = stringResource(R.string.nextPage),
                    tint = primaryColor
                )
            }
        }


        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 1.dp) ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Rounded.Favorite,
                contentDescription = stringResource(R.string.liste),
                tint = Rouge
            )
            Spacer(Modifier.width(10.dp))
            Column(

            ) {
                Text(
                    "Mes favoris",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )
                Text(
                    "Vos meilleurs hbnmbv hbvh  ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Grey,
                )
            }
            Spacer(Modifier.width(24.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Rounded.NavigateNext,
                    contentDescription = stringResource(R.string.nextPage),
                    tint = primaryColor
                )
            }
        }


        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 1.dp) ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Rounded.Info,
                contentDescription = stringResource(R.string.liste),
                tint = Orange
            )
            Spacer(Modifier.width(10.dp))
            Column(

            ) {
                Text(
                    "A Propos",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )
                Text(
                    "A propos de cette application",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Grey,
                )
            }
            Spacer(Modifier.width(24.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Rounded.NavigateNext,
                    contentDescription = stringResource(R.string.nextPage),
                    tint = primaryColor
                )
            }
        }
    }

}


@Composable
 fun NavBottomBar(navController: NavController) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 2.dp,
        backgroundColor = blanc
    ) {

        BottomNavigationItem(icon = {
            Icon(
                imageVector = Icons.Default.LocalLaundryService,
                "",
                tint = if(selectedIndex.value == 0) primaryColor
                else Color.DarkGray
            )
        },
            label = {
                Text(
                    text = "Laundry",
                    color = if(selectedIndex.value == 0) primaryColor
                    else Color.DarkGray
                )
            },
            selected = (selectedIndex.value == 0),
            onClick = {
                navController.navigate(Screen.Home.road)
                selectedIndex.value = 0
            })
        BottomNavigationItem(icon = {
            Icon(
                imageVector = Icons.Default.Reorder,
                "",
                tint = if(selectedIndex.value == 1) primaryColor
                else Color.DarkGray
            )
        },
            label = {
                Text(
                    text = "Order",
                    color = if(selectedIndex.value == 1) primaryColor
                    else Color.DarkGray
                )
            },
            selected = (selectedIndex.value == 1),
            onClick = {
                navController.navigate(Screen.ListCommande.road)
                selectedIndex.value = 1
            })

        BottomNavigationItem(icon = {
            Icon(
                imageVector = Icons.Default.ShoppingBasket,
                "",
                tint = if(selectedIndex.value == 2) primaryColor
                else Color.DarkGray
            )
        },
            label = {
                Text(
                    text = "Needs",
                    color = if(selectedIndex.value == 2) primaryColor
                    else Color.DarkGray
                )
            },
            selected = (selectedIndex.value == 2),
            onClick = {
                navController.navigate(Screen.ConsulterBesoin.road)
                selectedIndex.value = 2
            })

        BottomNavigationItem(icon = {
            Icon(
                imageVector = Icons.Default.Person,
                "",
                tint = if(selectedIndex.value == 3) primaryColor
                else Color.DarkGray
            )
        },
            label = {
                Text(
                    text = "Profile",
                    color = if(selectedIndex.value == 3) primaryColor
                    else Color.DarkGray
                )
            },
            selected = (selectedIndex.value == 3),
            onClick = {
                navController.navigate(Screen.Profile.road)
                selectedIndex.value = 3
            })
    }
}

@Preview
@Composable
fun Profileview(){
    val navController = rememberNavController()
    ProfileScreen(navController)
}

