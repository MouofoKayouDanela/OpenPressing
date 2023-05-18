package com.android.openpressing.client_module.presentation.module

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.android.openpressing.R
import com.android.openpressing.ui.component.AppTextField
import com.android.openpressing.utils.Screen


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RegisterScreen(navController: NavHostController) {
    val focusManager = LocalFocusManager.current
    var nom by remember { mutableStateOf("") }
    var prenom by remember { mutableStateOf("") }
    var date_naissance by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                elevation = 0.dp,
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back Button"
                    )
                }
            }
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Box(modifier = Modifier.height(24.dp))
            Image(
                painter = painterResource(id = R.drawable.logopressing),
                contentDescription = "Sign up Illustration",
                modifier = Modifier
                    .weight(3f)
                    .padding(
                        horizontal = 32.dp,
                    ),
                contentScale = ContentScale.Fit,
            )
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.weight(7f),
            ) {
                Text(
                    text = "Sign Up", style = MaterialTheme.typography.h4.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                AppTextField(
                    onValueChange = {
                        nom = it
                    },
                    hint = "Nom",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Nom",
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next,
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Next) }
                    ),
                    value = nom,
                )
                AppTextField(
                    onValueChange = {
                        prenom = it
                    },
                    hint = "Prenom",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Prenom",
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done,
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    ),
                    value = prenom,
                )
                dropDownMenuVille()
                dropDownMenuPays()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { /* Gérer l'événement du bouton précédent */ },
                        enabled = false // Griser le bouton précédent,

                    ) {
                        Text(text = "Précédent", style = MaterialTheme.typography.body1)
                    }
                    var showSnackbar by remember {
                        mutableStateOf(false)
                    }
                    Button(
                        onClick = {
                            if (nom.isNotEmpty() && prenom.isNotEmpty()) {
                                // Naviguer vers l'ecran suivant
                            } else // Naviguer vers l'ecran suivant
                            {
                                showSnackbar = true
                            }
                            // Afficher un message d'erreur }
                        }
                    ) {
                        Text(text = "Continuer", style = MaterialTheme.typography.body1,
                            modifier = Modifier.clickable {
                                navController.navigate(Screen.Login.road)
                            })
                    }
                    if (showSnackbar){
                        Snackbar(
                            action = {
                                Button(onClick = { showSnackbar = false }) {
                                    Text("OK")
                                }
                            }) {
                            Text("veuillez remplir tous les champs.")
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {

                    Text(
                        "Have joined us before ?",
                        style = MaterialTheme.typography.body2,
                    )
                    Box(modifier = Modifier.width(8.dp))
                    Text(
                        "Login",
                        style = MaterialTheme.typography.body2.copy(
                            color = Blue,
                        ),
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    )

                }
            }
        }
    }
}