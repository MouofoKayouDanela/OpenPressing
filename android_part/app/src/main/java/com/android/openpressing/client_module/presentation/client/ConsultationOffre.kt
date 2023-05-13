package com.android.openpressing.client_module.presentation.client


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.android.openpressing.R
import com.android.openpressing.data.models.agency.Agency
import com.android.openpressing.ui.theme.Orange
import com.android.openpressing.ui.theme.Purple500
import com.android.openpressing.ui.theme.Vert
import com.android.openpressing.ui.theme.black
import com.android.openpressing.utils.Screen

data class pressing(
    val imageVector: Painter,
    val nom:String
)

data class user(
    val name: String,
    val localisation: String
)
data class offer(

    val servicee:service,
    val lingee:linge,
    val unitPrice:Int
)
data class agency(

    val pressing:pressing ,
    val location:String
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
fun AppTopBar(agency:agency, scrollState: LazyListState, navController: NavHostController) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(height = 110.dp, width = 180.dp) /////taille du box bleue/////
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomEnd = 20.dp,
                        bottomStart = 20.dp
                    )
                )//////forme arrondie de la box/////
                .background(color = Purple500)
            //shape=RoundedCornerShape(32.dp)
        ){
            Column() {
                /////Ligne de l'icone de notification/////
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween

                ){
                    IconButton(onClick = { navController.navigate(Screen.Home.road) }) {
                        Icon(
                            Icons.Rounded.NavigateBefore,
                            contentDescription = "stringResource(R.string.previewPage)",
                            tint = Color.White
                        )
                    }
                     IconButton(onClick = {navController.navigate( Screen.AddBesoin.road) }) {
                        Icon(
                            Icons.Rounded.ShoppingCart,
                            contentDescription = stringResource(R.string.notifications),
                            tint = Color.White
                        )
                    }


                }

                ////////////Image +nom//////////////
                Row(
                    modifier = Modifier
                        .padding( horizontal = 25.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = agency.pressing.imageVector,
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(50.dp)
                            .border(1.dp, color = Color.White, CircleShape)

                    )
                    //Spacer(Modifier.width(1.dp))
                    //////description du la photo////
                    Column(
                        verticalArrangement  =Arrangement.spacedBy(10.dp),
                        horizontalAlignment=Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding( horizontal = 25.dp)
                    ) {
                        Text(
                            text = agency.pressing.nom,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                        )
                        Spacer(Modifier.height(5.dp))
                        ////logo de location/////
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                "",
                                fontWeight = FontWeight.Normal,
                                fontSize = 11.sp,
                                color = Color.White,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                        }
                    }
                }
            }
        }
    }





@Composable
fun ContentCard(Offers: List<offer>,scrollState: LazyListState,navController: NavHostController, innerPadding: PaddingValues){
    
    LazyColumn(contentPadding = innerPadding, state = scrollState){

        items(Offers){
            OfferCard(it)
        }
    }

}

@Composable
fun OfferCard(offer: offer) {

    val scrollState = rememberLazyListState()

    Card(
        elevation = 10.dp,
        contentColor = black,
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .padding(15.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 5.dp),
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(50.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {


                Image(
                    painter = offer.servicee.imageVector,
                    contentDescription = "image du service",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(39.dp)
                       ,

                )

                Text(
                    text = offer.servicee.nom,
                    color = Color.DarkGray,
                    style = MaterialTheme.typography.h6                                                                 
                )


            }
            Laundryline( offer = offer(
                servicee = service(
                    imageVector = painterResource(R.drawable.pant),
                    nom = "nettoyage a eau"
                ),
                lingee = linge(
                    imageVector = painterResource(R.drawable.pant),
                    nom = "jupe en soie"
                ),
                unitPrice = 1000
            ),
            )
            Laundryline( offer = offer(
                servicee = service(
                    imageVector = painterResource(R.drawable.pant),
                    nom = "nettoyage a eau"
                ),
                lingee = linge(
                    imageVector = painterResource(R.drawable.chaussurejersey    ),
                    nom = "chaussure en soie"
                ),
                unitPrice = 1000
            ),
            )
            Laundryline( offer = offer(
                servicee = service(
                    imageVector = painterResource(R.drawable.pant),
                    nom = "nettoyage a eau"
                ),
                lingee = linge(
                    imageVector = painterResource(R.drawable.chaussurejersey),
                    nom = "robe en soie"
                ),
                unitPrice = 1000
            ),
            )
            Laundryline( offer = offer(
                servicee = service(
                    imageVector = painterResource(R.drawable.pant),
                    nom = "nettoyage a eau"
                ),
                lingee = linge(
                    imageVector = painterResource(R.drawable.chaussurejersey),
                    nom = "chaussure en jersey"
                ),
                unitPrice = 1000
            ),
            )
            Laundryline( offer = offer(
                servicee = service(
                    imageVector = painterResource(R.drawable.pant),
                    nom = "nettoyage a eau"
                ),
                lingee = linge(
                    imageVector = painterResource(R.drawable.chaussurejersey    ),
                    nom = "chaussure en jean"
                ),
                unitPrice = 1000
            ),
            )



        }

        }


        }





@Composable
fun Laundryline(offer: offer) {

    Row(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = offer.lingee.imageVector,
            contentDescription = "image du service",
            modifier = Modifier
                .clip(CircleShape)
                .size(30.dp)
                .padding(start = 5.dp)
            ,

            )


        Text(
            text = offer.lingee.nom +"(FCFA)",
            color = Color.DarkGray,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(end = 5.dp)

        )

        Text(
            text =offer.unitPrice.toString() ,
            color = Color.DarkGray,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.width(75.dp)

        )




    }

}



@Composable
fun OfferScreen(navController: NavHostController){

    val scrollState = rememberLazyListState()
     Scaffold(
         topBar = {AppTopBar(agency = agency(pressing = pressing(imageVector =  painterResource(R.drawable.ele1 ), nom = "Elegance Pressing",)    , location = "NDogbon"), scrollState, navController)},

         content = { innerPadding ->
             ContentCard(Offers= listOf (
             offer(
                 servicee = service(
                     imageVector = painterResource(R.drawable.pant),
                     nom = "nettoyage a eau"
                 ),
                 lingee = linge(
                     imageVector = painterResource(R.drawable.pant),
                     nom = "chaussure en soie"
                 ),
                 unitPrice = 1000
             ),
             offer(
                 servicee = service(
                     imageVector = painterResource(R.drawable.pant),
                     nom = "nettoyage a sec"
                 ),
                 lingee = linge(
                     imageVector = painterResource(R.drawable.pant),
                     nom = "veste en soie"
                 ),
                 unitPrice = 700
             ),
             offer(
                 servicee = service(
                     imageVector = painterResource(R.drawable.pant),
                     nom = "nettoyage a sec"
                 ),
                 lingee = linge(
                     imageVector = painterResource(R.drawable.pant),
                     nom = "robe en soie"
                 ),
                 unitPrice = 1000
             ),
             offer(
                 servicee = service(
                     imageVector = painterResource(R.drawable.pant),
                     nom = "nettoyage a sec"
                 ),
                 lingee = linge(
                     imageVector = painterResource(R.drawable.pant),
                     nom = "blouson en soie"
                 ),
                 unitPrice = 1700
             ),
             offer(
                 servicee = service(
                     imageVector = painterResource(R.drawable.pant),
                     nom = "retouche simple"
                 ),
                 lingee = linge(
                     imageVector = painterResource(R.drawable.pant),
                     nom = "pantalon jean"
                 ),
                 unitPrice = 500
             )

         ),
             scrollState,navController, innerPadding = innerPadding )
         },

     )





}
