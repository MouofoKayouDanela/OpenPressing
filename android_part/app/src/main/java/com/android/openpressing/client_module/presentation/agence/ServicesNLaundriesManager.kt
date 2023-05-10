package com.android.openpressing.client_module.presentation.agence

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.android.openpressing.client_module.presentation.agence.components.AddPrestationScreen
import com.android.openpressing.client_module.presentation.agence.utils.AgenceInfo
import com.android.openpressing.client_module.presentation.agence.utils.Data
import com.android.openpressing.client_module.presentation.agence.utils.Laundry
import com.android.openpressing.client_module.presentation.agence.utils.Service
import com.android.openpressing.ui.theme.*
import com.android.openpressing.utils.Screen


@Composable
fun ServicesNLaundriesManager(navController: NavHostController) {

    val agenceInfo = AgenceInfo(
            "Elegance Pressing",
            Icons.Rounded.LocalLaundryService,
            "Bonamoussadi"
    )
    var laundries by remember {
        mutableStateOf( listOf(
            Laundry("Pantalon jean", Icons.Rounded.LocalLaundryService) ,
            Laundry("Culotte jean", Icons.Rounded.LocalLaundryService) ,
            Laundry("Robe en Nylon", Icons.Rounded.LocalLaundryService) ,
            Laundry("Echarpe en coton", Icons.Rounded.LocalLaundryService) ,
            Laundry("Pull en cuire", Icons.Rounded.LocalLaundryService) ,
            Laundry("Cravate en soie", Icons.Rounded.LocalLaundryService) ,
            Laundry("Veste en soie", Icons.Rounded.LocalLaundryService) ,
            Laundry("Jacket jean", Icons.Rounded.LocalLaundryService) ,
            Laundry("Jupe Nylon", Icons.Rounded.LocalLaundryService) ,
            Laundry("Chemise coton", Icons.Rounded.LocalLaundryService)
    )) }
    var services by remember {
        mutableStateOf(listOf(
                Service("Nettoyage à sec" , Icons.Rounded.Wash) ,
                Service("Nettoyage à eau" , Icons.Rounded.Wash) ,
                Service("Lavage à sec" , Icons.Rounded.Wash) ,
                Service("Déttachage" , Icons.Rounded.Wash) ,
                Service("Blanchissage" , Icons.Rounded.Wash) ,
                Service("Amidonnage" , Icons.Rounded.Wash)
        ))
    }

    Scaffold(
            topBar = {
                 TopNavBar(navController)
            },
            content = { innerPadding ->
                      BodyList(
                              innerPadding = innerPadding,
                              agenceInfo = agenceInfo,
                              laundries = laundries,
                              services = services,
                              updateLaundryData = { laundries = it },
                              updateServiceData = { services = it },

                      )

            },
            bottomBar = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    TextButton(
                        onClick = {  },
                        colors = ButtonDefaults.textButtonColors(
                            backgroundColor = Purple200,
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .clip(CircleShape)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Save",
                            style = MaterialTheme.typography.body1.copy(
                                fontSize = 22.sp
                            )
                        )
                    }

                }
                //BottomBar(navController)
            }
    )
}

/*fun BottomBar(navController: NavHostController) {
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
}*/

@Composable
fun TopNavBar(navController: NavHostController) {

    Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
    ) {

        IconButton(
                onClick = { navController.navigate(Screen.Home.road) },
                modifier = Modifier
                    .weight(0.2f)
        ) {
                Icon(
                        Icons.Rounded.ArrowBack,
                        contentDescription = null
                )
        }

        Row (
                modifier = Modifier
                    .weight(1.8f)
                    .size(32.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
        ) {
            Text(
                    text = "Services and laundries manager" ,
                    style = MaterialTheme.typography.h5.copy(
                            fontSize = 18.sp
                    )
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BodyList(
    innerPadding: PaddingValues ,
    agenceInfo: AgenceInfo ,
    laundries: List<Laundry> ,
    services: List<Service> ,
    updateLaundryData: (List<Laundry>) -> Unit,
    updateServiceData: (List<Service>) -> Unit
) {

    var selectedIndex by remember { mutableStateOf(0) }
    
    LazyColumn(contentPadding = innerPadding) {

        item { Spacer(modifier = Modifier.height(8.dp)) }
        
        stickyHeader {
            Column(
                    modifier = Modifier.background(Color.White),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                        modifier = Modifier
                            .padding(
                                    horizontal = 4.dp,
                                    vertical = 16.dp
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                ) {

                    Icon(
                            agenceInfo.icon ,
                            contentDescription = agenceInfo.name,
                            tint = SoftPurple200,
                            modifier = Modifier
                                .size(100.dp)
                                .weight(0.2f)
                    )

                    Column(
                            modifier = Modifier
                                .weight(0.8f)
                                .padding(vertical = 4.dp)
                    ) {

                        Text(
                                agenceInfo.name,
                                style = MaterialTheme.typography.h4.copy(
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 28.sp
                                ),
                        )

                        Text(
                                agenceInfo.quarter,
                                style = MaterialTheme.typography.body1.copy(
                                        fontSize = 20.sp
                                )
                        )
                    }

                }

                val tabTitles = listOf(
                        "Services",
                        "Laundries"
                )

                TabRow(
                        selectedTabIndex = selectedIndex,
                        backgroundColor = Color.White,
                        contentColor = SoftPurple200
                ) {

                    tabTitles.forEachIndexed { index, title ->
                        Tab(
                                text = {
                                    Text(
                                            title,
                                            color = if (selectedIndex == index) Purple200 else VerySoftPurple200,
                                            style = MaterialTheme.typography.body1.copy(
                                                    fontSize = 18.sp
                                            )
                                    )
                                },
                                selected = index == selectedIndex,
                                onClick = { selectedIndex = index },
                                selectedContentColor = Purple200
                        )
                    }

                }

                var showAddDialog by remember { mutableStateOf(false) }

                Row(
                        Modifier
                            .clickable { showAddDialog = !showAddDialog }
                            .padding(
                                    horizontal = 4.dp ,
                                    vertical = 8.dp
                            )
                            .background(Color.White),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                ) {
                    Icon(
                            Icons.Rounded.Add,
                            contentDescription = null,
                            tint = Purple200,
                            modifier = Modifier
                                .size(48.dp)
                                .weight(0.2f)
                    )

                    Text(
                            text = "Add new ${if (selectedIndex == 0) "service" else "laundry"}",
                            color = Purple200,
                            style = MaterialTheme.typography.body1.copy(
                                    fontSize = 18.sp
                            ),
                            modifier = Modifier
                                .weight(0.8f)
                    )
                }

                if (showAddDialog) {

                    AddPrestationScreen(
                            selectedIndex = selectedIndex,
                            updateDialogState = { showAddDialog = it },
                            datas = fetchDatas(
                                    selectedIndex = selectedIndex,
                                    services = services,
                                    laundries = laundries
                            )
                    ) {
                        if (selectedIndex == 0) {

                            val updatedServices = mutableListOf<Service>()
                            it.forEach { updatedData ->
                                updatedServices.add(Service(updatedData.name , updatedData.icon))
                            }

                            updateServiceData(updatedServices.toList())
                        } else {

                            val updatedLaundries = mutableListOf<Laundry>()
                            it.forEach { updatedData ->
                                updatedLaundries.add(Laundry(updatedData.name , updatedData.icon))
                            }

                            updateLaundryData(updatedLaundries.toList())
                        }
                    }

                }


            }
        }

        items (
                fetchDatas(
                selectedIndex = selectedIndex,
                laundries = laundries,
                services = services
        )
        ) { data ->

            Row(
                    Modifier
                        .padding(
                                horizontal = 4.dp ,
                                vertical = 8.dp
                        )
                        .clickable { },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
            ) {
                data.icon?.let {
                    Icon(
                            it ,
                            contentDescription = null ,
                            modifier = Modifier
                                .size(48.dp)
                                .weight(0.2f)
                    )
                }

                Text(
                        text = data.name ,
                        modifier = Modifier
                            .weight(0.8f)
                )

                IconButton(
                        onClick = {
                           if (selectedIndex == 0) {
                               val updatedServices = services.toMutableList()
                               updatedServices.remove(Service(data.name , data.icon))
                               updateServiceData(updatedServices.toList())
                           }
                           else {
                               val updatedLaundries = laundries.toMutableList()
                               updatedLaundries.remove(Laundry(data.name , data.icon))
                               updateLaundryData(updatedLaundries.toList())
                           }

                        },
                        modifier = Modifier
                            .size(24.dp)
                            .weight(0.2f)
                ){
                    Icon(
                            Icons.Rounded.Delete ,
                            contentDescription = null,
                            tint = Purple200
                    )
                }
            }
        }

    }
    
}

fun fetchDatas(
    selectedIndex: Int ,
    laundries: List<Laundry> ,
    services: List<Service>
) : List<Data> {

    val datas : MutableList<Data> = mutableListOf()

    when (selectedIndex) {

        0 -> {

            services.forEach {
                datas.add(Data(it.name , it.icon))
            }

        }

        1 -> {

            laundries.forEach {
                datas.add(Data(it.name , it.icon))
            }

        }

        else -> {}

    }

    return datas.toList()

}

