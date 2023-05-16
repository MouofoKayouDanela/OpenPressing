package com.android.openpressing.client_module.presentation.profile

import android.content.Intent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.android.openpressing.R
import com.android.openpressing.client_module.presentation.BlueSection
import com.android.openpressing.client_module.presentation.BottomBar
import com.android.openpressing.client_module.presentation.ListeSoustitre
import com.android.openpressing.client_module.presentation.ProfileScreen
import com.android.openpressing.ui.theme.*
import com.android.openpressing.utils.Screen
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun EditerProfil(navController: NavHostController) {

    Scaffold(
        topBar = {
            FixBare(navController)
        },

        content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                modifier = Modifier
                    .fillMaxHeight(),
            ) {

                item {
                    ListBox()
                }
            }
        },

        bottomBar = {BottomBar(navController)}
    )


}




@Composable
fun FixBare(navController: NavHostController) {
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
            .background(color = Purple500)
        //shape=RoundedCornerShape(32.dp)
    ){
        Column() {
            /////Ligne de l'icone de notification/////
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(50.dp),
                verticalAlignment = Alignment.CenterVertically

            ){
                IconButton(
                    onClick = {
                        navController.navigate(Screen.Profile.road)
                    }
                ) {
                    Icon(
                        Icons.Rounded.NavigateBefore,
                        contentDescription = stringResource(R.string.previewPage),
                        tint = Color.White
                    )
                }

                Text(
                    text = "Mon Profil",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
        }
    }
}

}

@Composable
fun ListBox() {
    var value by remember {
        mutableStateOf(0)
    }
    var defaultname by remember { mutableStateOf("") }
    var defaultmail by remember { mutableStateOf("") }
    var defaultphone by remember { mutableStateOf(0) }
    var defaultadress by remember { mutableStateOf("") }
    val showDialog = remember { mutableStateOf(false) }
    var texte by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ///////*******BOX DE L'IMAGE*********//////
        Row(
        ) {
            Box(
                contentAlignment = Alignment.BottomEnd
            ){
                Image(
                    painter = painterResource(id = R.drawable.homme),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(130.dp)
                        .border(1.dp, color = Color.Black, CircleShape),
                    contentScale = ContentScale.FillHeight
                )
                ///////////icone de modification de l'image////////////
                IconButton(onClick = {
                    //openImagePicker()
                }) {
                    Icon(
                        Icons.Rounded.PhotoCamera,
                        contentDescription = stringResource(R.string.nextPage),
                        tint = Violet,
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(VioletPal)
                            .padding(5.dp)
                            //.padding(horizontal = 5.dp)
                            .align(Alignment.BottomEnd)
                    )
                }
            }
        }

///////////DIFFERENTS ELEMENTS///////////////
        Spacer(modifier = Modifier.height(10.dp))

        ///////////////GRANDE ROW////////////
        Column(
            modifier = Modifier .fillMaxHeight(0.5f),
            verticalArrangement = Arrangement.spacedBy(15.dp),
           // horizontalAlignment = Alignment.CenterHorizontally
        ){

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .weight(0.7f)
                        .padding(horizontal = 20.dp),
                ) {

                    Text(
                        "FullName : ",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black.copy(alpha = 0.5f),
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        " Emmanuel Zipar",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                    )
                }

                IconButton(
                    modifier = Modifier .weight(0.3f),
                    onClick = {
                    //navController.navigate(Screen.EditScreen.road)
                }
                ) {
                    Icon(
                        Icons.Rounded.Edit,
                        contentDescription = stringResource(R.string.nextPage),
                        tint = Orange,
                        modifier = Modifier
                            .clip(CircleShape)
                            //.background(VioletPal)
                            .padding(5.dp)
                    )
                }
            }

            ////////////LIGNE DE SEPARATION////////
            Canvas(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp)
            ) {
                drawLine(
                    color = Color.Black,
                    alpha = 0.1f,
                    start = Offset(3f, 3f),
                    end = Offset(size.width, size.height / 2),
                    strokeWidth = 1.dp.toPx()
                )
            }
            ////

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column(
                    modifier = Modifier
                        .weight(0.7f)
                        .padding(horizontal = 20.dp),
                    //horizontalArrangement = Arrangement.SpaceBetween,
                    //verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        "Email : ",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black.copy(alpha = 0.5f),
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        " Emanuelzipar@gmail.com",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                    )
                }

                IconButton(
                    modifier = Modifier .weight(0.3f),
                    onClick = {
                    //navController.navigate(Screen.EditScreen.road)
                }
                ) {
                    Icon(
                        Icons.Rounded.Edit,
                        contentDescription = stringResource(R.string.nextPage),
                        tint = Orange,
                        modifier = Modifier
                            .clip(CircleShape)
                            //.background(VioletPal)
                            .padding(5.dp)
                    )
                }
            }

            ////////////LIGNE DE SEPARATION////////
            Canvas(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp)
            ) {
                drawLine(
                    color = Color.Black,
                    alpha = 0.1f,
                    start = Offset(3f, 3f),
                    end = Offset(size.width, size.height / 2),
                    strokeWidth = 1.dp.toPx()
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .weight(0.7f)
                        .padding(horizontal = 20.dp),
                    //horizontalArrangement = Arrangement.SpaceBetween,
                    //verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        "Contact : ",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black.copy(alpha = 0.5f),
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        " +237 657 290 643",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                    )
                }
                IconButton(
                    modifier = Modifier .weight(0.3f),
                    onClick = {
                    //navController.navigate(Screen.EditScreen.road)
                },
                ) {
                    Icon(
                        Icons.Rounded.Edit,
                        contentDescription = stringResource(R.string.nextPage),
                        tint = Orange,
                        modifier = Modifier
                            .clip(CircleShape)
                            //.background(VioletPal)
                            .padding(5.dp)
                    )
                }
            }

            ////////////LIGNE DE SEPARATION////////
            Canvas(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp)
            ) {
                drawLine(
                    color = Color.Black,
                    alpha = 0.1f,
                    start = Offset(3f, 3f),
                    end = Offset(size.width, size.height / 2),
                    strokeWidth = 1.dp.toPx()
                )
            }

            /*Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .weight(0.7f)
                        .padding(horizontal = 20.dp),
                    //horizontalArrangement = Arrangement.SpaceBetween,
                    //verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        "Date & lieu de naissance : ",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black.copy(alpha = 0.5f),
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        " Banfang, 23/08/1998",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                    )
                }
                IconButton(
                    modifier = Modifier .weight(0.3f),
                    onClick = {
                    //navController.navigate(Screen.EditScreen.road)
                }
                ) {
                    Icon(
                        Icons.Rounded.Edit,
                        contentDescription = stringResource(R.string.nextPage),
                        tint = Orange,
                        modifier = Modifier
                            .clip(CircleShape)
                            //.background(VioletPal)
                            .padding(5.dp)
                    )
                }
            }
            ////////////LIGNE DE SEPARATION////////
            Canvas(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp)
            ) {
                drawLine(
                    color = Color.Black,
                    alpha = 0.1f,
                    start = Offset(3f, 3f),
                    end = Offset(size.width, size.height / 2),
                    strokeWidth = 1.dp.toPx()
                )
            }*/

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .weight(0.7f),
                    //horizontalArrangement = Arrangement.SpaceBetween,
                    //verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        "Adresse de residence : ",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black.copy(alpha = 0.5f),
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        " Douala, Nyalla Rue210",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                    )
                }
                IconButton(
                    modifier = Modifier .weight(0.3f),
                    onClick = {
                    //navController.navigate(Screen.EditScreen.road)
                }) {
                    Icon(
                        Icons.Rounded.Edit,
                        contentDescription = stringResource(R.string.nextPage),
                        tint = Orange,
                        modifier = Modifier
                            .clip(CircleShape)
                            //.background(VioletPal)
                            .padding(5.dp)
                    )
                }
            }

            ////////////LIGNE DE SEPARATION////////
            Canvas(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp)
            ) {
                drawLine(
                    color = Color.Black,
                    alpha = 0.1f,
                    start = Offset(3f, 3f),
                    end = Offset(size.width, size.height / 2),
                    strokeWidth = 1.dp.toPx()
                )
            }
        }
        }

        Row (
            modifier = Modifier.padding(horizontal = 70.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            TextButton(
                onClick = { /*TODO*/ },
                shape = CircleShape
                ) {
                Icon(
                    Icons.Rounded.Logout,
                    contentDescription = stringResource(R.string.nextPage),
                    tint = Color.Red,
                    modifier = Modifier
                        .clip(CircleShape)
                        //.background(VioletPal)
                        .padding(5.dp)
                        //.padding(horizontal = 5.dp)
                )
                Text(
                    "Se Deconnecter",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red,
                )
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
                selectedIndex.value = 1
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Chat, "")
        },
            label = { Text(text = "Chat") },
            selected = (selectedIndex.value == 2),
            onClick = {
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
fun EditionView() {
    val navController = rememberNavController()
    EditerProfil(navController)
}
