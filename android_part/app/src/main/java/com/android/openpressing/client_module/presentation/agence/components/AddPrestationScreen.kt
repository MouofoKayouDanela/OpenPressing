package com.android.openpressing.client_module.presentation.agence.components

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
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.android.openpressing.data.models.laundry.LaundryData
import com.android.openpressing.data.models.service.ServiceData
import com.android.openpressing.data.models.utils.service_n_laundry.IntermediaryData
import com.android.openpressing.ui.theme.primaryColor
import com.android.openpressing.ui.theme.thirdPrimeColor
import com.android.openpressing.utils.BASE_URL
import com.android.openpressing.viewmodels.laundries.LaundryViewModel
import com.android.openpressing.viewmodels.services.ServiceViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AddPrestationScreen(
    selectedIndex: Int ,
    updateDialogState: (Boolean) -> Unit ,
    datas: List<IntermediaryData> ,
    updateData: (List<IntermediaryData>) -> Unit ,
    laundryViewModel: LaundryViewModel = hiltViewModel() ,
    serviceViewModel: ServiceViewModel = hiltViewModel()
) {

   val addedDatas = mutableListOf<IntermediaryData>()

    val rememberDatas = remember{ mutableStateOf<List<IntermediaryData>?>(null) }
    val allDataKey = "allDatas"
    val allServices = remember(allDataKey) { mutableStateOf<List<ServiceData>?>(null)}
    val allLaundries = remember(allDataKey) { mutableStateOf<List<LaundryData>?>(null) }
    LaunchedEffect(key1 = allDataKey) {
        val allDatas = mutableListOf<IntermediaryData>()
        if (selectedIndex == 0) {
            allDatas.clear()
            serviceViewModel.findAll()
                .flowOn(Dispatchers.IO)
                .collect{
                    allServices.value = it
                }
            if(allServices.value != null) {
                allServices.value!!.forEach {
                    allDatas.add(
                            IntermediaryData(
                                    id = it.id!!,
                                    idType = it.attributes.type.data.id!!,
                                    idCategory = it.attributes.category.data.id!!,
                                    title = it.attributes.type.data.attributes.title + " " +
                                                it.attributes.category.data.attributes.name,
                                    imageUrl = it.attributes.serviceImage.data.attributes.url
                            )
                    )
                }
                rememberDatas.value = allDatas
            }
        } else {
            allDatas.clear()
            laundryViewModel.findAll()
                .flowOn(Dispatchers.IO)
                .collect{
                    allLaundries.value = it
                }
            allLaundries.value!!.forEach {
                allDatas.add(
                        IntermediaryData(
                                id = it.id!!,
                                idType = it.attributes.type.data.id!!,
                                idCategory = it.attributes.category.data.id!!,
                                title = it.attributes.type.data.attributes.title + " " +
                                        it.attributes.category.data.attributes.name,
                                imageUrl = it.attributes.laundryImage.data.attributes.url
                        )
                )
            }
            rememberDatas.value = allDatas
        }
    }
    /*if (selectedIndex == 0)
        services.forEach { allDatas.add(Data(it.name, it.icon)) }
    else
        laundries.forEach { allDatas.add(Data(it.name, it.icon)) }*/
    var actualPage by remember { mutableStateOf(0) }
    var pageSize by remember { mutableStateOf(0) }
    var dataTitle by remember { mutableStateOf(listOf<String>()) }
    AlertDialog(
            onDismissRequest = { updateDialogState(false) },
            text = {
                LazyColumn {

                    stickyHeader {
                        Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.White)
                                    .padding(vertical = 8.dp)
                        ){
                            Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically ,
                                    horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                        text = "Select ${if (selectedIndex == 0) "service(s)" else "laundry(ies)"}" ,
                                        style = MaterialTheme.typography.h5.copy(
                                                fontSize = 22.sp
                                        ) ,
                                        color = primaryColor
                                )
                            }

                            Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically ,
                                    horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                IconButton(
                                        onClick = { actualPage-- },
                                        enabled = actualPage != 0
                                ) {
                                    Icon(
                                            Icons.Default.KeyboardArrowLeft ,
                                            contentDescription = null,
                                            modifier = Modifier.size(32.dp)
                                    )
                                }
                                IconButton(
                                        onClick = { actualPage++ },
                                        enabled = actualPage != pageSize - 1
                                ) {
                                    Icon(
                                            Icons.Default.KeyboardArrowRight ,
                                            contentDescription = null,
                                            modifier = Modifier.size(32.dp)
                                    )
                                }
                            }
                        }
                    }

                    if(rememberDatas.value != null) {

                        items(fetchData(
                                actualPage = actualPage,
                                datas = rememberDatas.value!!,
                                getPageSize = { pageSize = it }
                        )) { data ->

                            var isChecked = dataTitle.contains(data.title)
                            val enabled = !datas.contains(data)

                            Row(
                                    Modifier
                                        .padding(
                                                horizontal = 4.dp ,
                                                vertical = 8.dp
                                        )
                                        .clickable(
                                                enabled = enabled ,
                                                onClick = {

                                                    dataTitle = if (!isChecked) {
                                                        addedDatas.add(data)
                                                        val titleData = dataTitle.toMutableList()
                                                        titleData.add(data.title)
                                                        titleData.toList()
                                                    } else {
                                                        addedDatas.remove(data)
                                                        val titleData = dataTitle.toMutableList()
                                                        titleData.remove(data.title)
                                                        titleData.toList()
                                                    }
                                                    isChecked = !isChecked
                                                }
                                        ) ,
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
                                            .size(56.dp),
                                        contentScale = ContentScale.Crop
                                )

                                Text(
                                        text = data.title ,
                                        modifier = Modifier
                                            .weight(0.6f)
                                            .padding(
                                                    start = 16.dp
                                            ) ,
                                        style = if (enabled) MaterialTheme.typography.body1
                                        else MaterialTheme.typography.body1.copy(fontStyle = FontStyle.Italic) ,
                                        color = if (enabled) Color.Black
                                        else Color.LightGray
                                )

                                if (isChecked) {

                                    Icon(
                                            Icons.Rounded.Check ,
                                            contentDescription = null ,
                                            tint = thirdPrimeColor ,
                                            modifier = Modifier
                                                .weight(0.2f)
                                    )
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(
                        onClick = {
                            updateData(addedDatas.toList())
                            updateDialogState(false)
                        },
                        colors = ButtonDefaults.textButtonColors(
                                contentColor = primaryColor
                        )
                ) {
                    Text(
                            text = "Add"
                    )
                }
            },
            dismissButton = {
                TextButton(
                        onClick = {
                            updateDialogState(false)
                        },
                        colors = ButtonDefaults.textButtonColors(
                                contentColor = primaryColor
                        )
                ) {
                    Text(
                            text = "Cancel"
                    )
                }
            },
            modifier = Modifier
                .height(400.dp),
            shape = RoundedCornerShape(10)
    )
}

private fun fetchData(
    actualPage: Int ,
    datas: List<IntermediaryData> ,
    getPageSize : (Int) -> Unit
) : List<IntermediaryData> {

    getPageSize((datas.size + 2) / 3)

    return datas.subList(
            actualPage * 3,
            minOf(
                    (actualPage + 1) * 3,
                    datas.size
            )
    )

}