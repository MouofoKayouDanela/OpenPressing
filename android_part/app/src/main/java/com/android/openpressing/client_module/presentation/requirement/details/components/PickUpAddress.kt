package com.android.openpressing.client_module.presentation.requirement.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationCity
import androidx.compose.material.icons.rounded.NavigateNext
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.openpressing.ui.theme.HardGray
import com.android.openpressing.ui.theme.Purple200
import com.android.openpressing.ui.theme.SoftPurple200

@Composable
fun PickUpAddress() {
    Column(
        Modifier
            .background(MaterialTheme.colors.background)
            .padding(12.dp)
            .fillMaxWidth()
    )
    {

        Row(
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Icon(
                Icons.Rounded.LocationCity ,
                contentDescription = "Location" ,
                tint = Purple200 ,
                modifier = Modifier.weight(0.1f)
            )

            Text(
                text = "Pick up Address" ,
                style = MaterialTheme.typography.h6 ,
                modifier = Modifier.weight(0.8f)
            )

            Button(
                onClick = { } ,
                modifier = Modifier
                    .weight(0.1f) ,
                contentPadding = PaddingValues(1.dp) ,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = SoftPurple200
                )
            ) {
                Icon(
                    Icons.Rounded.NavigateNext ,
                    contentDescription = "Next" ,
                    modifier = Modifier
                        .size(ButtonDefaults.IconSize) ,
                    tint = Purple200
                )
            }

        }

        Text(
            "Jl. Raya Cikotomos No 68567 tasikmalaya perum compoka block A" ,
            style = MaterialTheme.typography.subtitle2 ,
            color = HardGray ,
            modifier = Modifier.fillMaxWidth(0.8f)
        )

    }
}