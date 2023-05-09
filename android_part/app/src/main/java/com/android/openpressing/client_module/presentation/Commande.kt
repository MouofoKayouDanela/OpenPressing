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
import androidx.navigation.NavHostController
import com.android.openpressing.R
import com.android.openpressing.ui.theme.OpenPressingTheme
import com.android.openpressing.ui.theme.black
import com.android.openpressing.ui.theme.blanc


@Composable
fun commandeBox( Commande: Commande) {

    Card(
        elevation = 3.dp,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp),
        )
    {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement=Arrangement.SpaceAround,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Image(
                        painter = Commande.imageVector,
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .border(1.5.dp, blanc, CircleShape)
                            .height(84.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth()
                        .weight(0.8f),
                    ) {
                    Text(

                        text = Commande.nomAgence,
                        color = black,
                        style = MaterialTheme.typography.body1.copy(
                            fontSize = 15.sp
                        )
                    )
                    Text(
                        modifier=Modifier.padding(3.dp),
                        text = "Date: ${Commande.dateCmd}",
                        color = black,
                        style = MaterialTheme.typography.body1.copy(
                            fontSize = 12.sp
                        )
                    )
                    Text(
                        modifier=Modifier.padding(3.dp),
                        text = "Prix:${Commande.prix}",
                        color = black,
                        style = MaterialTheme.typography.subtitle2.copy(
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp
                        )
                    )
                }
                Row(
                    modifier = Modifier
                        //.weight(0.2f)
                        .size(100.dp),
                        verticalAlignment=Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier=Modifier.width(170.dp)
                            .padding(horizontal = 12.dp)
                    ) {
                        Text(
                            "Details",
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


    data class Commande(
        val imageVector: Painter,
        val nomAgence: String,
        val prix: Double,
        val dateCmd: String
    )


    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun CommandeCard(
        Commande: List<Commande>,
    ) {
        LazyColumn(contentPadding = PaddingValues(vertical=8.dp)){
            stickyHeader {
                TopBarCmd()
            }
            items(Commande) {
                commandeBox(it)
            }

        }
    }


@Composable
fun TopBarCmd(modifier: Modifier = Modifier){
    Box{
        Row(
            Modifier
                .fillMaxWidth()
                .background(blanc)
                .padding(horizontal = 4.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp),

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
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Mes Commandes",
                    style = MaterialTheme.typography.body1.copy(
                        color = black,
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                )
            }

        }
    }

}



@Preview(showBackground = true)
@Composable
fun View() {
    OpenPressingTheme {
        CommandeCard( Commande = listOf(
            Commande(
                imageVector = painterResource(R.drawable.ele4),
                nomAgence = "Elegance Pressing",
                dateCmd = "12/02/2020",
                prix = 1500.0
            ),
            Commande(
                imageVector = painterResource(R.drawable.ele2),
                nomAgence = "Eco Pressing",
                dateCmd = "11/02/2020",
                prix = 4500.0
            ),
            Commande(
                imageVector = painterResource(R.drawable.ele1),
                nomAgence = "Blinding Pressing",
                dateCmd = "12/02/2023",
                prix = 15500.0
            ),
            Commande(
                imageVector = painterResource(R.drawable.ele4),
                nomAgence = "Saka Pressing",
                dateCmd = "12/08/2020",
                prix = 1800.0
            ),
            Commande(
                imageVector = painterResource(R.drawable.ele4),
                nomAgence = "Blood Pressing",
                dateCmd = "12/02/2019",
                prix = 3500.0
            ),
            Commande(
                imageVector = painterResource(R.drawable.ele3),
                nomAgence = "Blood Pressing",
                dateCmd = "12/02/2019",
                prix = 3500.0
            ),
            Commande(
                imageVector = painterResource(R.drawable.ele3),
                nomAgence = "Blood Pressing",
                dateCmd = "12/02/2019",
                prix = 3500.0
            ),
            Commande(
                imageVector = painterResource(R.drawable.ele3),
                nomAgence = "Blood Pressing",
                dateCmd = "12/02/2019",
                prix = 3500.0
            ),
            Commande(
                imageVector = painterResource(R.drawable.ele3),
                nomAgence = "Blood Pressing",
                dateCmd = "12/02/2019",
                prix = 3500.0
            ),
            Commande(
                imageVector = painterResource(R.drawable.ele3),
                nomAgence = "Blood Pressing",
                dateCmd = "12/02/2019",
                prix = 3500.0
            ),

        )
        )
    }
}


