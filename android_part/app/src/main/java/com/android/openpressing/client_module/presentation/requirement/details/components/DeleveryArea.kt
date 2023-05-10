@file:JvmName("DeleveryInformationKt")

package com.android.openpressing.client_module.presentation.requirement.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.EditNote
import androidx.compose.material.icons.rounded.Timer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.openpressing.ui.theme.HardGray
import com.android.openpressing.ui.theme.Purple200
import com.android.openpressing.ui.theme.SoftYellow

@Composable
fun DeliveryArea(){
    Column(
        Modifier
            .padding(vertical = 8.dp)
            .background(MaterialTheme.colors.background)
    ) {

        Text(
            "Detail Persanan" ,
            style = MaterialTheme.typography.h6 ,
            modifier = Modifier.padding(12.dp)
        )

        Divider(modifier = Modifier.fillMaxSize())

        Row(
            modifier = Modifier
                .padding(12.dp) ,
            horizontalArrangement = Arrangement.SpaceBetween ,
        ) {

            DeliveryInformation(
                modifier = Modifier.weight(1f) ,
                serviceType = "Express" ,
                specification = "24 Km" ,
                imageVector = Icons.Rounded.Timer ,
                tintColor = Purple200
            )

            DeliveryInformation(
                modifier = Modifier.weight(1f) ,
                serviceType = "Mawar" ,
                specification = "lorem ipsum..." ,
                imageVector = Icons.Rounded.EditNote ,
                tintColor = SoftYellow
            )
        }

    }
}

@Composable
fun DeliveryInformation(
    modifier : Modifier = Modifier ,
    serviceType : String ,
    specification : String ,
    imageVector: ImageVector ,
    tintColor : Color
){
    Row(
        modifier = modifier ,
        verticalAlignment = Alignment.CenterVertically ,
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        Icon(
            imageVector,
            contentDescription = "fast",
            tint = tintColor,
            modifier = Modifier.size(32.dp , 32.dp)
        )

        Column {
            Text(
                serviceType,
                style = MaterialTheme.typography.body2.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Text(
                specification ,
                style = MaterialTheme.typography.subtitle2 ,
                color = HardGray
            )
        }
    }
}