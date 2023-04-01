package com.android.openpressing.client_module.presentation.requirement

import androidx.compose.material.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SwitchDefaults.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
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
import com.android.openpressing.R
import com.android.openpressing.ui.theme.*


data class Service(
    val laundryName : String,
    val price : Double,
    val imageVector: ImageVector,
    val quantity : Int
)


@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun RequirementDetailsScreen(){

    ConstraintLayout {
        val (lazyColumn, box) = createRefs()

        LazyColumn(
            Modifier.constrainAs(lazyColumn) {

            }
        ) {

            item {
                TopAppBar()
            }

            item {
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {

                Column(
                    Modifier
                        .padding(vertical = 8.dp)
                        .background(MaterialTheme.colors.background)
                ) {

                    Text(
                        "Detail Persanan" ,
                        style = MaterialTheme.typography.h6 ,
                        modifier = Modifier.padding(16.dp)
                    )

                    Divider(modifier = Modifier.fillMaxSize())

                    Row(
                        modifier = Modifier
                            .padding(16.dp) ,
                        horizontalArrangement = Arrangement.SpaceBetween ,
                    ) {

                        DeliveryArea(
                            modifier = Modifier.weight(1f) ,
                            serviceType = "Express" ,
                            specification = "24 Km" ,
                            imageVector = Icons.Rounded.Timer ,
                            tintColor = Purple200
                        )

                        DeliveryArea(
                            modifier = Modifier.weight(1f) ,
                            serviceType = "Mawar" ,
                            specification = "lorem ipsum..." ,
                            imageVector = Icons.Rounded.EditNote ,
                            tintColor = SoftYellow
                        )
                    }

                }

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
                )
            )

            items(services) { service ->

                Surface(
                    onClick = {}
                ) {
                    Row(
                        Modifier
                            .background(MaterialTheme.colors.background)
                            .padding(16.dp)
                            .fillMaxWidth() ,
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        DeliveryArea(
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
                        .padding(16.dp)
                ) {

                    Column(
                        Modifier
                            .weight(0.9f)
                    ) {
                        Text(
                            "Clothing safety",
                            style = MaterialTheme.typography.h6
                        )
                        Text(
                            "5000 FCFA",
                            style = MaterialTheme.typography.subtitle2,
                            color = HardGray
                        )
                    }

                    var checked by remember {
                        mutableStateOf(true)
                    }

                    Switch(
                        checked = checked ,
                        onCheckedChange = { checked = it } ,
                        colors = colors(
                            checkedThumbColor = Purple200 ,
                            uncheckedThumbColor = MaterialTheme.colors.background
                        ),
                        modifier = Modifier
                            .weight(0.1f)
                    )

                }
            }

            item {
                Row (
                    Modifier
                        .background(MaterialTheme.colors.background)
                        .fillMaxWidth()
                        .padding(16.dp)
                ){
                    Text(
                        "Add Notice",
                        Modifier
                            .weight(0.9f),
                        style = MaterialTheme.typography.h6
                    )
                    Button(
                        onClick = {  },
                        modifier = Modifier
                            .weight(0.1f),
                        contentPadding = PaddingValues(1.dp),
                        colors = buttonColors(
                            backgroundColor = SoftPurple200
                        )
                    ) {
                        Icon(
                            Icons.Rounded.NavigateNext,
                            contentDescription = "Next",
                            modifier = Modifier
                                .size(ButtonDefaults.IconSize),
                            tint = Purple200
                        )
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                Column(
                    Modifier
                        .background(MaterialTheme.colors.background)
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ){

                        Icon(
                            Icons.Rounded.LocationCity,
                            contentDescription = "Location",
                            tint = Purple200,
                            modifier = Modifier.weight(0.1f)
                        )

                        Text(
                            text = "Pick up Address",
                            style = MaterialTheme.typography.h6,
                            modifier = Modifier.weight(0.8f)
                        )

                        Button(
                            onClick = {  },
                            modifier = Modifier
                                .weight(0.1f),
                            contentPadding = PaddingValues(1.dp),
                            colors = buttonColors(
                                backgroundColor = SoftPurple200
                            )
                        ) {
                            Icon(
                                Icons.Rounded.NavigateNext,
                                contentDescription = "Next",
                                modifier = Modifier
                                    .size(ButtonDefaults.IconSize),
                                tint = Purple200
                            )
                        }

                    }

                    Text(
                        "Jl. Raya Cikotomos No 68567 tasikmalaya perum compoka block A",
                        style = MaterialTheme.typography.subtitle2,
                        color = HardGray,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )

                }
            }

            item {
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        Box(
            Modifier
                .background(MaterialTheme.colors.background)
                .padding(4.dp, 8.dp),
            contentAlignment = Alignment.Center
        ){
            FloatingActionButton (
                onClick = {  },
                modifier = Modifier
                    .clip(CircleShape)
                    .fillMaxSize()
                    .padding(16.dp),
                shape = RoundedCornerShape(24.dp),
                backgroundColor = Purple200,
                contentColor = Color.White
            ) {

                Row{

                    Column{
                        Text(
                            "25000 FCFA"
                        )
                        Text(
                            "Total (7 items)"
                        )
                    }

                    Text(
                        "Payement"
                    )

                }

            }
        }

    }

}

@Composable
private fun TopAppBar() {
    Row(
        Modifier
            .padding(vertical = 4.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(84.dp)
    ) {

        IconButton(
            onClick = { }
        ) {
            Icon(
                Icons.Rounded.ArrowBack,
                contentDescription = stringResource(R.string.arrow_back),
                modifier = Modifier.size(32.dp, 32.dp)
            )
        }

        Text(
            text = "Detail Order",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.fillMaxWidth()
        )

    }
}

@Composable
private fun DeliveryArea(
    modifier : Modifier = Modifier,
    serviceType : String,
    specification : String,
    imageVector: ImageVector,
    tintColor : Color
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        Icon(
            imageVector,
            contentDescription = "fast",
            tint = tintColor,
            modifier = Modifier.size(32.dp, 32.dp)
        )

        Column {
            Text(
                serviceType,
                style = MaterialTheme.typography.body2.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Text(
                specification,
                style = MaterialTheme.typography.subtitle2,
                color = HardGray
            )
        }
    }
}