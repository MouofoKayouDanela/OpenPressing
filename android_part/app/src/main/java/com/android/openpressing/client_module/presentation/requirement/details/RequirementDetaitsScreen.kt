package com.android.openpressing.client_module.presentation.requirement.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.LocalLaundryService
import androidx.compose.material.icons.rounded.NavigateNext
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.android.openpressing.R
import com.android.openpressing.ui.theme.*
import com.android.openpressing.client_module.presentation.requirement.details.components.*
import com.android.openpressing.utils.Screen


data class Service(
    val laundryName : String,
    val price : Double,
    val imageVector: ImageVector,
    val quantity : Int
)


@OptIn(ExperimentalMaterialApi::class)

@Composable
fun RequirementDetailsScreen(navController: NavHostController) {

    Scaffold(
        modifier = Modifier
            .background(SurfaceColor),

        topBar = {
                TopAppBar(navController)
            } ,

        content = { innerPadding ->

                LazyColumn(
                    contentPadding = innerPadding,
                    modifier = Modifier
                        .background(SurfaceColor)
                        .fillMaxHeight(),
                ) {

                    item {
                        DeliveryArea()
                    }

                    val services = listOf(
                        Service(
                            laundryName = "Short T-Shirt" ,
                            price = 10.000 ,
                            imageVector = Icons.Rounded.LocalLaundryService ,
                            quantity = 3
                        ) ,
                        Service(
                            laundryName = "Jacket" ,
                            price = 10.000 ,
                            imageVector = Icons.Rounded.LocalLaundryService ,
                            quantity = 3
                        ) ,
                        Service(
                            laundryName = "Pants" ,
                            price = 10000.0 ,
                            imageVector = Icons.Rounded.LocalLaundryService ,
                            quantity = 3
                        ),
                        Service(
                            laundryName = "Pants" ,
                            price = 10000.0 ,
                            imageVector = Icons.Rounded.LocalLaundryService ,
                            quantity = 3
                        ),
                        Service(
                            laundryName = "Pants" ,
                            price = 10000.0 ,
                            imageVector = Icons.Rounded.LocalLaundryService ,
                            quantity = 3
                        ),
                        Service(
                            laundryName = "Pants" ,
                            price = 10000.0 ,
                            imageVector = Icons.Rounded.LocalLaundryService ,
                            quantity = 3
                        ),
                        Service(
                            laundryName = "Pants" ,
                            price = 10000.0 ,
                            imageVector = Icons.Rounded.LocalLaundryService ,
                            quantity = 3
                        ),
                        Service(
                            laundryName = "Pants" ,
                            price = 10000.0 ,
                            imageVector = Icons.Rounded.LocalLaundryService ,
                            quantity = 3
                        ),
                        Service(
                            laundryName = "Pants" ,
                            price = 10000.0 ,
                            imageVector = Icons.Rounded.LocalLaundryService ,
                            quantity = 3
                        ),
                        Service(
                            laundryName = "Pants" ,
                            price = 10000.0 ,
                            imageVector = Icons.Rounded.LocalLaundryService ,
                            quantity = 3
                        ),
                        Service(
                            laundryName = "Pants" ,
                            price = 10000.0 ,
                            imageVector = Icons.Rounded.LocalLaundryService ,
                            quantity = 3
                        ),
                        Service(
                            laundryName = "Pants" ,
                            price = 10000.0 ,
                            imageVector = Icons.Rounded.LocalLaundryService ,
                            quantity = 3
                        ),
                        Service(
                            laundryName = "Pants" ,
                            price = 10000.0 ,
                            imageVector = Icons.Rounded.LocalLaundryService ,
                            quantity = 3
                        ),
                        Service(
                            laundryName = "Pants" ,
                            price = 10000.0 ,
                            imageVector = Icons.Rounded.LocalLaundryService ,
                            quantity = 3
                        ),
                        Service(
                            laundryName = "Pants" ,
                            price = 10000.0 ,
                            imageVector = Icons.Rounded.LocalLaundryService ,
                            quantity = 3
                        ),
                        Service(
                            laundryName = "Pants" ,
                            price = 10000.0 ,
                            imageVector = Icons.Rounded.LocalLaundryService ,
                            quantity = 3
                        ),
                        Service(
                            laundryName = "Pants" ,
                            price = 10000.0 ,
                            imageVector = Icons.Rounded.LocalLaundryService ,
                            quantity = 3
                        ),
                        Service(
                            laundryName = "Pants" ,
                            price = 10000.0 ,
                            imageVector = Icons.Rounded.LocalLaundryService ,
                            quantity = 3
                        ),
                        Service(
                            laundryName = "Pants" ,
                            price = 10000.0 ,
                            imageVector = Icons.Rounded.LocalLaundryService ,
                            quantity = 3
                        )
                    )

                    items(services) { service ->

                        Surface(
                            onClick = {}
                        ) {
                            Row(
                                Modifier
                                    .background(MaterialTheme.colors.background)
                                    .padding(12.dp)
                                    .fillMaxWidth() ,
                                verticalAlignment = Alignment.Bottom ,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {

                                DeliveryInformation(
                                    serviceType = service.laundryName ,
                                    specification = "${service.price} FCFA" ,
                                    imageVector = service.imageVector ,
                                    tintColor = Color.Red ,
                                    modifier = Modifier.weight(0.9f)
                                )

                                Text(
                                    text = "x${service.quantity}" ,
                                    color = HardGray ,
                                    style = MaterialTheme.typography.subtitle1.copy(
                                        fontWeight = FontWeight.Bold
                                    ) ,
                                    modifier = Modifier
                                        .weight(0.1f)
                                )

                            }
                        }

                    }

                    item {
                        Row(
                            Modifier
                                .background(MaterialTheme.colors.background)
                                .fillMaxWidth()
                                .padding(12.dp)
                        ) {

                            Column(
                                Modifier
                                    .weight(0.9f)
                            ) {
                                Text(
                                    "Clothing safety" ,
                                    style = MaterialTheme.typography.h6
                                )
                                Text(
                                    "5000 FCFA" ,
                                    style = MaterialTheme.typography.subtitle2 ,
                                    color = HardGray
                                )
                            }

                            var checked by remember {
                                mutableStateOf(true)
                            }

                            Switch(
                                checked = checked ,
                                onCheckedChange = { checked = it } ,
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Purple200 ,
                                    uncheckedThumbColor = MaterialTheme.colors.background
                                ) ,
                                modifier = Modifier
                                    .weight(0.1f)
                            )

                        }
                    }

                    item {
                        Row(
                            Modifier
                                .background(MaterialTheme.colors.background)
                                .fillMaxWidth()
                                .padding(12.dp)
                        ) {
                            Text(
                                "Add Notice" ,
                                Modifier
                                    .weight(0.9f) ,
                                style = MaterialTheme.typography.h6
                            )
                            Button(
                                onClick = { } ,
                                modifier = Modifier
                                    .weight(0.1f) ,
                                contentPadding = PaddingValues(1.dp) ,
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = SoftPurple200
                                )
                            ) {
                                Icon(
                                    Icons.Rounded.NavigateNext ,
                                    contentDescription = "Next" ,
                                    modifier = Modifier
                                        .size(ButtonDefaults.IconSize) ,
                                    tint = Purple200
                                )
                            }
                        }
                    }

                    item{
                        Spacer(Modifier.height(8.dp))
                    }

                    item {
                        PickUpAddress()
                    }

                    item{
                        Spacer(Modifier.height(8.dp))
                    }
                }

            },

        bottomBar = {
            ValidationArea()
        }
    )

}

@Composable
private fun TopAppBar(navController: NavHostController){
    Row(
        Modifier
            .padding(vertical = 4.dp)
            .background(Color.White) ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row (
            Modifier
                .weight(0.5f),
            horizontalArrangement = Arrangement.Start
        )
        {
            IconButton(
                onClick = { navController.navigate(Screen.ListCommande.road)} ,
                modifier = Modifier
                    .size(32.dp , 32.dp)
            ) {
                Icon(
                    Icons.Rounded.ArrowBack ,
                    contentDescription = stringResource(R.string.arrow_back) ,
                    modifier = Modifier
                        .size(32.dp , 32.dp)
                )
            }
        }

        Row(
            Modifier
                .weight(1f),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Detail Order" ,
                style = MaterialTheme.typography.h5.copy(
                    fontSize = 22.sp
                ) ,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
private fun ValidationArea() {
    Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(          topStart = 28.dp ,
                        topEnd = 28.dp ,
                        bottomEnd = 0.dp ,
                        bottomStart = 0.dp
                    )
                )
                .background(MaterialTheme.colors.surface)
                .padding(0.dp , 8.dp)
                .height(92.dp)
    ) {
            Button (
                onClick = {  },
                modifier = Modifier
                    .clip(CircleShape)
                    .fillMaxSize()
                    .padding(16.dp),
                shape = RoundedCornerShape(24.dp) ,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Purple200
                )
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){

                    Column(
                        Modifier
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "25000 FCFA",
                            style = MaterialTheme.typography.subtitle1.copy(
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                        )
                        Text(
                            "Total (7 items)",
                            style = MaterialTheme.typography.subtitle2.copy(
                                fontWeight = FontWeight.W400,
                                fontSize = 12.sp,
                                color = Color.White
                            )
                        )
                    }

                    Row(
                        modifier = Modifier
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Payement" ,
                            style = MaterialTheme.typography.h6.copy(
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                        )
                    }

                }

            }
    }
}


