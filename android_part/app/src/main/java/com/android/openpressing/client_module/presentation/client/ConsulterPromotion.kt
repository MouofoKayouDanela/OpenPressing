package com.android.openpressing.client_module.presentation.client

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.NavigateBefore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.openpressing.R
import com.android.openpressing.ui.theme.Orange
import com.android.openpressing.ui.theme.primaryColor


@Composable
fun ListPromotion(){

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
                horizontalArrangement = Arrangement.spacedBy(85.dp),
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
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

}


@Composable
fun OfferCard(){

    Card(
        elevation = 5.dp,
        contentColor = Orange,
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .padding(15.dp)
    ){

        Column() {

            Row() {
                Text(
                    text = "Service1" ,                  //announceData.attributes.description
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

            Row() {
                Text(
                    text = "Service1" ,                  //announceData.attributes.description
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