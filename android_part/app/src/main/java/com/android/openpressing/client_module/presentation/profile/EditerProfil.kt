package com.android.openpressing.client_module.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
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


@Preview
@Composable
fun EditerProfil() {

    Box(modifier = Modifier
        .fillMaxSize()

    ){
        Column() {
            FixBare()

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



        }
    }
}



@Composable
fun FixBare() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .background(color = Color.White)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 15.dp),
            verticalAlignment = Alignment.CenterVertically

        ){
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Rounded.NavigateBefore,
                    contentDescription = stringResource(R.string.previewPage),
                    tint = Color.Black
                )
            }
            Spacer(Modifier.width(25.dp))
            Text(
                "Informations Personnelles",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )

        }

    }
}



@Composable
fun ListBox() {
    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 50.dp)
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
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            ///////*******LIGNE DE SOUS PAGE*********//////
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp) ,
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                    Text(
                        "FullName : ",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                    )
                    Text(
                        " Emmanuel Zipar",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                    )

                //Spacer(Modifier.width(65.dp))
                /*IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Rounded.Edit,
                        contentDescription = stringResource(R.string.editer),
                        tint = Violet,
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(VioletPal)
                            .padding(5.dp)
                    )
                }*/
            }


            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp) ,
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
                    .padding(horizontal = 20.dp) ,
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
                    .padding(horizontal = 20.dp) ,
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
                    .padding(horizontal = 20.dp) ,
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
