package com.android.openpressing.client_module.presentation.creation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PressingForm() {
    var name by remember { mutableStateOf("") }
    var logo by remember { mutableStateOf<ImageBitmap?>(null) }
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Enregistrement d'un nouveau Pressing") })
        },
        content = {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                if (logo == null) {
                    Button(
                        onClick = { showDialog = true },
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text("Sélectionner une photo")
                    }
                } else {
                    Image(
                        bitmap = logo!!,
                        contentDescription = "Logo du pressing",
                        modifier = Modifier
                            .size(128.dp)
                            .padding(bottom = 16.dp),
                    )
                }

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Nom du pressing") },
                    modifier = Modifier.fillMaxWidth(),
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { /* TODO: handle "Suivant" button */ },
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text("Suivant")
                }
            }
        }
    )

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Sélectionner une photo") },
            text = { Text("TODO: implement file picker to select logo image") },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("OK")
                }
            }
        )
    }
}