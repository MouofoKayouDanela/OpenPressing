package com.android.openpressing.pressing_module.requirement

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.android.openpressing.data.models.client.Client
import com.android.openpressing.data.models.laundry.Laundry
import com.android.openpressing.data.models.requirement.RequirementData
import com.android.openpressing.data.models.requirement_detail.RequirementDetail
import com.android.openpressing.data.models.service.Service
import com.android.openpressing.data.models.user.User
import com.android.openpressing.ui.theme.primaryColor
import com.android.openpressing.ui.theme.primaryPrimeColor
import com.android.openpressing.ui.theme.secondaryPrimeColor
import com.android.openpressing.utils.BASE_URL
import com.android.openpressing.utils.Screen
import com.android.openpressing.viewmodels.client.ClientViewModel
import com.android.openpressing.viewmodels.laundries.LaundryViewModel
import com.android.openpressing.viewmodels.requirement.RequirementViewModel
import com.android.openpressing.viewmodels.requirement_detail.RequirementDetailViewModel
import com.android.openpressing.viewmodels.services.ServiceViewModel
import com.android.openpressing.viewmodels.services.state.LaundryState
import com.android.openpressing.viewmodels.services.state.RequirementState
import com.android.openpressing.viewmodels.user.UserViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import java.util.*

@Composable
fun ClRequirementConsulting(
    navController: NavController,
    requirementViewModel: RequirementViewModel = hiltViewModel()
) {

    var actualPage by remember { mutableStateOf(0) }
    var pageSize by remember { mutableStateOf(0) }

    requirementViewModel.getAll()

    Scaffold(
            topBar = { TopAppBar() } ,
            content = { innerPadding ->
                RequirementList(
                        innerPadding = innerPadding,
                        actualPage = actualPage,
                        updatePageSize = { pageSize = it },
                        state = requirementViewModel.avilablerequirement.collectAsState().value,
                        navController = navController
                )
            } ,
            bottomBar = {
                BottomAppBar(
                        actualPage = actualPage,
                        pageSize = pageSize,
                        updateActualPage = { actualPage = it }
                )
            }
    )
}

@Composable
private fun TopAppBar() {
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
    innerPadding: PaddingValues,
    actualPage: Int,
    updatePageSize: (Int) -> Unit,
    state: RequirementState,
    navController: NavController
) {

    when (state) {

        is RequirementState.Success.RequirementsSuccess -> {
            LazyColumn(
                    contentPadding = innerPadding,
            ) {

                items(fetchRequirement(
                        requirements = state.data,
                        actualPage = actualPage,
                        updatePageSize = { updatePageSize(it) }
                )) { data ->

                    var isExpanded by remember { mutableStateOf(false) }

                    Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(6.dp) ,
                            elevation = 2.dp ,
                            backgroundColor = Color.White ,
                            border = BorderStroke(
                                    1.dp ,
                                    secondaryPrimeColor
                            ) ,
                            shape = RoundedCornerShape(if (isExpanded) 10 else 20)
                    ) {

                        Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp) ,
                                verticalArrangement = Arrangement.Center ,
                                horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                    modifier = Modifier
                                        .fillMaxWidth() ,
                                    verticalAlignment = Alignment.CenterVertically ,
                                    horizontalArrangement = Arrangement.Center
                            ) {

                                FetchClient(
                                        id = data.attributes.client.data.id!! ,
                                        requirementDate = data.attributes.createdAt,
                                        modifier = Modifier.weight(0.7f)
                                )

                                IconButton(
                                        onClick = { isExpanded = !isExpanded } ,
                                        modifier = Modifier.weight(0.3f)
                                ) {

                                    Icon(
                                            imageVector = if (!isExpanded)
                                                Icons.Rounded.KeyboardArrowDown
                                            else
                                                Icons.Rounded.KeyboardArrowUp ,
                                            contentDescription = null ,
                                    )
                                }

                            }

                            if (isExpanded) {

                                Column(
                                        modifier = Modifier.padding(8.dp)
                                ) {

                                    LazyRow(
                                            modifier = Modifier
                                                .padding(
                                                        top = 4.dp ,
                                                        bottom = 10.dp
                                                )
                                    ) {

                                        val datas = data.attributes.requirement_details?.data

                                        if (datas != null){
                                            items(datas) { requirement_details ->

                                                FetchRequirementDetails(
                                                        id = requirement_details.id!!
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
                                                .clickable {
                                                    navController.navigate(
                                                            "${Screen.ClientRequirementDetails.road}/${data.id!!}"
                                                    )
                                                }
                                    ) {
                                        Text(
                                                "Voir plus" ,
                                                style = MaterialTheme.typography.body1 ,
                                                modifier = Modifier
                                                    .weight(0.9f)
                                        )
                                        Icon(
                                                Icons.Rounded.ArrowRightAlt ,
                                                contentDescription = null ,
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

        else -> {}
    }
}

private fun fetchRequirement(
    actualPage: Int ,
    updatePageSize: (Int) -> Unit,
    requirements: List<RequirementData>
) : List<RequirementData> {

    updatePageSize((requirements.size + 6) / 7)

    return requirements.subList(
            actualPage * 7,
            minOf(
                    (actualPage + 1) * 7,
                    requirements.size
            )
    )

}

@Composable
private fun FetchClient(
    id: Int,
    requirementDate: Date,
    modifier : Modifier = Modifier,
    viewModel: ClientViewModel = hiltViewModel()
) {

    var client by remember(id) { mutableStateOf<Client?>(null) }

    LaunchedEffect(key1 = id) {
        viewModel.getById(id)
            .flowOn(Dispatchers.IO)
            .collect { keptClient ->
                client = keptClient
            }
    }

    client?.let { keptClient ->
        FetchUser(
                id = keptClient.data.attributes.user.data.id!! ,
                requirementDate = requirementDate,
                modifier = modifier
        )
    }

}

@Composable
private fun FetchUser(
    id: Int,
    requirementDate: Date,
    modifier: Modifier = Modifier,
    viewModel: UserViewModel = hiltViewModel()
) {

    var user by remember(id) { mutableStateOf<User?>(null) }

    LaunchedEffect(key1 = id) {
        viewModel.getById(id)
            .flowOn(Dispatchers.IO)
            .collect { keptUser ->
                user = keptUser
            }
    }

    user?.let { keptUser ->
            Row(modifier) {
                Image(
                        rememberAsyncImagePainter(
                                model = BASE_URL + keptUser
                                    .profile_picture
                                    .url
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(48.dp),
                        contentScale = ContentScale.Crop

                )

                Column(
                        modifier = Modifier
                            .padding(8.dp) ,
                        verticalArrangement = Arrangement.Center
                ) {
                    Text(
                            keptUser.username ,
                            style = MaterialTheme.typography.body1
                    )
                    Text(
                            "$requirementDate",
                            style = MaterialTheme.typography.overline
                    )
                }
            }
    }
}

@Composable
private fun FetchRequirementDetails(
    id: Int,
    viewModel: RequirementDetailViewModel = hiltViewModel()
) {

    var requirementDetail by remember(id) { mutableStateOf<RequirementDetail?>(null) }

    LaunchedEffect(key1 = id) {
        viewModel.getById(id)
            .flowOn(Dispatchers.IO)
            .collect { keptRequirementDetail ->
                requirementDetail = keptRequirementDetail
            }
    }

    Row(
            modifier = Modifier
                .padding(end = 8.dp) ,
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.Center
    ) {

        requirementDetail?.let { keptRequirementDetail ->
            FetchService(id = keptRequirementDetail.data.attributes.service.data.id!!)
        }
    }
}

@Composable
private fun FetchService(
    id: Int,
    viewModel: ServiceViewModel = hiltViewModel()
) {

    var service by remember(id) { mutableStateOf<Service?>(null) }

    LaunchedEffect(key1 = id) {
        viewModel.getById(id)
            .flowOn(Dispatchers.IO)
            .collect { keptService ->
                service = keptService
            }
    }

    service?.let { keptService ->
            Text(
                    "${keptService.data.attributes.type.data.attributes.title} ${keptService.data.attributes.category.data.attributes.name}" ,
                    style = MaterialTheme.typography.body1 ,
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(primaryPrimeColor)
                        .padding(4.dp)
            )
    }

}

@Composable
fun BottomAppBar(
    actualPage: Int,
    pageSize: Int,
    updateActualPage: (Int) -> Unit
) {
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

        val canClickPrevious = actualPage != 0
        val canClickNext = actualPage != pageSize - 1

        IconButton(
                onClick = { updateActualPage(0) },
                modifier = Modifier.weight(1.5f),
                enabled = canClickPrevious
        ) {
            Icon(
                    Icons.Rounded.SkipPrevious,
                    contentDescription = null,
                    tint = if (canClickPrevious) Color.White else Color.LightGray
            )
        }
        IconButton(
                onClick = { updateActualPage(actualPage - 1) },
                modifier = Modifier.weight(1.5f),
                enabled = canClickPrevious
        ) {
            Icon(
                    Icons.Rounded.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = if (canClickPrevious) Color.White else Color.LightGray
            )
        }

        val page = if (actualPage < 9) "0${actualPage + 1}" else "${actualPage + 1}"
        val size = if (pageSize < 10) "0$pageSize" else "$pageSize"

        Row(
                modifier = Modifier.weight(4f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
        ){
            Text(
                    "page $page sur $size" ,
                    color = Color.White,
                    style = MaterialTheme.typography.body1
            )
        }

        IconButton(
                onClick = { updateActualPage(actualPage + 1) },
                modifier = Modifier.weight(1.5f),
                enabled = canClickNext
        ) {
            Icon(
                    Icons.Rounded.KeyboardArrowRight,
                    contentDescription = null,
                    tint = if (canClickNext) Color.White else Color.LightGray
            )
        }
        IconButton(
                onClick = { updateActualPage(pageSize - 1) },
                modifier = Modifier.weight(1.5f),
                enabled = canClickNext
        ) {
            Icon(
                    Icons.Rounded.SkipNext,
                    contentDescription = null,
                    tint = if (canClickNext) Color.White else Color.LightGray
            )
        }
    }
}