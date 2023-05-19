package com.android.openpressing.client_module.presentation.besoin

import android.annotation.SuppressLint
import android.app.Notification.MessagingStyle.Message
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
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.android.openpressing.R
import com.android.openpressing.ui.theme.Purple500
import java.util.Date

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun MyNeed(){
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 10.dp,
                modifier = Modifier
                    .fillMaxWidth(),
                title = {
                    Text("Mes Besoins")
                },
                backgroundColor = MaterialTheme.colors.primarySurface,
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.ArrowBack, null)

                    }
                },
                actions = {
                    Row {
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            )},
        content= {
                innerPadding-> stock(contenu= listOf(
            Contenu(
                Description = "5 Vetements",
                prix = "1500 FCFA",
                date = "publié le 22/03/2023"
            ),
            Contenu(
                Description = "10 vetements",
                prix = "1000 FCFA",
                date = "publié le 15/03/2023"

            ),
            Contenu(
                Description = "12 Vetements",
                prix = "3100 FCFA",
                date = "publié le 15/03/2023"

            ),
            Contenu(
                Description = "15 Vetements",
                prix= "4000",
                date = " publié le 15/05/2023"
            ),
            Contenu(
                Description = "20 Vetements",
                prix= "4000",
                date = " publié le 15/05/2023"
            ),
            Contenu(
                Description = "18 Vetements",
                prix= "4000",
                date = " publié le 15/05/2023"
            ),
            Contenu(
                Description = "15 Vetements",
                prix= "4000",
                date = " publié le 15/05/2023"
            ),
            Contenu(
                Description = "15 Vetements",
                prix= "4000",
                date = " publié le 15/05/2023"
            ),
            Contenu(
                Description = "15 Vetements",
                prix= "4000",
                date = " publié le 15/05/2023"
            ),
            Contenu(
                Description = "15 Vetements",
                prix= "4000",
                date = " publié le 15/05/2023"
            ),
            Contenu(
                Description = "15 Vetements",
                prix= "4000",
                date = " publié le 15/05/2023"

            ),
            Contenu(
                Description = "15 Vetements",
                prix= "4000",
                date = " publié le 15/05/2023"
            ),
            Contenu(
                Description = "15 Vetements",
                prix= "4000",
                date = " publié le 15/05/2023"
            ),
            Contenu(
                Description = "15 Vetements",
                prix= "4000",
                date = " publié le 15/05/2023"
            ),
            Contenu(
                Description = "15 Vetements",
                prix= "4000",
                date = " publié le 15/05/2023"
            )
        ),
            innerPadding = innerPadding
        )


        },
        bottomBar= {BottomBar()}
    )}




data class Contenu(
    val Description: String,
    val prix: String,
    val date: String,
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun stock(contenu: List<Contenu>,
          innerPadding: PaddingValues){
    LazyColumn(contentPadding = innerPadding) {
        items(contenu) {
            Consult(it)
        }
    }

}
@Composable
fun BottomBar() {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 2.dp,
        backgroundColor = Color.White
    ) {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.LocalLaundryService, "", tint = Purple500)
        },
            label = { Text(text = "Laundry") },
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
            })
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Reorder, "")
        },
            label = { Text(text = "Order") },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Chat, "")
        },
            label = { Text(text = "Chat") },
            selected = (selectedIndex.value == 2),
            onClick = {
                selectedIndex.value = 2
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Person, "")
        },
            label = { Text(text = "Profile") },
            selected = (selectedIndex.value == 3),
            onClick = {
                selectedIndex.value = 3
            })
    }
}

@Composable
fun Consult(affiche: Contenu) {
    Card(
        elevation = 3.dp,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(3.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Spacer(modifier = Modifier.width(16.dp))
            Column(

            ) {
                Text(
                    text = affiche.Description,
                    color = Color.Black,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(height = 24.dp))
                Text(
                    text = affiche.prix,
                    color = Color.Gray,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(height = 24.dp))
                Text(
                    text = affiche.date,
                    color = Color.Gray,
                    fontSize = 16.sp
                )

            }
            Spacer(modifier = Modifier.width(40.dp))
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(200.dp)
                        .padding(8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primarySurface),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Consulter")
                }
            }
        }
    }
}

