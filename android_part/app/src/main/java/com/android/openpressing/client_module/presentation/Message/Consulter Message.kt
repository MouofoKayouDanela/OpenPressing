package com.android.openpressing.client_module.presentation.Message

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
fun MySMS(){
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 10.dp,
                modifier = Modifier
                    .fillMaxWidth(),
                title = {
                    Text("Chat")
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
                        IconButton(onClick = {/*TODO*/}){
                            Icon(Icons.Filled.Notifications, contentDescription = "Notifications")
                        }
                    }
                }
            )},
        content= {
            innerPadding-> stock(Msg= listOf(
            Msg(
                imageVector = painterResource(R.drawable.ele),
                NomAgence = "Elegance Pressing",
                titre = "Avez-vous besoin d'un pressing",
                date = "15:21",
                img = Icons.Rounded.Delete
            ),
            Msg(
                imageVector = painterResource(R.drawable.ele),
                NomAgence = "Elegance Pressing",
                titre = "Avez-vous besoin d'un pressing",
                date = "15:21",
                img = Icons.Rounded.Delete
            ),
            Msg(
                imageVector = painterResource(R.drawable.ele),
                NomAgence = "Elegance Pressing",
                titre = "Avez-vous besoin d'un pressing",
                date = "15:21",
                img = Icons.Rounded.Delete
            ),
            Msg(
                imageVector = painterResource(R.drawable.ele),
                NomAgence = "Elegance Pressing",
                titre = "Avez-vous besoin d'un pressing",
                date = "15:21",
                img = Icons.Rounded.Delete
            ),
            Msg(
                imageVector = painterResource(R.drawable.ele),
                NomAgence = "Elegance Pressing",
                titre = "Avez-vous besoin d'un pressing",
                date = "15:21",
                img = Icons.Rounded.Delete
            ),
            Msg(
                imageVector = painterResource(R.drawable.ele),
                NomAgence = "Elegance Pressing",
                titre = "Avez-vous besoin d'un pressing",
                date = "15:21",
                img = Icons.Rounded.Delete
            ),
            Msg(
                imageVector = painterResource(R.drawable.ele),
                NomAgence = "Elegance Pressing",
                titre = "Avez-vous besoin d'un pressing",
                date = "15:21",
                img = Icons.Rounded.Delete
            ),
            Msg(
                imageVector = painterResource(R.drawable.ele),
                NomAgence = "Elegance Pressing",
                titre = "Avez-vous besoin d'un pressing",
                date = "15:21",
                img = Icons.Rounded.Delete
            ),
            Msg(
                imageVector = painterResource(R.drawable.ele),
                NomAgence = "Elegance Pressing",
                titre = "Avez-vous besoin d'un pressing",
                date = "15:21",
                img = Icons.Rounded.Delete
            ),
            Msg(
                imageVector = painterResource(R.drawable.ele),
                NomAgence = "Elegance Pressing",
                titre = "Avez-vous besoin d'un pressing",
                date = "15:21",
                img = Icons.Rounded.Delete
            ),
            Msg(
                imageVector = painterResource(R.drawable.ele),
                NomAgence = "Elegance Pressing",
                titre = "Avez-vous besoin d'un pressing",
                date = "15:21",
                img = Icons.Rounded.Delete
            ),
            Msg(
                imageVector = painterResource(R.drawable.ele),
                NomAgence = "Elegance Pressing",
                titre = "Avez-vous besoin d'un pressing",
                date = "15:21",
                img = Icons.Rounded.Delete
            ),
            Msg(
                imageVector = painterResource(R.drawable.ele),
                NomAgence = "Elegance Pressing",
                titre = "Avez-vous besoin d'un pressing",
                date = "15:21",
                img = Icons.Rounded.Delete
            ),
            Msg(
                imageVector = painterResource(R.drawable.ele),
                NomAgence = "Elegance Pressing",
                titre = "Avez-vous besoin d'un pressing",
                date = "15:21",
                img = Icons.Rounded.Delete
            ),
            Msg(
                imageVector = painterResource(R.drawable.ele),
                NomAgence = "Elegance Pressing",
                titre = "Avez-vous besoin d'un pressing",
                date = "15:21",
                img = Icons.Rounded.Delete
            )
            ),
        innerPadding = innerPadding
        )
            Column(modifier = Modifier.padding(16.dp)){
            }

        },
    bottomBar= {BottomBar()}
    )}




data class Msg(
    val imageVector: Painter,
    val NomAgence: String,
    val titre: String,
    val date: String,
    val img:  ImageVector
    )

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun stock(Msg: List<Msg>,
    innerPadding: PaddingValues){
    LazyColumn(contentPadding = innerPadding) {
        items(Msg) {
            Message(it)
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
fun Message(Msg: Msg) {
    Card(
        elevation = 3.dp,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(3.dp)
        ){
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = Msg.imageVector,
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .border(1.6.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = Msg.NomAgence,
                color = Color.Black,
                fontSize = 16.sp
            )
            Text(
                text = Msg.titre,
                color = Color.Gray,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
        Column(
            modifier = Modifier
                .padding(start = 24.dp)
        ) {
            Text(
                text = Msg.date,
                color = Color.Gray,
                fontSize = 16.sp
            )
            IconButton(
                onClick = { },
                content = { Icon(imageVector = Msg.img, contentDescription = "Delete")}
            )
        }


    }
    }
}

