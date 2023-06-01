package com.android.openpressing.client_module.presentation.besoin.component


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.android.openpressing.data.models.service.ServiceData
import com.android.openpressing.ui.theme.Purple200
import com.android.openpressing.utils.BASE_URL
import com.android.openpressing.viewmodels.services.ServiceViewModel
import com.android.openpressing.viewmodels.services.state.ServicesStates

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChooseServicesScreen(

    updateDialogState: (Boolean) -> Unit,
    Services:List<ServiceData>,
    updateservice: (List<ServiceData>) -> Unit,
    state: ServicesStates,
    viewModel: ServiceViewModel= hiltViewModel()



) {
    val addedServices = Services.toMutableList()

    val allServices = mutableListOf<ServiceData>()
    when(state) {
        is ServicesStates.Success.ServicesSuccess -> {

            viewModel.getAll()


           var  services= state.data
            services.forEach { allServices.add(ServiceData(it.id,it.attributes)) }

            AlertDialog(
                onDismissRequest = { updateDialogState(false) },
                text = {
                    LazyColumn {

                        stickyHeader {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.White),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Select service(s)",
                                    style = MaterialTheme.typography.h5.copy(
                                        fontSize = 22.sp
                                    ),
                                    color = Purple200
                                )
                            }
                        }

                        items(allServices) { ServiceData ->

                            var isChecked by remember { mutableStateOf(false) }
                            val enabled by remember { mutableStateOf(!Services.contains(ServiceData)) }

                            Row(
                                Modifier
                                    .padding(
                                        horizontal = 4.dp,
                                        vertical = 8.dp
                                    )
                                    .clickable(
                                        enabled = enabled,
                                        onClick = {

                                            if (!isChecked) {
                                                addedServices.add(ServiceData)
                                            } else {
                                                addedServices.remove(ServiceData)
                                            }
                                            isChecked = !isChecked
                                        }
                                    ),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                            ) {
                                ServiceData.attributes.serviceImage?.let {
                                    Image(
                                        rememberAsyncImagePainter(
                                            model = BASE_URL+ServiceData.attributes.serviceImage
                                                .attributes.url
                                        )
                                        ,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(48.dp)
                                            .weight(0.2f),
                                    )
                                }

                                Text(
                                    text = ServiceData.attributes.type.data.attributes.title+ " "+ServiceData.attributes.category.data.attributes.name,
                                    modifier = Modifier
                                        .weight(0.6f),
                                    style = if (enabled) MaterialTheme.typography.body1
                                    else MaterialTheme.typography.body1.copy(fontStyle = FontStyle.Italic),
                                    color = if (enabled) Color.Black
                                    else Color.LightGray
                                )

                                if (isChecked) {

                                    Icon(
                                        Icons.Rounded.Check,
                                        contentDescription = null,
                                        tint = Purple200,
                                        modifier = Modifier
                                            .weight(0.2f)
                                    )
                                }
                            }
                        }

                    }
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            updateservice(addedServices.toList())
                            updateDialogState(false)
                        },
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = Purple200
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
                            contentColor = Purple200
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
        else ->{}


    }
}