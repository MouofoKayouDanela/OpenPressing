package com.android.openpressing.client_module.presentation.besoin



import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.android.openpressing.R
import com.android.openpressing.client_module.presentation.client.*
import com.android.openpressing.client_module.presentation.client.pressing
import com.android.openpressing.ui.theme.*
import com.android.openpressing.utils.Screen
import okhttp3.internal.http.HTTP_RESET_CONTENT
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols


data class pressing(
    val imageVector: Painter,
    val nom:String,
    val position:String,
    val nomLivraison:String
)

data class user(
    val name: String,
    val localisation: String
)
data class requirement(

    var requirement_details: requiremendetails,
    var client: user,
)

data class requiremendetails(

    var laundry: linge,
    var service: service,
    var quantity : Int,
    var unitPrice: Double,
    var name: String,
    var description: String,
)


data class service(
    val imageVector: Painter,
    val nom:String
)

data class linge(
    val imageVector: Painter,
    val nom:String
)


@Composable
fun AddRequirement(navController: NavHostController) {

    val scrollState = rememberLazyListState()
    Scaffold(
        topBar = { TopBar(navController = navController ) },

        content = { innerPadding ->
            ContentCard(
                services = listOf(
                    service(
                        imageVector = painterResource(R.drawable.pant),
                        nom = "nettoyage a eau"
                    ),
                    service(
                        imageVector = painterResource(R.drawable.pant),
                        nom = "nettoyage a eau"
                    ),
                    service(
                        imageVector = painterResource(R.drawable.pant),
                        nom = "nettoyage a eau"
                    ),
                    service(
                        imageVector = painterResource(R.drawable.pant),
                        nom = "nettoyage a eau"
                    ),
                    service(
                        imageVector = painterResource(R.drawable.pant),
                        nom = "nettoyage a eau"
                    ),
                    service(
                        imageVector = painterResource(R.drawable.pant),
                        nom = "nettoyage a eau"
                    ),
                ),
                scrollState, navController, innerPadding = innerPadding
            )
        },
        floatingActionButton ={
            FloatingActionButton(
                onClick = {navController .navigate( Screen.ListBesoin.road) },
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

    )








}

@Composable
fun  TopBar(navController: NavHostController)
   {
       TopAppBar(
           elevation =  AppBarDefaults.TopAppBarElevation,
           backgroundColor = Color.White,
           modifier = Modifier.padding(bottom = 18.dp)
       ) {
           Row(
               modifier = Modifier
                   .padding(start = 4.dp, top = 4.dp, end = 4.dp, bottom = 4.dp)
                   .fillMaxWidth(),
               verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = Arrangement.spacedBy(100.dp)
           )
           {

               IconButton(
                   onClick = { navController.navigate(Screen.ListOffer.road ) },
                   modifier = Modifier.size(32.dp, 32.dp)


               ) {
                   Image(imageVector = Icons.Default.ArrowBack, contentDescription ="" )
               }
               Text(
                   text = "General",
                   color = Color.DarkGray,
                   style= MaterialTheme.typography.h5,
                   modifier = Modifier.fillMaxWidth()
               )
           }
       }
  }

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Content( servicee: service){
   var  expandedState by remember { mutableStateOf( false) }

    Card(


        modifier = Modifier
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

            Row (horizontalArrangement = Arrangement.spacedBy(50.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)){


                Image(
                    painter = servicee.imageVector,
                    contentDescription = "image du service",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(35.dp)
                        .border(
                            width = 0.dp,
                            brush = Brush.horizontalGradient(listOf(Color.White, Color.LightGray )),
                            shape = CircleShape
                        )
                )

                Text(
                    text = servicee .nom,
                    color = Color.DarkGray,
                    style = MaterialTheme.typography.body1
                )
            }
            if (expandedState ){
                Column {
                    LaundryLines(LaundryTitle ="pantalon en soie" , LaundryImage = R.drawable.pant)
                    LaundryLines(LaundryTitle ="pantalon en soie" , LaundryImage = R.drawable.pant)
                    LaundryLines(LaundryTitle ="pantalon en soie" , LaundryImage = R.drawable.pant)
                    LaundryLines(LaundryTitle ="pantalon en soie" , LaundryImage = R.drawable.pant)
                }





            }
        }
    }

}





@Composable
fun LaundryLines(LaundryTitle:String,  @DrawableRes LaundryImage:Int ) {
    var value by remember {
        mutableStateOf(0)
    }
    var defaultPrice by remember { mutableStateOf(0) }
    val showDialog = remember { mutableStateOf(false) }
    var texte by remember { mutableStateOf("") }

    Column {


        Row(
            modifier = Modifier.padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                LaundryTitle,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(start = 10.dp, top = 15.dp, end = 25.dp)
                    .width(265.dp)
            )
            IconButton(
                onClick = { value++ },
                modifier = Modifier
                    .clip(CircleShape)
                    .background(color = Purple500)
                    .size(25.dp)
            ) {

                Image(painter = painterResource(id = R.drawable.plus), contentDescription = "plus")


            }
            Text(
                "$value",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
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
                    .size(25.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.minus),
                    contentDescription = "minus"
                )


            }


        }
        Row(
            modifier = Modifier.padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(
                "Prix unitaire (FCFA):",
                fontWeight = FontWeight.W300,
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .clickable {

                        showDialog.value = true
                    }
            )

            if (showDialog.value) {
                AlertDialog(

                    onDismissRequest = { showDialog.value = false },
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
                                showDialog.value = false
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
                                showDialog.value = false
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

                        showDialog.value = true
                    }
            )
        }
    }



        }
@Composable
fun ContentCard(services: List<service>, scrollState: LazyListState, navController: NavHostController, innerPadding: PaddingValues){

    LazyColumn(contentPadding =innerPadding, state = scrollState ){

        items(services){

            Content(it)
        }
    }






}










