package com.android.openpressing.client_module.presentation




import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.android.openpressing.R
import com.android.openpressing.client_module.presentation.besoin.user
import com.android.openpressing.client_module.presentation.profile.id
import com.android.openpressing.data.models.agency.Agency
import com.android.openpressing.data.models.agency.AgencyData
import com.android.openpressing.data.models.laundry.Laundry
import com.android.openpressing.data.models.pressing.Pressing
import com.android.openpressing.data.models.pressing.PressingData
import com.android.openpressing.data.models.quarter.QuarterData
import com.android.openpressing.data.models.user.User
import com.android.openpressing.data.models.user.UserData
import com.android.openpressing.ui.theme.*
import com.android.openpressing.utils.BASE_URL
import com.android.openpressing.utils.Screen
import com.android.openpressing.viewmodels.agency.AgencyViewModel
import com.android.openpressing.viewmodels.agency.state.AgencyState
import com.android.openpressing.viewmodels.laundries.LaundryViewModel
import com.android.openpressing.viewmodels.pressing.PressingViewModel
import com.android.openpressing.viewmodels.quarter.QuarterViewModel
import com.android.openpressing.viewmodels.quarter.state.QuarterState
import com.android.openpressing.viewmodels.services.state.LaundryState
import com.android.openpressing.viewmodels.services.state.PressingState
import com.android.openpressing.viewmodels.services.state.RequirementState
import com.android.openpressing.viewmodels.user.UserViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch



@Composable
fun ScaffoldSample(
    connectedClientId: Int,
    navController: NavHostController,
    viewModel : PressingViewModel = hiltViewModel()
) {
    Log.i("", "le client connecte a pour id : $connectedClientId")

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    viewModel.getAll()
    var quarterId by remember { mutableStateOf(0) }
    Scaffold(
        scaffoldState = scaffoldState,
        //LazyColumn(content = LazyListScope.item()->unit ),
        topBar =  {
            SectionBleue(
                connectedClientId,
                getConnectedUserQuarter = { quarterId = it }
            )
        },
        //drawerContent = { Text(text = "Drawer Menu 1") },
        content = {
                innerPadding->  CardContent(
            innerPadding = innerPadding,
            state=viewModel.availablePressing.collectAsState().value,
            quarterId = quarterId,
            navController
        )
                  },
        bottomBar = { BottomBar(navController)}
    )
}

@Composable
fun SectionBleue(
   connectedClientId: Int,
   getConnectedUserQuarter: (Int) -> Unit,
   userViewModel: UserViewModel = hiltViewModel(),
){

    val user = remember {
        mutableStateOf<User?>(null)
    }
    LaunchedEffect(key1 = connectedClientId){
        userViewModel.getById(connectedClientId)
            .flowOn(Dispatchers.IO)
            .collect{
                user.value = it
            }
    }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(height = 160.dp, width = 300.dp) /////taille du box bleue/////
            .clip(
                shape = RoundedCornerShape(
                    bottomEnd = 40.dp,
                    bottomStart = 40.dp
                )
            )//////forme arrondie de la box/////
            .background(color = primaryColor)
        //shape=RoundedCornerShape(32.dp)
    ) {Column() {
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
                if (user.value != null){
                    Image(
                        rememberAsyncImagePainter(
                            model = BASE_URL + user.value!!.profile_picture
                                .url
                        ),
                        //painter = painterResource(id = R.drawable.homme),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(45.dp)
                            .border(1.dp, color = Color.White, CircleShape),

                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(Modifier.width(1.dp))
                //////description du la photo////

                Text(
                    " Hello, ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                )
                if (user.value != null){
                    Text(
                        text = user.value!!.name,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                    )
                }
                //Spacer(Modifier.height(5.dp))
            }

            ////logo de location/////

            IconButton(onClick =
            {
                //navController.navigate(  Screen  .ConsulterMessage   .road   )
                }
            ) {
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
                tint = secondaryColor
            )
            if (user.value != null){
                Text(
                    text = user.value!!.quarter.name,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                    color = Color.White,
                )
                getConnectedUserQuarter(user.value!!.quarter.id!!)
            }

        }
    }
    }
}

@Composable
fun CardWithContent(
    pressing: PressingData,
    quarterId: Int,
    navController: NavHostController,
    viewModel : AgencyViewModel = hiltViewModel(),

) { //navController: NavHostController

    Card(
        elevation = 10.dp,
        contentColor = black,
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .padding(15.dp)
            .clickable {
                navController.navigate(Screen.ListOffer.road)
            },

        ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 5.dp),
        ) {
            Image(
                rememberAsyncImagePainter(
                    model = BASE_URL + pressing.attributes.logo
                        .data
                        .attributes
                        .url
                ) ,
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
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(0.8f),
                ) {

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier.padding(15.dp)

                    ) {
                        Text(
                            text =  pressing.attributes.name,
                            color = black,
                            style = MaterialTheme.typography.body1.copy(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        )

                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier.padding(
                            horizontal = 8.dp
                        )
                    ) {
                        Icon(
                            Icons.Rounded.LocationOn,
                            contentDescription = "position",
                            tint = Orange
                        )
                        var agencies by remember(quarterId) { mutableStateOf<MutableList<AgencyData>?>(null) }
                        LaunchedEffect(key1 = quarterId) {
                            viewModel.findAll()
                                .flowOn(Dispatchers.IO)
                                .collect { keptAgencies ->
                                    agencies = keptAgencies
                                }
                        }
                        if(agencies != null ){
                            val quarter = agencies!!.find { oneOfAllAgencies ->
                                oneOfAllAgencies.attributes.quarter.data.id == quarterId &&
                                        pressing.attributes.agencies!!.data.any{ pressingAgence ->
                                            pressingAgence.id == oneOfAllAgencies.id
                                        }
                            }?.attributes?.quarter

                            if(quarter!= null){
                                Text(
                                    text = quarter.data.attributes.name,
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
        }

    }
}


    /////////BARRE DE RECHERCHE//////////////////
    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun SearchField(
        searchQuery: String,
        onSearchQuery: (String) -> Unit
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = searchQuery,
                onValueChange = { onSearchQuery(it) },
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
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    textColor = black,
                    placeholderColor = Color.LightGray,
                    leadingIconColor = Color.LightGray
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(onSearch = { onSearchQuery(searchQuery) })
            )

            //////icone de filtre/////
            //Spacer(Modifier.width(2.dp))

            IconButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    imageVector = Icons.Default.Sort,
                    contentDescription = stringResource(R.string.editer),
                    tint = Purple500,
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
        innerPadding: PaddingValues,
        state : PressingState,
        quarterId: Int,
        navController: NavHostController
    ) {
        var searchQuery by remember { mutableStateOf("") }
        LazyColumn(contentPadding = innerPadding) {
            stickyHeader {
                SearchField(
                    searchQuery = searchQuery,
                    onSearchQuery = { searchText ->
                    // Traiter la recherche ici
                    searchQuery = searchText
                    }
                )

            }
            if(state is PressingState.Success.PressingsSuccess){
                items (fetchPressings(
                    searchQuery = searchQuery,
                    pressings =state.data
                )) { pressing ->
                    CardWithContent(
                        pressing,
                        quarterId,
                        navController
                    )
                }
            }
        }
    }

private fun fetchPressings(
    searchQuery:String,
    pressings : MutableList<PressingData>
): MutableList<PressingData> {

    return if(searchQuery.isEmpty()) pressings else pressings.filter {
        it.attributes.name.lowercase().contains(searchQuery.lowercase())
    }.toMutableList()

}

    //////////////BOTTOM BARRE/////////////////
    @Composable
    fun BottomBar(navController: NavController) {
        val selectedIndex = remember { mutableStateOf(0) }
        BottomNavigation(
            elevation = 2.dp,
            backgroundColor = blanc
        ) {

            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.LocalLaundryService, "", tint = primaryColor)
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
                    navController.navigate(Screen.ListCommande.road)
                    selectedIndex.value = 1
                })

            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.Notes, "")
            },
                label = { Text(text = "Needs") },
                selected = (selectedIndex.value == 2),
                onClick = {
                    navController.navigate(Screen.ConsulterBesoin.road)
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

/*@Preview(showBackground = true)
   @Composable
    fun Preview() {
        OpenPressingTheme {
            ScaffoldSample()
        }
    }*/