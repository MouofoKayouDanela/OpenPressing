package com.android.openpressing.client_module.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.material.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.openpressing.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.android.openpressing.ui.theme.*

@Preview
@Composable
fun ProfileScreen(){

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Gris)

    ){ Column() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(230.dp) /////taille du box bleue/////
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomEnd = 40.dp,
                        bottomStart = 40.dp
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
                        .padding(horizontal = 8.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween

                ){
                    Icon(
                        Icons.Rounded.NavigateBefore,
                        contentDescription = stringResource(R.string.previewPage),
                        tint = Color.White
                    )
                    Icon(
                        Icons.Rounded.Notifications,
                        contentDescription = stringResource(R.string.notifications),
                        tint = Color.White
                    )

                }

                Spacer(Modifier.height(5.dp))
                ////////////Image +nom//////////////
                Row(

                    modifier = Modifier
                        .padding( horizontal = 25.dp),
                    //verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(id = R.drawable.homme),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(55.dp)
                            .border(1.dp, color = Color.White, CircleShape)

                    )
                    Spacer(Modifier.width(2.dp))
                    //////description du la photo////
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(vertical = 15.dp, horizontal = 20.dp)
                    ) {
                        Text(
                            "Emmanuel Zipar",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                        )
                        Spacer(Modifier.height(5.dp))
                        ////logo de location/////
                        Row() {
                            Icon(
                                Icons.Rounded.LocationOn,
                                contentDescription = stringResource(R.string.location),
                                tint = Color.White
                            )
                            Text(
                                "Douala,Nyalla Rue 225",
                                fontWeight = FontWeight.Normal,
                                color = Color.White,
                            )
                        }
                    }
                }
                Spacer(Modifier.height(18.dp))

                ////////////Les 3 icones du bas//////////////
                Row(
                    Modifier
                        .padding(horizontal = 25.dp)
                ){
                    Column() {
                        Row{
                            Icon(
                                Icons.Rounded.AttachMoney, /////icone du solde////////////
                                contentDescription = stringResource(R.string.money),
                                tint = Orange
                            )
                            Text(
                                "Solde",
                                fontWeight = FontWeight.Normal,
                                color = Color.White,

                                )
                        }
                        Spacer(Modifier.height(1.dp))
                        Text(
                            "25.000Fcfa",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                        )
                    }

                    //////*****Icone de gauche*******///////////
                }

            }
        }
        //Divider(modifier = Modifier.fillMaxSize())
        ///////**********PARTIES BLANCHE DES DETAILS DU PROFILE*******//////////////

        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 35.dp)
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
                verticalArrangement = Arrangement.SpaceAround
            ) {
                ///////*******LIGNE DE SOUS PAGE*********//////
                Row(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        Icons.Rounded.Person,
                        contentDescription = stringResource(R.string.nextPage),
                        tint = Color.Green
                    )
                    Spacer(Modifier.width(10.dp))
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Informations sur le compte",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                        )
                        Text(
                            "Nom, Email, Adresse, ...",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = Grey,
                        )
                    }
                    Spacer(Modifier.width(10.dp))
                    Icon(
                        Icons.Rounded.NavigateNext,
                        contentDescription = stringResource(R.string.nextPage),
                        tint = Color.Blue
                    )
                }


                Row(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        Icons.Rounded.List,
                        contentDescription = stringResource(R.string.liste),
                        tint = Purple
                    )
                    Spacer(Modifier.width(10.dp))
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Historique des commandes",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                        )
                        Text(
                            "par jour, par semaine,...",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = Grey,
                        )
                    }
                    Spacer(Modifier.width(10.dp))
                    Icon(
                        Icons.Rounded.NavigateNext,
                        contentDescription = stringResource(R.string.nextPage),
                        tint = Color.Blue
                    )
                }


                Row(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
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
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                        )
                        Text(
                            "A propos de cette application",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = Grey,
                        )
                    }
                    Spacer(Modifier.width(24.dp))
                    Icon(
                        Icons.Rounded.NavigateNext,
                        contentDescription = stringResource(R.string.nextPage),
                        tint = Color.Blue
                    )
                }
            }


        }
    }



    }
    
}


