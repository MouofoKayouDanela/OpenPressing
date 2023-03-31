package com.android.openpressing.client_module.presentation.requirement

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.openpressing.R

@Preview
@Composable
fun RequirementDetailsScreen(){

    Surface {
        Box(
            Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxSize()
        ) {

            LazyColumn(
                Modifier.background(MaterialTheme.colors.onSurface),
                contentPadding = PaddingValues(horizontal = 16.dp),
            ) {

                item {

                    TopAppBar()

                }

            }

        }
    }

}

@Composable
private fun TopAppBar() {
    Row(
        Modifier
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(72.dp)
    ) {

        IconButton(
            onClick = { }
        ) {
            Icon(
                Icons.Rounded.ArrowBack,
                contentDescription = stringResource(R.string.arrow_back)
            )
        }

        Text(
            text = "Detail Order",
            style = MaterialTheme.typography.h5
        )

    }
}