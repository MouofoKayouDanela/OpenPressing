package com.android.openpressing.client_module.presentation.besoin

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.android.openpressing.data.models.laundry.Laundry
import com.android.openpressing.data.models.requirement.Requirement
import com.android.openpressing.data.models.requirement_detail.RequirementDetail
import com.android.openpressing.data.models.requirement_detail.RequirementDetailData
import com.android.openpressing.data.models.service.Service
import com.android.openpressing.ui.theme.primaryColor
import com.android.openpressing.ui.theme.secondaryPrimeColor
import com.android.openpressing.utils.Screen
import com.android.openpressing.viewmodels.laundries.LaundryViewModel
import com.android.openpressing.viewmodels.requirement.RequirementViewModel
import com.android.openpressing.viewmodels.requirement_detail.RequirementDetailViewModel
import com.android.openpressing.viewmodels.services.ServiceViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailBesoin(
    requirementId: Int ,
    navController: NavHostController,
    requirementViewModel: RequirementViewModel = hiltViewModel()
){
    val requirement = remember(requirementId) { mutableStateOf<Requirement?>(null) }
    LaunchedEffect(key1 = requirementId) {
        requirementViewModel.getById(requirementId)
            .flowOn(Dispatchers.IO)
            .collect{ keptRequirement ->
                requirement.value = keptRequirement }
    }


    Scaffold(
        topBar ={
            TopNavBar(navController)
        },
        content = {
            if(requirement.value != null) {
                ContentDetail(
                        requirementDetails = requirement.value!!.data!!.attributes.requirement_details.data
                )
            }
        }
    )
}

@Composable
fun TopNavBar(navController: NavHostController) {

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
                    text = "Need detail" ,
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
private fun ContentDetail(
    requirementDetails: MutableList<RequirementDetailData> ,
    rdViewModel: RequirementDetailViewModel = hiltViewModel() ,
) {
    val allRdsKey = "ARK"
    val wantedRds = remember(allRdsKey) { mutableStateOf<List<RequirementDetailData>?>(null)}

    LaunchedEffect(key1 = allRdsKey) {
        rdViewModel.getAll()

            .flowOn(Dispatchers.IO)
            .collect { keptRequirementDetails ->
                wantedRds.value = keptRequirementDetails.filter { oneOfAllRds ->
                    requirementDetails.any { oneOfAllRds.id == it.id }
                }
            }
    }

    LazyColumn {

        if(wantedRds.value != null) {

            wantedRds.value!!.groupBy { it.attributes.laundry.data.id }
                .forEach { (laundryId, requirementDetails) ->

                    stickyHeader {
                        FetchLaundry(id = laundryId!!)
                    }

                    items(requirementDetails) { requirementDetail ->
                        FetchRequirementDetail(id = requirementDetail.id!!)
                    }

                }

        }

    }

}

@Composable
private fun FetchLaundry(
    id: Int,
    viewModel: LaundryViewModel = hiltViewModel()
) {

    val laundry = remember(id) { mutableStateOf<Laundry?>(null) }
    LaunchedEffect(key1 = id) {
        viewModel.getById(id)
            .flowOn(Dispatchers.IO)
            .collect { keptLaundry ->
                laundry.value = keptLaundry
            }
    }

    if(laundry.value != null) {
        Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(
                            start = 16.dp ,
                            end = 16.dp ,
                            top = 16.dp
                    ) ,
                horizontalArrangement = Arrangement.Center ,
                verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                laundry.value!!.data.attributes.type.data.attributes.title + " " +
                        laundry.value!!.data.attributes.category.data.attributes.name,
                style = MaterialTheme.typography.h6.copy(
                        fontWeight = FontWeight.Normal,
                        color = primaryColor
                )
            )
        }
    }
}

@Composable
private fun FetchRequirementDetail(
    id: Int,
    viewModel: RequirementDetailViewModel = hiltViewModel()
) {
    val requirementDetail = remember(id) { mutableStateOf<RequirementDetail?>(null) }

    LaunchedEffect(key1 = id) {
        viewModel.getById(id)
            .flowOn(Dispatchers.IO)
            .collect { keptRd ->
                requirementDetail.value = keptRd
            }
    }

    if(requirementDetail.value != null) {
        Card(
                elevation = 1.dp ,
                shape = RoundedCornerShape(10.dp) ,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                            vertical = 8.dp ,
                            horizontal = 16.dp
                    )
        ){
            Row(
                    modifier = Modifier
                        .background(secondaryPrimeColor)
                        .fillMaxWidth()
                        .padding(
                                vertical = 8.dp ,
                                horizontal = 8.dp
                        ) ,
                    horizontalArrangement = Arrangement.Center ,
                    verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.7f) ,
                        verticalArrangement = Arrangement.Center
                ) {
                    FetchService(id = requirementDetail.value!!.data.attributes.service.data.id!!)
                    Text("x${requirementDetail.value!!.data.attributes.quantity}")
                }
                Row(
                        modifier = Modifier
                            .weight(0.3f) ,
                        horizontalArrangement = Arrangement.End
                ) {
                    Text("${requirementDetail.value!!.data.attributes.unitPrice} FCFA")
                }
            }
        }
    }
}

@Composable
private fun FetchService(
    id: Int,
    viewModel: ServiceViewModel = hiltViewModel()
) {
    val service = remember(id) { mutableStateOf<Service?>(null) }
    LaunchedEffect(key1 = id) {
        viewModel.getById(id)
            .flowOn(Dispatchers.IO)
            .collect { keptService ->
                service.value = keptService
            }
    }

    if(service.value != null) {
        Text(
                service.value!!.data.attributes.type.data.attributes.title + " " +
                        service.value!!.data.attributes.category.data.attributes.name
        )
    }
}