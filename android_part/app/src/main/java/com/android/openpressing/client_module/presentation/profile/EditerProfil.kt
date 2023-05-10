package com.android.openpressing.client_module.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.LocalLaundryService
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Reorder
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.android.openpressing.R
import com.android.openpressing.ui.theme.*
import com.android.openpressing.utils.Screen
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun EditerProfil(navController: NavHostController) {

    Box(modifier = Modifier
        .fillMaxSize()

    ){
        Column() {
            FixBare(navController)

            Row(
                modifier = Modifier
                    .padding(vertical = 11.dp, horizontal = 10.dp),
               // horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Rounded.Edit,
                        contentDescription = stringResource(R.string.editer),
                        tint = Violet,
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(VioletPal)
                            .padding(5.dp)
                    )

                }
            }


            ListBox()

            Spacer(Modifier.height(7.dp))
            TextButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(horizontal = 80.dp),

            ) {
                Text(
                    "Se Deconnecter",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Red,
                )
            }

            BottomBar(navController)
        }

    }


}



@Composable
fun FixBare(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .background(color = Color.White)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ){
            IconButton(onClick = { navController.navigate(Screen.Profile.road) }) {
                Icon(
                    Icons.Rounded.NavigateBefore,
                    contentDescription = stringResource(R.string.previewPage),
                    tint = Color.Black
                )
            }
            //Spacer(Modifier.width(15.dp))
            Text(
                "Informations Personnelles",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Spacer(Modifier.width(15.dp))

    }
}
}


@Composable
fun ListBox() {
    Box(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .size(300.dp)
            .clip(
                shape = RoundedCornerShape(
                    topStart = 15.dp,
                    topEnd = 15.dp,
                    bottomEnd = 15.dp,
                    bottomStart = 15.dp
                )
            )//////forme arrondie de la box/////
            .background(color = Color.White),

        ) {
        Column(
            modifier = Modifier.padding(vertical = 15.dp),
            //horizontalArrangement = Arrangement.SpaceBetween,
            //verticalArrangement = Arrangement.SpaceBetween
        ) {
            ///////*******LIGNE DE SOUS PAGE*********//////
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp),

                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    "FullName : ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                )
                Text(
                    " Emmanuel Zipar",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                )
            }


            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    "Email : ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                )
                Text(
                    " Emanuelzipar@gmail.com",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                )
            }


            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    "Contact : ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                )
                Text(
                    " +237 657 290 643",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                )
            }

            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    "Date & lieu de naissance : ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                )
                Text(
                    " Banfang, 23/08/1998",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                )
            }

            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    "Adresse de residence : ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                )
                Text(
                    " Douala, Nyalla Rue210",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                )
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
