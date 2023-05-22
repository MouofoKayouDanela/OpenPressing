package com.android.openpressing.client_module.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.openpressing.R
import com.android.openpressing.ui.theme.OpenPressingTheme
import com.android.openpressing.ui.theme.Purple500
import com.android.openpressing.ui.theme.black
import com.android.openpressing.ui.theme.blanc

data class PublicationBesoin(
    val imageVector: Painter,
    val nom:String,
    val datePub:String,
    val prix:Double)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BesoinPressing(
    PublicationBesoin: List<PublicationBesoin>
){
    LazyColumn{
        stickyHeader{
            TopBarApp()
        }
        items(PublicationBesoin){
            CardBesoinPressing(it)
        }

    }
}
@Composable
fun TopBarApp(){
    Box{
        Row(
            Modifier
                .fillMaxWidth()
                .background(Purple500)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Rounded.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp, 32.dp)
                )
            }
            // Spacer(Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .padding(10.dp),
                //horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Consulter les differents besoins",
                    style = MaterialTheme.typography.body1.copy(
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp
                    )
                )
            }

        }
    }

}
@Composable
fun CardBesoinPressing(PublicationBesoin : PublicationBesoin){
    Card(
        elevation = 3.dp,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ){
        Column() {
            Row(){
                Image(
                    painter = PublicationBesoin.imageVector,
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, blanc, CircleShape)
                        .height(84.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth()
                        .weight(0.8f),
                ) {
                    Text(
                        modifier=Modifier.padding(3.dp),
                        text = PublicationBesoin.nom,
                        color = black,
                        style = MaterialTheme.typography.body1.copy(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        modifier=Modifier.padding(3.dp),
                        text = "Date de publication:${PublicationBesoin.datePub}",
                        color = black,
                        style = MaterialTheme.typography.body1.copy(
                            fontSize = 15.sp
                        )
                    )
                    Text(
                        modifier=Modifier.padding(3.dp),
                        text = "Prix:${PublicationBesoin.prix}",
                        color = black,
                        style = MaterialTheme.typography.body1.copy(
                            fontSize = 15.sp
                        )
                    )
                }
            }
            Row(

                verticalAlignment=Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(50.dp),
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier=Modifier.width(150.dp)
                        .padding(horizontal = 12.dp)

                ) {
                    Text(
                        "Envoi message",
                        style = MaterialTheme.typography.subtitle1.copy(
                            fontSize = 12.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    )
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier=Modifier.width(150.dp)
                        .padding(horizontal = 12.dp)
                ) {
                    Text(
                        "Voir details",
                        style = MaterialTheme.typography.subtitle1.copy(
                            fontSize = 12.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    OpenPressingTheme {
        TopBarApp()
        BesoinPressing(PublicationBesoin = listOf(
            PublicationBesoin(
                imageVector = painterResource(R.drawable.ele4),
                nom= "Danela Mouofo",
                datePub = "12/02/2020",
                prix = 1500.0
            ),
            PublicationBesoin(
                imageVector = painterResource(R.drawable.ele4),
                nom= "Tedongmo Valdez",
                datePub = "12/02/2020",
                prix = 1500.0
            ),
            PublicationBesoin(
                imageVector = painterResource(R.drawable.ele4),
                nom= "Nikiledji Aurore",
                datePub = "12/02/2020",
                prix = 1500.0
            ),
            PublicationBesoin(
                imageVector = painterResource(R.drawable.ele4),
                nom= "Kengni Johan",
                datePub = "12/02/2020",
                prix = 1500.0
            ),
            PublicationBesoin(
                imageVector = painterResource(R.drawable.ele4),
                nom= "Fossa maxime",
                datePub = "12/02/2020",
                prix = 1500.0
            ),
        )
        )
    }
}