package com.android.openpressing.pressing_module.requirement

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.android.openpressing.data.models.client.Client
import com.android.openpressing.data.models.laundry.Laundry
import com.android.openpressing.data.models.requirement.Requirement
import com.android.openpressing.data.models.requirement.RequirementData
import com.android.openpressing.data.models.requirement_detail.RequirementDetail
import com.android.openpressing.data.models.service.Service
import com.android.openpressing.data.models.user.User
import com.android.openpressing.ui.theme.primaryColor
import com.android.openpressing.ui.theme.primaryPrimeColor
import com.android.openpressing.ui.theme.secondaryPrimeColor
import com.android.openpressing.ui.theme.softPrimaryPrimeColor
import com.android.openpressing.utils.BASE_URL
import com.android.openpressing.viewmodels.client.ClientViewModel
import com.android.openpressing.viewmodels.client.state.ClientState
import com.android.openpressing.viewmodels.laundries.LaundryViewModel
import com.android.openpressing.viewmodels.promotion.PromotionViewModel
import com.android.openpressing.viewmodels.requirement.RequirementViewModel
import com.android.openpressing.viewmodels.requirement_detail.RequirementDetailViewModel
import com.android.openpressing.viewmodels.requirement_detail.state.RequirementDetailState
import com.android.openpressing.viewmodels.services.ServiceViewModel
import com.android.openpressing.viewmodels.services.state.LaundryState
import com.android.openpressing.viewmodels.services.state.RequirementState
import com.android.openpressing.viewmodels.services.state.ServicesStates
import com.android.openpressing.viewmodels.services.state.UserState
import com.android.openpressing.viewmodels.user.UserViewModel
//import com.android.openpressing.viewmodels.user.UserViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import java.util.*

data class Data(
    val username: String ,
    val date: Date ,
    val services: List<String>
)

val myDatas = listOf(
        Data(
                "Boris Temfack",
                Date(),
                listOf(
                        "Lavage à sec",
                        "Lavage à eau",
                        "Détachage",
                        "Amidonnage"
                )
        ),
        Data(
                "Ernest Donfack",
                Date(),
                listOf(
                        "Lavage à sec",
                        "Lavage à eau",
                        "Détachage",
                        "Amidonnage"
                )
        ),
        Data(
                "Valdez Kanouo",
                Date(),
                listOf(
                        "Lavage à sec",
                        "Lavage à eau",
                        "Détachage",
                        "Amidonnage"
                )
        ),
        Data(
                "Claudel Noumbissie",
                Date(),
                listOf(
                        "Lavage à sec",
                        "Lavage à eau",
                        "Détachage",
                        "Amidonnage"
                )
        ),
        Data(
                "Henry Kemadjou",
                Date(),
                listOf(
                        "Lavage à sec",
                        "Lavage à eau",
                        "Détachage",
                        "Amidonnage"
                )
        ),
        Data(
                "Nicolas Bogni",
                Date(),
                listOf(
                        "Lavage à sec",
                        "Lavage à eau",
                        "Détachage",
                        "Amidonnage"
                )
        ),
        Data(
                "Idriss Keni",
                Date(),
                listOf(
                        "Lavage à sec",
                        "Lavage à eau",
                        "Détachage",
                        "Amidonnage"
                )
        ),
        Data(
                "Celestin Kouetchou",
                Date(),
                listOf(
                        "Lavage à sec",
                        "Lavage à eau",
                        "Détachage",
                        "Amidonnage"
                )
        ),
        Data(
                "Loic Tatsalekeu",
                Date(),
                listOf(
                        "Lavage à sec",
                        "Lavage à eau",
                        "Détachage",
                        "Amidonnage"
                )
        )
)

@Composable
fun ClRequirementConsulting(
    state: RequirementState
) {

    var actualPage by remember { mutableStateOf(0) }
    var pageSize by remember { mutableStateOf(0) }

    Scaffold(
            topBar = { TopAppBar() } ,
            content = { innerPadding ->
                RequirementList(
                        innerPadding = innerPadding,
                        actualPage = actualPage,
                        updatePageSize = { pageSize = it },
                        state = state
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
fun TopAppBar() {
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
    state: RequirementState
) {

    when (state) {

        is RequirementState.Success -> {
            LazyColumn(
                    contentPadding = innerPadding
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

//                                Icon(
//                                        Icons.Rounded.Person ,
//                                        contentDescription = null ,
//                                        modifier = Modifier
//                                            .clip(CircleShape)
//                                            .background(Color.LightGray)
//                                            .size(48.dp)
//                                )

                                Image(
                                        rememberAsyncImagePainter(
                                                model = BASE_URL + fetchUser(
                                                        fetchClient(data.attributes.client.data.id!!)
                                                            !!.data.attributes.user.data.id!!
                                                )!!.profile_picture.attributes.formats.medium.url
                                        ),
                                       contentDescription = null,
                                        modifier = Modifier
                                            .clip(CircleShape)
                                            .size(48.dp),
                                        contentScale = ContentScale.Crop

                                )

                                Column(
                                        modifier = Modifier
                                            .weight(0.65f)
                                            .padding(8.dp) ,
                                        verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                            fetchUser(
                                                    fetchClient(data.attributes.client.data.id!!)
                                                    !!.data.attributes.user.data.id!!
                                            )!!.username ,
                                            style = MaterialTheme.typography.body1
                                    )
                                    Text(
                                            "${data.attributes.createdAt}",
                                            style = MaterialTheme.typography.overline
                                    )
                                }

                                IconButton(
                                        onClick = { isExpanded = !isExpanded } ,
                                        modifier = Modifier.weight(0.1f)
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

                                                val requirement_detail = fetchRequirementDetails(requirement_details.id!!)

                                                Row(
                                                        modifier = Modifier
                                                            .padding(end = 8.dp) ,
                                                        verticalAlignment = Alignment.CenterVertically ,
                                                        horizontalArrangement = Arrangement.Center
                                                ) {

                                                    val service = fetchService(requirement_detail!!.data.attributes.service.data.id!!)!!

                                                    Text(
                                                            "${service.data.attributes.type.data.attributes.title}  ${service.data.attributes.category.data.attributes.name}" ,
                                                            style = MaterialTheme.typography.body1 ,
                                                            modifier = Modifier
                                                                .clip(CircleShape)
                                                                .background(primaryPrimeColor)
                                                                .padding(4.dp)
                                                    )
                                                }
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
                                                .clickable { }
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

@Composable
private fun fetchUser(
    id: Int,
    userViewModel: UserViewModel = hiltViewModel()
) : User? {

    userViewModel.getById(id)
    return when(val state = userViewModel.userState.collectAsState().value) {

        is UserState.Success.UserSuccess -> state.data

        else -> null
    }
}

@Composable
private fun fetchClient(
    id: Int,
    clientViewModel: ClientViewModel = hiltViewModel()
) : Client? {

    clientViewModel.getById(id)
    return when(val state = clientViewModel.clientState.collectAsState().value) {

        is ClientState.Success.ClientSuccess -> state.data

        else -> null
    }
}

@Composable
private fun fetchRequirementDetails(
    id: Int,
    requirementDetailViewModel: RequirementDetailViewModel = hiltViewModel()
) : RequirementDetail? {

    requirementDetailViewModel.getById(id)
    return when(val state = requirementDetailViewModel.requirementDetailState.collectAsState().value) {

        is RequirementDetailState.Success -> state.requirementDetail

        else -> null
    }
}

@Composable
private fun fetchLaundry(
    id: Int,
    laundryViewModel: LaundryViewModel = hiltViewModel()
) : Laundry? {

    laundryViewModel.getById(id)
    return when(val state = laundryViewModel.laundryState.collectAsState().value) {

        is LaundryState.Success.LaundrySuccess -> state.data

        else -> null
    }
}

@Composable
private fun fetchService(
    id: Int,
    serviceViewModel: ServiceViewModel = hiltViewModel()
) : Service? {

    serviceViewModel.getById(id)
    return when(val state = serviceViewModel.serviceState.collectAsState().value) {

        is ServicesStates.Success.ServiceSuccess -> state.data

        else -> null
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
        IconButton(
                onClick = { updateActualPage(0) },
                modifier = Modifier.weight(1.5f),
                enabled = actualPage != 0
        ) {
            Icon(
                    Icons.Rounded.SkipPrevious,
                    contentDescription = null,
                    tint = Color.White
            )
        }
        IconButton(
                onClick = { updateActualPage(actualPage + 1) },
                modifier = Modifier.weight(1.5f),
                enabled = actualPage != 0
        ) {
            Icon(
                    Icons.Rounded.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = Color.White
            )
        }

        val page = if (actualPage <= 9) "0${actualPage + 1}" else "${actualPage + 1}"
        val size = if (pageSize <= 9) "0${pageSize + 1}" else "${pageSize + 1}"

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
                onClick = { updateActualPage(actualPage - 1) },
                modifier = Modifier.weight(1.5f),
                enabled = actualPage != pageSize
        ) {
            Icon(
                    Icons.Rounded.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.White
            )
        }
        IconButton(
                onClick = { updateActualPage(pageSize) },
                modifier = Modifier.weight(1.5f),
                enabled = actualPage != pageSize
        ) {
            Icon(
                    Icons.Rounded.SkipNext,
                    contentDescription = null,
                    tint = Color.White
            )
        }
    }
}