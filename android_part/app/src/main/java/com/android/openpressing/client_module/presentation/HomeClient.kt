package com.android.openpressing.client_module.presentation



import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.openpressing.R
import com.android.openpressing.ui.theme.*

@Preview
@Composable
fun ScaffoldSample() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {SectionBleu()},
        //drawerContent = { Text(text = "Drawer Menu 1") },
        content = { SearchField() },
        bottomBar = { BottomBar()}
    )
}

@Composable
fun CardWithContentColor() {
    val paddingModifier = Modifier.padding(10.dp)
    Card(
        elevation = 10.dp,
        contentColor = black,
        modifier = paddingModifier
    ) {
        Column() {
            Text(text = "Text with card content color (Blue)",
                modifier = paddingModifier)
            Text(text = "Text with card custom color",
                color = blanc,
                modifier = paddingModifier)

        }
    }
}

@Composable
fun SectionBleu() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(height = 160.dp, width = 300.dp) /////taille du box bleue/////
            .clip(
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomEnd = 40.dp,
                    bottomStart = 40.dp
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
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ){

                Row(

                    modifier = Modifier
                        .padding( horizontal = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(R.drawable.baseline_person_outline_24),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(35.dp)
                            .border(1.dp, color = blanc, CircleShape)

                    )
                    Spacer(Modifier.width(1.dp))
                    //////description du la photo////
                    Text(
                        "  Hello,",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = blanc,
                    )
                        Text(
                            "Emmanuel Zipar",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = blanc,
                        )
                }
                /////////////////////////icone de notification
                Icon(
                    Icons.Rounded.Notifications,
                    contentDescription ="notifications",
                    tint = blanc
                )

            }

            Spacer(Modifier.height(5.dp))
            
            ////////text de titre///////
            Row(
                Modifier
                    .padding(horizontal = 25.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                "Find your favorite Laundry place",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = blanc,
                )
            }


            Spacer(Modifier.height(15.dp))

            ////////////Les 3 icones du bas//////////////
            Row(
                Modifier
                    .padding(horizontal = 25.dp),
                verticalAlignment = Alignment.CenterVertically
            ){

                Icon(
                    Icons.Rounded.LocationOn,
                    contentDescription = "location",
                    tint = Orange
                )
                Text(
                    "Douala,Nyalla Rue 225",
                    fontWeight = FontWeight.Normal,
                    color = blanc,
                )

            }

        }
    }
}


@Composable
fun BottomBar() {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(elevation = 2.dp,
            backgroundColor = blanc) {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.LocalLaundryService,"",tint=Purple500)
        },
            label = { Text(text = "Laundry") },
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
            })
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Reorder,"")
        },
            label = { Text(text = "Order") },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Chat,"")
        },
            label = { Text(text = "Chat") },
            selected = (selectedIndex.value == 2),
            onClick = {
               selectedIndex.value = 2
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Person,"")
        },
            label = { Text(text = "Profile") },
            selected = (selectedIndex.value == 3),
            onClick = {
                selectedIndex.value = 3
            })
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchField() {  ////onSearch: (String) -> Unit
    var value by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = value,
            onValueChange = {
                value = it
                //onSearch(it)
            },
            modifier = Modifier
                .background(Color.Transparent)
                .padding(horizontal = 15.dp, vertical =   10.dp)
                .size(height = 50.dp, width = 220.dp)
                .border(
                    BorderStroke(1.dp, color = Violet),
                    shape = RoundedCornerShape(8.dp, 8.dp, 8.dp, 8.dp)
                ),
            //maxLines = 1,
            shape = RoundedCornerShape(8.dp),
            placeholder = {
                Text(
                    text = "Search your laundry",
                    style = TextStyle(
                        fontSize = 12.sp
                    )
                )
            },


            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {

                    keyboardController?.hide()
                }
            ),
            singleLine = true,
            textStyle = TextStyle(
                // color = primary,
                fontSize = 15.sp,

                ),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = "search icon",
                    modifier = Modifier.padding(start = 14.dp)
                )
            }
        )

            //////icone de filtre/////
        Spacer(Modifier.width(10.dp))

        IconButton(
            onClick = { /*TODO*/ },
        ) {
            Icon(
                Icons.Rounded.Sort,
                contentDescription = stringResource(R.string.editer),
                tint = Purple,
                modifier = Modifier
                    .size(height = 40.dp, width = 40.dp )
                    /*.clip(
                        shape = RoundedCornerShape(
                            topStart = 5.dp,
                            topEnd = 5.dp,
                            bottomEnd = 5.dp,
                            bottomStart = 5.dp
                        )
                    )*/
                    //.background(bla)

            )
        }
    }

}





@Preview(showBackground = true)
@Composable
fun Preview() {
    OpenPressingTheme {
        CardWithContentColor()
    }
}