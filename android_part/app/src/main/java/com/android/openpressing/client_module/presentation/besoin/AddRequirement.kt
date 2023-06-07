package com.android.openpressing.client_module.presentation.besoin

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.openpressing.R
import com.android.openpressing.client_module.presentation.besoin.component.ChooseLaundryScreen
import com.android.openpressing.client_module.presentation.besoin.component.ChooseServicesScreen
import com.android.openpressing.client_module.presentation.besoin.component.uil.Data
import com.android.openpressing.data.models.laundry.Laundry
import com.android.openpressing.client_module.presentation.besoin.component.uil.Service
import com.android.openpressing.ui.theme.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.android.openpressing.data.models.client.ClientData
import com.android.openpressing.data.models.laundry.LaundryData
import com.android.openpressing.data.models.requirement.RequirementInfo
import com.android.openpressing.data.models.requirement.RequirementInfoData
import com.android.openpressing.data.models.requirement_detail.RequirementDetailData
import com.android.openpressing.data.models.requirement_detail.RequirementDetailInfo
import com.android.openpressing.data.models.requirement_detail.RequirementDetailInfoData
import com.android.openpressing.data.models.utils.service_n_laundry.IntermediaryData
import com.android.openpressing.utils.Screen
import com.android.openpressing.viewmodels.client.ClientViewModel
import com.android.openpressing.viewmodels.laundries.LaundryViewModel
import com.android.openpressing.viewmodels.requirement.RequirementViewModel
import com.android.openpressing.viewmodels.requirement_detail.RequirementDetailViewModel
import com.android.openpressing.viewmodels.services.ServiceViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

@Composable
fun AddRequirementScreen(
    connectedUserId: Int,
    navController: NavHostController,
    clientViewModel: ClientViewModel = hiltViewModel(),
    requirementViewModel: RequirementViewModel = hiltViewModel()
){

/*    var laundries by remember {
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

    var client by remember(connectedUserId) {
        mutableStateOf<ClientData?>(null)
    }

    LaunchedEffect(key1 = connectedUserId) {
        clientViewModel.findAll()
            .flowOn(Dispatchers.IO)
            .collect{ keptClient ->
                client = keptClient.find {
                    connectedUserId == it.attributes.user.data.id
                }
            }
    }

    var createdRequirementDetailsId by remember {
        mutableStateOf<List<Int>?>(null)
    }

    var isCreatingRequirement by remember {
        mutableStateOf(false)
    }

    if(isCreatingRequirement && client != null){
        LaunchedEffect(key1 = connectedUserId) {
            requirementViewModel.save(
                    RequirementInfo(
                           RequirementInfoData(
                                   client = client!!.id!!,
                                   requirement_details = createdRequirementDetailsId!!
                           )
                    )
            )
            navController.navigate(Screen.ConsulterBesoin.road)
        }
    }

    Scaffold(
            topBar = {
                AppBar(navController)
            },
            content = { innerPadding ->

                RequirementDetailList(
                        innerPadding = innerPadding,
                        getCreatedRequirementDetailsId = {
                            createdRequirementDetailsId = it
                        }
                )

                /*ContentCardlist(
                        innerPadding = innerPadding,
                        laundries = laundries,
                        services = services,
                        updateLaundryData = { laundries = it },
                        updateServiceData = { services = it }
                )*/
            },
            bottomBar = {
                Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding(
                                    vertical = 8.dp ,
                                    horizontal = 16.dp
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                ) {
                    TextButton(
                            onClick = {
                                    isCreatingRequirement = true
                            },
                            shape = CircleShape,
                            enabled = createdRequirementDetailsId != null,
                            colors = ButtonDefaults.textButtonColors(
                                    backgroundColor = primaryColor,
                                    contentColor = secondaryPrimeColor,
                                    disabledContentColor = Color.LightGray
                            ),
                            modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                                "Save the need",
                                style = MaterialTheme.typography.h6.copy(
                                        fontWeight = FontWeight.Normal
                                )
                        )
                    }
                }

                /*Row(
                        modifier = Modifier
                    .background(color = Color.White)
                    .padding(16.dp))  {
                    FloatingActionButton(
                            onClick = {
                                navController.navigate( Screen.ConsulterBesoin.road)
                            },
                            backgroundColor = Purple500,
                            contentColor = Color.White,
                            modifier = Modifier
                                .clip(CircleShape)
                                .fillMaxWidth()

                    ) {
                        Text(
                                text = "Add requirement",
                                style = MaterialTheme.typography.body1.copy(
                                        fontSize = 22.sp
                                )
                        )
                    }
                }*/
            },
            /*floatingActionButtonPosition = FabPosition.Center,
            backgroundColor = Color.White*/
    )

}

@Composable
fun AppBar(navController: NavHostController,) {

    Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(primaryColor)
                .padding(
                        horizontal = 16.dp ,
                        vertical = 8.dp
                ) ,
            verticalAlignment = Alignment.CenterVertically ,
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
                    modifier = Modifier.size(32.dp),
                    tint = Color.White
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
                    text = "Need elaboration" ,
                    style = MaterialTheme.typography.h6.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Normal
                    )
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun RequirementDetailList(
    innerPadding: PaddingValues,
    getCreatedRequirementDetailsId: (List<Int>) -> Unit,
    viewModel: RequirementDetailViewModel = hiltViewModel()
) {

    var showDialog by remember {
        mutableStateOf(false)
    }

    var loadRequirementDetails by remember {
        mutableStateOf(false)
    }
    if(loadRequirementDetails) {
        LaunchedEffect(key1 = viewModel) {
            viewModel.getAll()
                .flowOn(Dispatchers.IO)
                .collect { requirementDetails ->
                    getCreatedRequirementDetailsId(
                            requirementDetails
                                .filter { it.attributes.requirement.data == null }
                                .map { it.id!! }
                    )
                }
            loadRequirementDetails = false
        }
    }

    var addedLaundries by remember {
        mutableStateOf(listOf<IntermediaryData>())
    }

    var isDeletingDetail by remember {
        mutableStateOf(false)
    }

    LazyColumn(contentPadding = innerPadding) {

        stickyHeader {
            Row(
                    Modifier
                        .clickable { showDialog = true }
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
                        tint = primaryColor ,
                        modifier = Modifier
                            .size(48.dp)
                            .weight(0.2f)
                )

                Text(
                        text = "Add new detail" ,
                        color = primaryColor ,
                        style = MaterialTheme.typography.body1.copy(
                                fontSize = 18.sp
                        ) ,
                        modifier = Modifier
                            .weight(0.8f)
                )
            }
        }

        item {
            if (showDialog) {
                ChooseLaundryScreen(
                        updateDialogState = { showDialog = it } ,
                        datas = addedLaundries ,
                        getSelectedData = {
                            val laundries = addedLaundries.toMutableList()
                            laundries.add(it)
                            addedLaundries = laundries.toList()
                        }
                )
            }
        }

        items(addedLaundries) { laundry ->
            ElementList(
                    laundry = laundry,
                    isDeleting = { isDeletingDetail = it },
                    hasBeenSaved = { loadRequirementDetails = it }
            )
            if(isDeletingDetail) {
                val laundries = addedLaundries.toMutableList()
                laundries.remove(laundry)
                addedLaundries = laundries.toList()
                isDeletingDetail = false
            }
        }

    }
}

@Composable
private fun ElementList(
    laundry: IntermediaryData,
    isDeleting: (Boolean) -> Unit,
    hasBeenSaved: (Boolean) -> Unit,
    viewModel: RequirementDetailViewModel = hiltViewModel()
) {

    var isExpanded by remember {
        mutableStateOf(false)
    }

    var quantity by remember{
        mutableStateOf(0)
    }

    var showDialog by remember {
        mutableStateOf(false)
    }

    var addedServices by remember {
        mutableStateOf(listOf<Pair<IntermediaryData, Double>>())
    }

    val serviceInformations by remember {
        mutableStateOf(mutableMapOf<IntermediaryData, Double>())
    }

    var isSaving by remember {
        mutableStateOf(false)
    }

    var isSaved by remember {
        mutableStateOf(false)
    }

    if(
        isSaving &&
        addedServices.isNotEmpty() &&
        quantity != 0
    ) {
        LaunchedEffect(key1 = laundry.id) {
            addedServices.forEach { serviceInfo ->
                viewModel.save(
                        RequirementDetailInfo(
                                RequirementDetailInfoData(
                                        laundry = laundry.id,
                                        service = serviceInfo.first.id,
                                        quantity = quantity,
                                        unitPrice = serviceInfo.second
                                )
                        )
                )
            }
            isSaved = true
            hasBeenSaved(true)
        }
    }

    Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                        horizontal = 16.dp ,
                        vertical = 4.dp
                ),
            shape = RoundedCornerShape(if(isExpanded) 10 else 20),
            elevation = 3.dp,
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
            ) {
                FetchLaundry(
                        id = laundry.id,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.9f)
                )

                IconButton(
                        onClick = { isExpanded = !isExpanded },
                        modifier = Modifier.weight(0.2f)
                ) {
                    Icon(
                            if(isExpanded)
                                Icons.Default.KeyboardArrowUp
                            else
                                Icons.Default.KeyboardArrowDown ,
                            contentDescription = null,
                            tint = primaryColor,
                    )
                }
            }

            Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp) ,
                    horizontalArrangement = Arrangement.End
            ){
                Row(
                        modifier = Modifier.width(100.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                ) {
                    IconButton(
                            onClick = { quantity-- } ,
                            enabled = quantity > 0 ,
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(
                                        if (quantity > 0)
                                            primaryColor
                                        else
                                            Color.DarkGray
                                )
                                .size(24.dp)
                    ) {
                        Row(
                                modifier = Modifier.fillMaxSize() ,
                                verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                    Icons.Default.Minimize ,
                                    null ,
                                    tint = secondaryPrimeColor
                            )
                        }
                    }

                    Row(
                            verticalAlignment = Alignment.CenterVertically ,
                            horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                                if (quantity < 10)
                                    "0$quantity"
                                else
                                    quantity.toString()
                        )
                    }

                    IconButton(
                            onClick = { quantity++ } ,
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(
                                        primaryColor
                                )
                                .size(24.dp)
                    ) {
                        Icon(
                                Icons.Default.Add ,
                                null ,
                                tint = secondaryPrimeColor
                        )
                    }
                }
            }

            if (showDialog) {
                ChooseServicesScreen(
                        updateDialogState = { showDialog = it } ,
                        datas = addedServices.map { it.first } ,
                        getDataInformation = { service, price ->
                            serviceInformations[service] = price
                            addedServices = serviceInformations.toList()
                            isSaved = false
                        }
                )
            }

            if(isExpanded){

                TextButton(
                        onClick = {
                            showDialog = true
                        } ,
                        shape = CircleShape ,
                        colors = ButtonDefaults.textButtonColors(
                                backgroundColor = primaryColor ,
                                contentColor = Color.White
                        ),
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                ) {
                    Icon(
                            Icons.Default.Add ,
                            null ,
                            tint = Color.White
                    )
                    Text("Add service")
                }

                Column(
                        modifier = Modifier
                            .padding(vertical =16.dp)
                ) {
                    addedServices.forEach { serviceInfo ->

                        Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(0.8f)){
                                FetchService(id = serviceInfo.first.id)

                                val priceFormat = DecimalFormat("#,##0", DecimalFormatSymbols.getInstance())
                                val formattedPrice = priceFormat.format(serviceInfo.second)
                                Text(
                                        "$formattedPrice FCFA",
                                        style = MaterialTheme.typography.body1.copy(
                                                color = primaryColor,
                                                fontSize = 12.sp
                                        )
                                )
                            }
                            IconButton(
                                    onClick = {
                                        val services = addedServices.toMutableList()
                                        services.remove(serviceInfo)
                                        addedServices = services.toList()
                                    }
                            ) {
                                Icon(
                                        Icons.Default.DeleteOutline,
                                        null,
                                        tint = thirdPrimeColor
                                )
                            }
                        }
                    }
                }

                Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                            onClick = { isDeleting(true) },
                            modifier = Modifier
                                .clip(CircleShape)
                    ) {
                        Icon(
                                Icons.Default.Delete,
                                null,
                                tint = thirdPrimeColor
                        )
                    }
                    if(!isSaved) {
                        IconButton(
                                onClick = { isSaving = true } ,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(primaryColor)
                        ) {
                            Icon(
                                    Icons.Default.Save ,
                                    null ,
                                    tint = thirdPrimeColor
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun FetchLaundry(
    id: Int,
    modifier : Modifier = Modifier,
    viewModel: LaundryViewModel = hiltViewModel()
) {
    var laundry by remember {
       mutableStateOf<Laundry?>(null)
    }
    LaunchedEffect(key1 = id) {
        viewModel.getById(id)
            .flowOn(Dispatchers.IO)
            .collect { laundry = it }
    }

    if(laundry != null) {
        Text(
                laundry!!.data.attributes.type.data.attributes.title + " " +
                        laundry!!.data.attributes.category.data.attributes.name,
                style = MaterialTheme.typography.h6.copy(
                        color = primaryColor,
                        fontWeight = FontWeight.Normal,
                ),
                modifier = modifier
        )
    }
}

@Composable
private fun FetchService(
    id: Int,
    viewModel: ServiceViewModel = hiltViewModel()
) {
    var service by remember(id) {
        mutableStateOf<com.android.openpressing.data.models.service.Service?>(null)
    }
    LaunchedEffect(key1 = id) {
        viewModel.getById(id)
            .flowOn(Dispatchers.IO)
            .collect { service = it }
    }

    if(service != null) {
        Text(
                service!!.data.attributes.type.data.attributes.title + " " +
                        service!!.data.attributes.category.data.attributes.name,
                color = primaryColor
        )
    }
}






/*@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun ContentCardlist(
    innerPadding: PaddingValues,
    laundries: List<Laundry>,
    services: List<Service>,
    updateLaundryData: (List<Laundry>) -> Unit,
    updateServiceData: (List<Service>) -> Unit
) {
    var showAddDialog1 by remember { mutableStateOf(false) }
    var showAddDialog2 by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    var expandedState   by remember {mutableStateOf(false    ) }
    val context = LocalContext.current
    var value by remember {
        mutableStateOf(0)
    }
    var defaultPrice by remember { mutableStateOf(0) }
    var texte by remember { mutableStateOf("") }

    LazyColumn(contentPadding = innerPadding, modifier = Modifier.background(color = Color.White)) {

        item { Spacer(modifier = Modifier
            .height(5.dp)
            .background(color = Color.White)) }


        stickyHeader {
            Row(
                modifier = Modifier
                    .padding(
                            horizontal = 4.dp ,
                            vertical = 16.dp
                    )
                    .clickable { showAddDialog1 = !showAddDialog1 }
                    .background(
                            color = Color.White
                    ),
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
                    text = "Add new laundry",
                    color = Purple200,
                    style = MaterialTheme.typography.body1.copy(
                        fontSize = 18.sp
                    ),
                    modifier = Modifier
                        .weight(0.8f)
                )
            }
            if (showAddDialog1) {

                ChooseLaundryScreen(
                    updateDialogState = { showAddDialog1 = it },
                    datas = fetchDatas1(
                        laundries = laundries
                    )
                ) {
                    val updatedLaundries = mutableListOf<Laundry>()
                    it.forEach { updatedData ->
                        updatedLaundries.add(
                          Laundry   (
                                updatedData.name,
                                updatedData.icon
                            )
                        )
                    }
                    updateLaundryData(updatedLaundries .toList())
                }
            }
        }

        items(fetchDatas1(
            laundries = laundries
        )){
                data ->

            Card(       modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp , end = 12.dp , bottom = 8.dp)
                .animateContentSize(
                        animationSpec = tween(
                                delayMillis = 300 ,
                                easing = LinearOutSlowInEasing
                        )
                )
                .border(
                        width = 1.dp ,
                        color = Orange ,
                        shape = RoundedCornerShape(
                                topEnd = 10.dp ,
                                topStart = 10.dp ,
                                bottomEnd = 10.dp ,
                                bottomStart = 10.dp
                        )
                )
                .background(color = thirdColor)
                .pointerInput(Unit) {
                    detectTapGestures(
                            onDoubleTap = {
                                Toast
                                    .makeText(context , "xcjsjej gj" , Toast.LENGTH_SHORT)
                                    .show()
                            }
                    )
                } ,
                onClick = {
                    expandedState = !expandedState

                },
                elevation =10.dp

            ) {
                Column(modifier =   Modifier.fillMaxWidth(),
                    verticalArrangement =Arrangement.SpaceBetween) {
                    Row(
                            Modifier
                                .padding(
                                        horizontal = 4.dp ,
                                        vertical = 8.dp
                                )
                                .clickable {
                                    expandedState = !expandedState
                                },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(50.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.weight(0.6f)

                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween) {
                                data.icon?.let {
                                    Icon(
                                        it,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(48.dp)
                                    )
                                }
                                Text(
                                    text = data.name,

                                )

                            }
                        }
                        Column(
                            horizontalAlignment = Alignment.End,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .weight(0.4f)
                                .padding(end = 8.dp)


                        ) {
                            Row (verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(20.dp)

                                    ){

                                IconButton(
                                    onClick = { value++ },
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .background(color = Orange)
                                        .height(20.dp)
                                        .width(20.dp)
                                ) {

                                    Image(
                                        painter = painterResource(id = R.drawable.plus),
                                        contentDescription = "plus"
                                    )


                                }
                                Text(
                                    "$value",
                                    fontWeight = FontWeight.Bold,

                                )
                                IconButton(
                                    onClick = {
                                        if (value > 0) {
                                            value--
                                        }
                                    },
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .background(color = Orange)
                                        .width(20.dp)
                                        .height(20.dp)

                                ) {

                                    Image(
                                        painter = painterResource(id = R.drawable.minus),
                                        contentDescription = "minus"
                                    )


                                }

                            }
                        }

                }
                    if (expandedState ) {

                        Row(
                            modifier = Modifier
                                .padding(
                                        horizontal = 4.dp ,
                                        vertical = 16.dp
                                )
                                .clickable { showAddDialog2 = !showAddDialog2 },
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
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
                                text = "Add services",
                                color = Purple200,
                                style = MaterialTheme.typography.body1.copy(
                                    fontSize = 18.sp
                                ),
                                modifier = Modifier
                                    .weight(0.8f)
                            )
                        }
                        if (showAddDialog2) {

                            ChooseServicesScreen(
                                updateDialogState = { showAddDialog2 = it },
                                datas = fetchDatas2(
                                    services = services
                                )
                            ) {
                                val updatedService = mutableListOf<Service>()
                                it.forEach { updatedData ->
                                    updatedService.add(
                                        Service(
                                            updatedData.name,
                                            updatedData.icon
                                        )
                                    )
                                }
                                updateServiceData(updatedService.toList())
                            }
                        }

                        fetchDatas2(services = services).forEach {

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
                                        it,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(48.dp)
                                            .weight(0.2f)
                                    )
                                }

                                Text(
                                    text = data.name,
                                    modifier = Modifier
                                        .weight(0.8f)
                                )
                                IconButton(
                                    onClick = {

                                        val updatedServices = services.toMutableList()
                                        updatedServices.remove(
                                            Service(
                                                data.name,
                                                data.icon
                                            )
                                        )
                                        updateServiceData(updatedServices.toList())
                                    },

                                    modifier = Modifier
                                        .size(24.dp)
                                        .weight(0.2f)
                                ) {
                                    Icon(
                                        Icons.Rounded.Delete,
                                        contentDescription = null,
                                        tint = Purple200
                                    )
                                }

                            }
                            Row(
                                modifier = Modifier.padding(5.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    "Prix unitaire (FCFA):",
                                    fontWeight = FontWeight.W300,
                                    modifier = Modifier
                                        .padding(start = 8.dp , end = 8.dp)
                                        .clickable {

                                            showDialog = !showDialog
                                        }
                                )
                                    if (!showDialog) {
                                        AlertDialog(

                                            onDismissRequest = { showDialog= !showDialog},
                                            title = { Text("Entrer le prix unitaire de votre linge") },
                                            text = {
                                                TextField(
                                                    value = texte,
                                                    onValueChange = { texte=it},
                                                    modifier = Modifier
                                                        .fillMaxWidth(),
                                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                                    singleLine = true,
                                                    placeholder = {Text(text = "000000")},
                                                )
                                            },

                                            confirmButton = {
                                                Button(
                                                    onClick = {
                                                        defaultPrice = texte.toInt()
                                                        showDialog=!showDialog
                                                    },
                                                    modifier = Modifier.padding(end = 15.dp)


                                                ) {
                                                    Text("Confirmer")
                                                }
                                            },
                                            dismissButton = {
                                                Button(
                                                    modifier = Modifier.padding(end = 55.dp),
                                                    onClick = {
                                                        showDialog=!showDialog
                                                    }
                                                ) {
                                                    Text("Annuler")
                                                }
                                            }
                                        )
                                    }
                                val priceFormat = DecimalFormat("#,##0", DecimalFormatSymbols.getInstance())
                                val formattedPrice = priceFormat.format(defaultPrice)

                                Text(
                                    formattedPrice,
                                    fontWeight = FontWeight.W300,
                                    modifier = Modifier
                                        .padding(start = 8.dp , end = 8.dp)
                                        .clickable {

                                            showDialog = !showDialog
                                        }
                                )

                            }

                        }
                    }

                }
        }

    }
}
}*/

/*@SuppressLint("SuspiciousIndentation")
fun fetchDatas1(
            laundries: List<Laundry>
        ) : List<Data> {
            val datas : MutableList<Data> = mutableListOf()
                    laundries.forEach {
                        datas.add(Data(it.name , it.icon))
                    }
            return datas.toList()
        }

fun fetchDatas2(
   services:List<Service>
) : List<Data> {
    val datas : MutableList<Data> = mutableListOf()
   services.forEach {
        datas.add(Data(it.name   , it.icon     ))
   }
    return datas.toList()
}*/