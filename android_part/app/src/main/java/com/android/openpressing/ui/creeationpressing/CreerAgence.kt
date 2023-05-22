package com.android.openpressing.ui.creeationpressing

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.openpressing.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Interface() {

    Scaffold(
        topBar = { NavBar() }
    ) {
         MyInterface()
        CityDropdown()
        NeighborhoodDropdown()
    }

}

@Composable
fun NavBar() {
    TopAppBar(
        title = { Text(text = "Créer une agence ") },
        backgroundColor = Color(0xFFFFFFFF),
        //shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp),
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")

            }

        }
    )
}

@Composable
fun MyInterface() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp)
            .padding(vertical = 30.dp, horizontal = 20.dp),

    )

    {
        Image(
            painter = painterResource(R.drawable.logoapp),
            contentDescription = null,
            modifier = Modifier
                .size(130.dp)
                .padding(vertical = 30.dp, horizontal = 60.dp)

        )


    }
}


@SuppressLint("UnrememberedMutableState")
@Composable
private fun CityDropdown() {

    val cities = mutableStateListOf<String>()
    var selectedCity by remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(vertical = 180.dp, horizontal = 20.dp)
            .width(16.dp)

    ) {
        OutlinedTextField(
            value = selectedCity ?: "",
            onValueChange = { selectedCity = it },
            label = { Text("Selectioner la ville") },
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(11.dp)
        )

        DropdownMenu(
            expanded = selectedCity != null,
            onDismissRequest = { selectedCity = null }
        ) {
            cities.forEach { city ->
                DropdownMenuItem(onClick = {
                    selectedCity = city.toString()
                }) {
                    Text(city)
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
private fun NeighborhoodDropdown() {
    val selectedCity = remember { mutableStateOf<String?>(null) }
    var selectedNeighborhood by remember { mutableStateOf<String?>(null) }
    val neighborhoods = mutableStateMapOf<String, List<String>>()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(vertical = 290.dp, horizontal = 20.dp)

    ) {
        OutlinedTextField(
            value = selectedNeighborhood ?: "",
            onValueChange = { selectedNeighborhood = it },
            label = { Text("Selectioner un quartier ")},
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(11.dp)
        )

        DropdownMenu(
            expanded = selectedCity.value != null && selectedNeighborhood == null,
            onDismissRequest = { /* Do nothing */ }
        ) {
            neighborhoods[selectedCity.value]?.forEach { neighborhood ->
                DropdownMenuItem(onClick = {
                    selectedNeighborhood = neighborhood
                }) {
                    Text(neighborhood)
                }
            }

        }

        DisposableEffect(selectedCity.value) {
            if (selectedCity.value != null) {
                // Reset selected neighborhood when city changes
                selectedNeighborhood = null
            }
            onDispose { /* Do nothing */ }
        }

        DisposableEffect(neighborhoods[selectedCity.value]) {
            if (selectedCity.value != null && neighborhoods[selectedCity.value]?.isEmpty() == false) {
                // Select first neighborhood when available
                selectedNeighborhood = neighborhoods[selectedCity.value]!![0]
            }
            onDispose { /* Do nothing */ }
        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(vertical = 93.dp, horizontal = 40.dp),
            //.width(18.dp)
        ) {
            Button(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFF6F00)),
                content = { Text("Confirmer") },
            )
        }
    }
}

@Preview
@Composable
fun InterfacePreview() {
    Interface()
}
