package com.android.openpressing.client_module.presentation.agence

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.android.openpressing.data.models.agency.AgencyData
import com.android.openpressing.data.models.owner.OwnerData
import com.android.openpressing.data.models.pressing.PressingData
import com.android.openpressing.ui.theme.primaryColor
import com.android.openpressing.ui.theme.primaryPrimeColor
import com.android.openpressing.utils.Screen
import com.android.openpressing.viewmodels.agency.AgencyViewModel
import com.android.openpressing.viewmodels.owner.OwnerViewModel
import com.android.openpressing.viewmodels.pressing.PressingViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AgencyList(
    navController: NavController ,
    ownerViewModel: OwnerViewModel = hiltViewModel() ,
    pressingViewModel: PressingViewModel = hiltViewModel()
) {
    val userId = 2
    val owner = remember(userId) { mutableStateOf<OwnerData?>(null) }
    LaunchedEffect(key1 = userId) {
        ownerViewModel.fineAll()
            .flowOn(Dispatchers.IO)
            .collect { keptOwners ->
                owner.value = keptOwners.find { userId == it.attributes.user.data.id!! }
            }
    }
    val pressing = remember(userId) { mutableStateOf<PressingData?>(null) }
    if(owner.value != null){
        LaunchedEffect(key1 = owner.value!!.id) {
            pressingViewModel.findAll()
                .flowOn(Dispatchers.IO)
                .collect { keptPressings ->
                    pressing.value = keptPressings.find {
                        owner.value!!.id == it.attributes.owner.data.id
                    }
                }
        }
    }

    Scaffold(
            topBar = {
                TopAppBar(
                     navController = navController
                )
            },

            content = {
                if(pressing.value != null){
                    ContentList(
                           pressingId = pressing.value!!.id!!,
                           navController = navController
                    )
                }
            },

            bottomBar = {

            }
    )

}

@Composable
private fun TopAppBar(
    navController: NavController
) {
    Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(primaryColor)
                .padding(
                        horizontal = 16.dp ,
                        vertical = 8.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
    ) {

        IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.weight(0.1f)
        ) {
            Icon(
                    Icons.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
            )
        }

        Text(
                "Pressing Agency",
                style = MaterialTheme.typography.h6.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Normal
                ),
                modifier = Modifier.weight(0.8f)
        )

    }
}

@Composable
private fun ContentList(
    pressingId: Int,
    navController: NavController,
    viewModel: AgencyViewModel = hiltViewModel()
) {
    val agencies = remember(pressingId) { mutableStateOf<List<AgencyData>?>(null) }
    LaunchedEffect(key1 = pressingId) {
        viewModel.findAll()
            .flowOn(Dispatchers.IO)
            .collect{ keptAgencies ->
                agencies.value = keptAgencies.filter {
                    pressingId == it.attributes.pressing.data.id!!
                }
            }
    }

    LazyColumn {
        if(agencies.value != null) {
            items(agencies.value!!){ agency ->

                Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                Log.i("", "${agency.id}")
                                navController.navigate("${Screen.AgencyOption.road}/${agency.id!!}")
                            }
                            .padding(
                                    vertical = 8.dp ,
                                    horizontal = 16.dp
                            )
                ){
                    Text(
                            agency.attributes.quarter.data.attributes.name,
                            style = MaterialTheme.typography.h6.copy(
                                    fontWeight = FontWeight.Normal,
                            )
                    )
                }

                Divider(
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }

}