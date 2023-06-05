package com.android.openpressing.client_module.presentation.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalLaundryService
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Reorder
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.android.openpressing.ui.theme.blanc
import com.android.openpressing.ui.theme.primaryColor
import com.android.openpressing.utils.Screen

@Composable
fun BottomBar(index: Int,navController: NavController) {
    val selectedIndex = remember { mutableStateOf(index) }
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