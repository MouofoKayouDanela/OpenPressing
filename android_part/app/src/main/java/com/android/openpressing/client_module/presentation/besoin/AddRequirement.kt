package com.android.openpressing.client_module.presentation.besoin

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.openpressing.R
import com.android.openpressing.client_module.presentation.agence.BodyList
import com.android.openpressing.client_module.presentation.agence.TopNavBar
import com.android.openpressing.client_module.presentation.agence.utils.services
import com.android.openpressing.client_module.presentation.besoin.component.ChooseLaundryScreen
import com.android.openpressing.client_module.presentation.besoin.component.ChooseServicesScreen
import com.android.openpressing.client_module.presentation.besoin.component.uil.Data
import com.android.openpressing.client_module.presentation.besoin.component.uil.Laundry
import com.android.openpressing.client_module.presentation.besoin.component.uil.Service
import com.android.openpressing.ui.theme.Orange
import com.android.openpressing.ui.theme.Purple200
import com.android.openpressing.ui.theme.Purple500
import com.android.openpressing.ui.theme.blanc
import com.android.openpressing.utils.Screen
import com.android.openpressing.viewmodels.laundries.LaundryViewModel


@Preview
@Composable
fun AddRequirementScreen(){

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
        }

        Scaffold(
            topBar = {
               AppBar()
            },
            content = { innerPadding ->
                ContentCardlist(
                    innerPadding = innerPadding,
                    laundries = laundries,
                    services = services,
                    updateLaundryData = { laundries = it },
                    updateServiceData = { services = it }
                    )


    }
        )






}

@Composable
fun AppBar() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomEnd = 40.dp,
                    bottomStart = 40.dp
                )
            )
            .background(color = Purple500)
    ) {
        Column {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ){
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick ={ }, modifier = Modifier.padding(start = 8.dp)) {

                    Icon(
                        Icons.Rounded.ArrowBackIos,
                        contentDescription =null,
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))

                Text(text ="Besoin",
                modifier =  Modifier    .fillMaxWidth())
            }
        }
        }
    }



}
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
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

    var expandedState   by remember {mutableStateOf(false    ) }

    LazyColumn(contentPadding = innerPadding) {

        item { Spacer(modifier = Modifier.height(5.dp)) }


        stickyHeader {
            Row(
                modifier = Modifier
                    .padding(
                        horizontal = 4.dp,
                        vertical = 16.dp
                    )
                    .clickable { showAddDialog1 = !showAddDialog1 }
                    .background(    color = Color.White
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
                .padding(start = 12.dp, end = 12.dp, bottom = 8.dp)
                .animateContentSize(
                    animationSpec = tween(
                        delayMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ) ,
                onClick = {
                    expandedState = !expandedState

                },
                elevation =3.dp

            ) {
                Column(modifier =   Modifier.fillMaxWidth(),
                    verticalArrangement =Arrangement.SpaceBetween) {

                    Row(
                        Modifier
                            .padding(
                                horizontal = 4.dp,
                                vertical = 8.dp
                            )
                            .clickable {
                                expandedState = !expandedState
                            },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        data.icon?.let {
                            Icon(
                                it ,
                                contentDescription = null ,
                                modifier = Modifier
                                    .size(48.dp)
                                    .weight(0.2f)
                            )
                        }

                        Text(
                            text = data.name ,
                            modifier = Modifier
                                .weight(0.8f)
                        )

                }
                    if (expandedState ) {

                        Row(
                            modifier = Modifier
                                .padding(
                                    horizontal = 4.dp,
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
                                        horizontal = 4.dp,
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


                        }
                    }











                }
        }


    }

}
    }


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
}





