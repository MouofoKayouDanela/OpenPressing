package com.android.openpressing.client_module.presentation.agence.components


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.openpressing.R
import com.android.openpressing.client_module.presentation.MyApp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Interface() {

    Scaffold(
        topBar = { NavBar() },
        content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                modifier = Modifier
                    .fillMaxHeight(),
            ) {

                item {
                    CityDropdown()
                    NeighborhoodDropdown()
                }
            }
        }
    )

    }


@Composable
fun NavBar() {
    TopAppBar(
        title = { Text(text = "Créer une agence ") },
        backgroundColor = Color(0xFF5B1866),
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
            .padding(start = 16.dp) ,
    )

    {
        Image(
            painter = painterResource(id = R.drawable.logoapp),
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 32.dp,)
                .size(50.dp),
            contentScale = ContentScale.Fit,
        )
    }
}


@SuppressLint("UnrememberedMutableState")
@Composable
private fun CityDropdown() {

    val cities = mutableStateListOf<String>()
    var selectedCity by remember { mutableStateOf<String?>(null) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 30.dp, horizontal = 20.dp)




    ) {
        OutlinedTextField(
            value = selectedCity ?: "",
            onValueChange = { selectedCity = it },
            label = { Text("Selectioner la ville") },
            readOnly = true,
            modifier = Modifier.fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 20.dp),
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

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 20.dp)

    ) {
        OutlinedTextField(
            value = selectedNeighborhood ?: "",
            onValueChange = { selectedNeighborhood = it },
            label = { Text("Selectioner un quartier ") },
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

    }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp, horizontal = 40.dp),

        ) {
            Button(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFF6F00)),
                content = { Text("Confirmer") }
            )
        }
    }


@Preview
@Composable
fun InterfacePreview() {
    Interface()
}
