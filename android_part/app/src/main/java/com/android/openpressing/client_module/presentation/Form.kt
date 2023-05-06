package com.android.openpressing.client_module.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowCircleRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.openpressing.R
import com.android.openpressing.ui.theme.Purple500
import com.android.openpressing.ui.theme.black

@Composable
fun form(){
    Box{

        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(R.drawable.images2),
                contentDescription = null,
                modifier = Modifier.size(400.dp)

            )
            Text(
                text = "Advantages of laundryce",
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                color = Purple500,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body1.copy(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)

            )
            Text(
                text = "online service free waiting",
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                color = black,
                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )
            Text(
                text = "with point and Pickup- Delivery",
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                color = black,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.fillMaxWidth()
            )
        }


    }
    Bar()
}

@Composable
fun Bar(){
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier
            .padding(start = 20.dp, bottom = 29.dp)
    ){
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                Icons.Rounded.ArrowCircleRight,
                contentDescription = null,
                tint= Purple500,
                modifier = Modifier.size(50.dp, 50.dp)
            )
        }

    }
}