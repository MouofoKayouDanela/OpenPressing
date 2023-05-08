package com.android.openpressing.client_module.presentation




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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.android.openpressing.R
import com.android.openpressing.ui.theme.*
import com.android.openpressing.utils.Screen
import com.android.openpressing.client_module.presentation.CardWithContent as CardWithContent

data class pressing(
    val imageVector: Painter,
    val nom:String,
    val position:String,
    val nomLivraison:String
)

data class user(
    val name: String,
    val localisation: String
)


@Composable
fun ScaffoldSample(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {SectionBleue()},
        //drawerContent = { Text(text = "Drawer Menu 1") },
        content = {
                innerPadding->  CardContent(pressing = listOf(
            pressing(
                imageVector = painterResource(R.drawable.lavage4),
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
                imageVector = painterResource(R.drawable.lavage),
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
        bottomBar = { BottomBar(navController)}
    )
}

@Composable
fun SectionBleue(){

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


@Composable
fun SectionBleu() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(height = 160.dp, width = 300.dp) /////taille du box bleue/////
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
    ) {

        Column() {
            /////Ligne de l'icone de notification/////
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ){ /////LIGNE DE L'IMAGE//////////
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.homme),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(40.dp)
                            .border(1.dp, color = Color.White, CircleShape)

                    )
                    Spacer(Modifier.width(1.dp))
                    //////description du la photo////

                    Text(
                        " Hello, ",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                    )
                    Text(
                        "Emmanuel Zipar",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                    )
                    //Spacer(Modifier.height(5.dp))
                }

                ////logo de location/////

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Rounded.Notifications,
                        contentDescription = stringResource(R.string.notifications),
                        tint = Color.White
                    )
                }
            }

            //Spacer(Modifier.height(5.dp))

            ////////text de titre///////
            Row(
                Modifier
                    .padding(horizontal = 25.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Find your favorite Laundry place",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = blanc,
                )
            }

            Spacer(Modifier.height(10.dp))

            ////logo de location/////
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 35.dp)
            ) {
                Icon(
                    Icons.Rounded.LocationOn,
                    contentDescription = stringResource(R.string.location),
                    tint = Orange
                )
                Text(
                    "Douala,Nyalla Rue225",
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    color = Color.White,
                )
            }
        }
    }
}

    /////////BARRE DE RECHERCHE//////////////////
    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun SearchField(onSearch: (String) -> Unit) {

        var searchQuery by remember { mutableStateOf("") }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon"
                    )
                },
                placeholder = { Text(text = "Search your laundry") },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    textColor = Color.Black
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(onSearch = { onSearch(searchQuery) })
            )

            //////icone de filtre/////
            //Spacer(Modifier.width(2.dp))

            IconButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    imageVector = Icons.Default.Sort,
                    contentDescription = stringResource(R.string.editer),
                    tint = Purple,
                    modifier = Modifier
                        .size(height = 30.dp, width = 40.dp)
                        .background(Color.White)
                )
            }
        }

    }


    ///////////card content///////////////////////
    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun CardContent(

        pressing: List<pressing>,
        innerPadding: PaddingValues
    ) {
        var searchQuery by remember { mutableStateOf("") }
        LazyColumn(contentPadding = innerPadding) {
            stickyHeader {
                SearchField(onSearch = { searchText ->
                    // Traiter la recherche ici
                    searchQuery = searchText
                })
            }
            items(pressing) {
                CardWithContent(it)
            }
        }
    }

    //////////////BOTTOM BARRE/////////////////
    @Composable
    fun BottomBar(navController: NavHostController) {
        val selectedIndex = remember { mutableStateOf(0) }
        BottomNavigation(
            elevation = 2.dp,
            backgroundColor = blanc
        ) {

            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.LocalLaundryService, "", tint = Purple500)
            },
                label = { Text(text = "Laundry") },
                selected = (selectedIndex.value == 0),
                onClick = {
                    navController.navigate(Screen.Home.road)
                    selectedIndex.value = 0
                })
            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.Reorder, "")
            },
                label = { Text(text = "Order") },
                selected = (selectedIndex.value == 1),
                onClick = {
                    selectedIndex.value = 1
                })

            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.Chat, "")
            },
                label = { Text(text = "Chat") },
                selected = (selectedIndex.value == 2),
                onClick = {
                    selectedIndex.value = 2
                })

            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.Person, "")
            },
                label = { Text(text = "Profile") },
                selected = (selectedIndex.value == 3),
                onClick = {
                    navController.navigate(Screen.Profile.road)
                    selectedIndex.value = 3
                })
        }
    }

    //@Preview(showBackground = true)
   /* @Composable
    fun Preview() {
        OpenPressingTheme {
            ScaffoldSample(navController)
        }
    }*/