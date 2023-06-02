package com.android.openpressing.pressing_module.requirement

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.android.openpressing.data.models.client.Client
import com.android.openpressing.data.models.laundry.Laundry
import com.android.openpressing.data.models.requirement.Requirement
import com.android.openpressing.data.models.requirement_detail.RequirementDetailData
import com.android.openpressing.data.models.service.Service
import com.android.openpressing.data.models.user.User
import com.android.openpressing.ui.theme.*
import com.android.openpressing.utils.BASE_URL
import com.android.openpressing.utils.Screen
import com.android.openpressing.viewmodels.client.ClientViewModel
import com.android.openpressing.viewmodels.laundries.LaundryViewModel
import com.android.openpressing.viewmodels.requirement.RequirementViewModel
import com.android.openpressing.viewmodels.requirement_detail.RequirementDetailViewModel
import com.android.openpressing.viewmodels.services.ServiceViewModel
import com.android.openpressing.viewmodels.user.UserViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import java.util.*

@Composable
fun RequirementDetail(
    requirementId: Int,
    navController: NavController,
    viewModel: RequirementViewModel = hiltViewModel()
) {

    val requirement = remember(requirementId) { mutableStateOf<Requirement?>(null) }

    LaunchedEffect(key1 = requirementId) {
        viewModel.getById(requirementId)
            .flowOn(Dispatchers.IO)
            .collect { keptRequirement ->
                requirement.value = keptRequirement
            }
    }

    Scaffold(

            topBar = {
                if (requirement.value != null){
                    TopAppBar(
                         clientId = requirement.value!!.data.attributes.client.data.id!!,
                         rdCreatedDate = requirement.value!!.data.attributes.createdAt,
                         navController = navController
                    )
                }
            } ,

            content = { innerPadding ->

                if (requirement.value != null) {
                    RequirementContent(
                            innerPadding = innerPadding ,
                            requirementDetails = requirement.value!!.data.attributes.requirement_details.data
                    )
                }
            } ,

            bottomBar = {

            }
    )

}

@Composable
private fun TopAppBar(
    clientId: Int ,
    rdCreatedDate: Date ,
    navController: NavController ,
    clientViewModel: ClientViewModel = hiltViewModel() ,
    userViewModel: UserViewModel = hiltViewModel()
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
                .background(Purple500)
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
                    onClick = { navController.navigate(Screen.ClientRequirement.road) },
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
                                backgroundColor = Purple500
                        ),
                        shape = RoundedCornerShape(20),
                        border = BorderStroke(
                                width = 1.dp,
                                color = secondaryPrimeColor
                        )
                ) {
                    Text(
                            "Répondre",
                            style = MaterialTheme.typography.body1.copy(
                                    fontWeight = FontWeight.Bold
                            )
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

            val client = remember(clientId) { mutableStateOf<Client?>(null) }

            LaunchedEffect(key1 = clientId) {
                clientViewModel.getById(clientId)
                    .flowOn(Dispatchers.IO)
                    .collect{ keptClient ->
                        client.value = keptClient
                    }
            }

            if(client.value != null) {

                val userId = client.value!!.data.attributes.user.data.id!!
                val user = remember { mutableStateOf<User?>(null) }
                LaunchedEffect(key1 = userId) {
                    userViewModel.getById(userId)
                        .flowOn(Dispatchers.IO)
                        .collect { keptUser ->
                            user.value = keptUser
                        }
                }

                if(user.value != null) {

                    Image(
                      painter = rememberAsyncImagePainter(
                              model = BASE_URL + user.value!!.profile_picture
                                  .url
                      ),
                      contentDescription = null,
                      contentScale = ContentScale.Crop,
                      modifier = Modifier
                          .clip(CircleShape)
                          .size(86.dp)
                          .background(Color.White)
                          .weight(0.35f),
                    )

                    Column(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .weight(0.65f) ,
                            verticalArrangement = Arrangement.Center ,

                            ) {

                        Text(
                                user.value!!.username ,
                                style = MaterialTheme.typography.h6.copy(
                                        color = Color.White ,
                                        fontWeight = FontWeight.W700
                                )
                        )

                        Text(
                                "$rdCreatedDate" ,
                                style = MaterialTheme.typography.subtitle2.copy(
                                        color = Color.White ,
                                        fontWeight = FontWeight.W500
                                )
                        )

                    }
                }
            }

        }


    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RequirementContent(
    innerPadding: PaddingValues ,
    requirementDetails: List<RequirementDetailData> ,
    viewModel: RequirementDetailViewModel = hiltViewModel()
) {
    val allRdKey = "allRd"
    val allRd = remember(allRdKey) { mutableStateOf<List<RequirementDetailData>?>(null) }

    LaunchedEffect(key1 = allRdKey) {
        viewModel.getAll()
            .flowOn(Dispatchers.IO)
            .collect { allRdKept ->
                allRd.value = allRdKept
            }
    }

    if (allRd.value != null ){
        val allWantedRd = allRd.value!!.filter { rd ->
            requirementDetails.any { it.id == rd.id }
        }

        LazyColumn(
                contentPadding = innerPadding ,
                modifier = Modifier
                    .fillMaxWidth()
        ) {

            allWantedRd.groupBy { it.attributes.service.data.id }
                .forEach { (serviceId , requirementDetails) ->

                    stickyHeader {
                        FetchService(
                                serviceId = serviceId!!
                        )
                    }

                    items(requirementDetails) { requirementDetail ->
                        Card(

                                modifier = Modifier
                                    .fillMaxWidth() ,
                                shape = RoundedCornerShape(20)
                        ) {

                            Column(
                                    modifier = Modifier
                                        .background(softSecondaryPrimeColor)
                                        .padding(16.dp)
                                        .fillMaxWidth() ,
                                    verticalArrangement = Arrangement.Center ,
                                    horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Row(
                                        modifier = Modifier
                                            .fillMaxWidth() ,
                                        verticalAlignment = Alignment.CenterVertically ,
                                ) {

                                    Column(
                                            modifier = Modifier
                                                .weight(0.6f) ,
                                    ) {

                                        FetchLaundry(
                                                laundryId = requirementDetail.attributes.laundry.data.id!!
                                        )

                                        Text(
                                                "x${requirementDetail.attributes.quantity}" ,
                                                style = MaterialTheme.typography.body2
                                        )

                                    }

                                    Row(
                                            modifier = Modifier
                                                .weight(0.4f) ,
                                            horizontalArrangement = Arrangement.End
                                    ) {
                                        Text(
                                                "${requirementDetail.attributes.unitPrice} FCFA" ,
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

}

@Composable
private fun FetchService(
    serviceId: Int ,
    viewModel: ServiceViewModel = hiltViewModel()
) {

    val service = remember(serviceId) { mutableStateOf<Service?>(null) }

    LaunchedEffect(key1 = serviceId) {
        viewModel.getById(serviceId)
            .flowOn(Dispatchers.IO)
            .collect { keptService ->
                service.value = keptService
            }
    }

    if(service.value != null) {
        Row(
                modifier = Modifier
                    .background(Color.White)
                    .padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 16.dp
                    )
                    .fillMaxWidth()
        ) {
            Text(
                    service.value!!.data.attributes.type.data.attributes.title + " " +
                            service.value!!.data.attributes.category.data.attributes.name ,
                    style = MaterialTheme.typography.body1.copy(
                            fontWeight = FontWeight.SemiBold ,
                            color = secondaryColor
                    )
            )
        }
    }

}

@Composable fun FetchLaundry(
    laundryId: Int,
    viewModel: LaundryViewModel = hiltViewModel()
) {

    val laundry = remember(laundryId) { mutableStateOf<Laundry?>(null) }

    LaunchedEffect(key1 = laundryId) {
        viewModel.getById(laundryId)
            .flowOn(Dispatchers.IO)
            .collect { keptLaundry ->
                laundry.value = keptLaundry
            }
    }

    if(laundry.value != null) {
        Text(
                laundry.value!!.data.attributes.type.data.attributes.title + " " +
                        laundry.value!!.data.attributes.category.data.attributes.name ,
                style = MaterialTheme.typography.body2
        )
    }

}