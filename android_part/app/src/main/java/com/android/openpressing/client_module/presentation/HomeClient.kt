package com.android.openpressing.client_module.presentation


import android.graphics.Color
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.openpressing.R
import com.android.openpressing.ui.theme.*
import com.android.openpressing.client_module.presentation.CardWithContent as CardWithContent


@Composable
fun ScaffoldSample() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { SectionBleue()  },
        content = {
                innerPadding->  CardContent(pressing = listOf(
            pressing(
                imageVector = painterResource(R.drawable.lavage),
                nom = "Elegance Pressing",
                position= "Bonamoussadi",
                nomLivraison = "Free Delivery"
            ),
            pressing(
                imageVector = painterResource(R.drawable.lavage2),
                nom = "Eco Pressing",
                position= "Makepe",
                nomLivraison = "Free Delivery"
            ),
            pressing(
                imageVector = painterResource(R.drawable.lavage1),
                nom = "Blinding Pressing",
                position= "Logpom",
                nomLivraison = "Free Delivery"
            ),
            pressing(
                imageVector = painterResource(R.drawable.lavage3),
                nom = "Saka Pressing",
                position= "Logbessou",
                nomLivraison = "Free Delivery"
            ),
            pressing(
                imageVector = painterResource(R.drawable.lavage4),
                nom = "Saka Pressing",
                position= "Logbessou",
                nomLivraison = "Free Delivery"
            ),
            pressing(
                imageVector = painterResource(R.drawable.lavage5),
                nom = "Saka Pressing",
                position= "Logbessou",
                nomLivraison = "Free Delivery"
            ),
        ),
            innerPadding = innerPadding
        )
                  },
        bottomBar = { BottomBar()}
    )
}


@Composable
fun CardWithContent(pressing: pressing) {
    val paddingModifier = Modifier.padding(15.dp)
    Card(
        elevation = 10.dp,
        contentColor = black,
        shape = RoundedCornerShape(15.dp),
        modifier = paddingModifier

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 5.dp),
        ){
        Row(
            modifier=Modifier.fillMaxSize(),
        ) {
            Image(
                painter = pressing.imageVector,
                contentDescription = null,
                modifier = Modifier
                    .clip(
                        shape = RoundedCornerShape(
                            topEnd = 10.dp,
                            topStart = 10.dp
                        )
                    )
                    .fillMaxWidth()
                    .height(200.dp),

                contentScale = ContentScale.Crop
            )
        }
            Row(
                verticalAlignment=Alignment.CenterVertically
            ) {

            Column(
                modifier=Modifier.weight(0.8f),
            ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                        modifier=Modifier.padding(15.dp)

            ) {
                Text(
                    text = pressing.nom,
                    color = black,
                    style = MaterialTheme.typography.body1.copy(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
            
        }
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                //modifier=Modifier.padding(5.dp)
            ) {
                Icon(
                    Icons.Rounded.LocationOn,
                    contentDescription = "position",
                    tint = Orange
                )
                Text(
                    text = pressing.position,
                    color = black,
                    style = MaterialTheme.typography.body1.copy(
                        fontSize = 15.sp
                    )
                )
            }
            }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier=Modifier.weight(0.3f),
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_directions_bike_24),
                        contentDescription = "position",
                        tint = Orange,
                                modifier = Modifier
                                    .padding(15.dp)
                                    .size(30.dp)
                                    .height(44.dp)
                    )
                    Text(
                        text = pressing.nomLivraison,
                        color = black,
                        style = MaterialTheme.typography.body1.copy(
                            fontSize = 15.sp
                        )
                    )
                }
            }
        }

    }


}

data class pressing(
    val imageVector: Painter,
    val nom:String,
    val position:String,
    val nomLivraison:String
)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardContent(
    pressing: List<pressing>,
    innerPadding: PaddingValues
)
{
    LazyColumn(contentPadding = innerPadding) {
        stickyHeader{
            SearchField()
        }
        items(pressing){
               CardWithContent(it)
        }


    }

}



@Composable
fun SectionBleue() {
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
                    contentDescription = "previewPage",
                    tint = blanc
                )
                Icon(
                    Icons.Rounded.Notifications,
                    contentDescription ="notifications",
                    tint = blanc
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
                    painter = painterResource(R.drawable.baseline_person_outline_24),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(55.dp)
                        .border(1.dp, color = blanc, CircleShape)

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
                        color = blanc,
                    )
                    Spacer(Modifier.height(5.dp))
                    ////logo de location/////
                    Row() {
                        Icon(
                            Icons.Rounded.LocationOn,
                            contentDescription = "location",
                            tint = blanc
                        )
                        Text(
                            "Douala,Nyalla Rue 225",
                            fontWeight = FontWeight.Normal,
                            color = blanc,
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
                            contentDescription = "money",
                            tint = Orange
                        )
                        Text(
                            "Solde",
                            fontWeight = FontWeight.Normal,
                            color = blanc
                        )
                    }
                    Spacer(Modifier.height(1.dp))
                    Text(
                        "25.000Fcfa",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = blanc
                    )
                }

                //////*****Icone de gauche*******///////////
            }

        }
    }
}


@Composable
fun BottomBar() {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(elevation = 2.dp,
            backgroundColor = blanc) {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.LocalLaundryService,"",tint=Purple500)
        },
            label = { Text(text = "Laundry") },
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
            })
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Reorder,"")
        },
            label = { Text(text = "Order") },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Chat,"")
        },
            label = { Text(text = "Chat") },
            selected = (selectedIndex.value == 2),
            onClick = {
               selectedIndex.value = 2
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Person,"")
        },
            label = { Text(text = "Profile") },
            selected = (selectedIndex.value == 3),
            onClick = {
                selectedIndex.value = 3
            })
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchField() {
    var value by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        modifier = Modifier
            //.fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 10.dp),
        value = value,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = bla,
            cursorColor = black,
            disabledLabelColor = gris,
            focusedIndicatorColor = blanc,
            unfocusedIndicatorColor = blanc
        ),
        onValueChange = {
            value = it
        },
        placeholder = {
            Text(
                text = "Search your laundry",
                style = TextStyle(
                  //  color = placeholderColor,
                    fontSize = 14.sp,
                   // fontFamily = metropolisFontFamily
                )
            )
        },
        shape = RoundedCornerShape(15.dp),

        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = {

                keyboardController?.hide()
            }
        ),
        singleLine = true,
        textStyle = TextStyle(
           // color = primary,
            fontSize = 15.sp,

        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_search_24),
                contentDescription = "search icon",
                modifier = Modifier.padding(start = 14.dp)
            )
        }
    )
}





@Preview(showBackground = true)
@Composable
fun Preview() {
    OpenPressingTheme {
        ScaffoldSample()
    }
}