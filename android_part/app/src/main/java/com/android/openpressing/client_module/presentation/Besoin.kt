package com.android.openpressing.client_module.presentation


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.openpressing.R
import com.android.openpressing.ui.theme.*


@Composable
fun Besoin(
    publier:Publication
){
    Column(
        horizontalAlignment=Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(2.dp)

    ) {
        Card(elevation = 8.dp,
            shape=RoundedCornerShape(15.dp),
            modifier= Modifier
                .fillMaxWidth()
                .padding(15.dp),

            )
        {
            Row(modifier=Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)){

                Row{
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier=Modifier.padding(12.dp)
                    ){
                        Image(
                            painter = painterResource(R.drawable.blank),
                            contentDescription = null,
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .border(1.5.dp, blanc, CircleShape)
                                .height(44.dp)
                        )
                    }
                    Column(modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth()
                        .weight(0.2f),

                        ) {
                        Text(
                            text = "Prix: ${publier.prix}",
                            color = black,
                            style = MaterialTheme.typography.body1.copy(
                                fontSize = 15.sp
                            )
                        )
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            ,
                            verticalArrangement = Arrangement.spacedBy(12.dp),

                            ) {
                            Text(
                                text ="Publier:${publier.publier}",
                                color=black,
                                style = MaterialTheme.typography.subtitle2.copy(
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 11.sp
                                )

                            )

                        }
                    }
                    Row(modifier = Modifier
                        .padding(20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        TabButton(

                        )
                    }
                }

            }

        }

    }


}


@Composable
fun TabButton(
    modifier: Modifier = Modifier
) {
    (Button(
        onClick = { /*TODO*/ },
        Modifier.size(85.dp, 30.dp)
    ) {
        Text(
            "Voir details",
            style = MaterialTheme.typography.subtitle1.copy(
                fontSize = 10.sp,
                color = blanc
            )
        )
    })
}
data class Publication(
    // val imageVector: ImageVector,
    val prix:Double,
    val publier:String)

@Composable
fun BesoinCard(publications: List<Publication>){
    LazyColumn{
        items(publications){
                publication -> Besoin(publication)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OpenPressingTheme {
        //Besoin(publier = Publication("publier le: 04/04/2023"))
        BesoinCard(publications = listOf(
            Publication(
                prix = 12.0,
                publier = "12/02/2023"),
            Publication(prix = 19.5,
                publier = "10/01/2022"),
            Publication(prix = 19.5,
                publier = "25/02/2020"),
            Publication(prix = 19.5,
                publier = "08/09/2021"),
            Publication(prix = 19.5,
                publier = "12/04/2020"),
            Publication(prix = 19.5,
                publier = "17/05/2022"),
            Publication(prix = 19.5,
                publier = "15/08/2022")
        ))

    }
}