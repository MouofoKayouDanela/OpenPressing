package com.android.openpressing.pressing_module.requirement

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.openpressing.ui.theme.primaryColor
import com.android.openpressing.ui.theme.secondaryColor
import com.android.openpressing.ui.theme.secondaryPrimeColor
import com.android.openpressing.ui.theme.softSecondaryPrimeColor
import com.android.openpressing.viewmodels.user.UserViewModel

data class Service(
    val laundry: String,
    val quantity: Int,
    val price: Double,
)

data class RequirementDetails(
    val serviceName: String,
    val serviceDetails: List<Service>
)

val datas = listOf(
        RequirementDetails(
                "Lavage à sec",
                listOf(
                        Service(
                                "pantalon jean",
                                3,
                                100.0
                        ),
                        Service(
                                "culotte coton",
                                1,
                                200.0
                        ),
                        Service(
                                "echarpe coton",
                                7,
                                300.0
                        )
                )
        ),
        RequirementDetails(
                "Lavage à eau",
                listOf(
                        Service(
                                "T-shirt",
                                4,
                                100.0
                        ),
                        Service(
                                "jupe laine",
                                4,
                                250.0
                        ),
                        Service(
                                "echarpe din",
                                7,
                                150.0
                        )
                )
        ),
        RequirementDetails(
                "Amidonage",
                listOf(
                        Service(
                                "Chemise coton",
                                4,
                                100.0
                        ),
                        Service(
                                "pullover laine",
                                4,
                                250.0
                        ),
                        Service(
                                "cravate soie",
                                7,
                                150.0
                        )
                )
        ),
)

@Preview
@Composable
fun RequirementDetail() {

    Scaffold(

            topBar = {
                TopAppBar()
            },

            content = { innerPadding ->
                RequirementContent(
                        innerPadding = innerPadding
                )
            },

            bottomBar = {

            }
    )

}

@Composable
private fun TopAppBar(
) {
    Column(
            modifier = Modifier
                .clip(
                        RoundedCornerShape(
                                bottomStart = 10.dp ,
                                bottomEnd = 10.dp
                        )
                )
                .fillMaxWidth()
                .background(primaryColor)
                .padding(
                        horizontal = 8.dp ,
                        vertical = 4.dp
                ) ,
            verticalArrangement = Arrangement.Center ,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
        ) {

            IconButton(
                    onClick = { },
                    modifier = Modifier.weight(0.1f)
            ) {
                Icon(
                        Icons.Rounded.KeyboardArrowLeft ,
                        contentDescription = null ,
                        tint = Color.White ,
                        modifier = Modifier
                            .size(48.dp)
                )
            }
            Row(
                    modifier = Modifier
                        .weight(0.9f),
                    horizontalArrangement = Arrangement.End
            ){
                TextButton(
                        onClick = {  },
                        colors = ButtonDefaults.textButtonColors(
                                contentColor = Color.White,
                                backgroundColor = primaryColor
                        ),
                        shape = RoundedCornerShape(20),
                        border = BorderStroke(
                                width = 1.dp,
                                color = secondaryPrimeColor
                        )
                ) {
                    Text(
                            "Répondre",
                            style = MaterialTheme.typography.h6
                    )
                }
            }

        }

        Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
        ) {

            Icon(
                  Icons.Rounded.Person,
                  contentDescription = null,
                  modifier = Modifier
                      .clip(CircleShape)
                      .size(100.dp)
                      .background(Color.White)
                      .weight(0.35f)
            )
            
            Column(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .weight(0.65f),
                    verticalArrangement = Arrangement.Center,

            ) {

                Text(
                        "Ernest Donfack",
                        style = MaterialTheme.typography.h5.copy(
                                color = Color.White,
                                fontWeight = FontWeight.W700
                        )
                )

                Text(
                        "11h00 12 mai",
                        style = MaterialTheme.typography.subtitle2.copy(
                                color = Color.White,
                                fontWeight = FontWeight.W500
                        )
                )

            }

        }


    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RequirementContent(
    innerPadding: PaddingValues
) {

    LazyColumn(
            contentPadding = innerPadding,
            modifier = Modifier
                .fillMaxWidth()
    ) {
        
        datas.forEach { requirementDetails ->  

            stickyHeader {
                Row(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth()
                ) {
                    Text(
                            requirementDetails.serviceName,
                            style = MaterialTheme.typography.h5.copy(
                                    fontWeight = FontWeight.SemiBold,
                                    color = secondaryColor
                            )
                    )
                }
            }

            items(requirementDetails.serviceDetails) { service ->
                Card(

                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(20)
                ) {

                    Column(
                            modifier = Modifier
                                .background(softSecondaryPrimeColor)
                                .padding(16.dp)
                                .fillMaxWidth(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Row(
                                modifier = Modifier
                                    .fillMaxWidth() ,
                                verticalAlignment = Alignment.CenterVertically ,
                        ) {

                            Column(
                                    modifier = Modifier
                                        .weight(0.6f) ,
                            ) {

                                Text(
                                        service.laundry,
                                        style = MaterialTheme.typography.h6
                                )

                                Text(
                                        "x${service.quantity}",
                                        style = MaterialTheme.typography.body1
                                )

                            }

                            Row(
                                    modifier = Modifier
                                        .weight(0.4f),
                                    horizontalArrangement = Arrangement.End
                            ) {
                                Text(
                                        "${service.price} FCFA",
                                        style = MaterialTheme.typography.body1
                                )
                            }

                        }
                    }
                    
                }
            }

        }
        
    }

}