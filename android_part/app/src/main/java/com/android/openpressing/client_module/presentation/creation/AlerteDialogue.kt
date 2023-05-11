package com.android.openpressing.client_module.presentation.creation

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.window.DialogProperties

@Composable
fun CreateAgencyDialog(onCreateAgency: () -> Unit) {
    var createAgency by remember { mutableStateOf(false) }

    if (createAgency) {
        AlertDialog(
            onDismissRequest = { createAgency = false },
            title = { Text("Créer une agence ?") },
            text = { Text("Voulez-vous créer une agence ?") },
            confirmButton = {
                Button(onClick = {
                    createAgency = false
                    onCreateAgency()
                }) {
                    Text("Oui")
                }
            },
            dismissButton = {
                Button(onClick = { createAgency = false }) {
                    Text("Non")
                }
            },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        )
    }
}