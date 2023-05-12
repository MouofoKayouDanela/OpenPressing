package com.android.openpressing.client_module.presentation.promotion




import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.openpressing.R
import com.android.openpressing.client_module.presentation.besoin.MainScreen
import com.android.openpressing.client_module.presentation.besoin.RequirementContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun AddRequirementScreen(){

    val scrollState = rememberLazyListState()
    //val scaffoldState2 = rememberScaffoldState()
    Box{
        MainScreen(scrollState)
        RequirementContent(scrollState)
    }
    Scaffold(scaffoldState = rememberScaffoldState(),
        topBar = {AppTopBar()},
        drawerContent = {},
        content = {RequirementCard()},
        bottomBar = {AppBottom()})

    LazyColumn(){
        item {
            RequirementCard()

        }
    }
}

@Composable
fun AppTopBar() { //Entete
    Box(modifier = Modifier
        .height(50.dp)
        .fillMaxWidth()
        .background(color = Color.Red)){
        Row(
            modifier = Modifier.padding(start = 4.dp, top = 4.dp, end = 4.dp, bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(100.dp)
        )
        {

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.size(32.dp, 32.dp)
            ) {
                Image(imageVector = Icons.Default.ArrowBack, contentDescription ="" )
            }


            Text(
                text = "Créer une promotion",
                color = Color.White,
                style= MaterialTheme.typography.h5,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun AppBottom() { //Footer
    Box(modifier = Modifier
        .height(30.dp)
        .fillMaxWidth()
        .background(color = Color.Red)
    ){
        Row(
            modifier = Modifier.padding(start = 200.dp, top = 4.dp, end = 4.dp, bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(100.dp)
        )
        {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.size(32.dp, 32.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = "My Image",
                    modifier = Modifier
                )
            }
        }


    }
}


//////////////Inutile
@Composable
fun MainScreen(scaffoldState: LazyListState) {

    TopAppBar(
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier.padding(start = 4.dp, top = 4.dp, end = 4.dp, bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(100.dp)
        )
        {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.size(32.dp, 32.dp)
            ) {
                Image(imageVector = Icons.Default.ArrowBack, contentDescription ="" )
            }
            Text(
                text = "Promotion",
                color = Color.DarkGray,
                style= MaterialTheme.typography.h5,
                modifier = Modifier.fillMaxWidth()
            )
        }

    }
}

@Composable
fun RequirementContent(scaffoldState: LazyListState) {
    RequirementCard()
}
//////////////


@Composable
fun RequirementCard() {
    //Icon(painterResource(R.drawable.arrow_back) , contentDescription = "" )
    Column {

        Row(modifier = Modifier/*.width(100.dp)*/.height(50.dp), verticalAlignment = Alignment.CenterVertically){

            Icon(painter = painterResource(com.google.android.gms.base.R.drawable.common_full_open_on_phone),
                contentDescription = null,
                modifier = Modifier
                    .height(24.dp)
                    .padding(12.dp))

            Text(text = "",
                fontWeight=FontWeight.Bold,
                style=MaterialTheme.typography.h6,
                color=Color.DarkGray,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row(modifier = Modifier/*.width(100.dp)*/.height(50.dp), verticalAlignment = Alignment.CenterVertically){

            Icon(painter = painterResource(com.google.android.gms.base.R.drawable.common_full_open_on_phone),
                contentDescription = null,
                modifier = Modifier
                    .height(24.dp)
                    .padding(12.dp))

            Text(text = "",
                fontWeight=FontWeight.Bold,
                style=MaterialTheme.typography.h6,
                color=Color.DarkGray,
                modifier = Modifier.fillMaxWidth()
            )
        }


 //////////******** Quantité minimale ****************************
        Row(
            modifier = Modifier
                //.width(100.dp)
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically
        ){

            Icon(painter = painterResource(com.google.android.gms.base.R.drawable.common_full_open_on_phone),
                contentDescription = null,
                modifier = Modifier
                    .height(24.dp)
                    .padding(12.dp))

            Text(text = "Quantité minimale :",
                fontWeight=FontWeight.Bold,
                style=MaterialTheme.typography.h6,
                color=Color.DarkGray,
                modifier = Modifier.fillMaxWidth()
            )

            var quantite by remember{ mutableStateOf("")}
            TextField(
                value = quantite,
                onValueChange = {quantite = it}
            )
        }


        Row(modifier = Modifier/*.width(100.dp)*/.height(50.dp), verticalAlignment = Alignment.CenterVertically){

            Icon(painter = painterResource(com.google.android.gms.base.R.drawable.common_full_open_on_phone),
                contentDescription = null,
                modifier = Modifier
                    .height(24.dp)
                    .padding(12.dp))

            Text(text = "",
                fontWeight=FontWeight.Bold,
                style=MaterialTheme.typography.h6,
                color=Color.DarkGray,
                modifier = Modifier.fillMaxWidth()
            )
        }



//////////******** Pourcentage de retrait ****************************
        Row(
            modifier = Modifier
                //.width(100.dp)
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically
        ){

            Icon(painter = painterResource(com.google.android.gms.base.R.drawable.common_full_open_on_phone),
                contentDescription = null,
                modifier = Modifier
                    .height(24.dp)
                    .padding(12.dp))

            Text(text = "Pourcentage des retraits :",
                fontWeight=FontWeight.Bold,
                style=MaterialTheme.typography.h6,
                color=Color.DarkGray,
                modifier = Modifier.fillMaxWidth()
            )

            var pourcentage by remember{ mutableStateOf("")}
            TextField(
                value = pourcentage,
                onValueChange = {pourcentage = it}
            )
        }


        Row(modifier = Modifier/*.width(100.dp)*/.height(50.dp), verticalAlignment = Alignment.CenterVertically){

            Icon(painter = painterResource(com.google.android.gms.base.R.drawable.common_full_open_on_phone),
                contentDescription = null,
                modifier = Modifier
                    .height(24.dp)
                    .padding(12.dp))
            Text(text = "",
                fontWeight=FontWeight.Bold,
                style=MaterialTheme.typography.h6,
                color=Color.DarkGray,
                modifier = Modifier.fillMaxWidth()
            )
        }




 //////////******** Date de création ****************************
        Row(
            modifier = Modifier
                //.width(100.dp)
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically
        ){

            Icon(painter = painterResource(com.google.android.gms.base.R.drawable.common_full_open_on_phone),
                contentDescription = null,
                modifier = Modifier
                    .height(24.dp)
                    .padding(12.dp))

            Text(text = "Date de création :",
                fontWeight=FontWeight.Bold,
                style=MaterialTheme.typography.h6,
                color=Color.DarkGray,
                modifier = Modifier.fillMaxWidth()
            )

            var creation by remember{ mutableStateOf("")}
            TextField(
                value = creation,
                onValueChange = {creation = it}
            )
        }


        Row(modifier = Modifier/*.width(100.dp)*/.height(50.dp), verticalAlignment = Alignment.CenterVertically){

            Icon(painter = painterResource(com.google.android.gms.base.R.drawable.common_full_open_on_phone),
                contentDescription = null,
                modifier = Modifier
                    .height(24.dp)
                    .padding(12.dp))
            Text(text = "",
                fontWeight=FontWeight.Bold,
                style=MaterialTheme.typography.h6,
                color=Color.DarkGray,
                modifier = Modifier.fillMaxWidth()
            )
        }



 //////////******** Date d'expiration ****************************
        Row(
            modifier = Modifier
                //.width(100.dp)
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically
        ){

            Icon(painter = painterResource(com.google.android.gms.base.R.drawable.common_full_open_on_phone),
                contentDescription = null,
                modifier = Modifier
                    .height(24.dp)
                    .padding(12.dp))

            Text(text = "Date d'expiration :",
                fontWeight=FontWeight.Bold,
                style=MaterialTheme.typography.h6,
                color=Color.DarkGray,
                modifier = Modifier.fillMaxWidth()
            )

            var expiration by remember{ mutableStateOf("")}
            TextField(
                value = expiration,
                onValueChange = {expiration = it}
            )
        }



    }

}



