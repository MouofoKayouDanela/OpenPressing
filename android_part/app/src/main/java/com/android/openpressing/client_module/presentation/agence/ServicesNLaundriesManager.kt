package com.android.openpressing.client_module.presentation.agence

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.android.openpressing.client_module.presentation.agence.components.AddPrestationScreen
import com.android.openpressing.client_module.presentation.agence.utils.AgenceInfo
import com.android.openpressing.client_module.presentation.agence.utils.Laundry
import com.android.openpressing.client_module.presentation.agence.utils.Service
import com.android.openpressing.data.models.agency.Agency
import com.android.openpressing.data.models.agency_laundry.AgencyLaundryData
import com.android.openpressing.data.models.agency_service.AgencyServiceData
import com.android.openpressing.data.models.laundry.LaundryData
import com.android.openpressing.data.models.pressing.PressingData
import com.android.openpressing.data.models.service.ServiceData
import com.android.openpressing.data.models.utils.IntermediaryData
import com.android.openpressing.ui.theme.*
import com.android.openpressing.utils.BASE_URL
import com.android.openpressing.utils.Screen
import com.android.openpressing.viewmodels.agency.AgencyViewModel
import com.android.openpressing.viewmodels.agency_laundry.AgencyLaundryViewModel
import com.android.openpressing.viewmodels.agency_service.AgencyServiceViewModel
import com.android.openpressing.viewmodels.laundries.LaundryViewModel
import com.android.openpressing.viewmodels.pressing.PressingViewModel
import com.android.openpressing.viewmodels.services.ServiceViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn


@Composable
fun ServicesNLaundriesManager(
    agencyId: Int,
    navController: NavHostController
) {

    /*val agenceInfo = AgenceInfo(
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
    }*/

    Scaffold(
            topBar = {
                 TopNavBar(navController)
            },
            content = { innerPadding ->
                      BodyList(
                              agencyId = agencyId,
                              innerPadding = innerPadding,
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

                }
    )
                //BottomBar(navController)
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
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .weight(0.2f)
        ) {
                Icon(
                        Icons.Rounded.KeyboardArrowLeft,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
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
    agencyId: Int,
    innerPadding: PaddingValues ,
) {

    var datas by remember { mutableStateOf<List<IntermediaryData>?>(null) }
    var selectedIndex by remember { mutableStateOf(0) }
    
    LazyColumn(contentPadding = innerPadding) {

        item { Spacer(modifier = Modifier.height(8.dp)) }
        
        stickyHeader {

            Column(
                    modifier = Modifier.background(Color.White) ,
                    verticalArrangement = Arrangement.Center ,
                    horizontalAlignment = Alignment.CenterHorizontally
            ) {

                FetchAgency(agencyId = agencyId)

                val tabTitles = listOf(
                        "Services" ,
                        "Laundries"
                )

                TabRow(
                        selectedTabIndex = selectedIndex ,
                        backgroundColor = Color.White ,
                        contentColor = SoftPurple200
                ) {

                    tabTitles.forEachIndexed { index , title ->
                        Tab(
                                text = {
                                    Text(
                                            title ,
                                            color = if (selectedIndex == index) Purple200 else VerySoftPurple200 ,
                                            style = MaterialTheme.typography.body1.copy(
                                                    fontSize = 18.sp
                                            )
                                    )
                                } ,
                                selected = index == selectedIndex ,
                                onClick = { selectedIndex = index } ,
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
                            .background(Color.White) ,
                        verticalAlignment = Alignment.CenterVertically ,
                        horizontalArrangement = Arrangement.Center ,
                ) {
                    Icon(
                            Icons.Rounded.Add ,
                            contentDescription = null ,
                            tint = Purple200 ,
                            modifier = Modifier
                                .size(48.dp)
                                .weight(0.2f)
                    )

                    Text(
                            text = "Add new ${if (selectedIndex == 0) "service" else "laundry"}" ,
                            color = Purple200 ,
                            style = MaterialTheme.typography.body1.copy(
                                    fontSize = 18.sp
                            ) ,
                            modifier = Modifier
                                .weight(0.8f)
                    )
                }

                if (showAddDialog) {

                    AddPrestationScreen(
                            selectedIndex = selectedIndex ,
                            updateDialogState = { showAddDialog = it } ,
                            datas = datas ,
                            updateData = {
                                if (selectedIndex == 0) {

//                                    val updatedServices = mutableListOf<Service>()
//                                    it.forEach { updatedData ->
//                                        updatedServices.add(
//                                                Service(
//                                                        updatedData.name ,
//                                                        updatedData.icon
//                                                )
//                                        )
//                                    }

//                                    updateServiceData(updatedServices.toList())
                                } else {

//                                    val updatedLaundries = mutableListOf<Laundry>()
//                                    it.forEach { updatedData ->
//                                        updatedLaundries.add(
//                                                Laundry(
//                                                        updatedData.name ,
//                                                        updatedData.icon
//                                                )
//                                        )
//                                    }

//                                    updateLaundryData(updatedLaundries.toList())
                                }
                            }
                    )

                }


            }
        }

        item {

            FetchDatas(
                    selectedIndex = selectedIndex,
                    agencyId = agencyId,
                    getData = {
                        datas = it
                    }
            )

        }

        if(datas != null) {
            items(datas!!) { data ->

                Row(
                        Modifier
                            .padding(
                                    horizontal = 4.dp ,
                                    vertical = 8.dp
                            )
                            .clickable { } ,
                        verticalAlignment = Alignment.CenterVertically ,
                        horizontalArrangement = Arrangement.Center ,
                ) {

                    Image(
                            painter = rememberAsyncImagePainter(
                                    model = BASE_URL + data.imageUrl
                            ) ,
                            contentDescription = null ,
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(56.dp)
                            ,
                            contentScale = ContentScale.Crop
                    )

                    Text(
                            text = data.title ,
                            modifier = Modifier
                                .weight(0.8f)
                    )

                    IconButton(
                            onClick = {
                                if (selectedIndex == 0) {
//                                    val updatedServices = services.toMutableList()
//                                    updatedServices.remove(Service(data.name , data.icon))
//                                    updateServiceData(updatedServices.toList())
                                } else {
//                                    val updatedLaundries = laundries.toMutableList()
//                                    updatedLaundries.remove(Laundry(data.name , data.icon))
//                                    updateLaundryData(updatedLaundries.toList())
                                }

                            } ,
                            modifier = Modifier
                                .size(24.dp)
                                .weight(0.2f)
                    ) {
                        Icon(
                                Icons.Rounded.Delete ,
                                contentDescription = null ,
                                tint = Purple200
                        )
                    }
                }
            }
        }

    }
    
}

@Composable
private fun FetchAgency(
    agencyId: Int,
    agencyViewModel: AgencyViewModel = hiltViewModel(),
    pressingViewModel: PressingViewModel = hiltViewModel()
){
    val agency = remember(agencyId) { mutableStateOf<Agency?>(null) }
    val pressing = remember(agencyId) { mutableStateOf<PressingData?>(null)}
    LaunchedEffect(key1 = agencyId) {
        agencyViewModel.findById(agencyId)
            .flowOn(Dispatchers.IO)
            .collect{ keptAgency ->
                agency.value = keptAgency
            }
        if(agency.value != null) {
            pressingViewModel.findAll()
                .flowOn(Dispatchers.IO)
                .collect { allPressings ->
                    pressing.value = allPressings.find { oneOfAllPressings ->
                        oneOfAllPressings.attributes.agencies!!.data.any { agencyId == it.id }
                    }
                }
        }
    }

    if(
        agency.value != null &&
        pressing.value != null
    ) {
        Row(
                modifier = Modifier
                    .padding(
                            horizontal = 4.dp ,
                            vertical = 16.dp
                    ) ,
                verticalAlignment = Alignment.CenterVertically ,
                horizontalArrangement = Arrangement.Center
        ) {

            Image(
                    painter = rememberAsyncImagePainter(
                            model = BASE_URL + pressing.value!!.attributes
                                .logo.data.attributes
                                .url
                    ) ,
                    contentDescription = pressing.value!!.attributes.name ,
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(20))
                        .size(100.dp),
                    contentScale = ContentScale.Crop
            )

            Column(
                    modifier = Modifier
                        .weight(0.8f)
                        .padding(vertical = 4.dp)
            ) {

                Text(
                        pressing.value!!.attributes.name ,
                        style = MaterialTheme.typography.h4.copy(
                                fontWeight = FontWeight.SemiBold ,
                                fontSize = 28.sp
                        ) ,
                )

                Text(
                        agency.value!!.data.attributes.quarter
                            .data.attributes.name ,
                        style = MaterialTheme.typography.body1.copy(
                                fontSize = 20.sp
                        )
                )
            }

        }
    }
}

@Composable
fun FetchDatas(
    selectedIndex: Int ,
    agencyId: Int,
    getData: (List<IntermediaryData>) -> Unit,
    aLViewModel: AgencyLaundryViewModel = hiltViewModel(),
    laundryViewModel: LaundryViewModel = hiltViewModel(),
    aSViewModel: AgencyServiceViewModel = hiltViewModel(),
    serviceViewModel: ServiceViewModel = hiltViewModel()
) {
    val allALs = remember(agencyId) { mutableStateOf<List<AgencyLaundryData>?>(null) }
    val allASs = remember(agencyId) { mutableStateOf<List<AgencyServiceData>?>(null) }
    val datas : MutableList<IntermediaryData> = mutableListOf()
    LaunchedEffect(key1 = agencyId) {
        if(selectedIndex == 0) {
            datas.clear()

            aSViewModel.findAll()
                .flowOn(Dispatchers.IO)
                .collect{ keptAgencyServices ->
                    allASs.value = keptAgencyServices.filter { agencyId == it.attributes.agency.data.id }
                }

            if(allASs.value != null) {
                var services : List<ServiceData>? = listOf()

                serviceViewModel.findAll()
                    .flowOn(Dispatchers.IO)
                    .collect{ services = it }

                if(services != null){
                    allASs.value!!.forEach { agencyService ->
                        val service = services!!.find {
                            agencyService.attributes.service.data.id == it.id
                        }
                        if(service != null) {
                            datas.add(
                                    IntermediaryData(
                                            title = service.attributes.type.data.attributes.title + " " +
                                                    service.attributes.category.data.attributes.name ,
                                            imageUrl = service.attributes.serviceImage.data.attributes.url
                                    )
                            )
                        }
                    }
                }

                getData(datas)
            }
        } else {
            datas.clear()

            aLViewModel.findAll()
                .flowOn(Dispatchers.IO)
                .collect{ keptAgencyLaundries ->
                    allALs.value = keptAgencyLaundries.filter { agencyId == it.attributes.agency.data.id }
                }

            if(allALs.value != null) {
                var laundries : List<LaundryData>? = listOf()
                laundryViewModel.findAll()
                    .flowOn(Dispatchers.IO)
                    .collect{ laundries = it }
                if(laundries != null){
                    allALs.value!!.forEach { agencyLaundry ->
                        val laundry = laundries!!.find {
                            agencyLaundry.attributes.laundry.data.id == it.id
                        }
                        if(laundry != null) {
                            datas.add(
                                    IntermediaryData(
                                            title = laundry.attributes.type.data.attributes.title + " " +
                                                    laundry.attributes.category.data.attributes.name ,
                                            imageUrl = laundry.attributes.laundryImage.data.attributes.url
                                    )
                            )
                        }
                    }
                }

                getData(datas)
            }
        }
    }


//    when (selectedIndex) {
//
//        0 -> {
//
//            services.forEach {
//                datas.add(IntermediaryData(it.name , it.icon))
//            }
//
//        }
//
//        1 -> {
//
//            laundries.forEach {
//                datas.add(Data(it.name , it.icon))
//            }
//
//        }
//
//        else -> {}
//
//    }
//
//    return datas.toList()

}

