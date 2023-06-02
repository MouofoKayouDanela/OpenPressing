package com.android.openpressing.client_module.presentation.agence

import android.util.Log
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.android.openpressing.client_module.presentation.agence.components.AddPrestationScreen
import com.android.openpressing.data.models.agency.Agency
import com.android.openpressing.data.models.agency_laundry.*
import com.android.openpressing.data.models.agency_service.*
import com.android.openpressing.data.models.laundry.LaundryData
import com.android.openpressing.data.models.pressing.PressingData
import com.android.openpressing.data.models.service.ServiceData
import com.android.openpressing.data.models.laundry.Laundry
import com.android.openpressing.data.models.service.Service
import com.android.openpressing.data.models.utils.IntermediaryData
import com.android.openpressing.ui.theme.*
import com.android.openpressing.utils.BASE_URL
import com.android.openpressing.viewmodels.agency.AgencyViewModel
import com.android.openpressing.viewmodels.agency_laundry.AgencyLaundryViewModel
import com.android.openpressing.viewmodels.agency_service.AgencyServiceViewModel
import com.android.openpressing.viewmodels.laundries.LaundryViewModel
import com.android.openpressing.viewmodels.pressing.PressingViewModel
import com.android.openpressing.viewmodels.services.ServiceViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn


@Composable
fun ServicesNLaundriesManager(
    agencyId: Int,
    navController: NavHostController,
    aLViewModel: AgencyLaundryViewModel = hiltViewModel(),
    laundryViewModel: LaundryViewModel = hiltViewModel(),
    aSViewModel: AgencyServiceViewModel = hiltViewModel(),
    serviceViewModel: ServiceViewModel = hiltViewModel()
) {

    var agencyLaundriesData by remember(agencyId) { mutableStateOf<List<IntermediaryData>?>(null) }
    var fetchLaundriesData by remember { mutableStateOf(false) }
    if(fetchLaundriesData) {
        LaunchedEffect(key1 = agencyId) {
            var allALs: List<AgencyLaundryData>? = null
            aLViewModel.findAll()
                .flowOn(Dispatchers.IO)
                .collect { keptAgencyLaundries ->
                    allALs = keptAgencyLaundries.filter { agencyId == it.attributes.agency.data.id }
                }
            if (allALs != null) {
                var laundries: List<LaundryData>? = null
                laundryViewModel.findAll()
                    .flowOn(Dispatchers.IO)
                    .collect { laundries = it }
                if (laundries != null) {
                    val pickedData: MutableList<IntermediaryData> = mutableListOf()
                    allALs!!.forEach { agencyLaundry ->
                        val laundry = laundries!!.find {
                            agencyLaundry.attributes.laundry.data.id == it.id
                        }
                        if (laundry != null) {
                            pickedData.add(
                                    IntermediaryData(
                                            id = laundry.id!! ,
                                            idType = laundry.attributes.type.data.id!! ,
                                            idCategory = laundry.attributes.category.data.id!! ,
                                            title = laundry.attributes.type.data.attributes.title + " " +
                                                    laundry.attributes.category.data.attributes.name ,
                                            imageUrl = laundry.attributes.laundryImage.data.attributes.url
                                    )
                            )
                        }
                    }
                    agencyLaundriesData = pickedData
                }
            }
        }
    }

    var agencyServicesData by remember(agencyId) { mutableStateOf<List<IntermediaryData>?>(null) }
    var fetchServicesData by remember { mutableStateOf(false) }
    if(fetchServicesData) {
        LaunchedEffect(key1 = agencyId) {
            var allASs: List<AgencyServiceData>? = null
            aSViewModel.findAll()
                .flowOn(Dispatchers.IO)
                .collect { keptAgencyServices ->
                    allASs = keptAgencyServices.filter { agencyId == it.attributes.agency.data.id }
                }
            if (allASs != null) {
                var services: List<ServiceData>? = null
                serviceViewModel.findAll()
                    .flowOn(Dispatchers.IO)
                    .collect { services = it }
                if (services != null) {
                    val pickedData: MutableList<IntermediaryData> = mutableListOf()
                    allASs!!.forEach { agencyService ->
                        val service = services!!.find {
                            agencyService.attributes.service.data.id == it.id
                        }
                        if (service != null) {
                            pickedData.add(
                                    IntermediaryData(
                                            id = service.id!! ,
                                            idType = service.attributes.type.data.id!! ,
                                            idCategory = service.attributes.category.data.id!! ,
                                            title = service.attributes.type.data.attributes.title + " " +
                                                    service.attributes.category.data.attributes.name ,
                                            imageUrl = service.attributes.serviceImage.data.attributes.url
                                    )
                            )
                        }
                    }
                    agencyServicesData = pickedData
                }
            }
        }
    }

    Scaffold(
            topBar = {
                 TopNavBar(navController)
            },
            content = { innerPadding ->
                BodyList(
                        agencyId = agencyId ,
                        innerPadding = innerPadding ,
                        agencyLaundriesData = agencyLaundriesData,
                        agencyServicesData = agencyServicesData,
                        canFetchLaundriesData = { fetchLaundriesData = it },
                        canFetchServicesData = { fetchServicesData = it }
                )

            },
    )
}

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
    innerPadding: PaddingValues,
    agencyLaundriesData: List<IntermediaryData>?,
    agencyServicesData: List<IntermediaryData>?,
    canFetchLaundriesData: (Boolean) -> Unit,
    canFetchServicesData: (Boolean) -> Unit
) {
    var selectedIndex by remember { mutableStateOf(0) }

    if(selectedIndex == 0) {
        canFetchServicesData(true)
        canFetchLaundriesData(false)
    } else if (selectedIndex == 1) {
        canFetchServicesData(false)
        canFetchLaundriesData(true)
    }
    
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

                var addedData by remember { mutableStateOf<List<IntermediaryData>?>(null) }

                if (showAddDialog) {
                    AddPrestationScreen(
                            selectedIndex = selectedIndex ,
                            updateDialogState = { showAddDialog = it } ,
                            datas = if (selectedIndex == 0 && agencyServicesData != null)
                                agencyServicesData
                            else if (selectedIndex == 1 && agencyLaundriesData != null)
                                agencyLaundriesData
                            else
                                listOf()
                            ,
                            updateData = {
                                addedData = it
                            }
                    )
                }

                if(addedData != null) {
                    SaveData(
                            agencyId = agencyId ,
                            selectedIndex = selectedIndex ,
                            datas = addedData!!,
                            updateData = { addedData = it },
                            canFetchServicesData = { canFetchServicesData(it) },
                            canFetchLaundriesData = { canFetchLaundriesData(it) }
                    )
                }


            }
        }

        items(
                if(selectedIndex == 0 && agencyServicesData != null)
                    agencyServicesData
                else if (selectedIndex == 1 && agencyLaundriesData != null)
                    agencyLaundriesData
                else
                    listOf()
        ) { data ->

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
                            .padding(
                                    start = 16.dp
                            )
                )

                var isDeleting by remember { mutableStateOf(false) }

                IconButton(
                        onClick = {
                            isDeleting = true
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
                if(isDeleting) {
                    DeleteData(
                            agencyId = agencyId,
                            selectedIndex = selectedIndex ,
                            data = data ,
                            canFetchLaundriesData = { canFetchLaundriesData(it) } ,
                            canFetchServicesData = { canFetchServicesData(it) } ,
                            updateDeletingState = { isDeleting = it }
                    )
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
private fun SaveData(
    agencyId: Int,
    selectedIndex: Int,
    datas: List<IntermediaryData>,
    updateData: (List<IntermediaryData>?) -> Unit,
    canFetchLaundriesData: (Boolean) -> Unit,
    canFetchServicesData: (Boolean) -> Unit,
    agencyViewModel: AgencyViewModel = hiltViewModel(),
    laundryAgencyViewModel: AgencyLaundryViewModel = hiltViewModel(),
    laundryViewModel: LaundryViewModel = hiltViewModel(),
    serviceAgencyViewModel: AgencyServiceViewModel = hiltViewModel(),
    serviceViewModel: ServiceViewModel = hiltViewModel()
) {
    val agency = remember (agencyId) { mutableStateOf<Agency?>(null) }
    if(selectedIndex == 1) {
        val laundry = remember(selectedIndex) { mutableStateOf<Laundry?>(null) }
        LaunchedEffect(key1 = selectedIndex) {
            agencyViewModel.findById(agencyId)
                .flowOn(Dispatchers.IO)
                .collect { agency.value = it }
            if(agency.value != null) {
                datas.forEach { data ->
                    laundryViewModel.getById(data.id)
                        .flowOn(Dispatchers.IO)
                        .collect{ laundry.value = it }
                    if(laundry.value != null) {
                        laundryAgencyViewModel.save(
                                AgencyLaundryInfo(
                                        AgencyLaundryInfoData(
                                                laundry = laundry.value!!.data.id!!,
                                                agency = agency.value!!.data.id!!
                                        )
                                )
                        )
                    }
                }
                canFetchLaundriesData(true)
                updateData(null)
            }
        }
    } else {
        val service = remember(selectedIndex) { mutableStateOf<Service?>(null) }
        LaunchedEffect(key1 = selectedIndex) {
            agencyViewModel.findById(agencyId)
                .flowOn(Dispatchers.IO)
                .collect { agency.value = it }
            if(agency.value != null) {
                datas.forEach { data ->
                    serviceViewModel.getById(data.id)
                        .flowOn(Dispatchers.IO)
                        .collect { service.value = it }
                    if(service.value != null) {
                        serviceAgencyViewModel.save(
                                AgencyServiceInfo(
                                        AgencyServiceInfoData(
                                                agency = agency.value!!.data.id!!,
                                                service = service.value!!.data.id!!
                                        )
                                )
                        )
                    }
                }
                canFetchServicesData(true)
                updateData(null)
            }
        }
    }
}

@Composable
private fun DeleteData(
    agencyId: Int,
    selectedIndex: Int,
    data: IntermediaryData,
    canFetchLaundriesData: (Boolean) -> Unit,
    canFetchServicesData: (Boolean) -> Unit,
    updateDeletingState: (Boolean) -> Unit,
    laundryAgencyViewModel: AgencyLaundryViewModel = hiltViewModel(),
    serviceAgencyViewModel: AgencyServiceViewModel = hiltViewModel(),
) {

    LaunchedEffect(key1 = agencyId){
        if (selectedIndex == 0) {
            var agencyServices: List<AgencyServiceData>? = null
            serviceAgencyViewModel.findAll()
                .flowOn(Dispatchers.IO)
                .collect { agencyServices = it }
            if(agencyServices != null) {
                val agencyService = agencyServices!!.find {
                    agencyId == it.attributes.agency.data.id &&
                            data.id == it.attributes.service.data.id
                }
                if(agencyService != null) {
                    serviceAgencyViewModel.delete(agencyService.id!!)
                    canFetchServicesData(true)
                    updateDeletingState(false)
                }
            }
        } else {
            var agencyLaundries: List<AgencyLaundryData>? = null
            laundryAgencyViewModel.findAll()
                .flowOn(Dispatchers.IO)
                .collect { agencyLaundries = it }
            if(agencyLaundries != null) {
                val agencyLaundry = agencyLaundries!!.find {
                    agencyId == it.attributes.agency.data.id &&
                            data.id == it.attributes.laundry.data.id
                }
                if(agencyLaundry != null) {
                    laundryAgencyViewModel.delete(agencyLaundry.id!!)
                    canFetchLaundriesData(true)
                    updateDeletingState(false)
                }
            }
        }
    }
}

