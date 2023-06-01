package com.android.openpressing.client_module.presentation.agence

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.android.openpressing.ui.theme.primaryColor
import com.android.openpressing.utils.Screen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AgencyOption(
    agencyId: Int,
    navController: NavController
) {

    Scaffold(
            topBar = {
                TopAppBar(
                        navController = navController
                )
            },

            content = {
                OptionList(
                        agencyId = agencyId ,
                        navController = navController
                )
            },
    )
}

@Composable
private fun TopAppBar(
    navController: NavController
) {
    Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(primaryColor)
                .padding(
                        horizontal = 16.dp ,
                        vertical = 8.dp
                ) ,
            verticalAlignment = Alignment.CenterVertically ,
    ) {

        IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.weight(0.1f)
        ) {
            Icon(
                    Icons.Default.KeyboardArrowLeft ,
                    contentDescription = null ,
                    tint = Color.White ,
                    modifier = Modifier.size(32.dp)
            )
        }

        Text(
                "Agency Option",
                style = MaterialTheme.typography.h6.copy(
                        color = Color.White ,
                        fontWeight = FontWeight.Normal
                ),
                modifier = Modifier.weight(0.8f)
        )

    }
}

@Composable
private fun OptionList(
    agencyId: Int,
    navController: NavController
) {

    val options = listOf(
            "Service and laundry management",
            "Announce management",
    )

    LazyColumn{

        items(options) { option ->
            Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            Log.i("", "$agencyId")
                            navController.navigate("${Screen.AddService.road}/${agencyId}")
                        }
                        .padding(
                                vertical = 8.dp ,
                                horizontal = 16.dp
                        )
            ){
                Text(
                        option,
                        style = MaterialTheme.typography.h6.copy(
                                fontWeight = FontWeight.Normal,
                        )
                )
            }

            Divider(
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth()
            )
        }
    }

}