@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.messagerie.Pressingsforms


import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MessageForm() {
    val context = LocalContext.current
    // Initial state of the text field
    val textFieldState = remember { mutableStateOf(TextFieldValue()) }

    Scaffold(
        topBar = {
            TopAppBar(

                title = {
                    Text(text = "ELEGANCE PRESSING")
                        },
                navigationIcon = {
                    IconButton(onClick = { /* Action pour la flèche de retour */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Retour")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Action pour l'icône de notification */ }) {
                        Icon(Icons.Default.Notifications, contentDescription = "Notifications")
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                     {

                    }
                }

                Spacer(modifier = Modifier.height(640.dp))

                TextField(
                    value = textFieldState.value,
                    onValueChange = { newValue ->
                        textFieldState.value = newValue
                    },
                    placeholder = {
                        Text(text = "Type your message here...")
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Send),
                    keyboardActions = KeyboardActions(onSend = {
                        // Handle message send here
                        textFieldState.value = TextFieldValue("")
                        // Show a confirmation toast
                        Toast.makeText(context, "Message sent!", Toast.LENGTH_SHORT).show()
                    }),
                    singleLine = false,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // Handle message send here
                    textFieldState.value = TextFieldValue("")
                    // Show a confirmation toast
                    Toast.makeText(context, "Message sent!", Toast.LENGTH_SHORT).show()
                },
                content = {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                    )
                    Icon(

                        imageVector = Icons.Filled.Send,
                        contentDescription = "Reply"
                    )
                }
            )
        }
    )
}


