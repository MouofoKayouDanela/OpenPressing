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
import com.android.openpressing.client_module.presentation.besoin.component.uil.Laundry
import com.android.openpressing.client_module.presentation.besoin.component.uil.Service
import com.android.openpressing.ui.theme.*
import com.android.openpressing.utils.Screen
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavHostController
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

@Composable
fun AddRequirementScreen(navController: NavHostController){

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
               AppBar(navController)
            },
            content = { innerPadding ->
                ContentCardlist(
                    innerPadding = innerPadding,
                    laundries = laundries,
                    services = services,
                    updateLaundryData = { laundries = it },
                    updateServiceData = { services = it }
                    )
    },
            bottomBar ={
              Row(modifier = Modifier
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
                }

            },
            floatingActionButtonPosition = FabPosition.Center,
            backgroundColor = Color.White


        )






}

@Composable
fun AppBar(navController: NavHostController,) {

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
                IconButton(onClick ={
                     navController.navigate(Screen.Home.road)
                }, modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(0.2f)) {

                    Icon(
                        Icons.Rounded.ArrowBackIos,
                        contentDescription =null,
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))

                Text(text ="Besoin",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.8f),
                    color = Color.White,


                )

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
                        horizontal = 4.dp,
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
                .padding(start = 12.dp, end = 12.dp, bottom = 8.dp)
                .animateContentSize(
                    animationSpec = tween(
                        delayMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                )
                .border(
                    width = 1.dp,
                    color = Orange,
                    shape = RoundedCornerShape(
                        topEnd = 10.dp,
                        topStart = 10.dp,
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp
                    )
                )
                .background(color = thirdColor)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onDoubleTap = {
                            Toast
                                .makeText(context, "xcjsjej gj", Toast.LENGTH_SHORT)
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
                                horizontal = 4.dp,
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
                            modifier = Modifier.weight(0.4f).padding(end=8.dp)


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
                            Row(
                                modifier = Modifier.padding(5.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    "Prix unitaire (FCFA):",
                                    fontWeight = FontWeight.W300,
                                    modifier = Modifier
                                        .padding(start = 8.dp, end = 8.dp)
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
                                        .padding(start = 8.dp, end = 8.dp)
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
}

@SuppressLint("SuspiciousIndentation")
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





