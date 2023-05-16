package com.android.openpressing.pressing_module.requirement

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.openpressing.ui.theme.primaryColor
import com.android.openpressing.ui.theme.primaryPrimeColor
import com.android.openpressing.ui.theme.secondaryPrimeColor
import com.android.openpressing.ui.theme.softPrimaryPrimeColor
import java.util.*

data class Data(
    val username: String ,
    val date: Date ,
    val services: List<String>
)

val myDatas = listOf(
        Data(
                "Boris Temfack",
                Date(),
                listOf(
                        "Lavage à sec",
                        "Lavage à eau",
                        "Détachage",
                        "Amidonnage"
                )
        ),
        Data(
                "Ernest Donfack",
                Date(),
                listOf(
                        "Lavage à sec",
                        "Lavage à eau",
                        "Détachage",
                        "Amidonnage"
                )
        ),
        Data(
                "Valdez Kanouo",
                Date(),
                listOf(
                        "Lavage à sec",
                        "Lavage à eau",
                        "Détachage",
                        "Amidonnage"
                )
        ),
        Data(
                "Claudel Noumbissie",
                Date(),
                listOf(
                        "Lavage à sec",
                        "Lavage à eau",
                        "Détachage",
                        "Amidonnage"
                )
        ),
        Data(
                "Henry Kemadjou",
                Date(),
                listOf(
                        "Lavage à sec",
                        "Lavage à eau",
                        "Détachage",
                        "Amidonnage"
                )
        ),
        Data(
                "Nicolas Bogni",
                Date(),
                listOf(
                        "Lavage à sec",
                        "Lavage à eau",
                        "Détachage",
                        "Amidonnage"
                )
        ),
        Data(
                "Idriss Keni",
                Date(),
                listOf(
                        "Lavage à sec",
                        "Lavage à eau",
                        "Détachage",
                        "Amidonnage"
                )
        ),
        Data(
                "Celestin Kouetchou",
                Date(),
                listOf(
                        "Lavage à sec",
                        "Lavage à eau",
                        "Détachage",
                        "Amidonnage"
                )
        ),
        Data(
                "Loic Tatsalekeu",
                Date(),
                listOf(
                        "Lavage à sec",
                        "Lavage à eau",
                        "Détachage",
                        "Amidonnage"
                )
        )
)

@Preview
@Composable
fun ClRequirementConsulting() {
    Scaffold(
            topBar = { TopAppBar() } ,
            content = { innerPadding ->
                RequirementList(innerPadding)
            } ,
            bottomBar = { BottomAppBar() } ,
    )
}

@Composable
fun TopAppBar() {
    Column {
        Row(
                Modifier
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
                    ),
                verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                    onClick = { },
                    modifier = Modifier.weight(0.1f)
            ) {
                Icon(
                        Icons.Rounded.KeyboardArrowLeft ,
                        contentDescription = null ,
                        tint = Color.White,
                        modifier = Modifier
                            .size(48.dp)
                )
            }

            Row(
                    modifier = Modifier.weight(0.9f),
                    horizontalArrangement = Arrangement.Center
            ){
                Text(
                        "Besoins disponibles" ,
                        style = MaterialTheme.typography.h5 ,
                        color = Color.White
                )
            }
        }
    }
}

@Composable
fun RequirementList(
    innerPadding: PaddingValues
) {
    LazyColumn(
            contentPadding = innerPadding
    ) {

        items(myDatas) { data ->

            var isExpanded by remember { mutableStateOf(false) }

            Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                    elevation = 2.dp,
                    backgroundColor = Color.White,
                    border = BorderStroke(
                            1.dp,
                            secondaryPrimeColor
                    ),
                    shape = RoundedCornerShape(if (isExpanded) 10 else 20)
            ) {

                Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp) ,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically ,
                            horizontalArrangement = Arrangement.Center
                    ) {

                        Icon(
                                Icons.Rounded.Person ,
                                contentDescription = null ,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(Color.LightGray)
                                    .size(48.dp)
                        )

                        Column(
                                modifier = Modifier
                                    .weight(0.65f)
                                    .padding(8.dp) ,
                                verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                    data.username ,
                                    style = MaterialTheme.typography.body1
                            )
                            Text(
                                    data.date.toString() ,
                                    style = MaterialTheme.typography.overline
                            )
                        }

                        IconButton(
                                onClick = { isExpanded = !isExpanded } ,
                                modifier = Modifier.weight(0.1f)
                        ) {

                            Icon(
                                    imageVector = if (!isExpanded)
                                                    Icons.Rounded.KeyboardArrowDown
                                                 else
                                                     Icons.Rounded.KeyboardArrowUp,
                                    contentDescription = null ,
                            )
                        }

                    }

                    if (isExpanded) {

                        Column(
                                modifier = Modifier.padding(8.dp)
                        ){

                            LazyRow(
                                    modifier = Modifier
                                        .padding(
                                                top = 4.dp,
                                                bottom = 10.dp
                                        )
                            ) {

                                items(data.services) { service ->

                                    Row(
                                            modifier = Modifier
                                                .padding(end = 8.dp),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                                service,
                                                style = MaterialTheme.typography.body1,
                                                modifier = Modifier
                                                    .clip(CircleShape)
                                                    .background(primaryPrimeColor)
                                                    .padding(4.dp)
                                        )
                                    }
                                }

                            }

                            Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .border(
                                                width = 1.dp ,
                                                brush = Brush.linearGradient(
                                                        listOf(
                                                                Color.Black ,
                                                                Color.Black
                                                        )
                                                ) ,
                                                shape = RoundedCornerShape(20)
                                        )
                                        .padding(4.dp)
                                        .clickable { }
                            ) {
                                Text(
                                        "Voir plus",
                                        style = MaterialTheme.typography.body1,
                                        modifier = Modifier
                                            .weight(0.9f)
                                )
                                Icon(
                                        Icons.Rounded.ArrowRightAlt,
                                        contentDescription =  null,
                                        modifier = Modifier.weight(0.1f)
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun BottomAppBar() {
    Row(
            Modifier
                .fillMaxWidth()
                .background(primaryColor)
                .padding(
                        horizontal = 8.dp ,
                        vertical = 4.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
                onClick = { },
                modifier = Modifier.weight(1.5f)
        ) {
            Icon(
                    Icons.Rounded.SkipPrevious,
                    contentDescription = null,
                    tint = Color.White
            )
        }
        IconButton(
                onClick = { },
                modifier = Modifier.weight(1.5f)
        ) {
            Icon(
                    Icons.Rounded.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = Color.White
            )
        }

        Row(
                modifier = Modifier.weight(4f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
        ){
            Text(
                    "page 01 sur 07" ,
                    color = Color.White,
                    style = MaterialTheme.typography.body1
            )
        }

        IconButton(
                onClick = { },
                modifier = Modifier.weight(1.5f)
        ) {
            Icon(
                    Icons.Rounded.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.White
            )
        }
        IconButton(
                onClick = { },
                modifier = Modifier.weight(1.5f)
        ) {
            Icon(
                    Icons.Rounded.SkipNext,
                    contentDescription = null,
                    tint = Color.White
            )
        }
    }
}