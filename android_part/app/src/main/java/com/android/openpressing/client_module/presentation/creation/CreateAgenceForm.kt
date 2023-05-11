package com.android.openpressing.client_module.presentation.creation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class Pressing(val id: Int, val name: String)

val pressings = listOf(
    Pressing(1, "Pressing A"),
    Pressing(2, "Pressing B"),
    Pressing(3, "Pressing C")
)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CreateAgencyForm() {
    var selectedPressing by remember { mutableStateOf(pressings.first()) }
    var agencyName by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Enregistrement d'une agence") },
                backgroundColor = Color.Blue,
                elevation = 12.dp
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            DropdownMenu(
                expanded = false,
                onDismissRequest = { },
                modifier = Modifier.width(200.dp)
            ) {
                pressings.forEach { pressing ->
                    DropdownMenuItem(onClick = {
                        selectedPressing = pressing
                    }) {
                        Text(text = pressing.name)
                    }
                }
            }
            OutlinedTextField(
                value = agencyName,
                onValueChange = { agencyName = it },
                label = { Text("Nom de l'agence") },
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Button(
                onClick = {
                    // Action to save the agency
                }
            ) {
                Text(text = "Enregistrer")
            }
        }
    }
}