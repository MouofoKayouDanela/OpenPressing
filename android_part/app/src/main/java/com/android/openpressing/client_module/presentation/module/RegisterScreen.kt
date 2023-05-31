package com.android.openpressing.client_module.presentation.module

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Place
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.android.openpressing.R
import com.android.openpressing.ui.component.AppTextField
import com.android.openpressing.ui.theme.OpenPressingTheme
import com.android.openpressing.utils.Screen


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RegisterScreen(navController: NavHostController) {
    val focusManager = LocalFocusManager.current
    var nom by remember { mutableStateOf("") }
    var prenom by remember { mutableStateOf("") }
    var Ville by remember { mutableStateOf("") }
    var showDialogNom by remember { mutableStateOf(false) }
    var showDialogPrenom by remember { mutableStateOf(false) }
    var showDialogDate by remember { mutableStateOf(false) }


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
                painter = painterResource(id = R.drawable.registre),
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
                    text = "",
                    style = MaterialTheme.typography.h4.copy(
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
                            tint=Color.Black
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
                            tint=Color.Black
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
                AppTextField(
                    onValueChange = {
                       Ville = it
                    },
                    hint = "Ville",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Place,
                            contentDescription = "ville",
                            tint=Color.Black
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    ),
                    value = Ville,

                )
                //Button(
                // onClick = {
                // },
                //shape = RoundedCornerShape(16.dp),
                //modifier = Modifier
                //  .height(48.dp)
                //  .fillMaxWidth(),
                //) {
                //   Text(
                //       text = "Continue", style = MaterialTheme.typography.body1,
                //       modifier = Modifier.clickable {
                //           navController.navigate(FINITION_ROUTE)
                //       }
                //   )
                //  }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { navController.navigate(Screen.Login.road) },
                        enabled = false // Griser le bouton précédent,

                    ) {
                        Text(text = "Précédent", style = MaterialTheme.typography.body1)
                    }
                    Button(
                        onClick = {
                            if(nom.isEmpty()){
                                showDialogNom=true
                            }
                            else if (prenom.isEmpty()){
                                showDialogPrenom=true
                            }
                            else if(Ville.isEmpty()){
                                showDialogDate=true
                            }
                            else{
                                navController.navigate(Screen.Finition.road)
                            }
                        /* Gérer l'événement du bouton continuer */ }
                    ) {
                        Text(text = "Continuer", style = MaterialTheme.typography.body1,
                        )
                    }
                    if(showDialogNom){
                        BackHandler {
                            showDialogNom=false
                        }
                        AlertDialog(onDismissRequest = { showDialogNom=false},
                            title = {Text("Champ vide")},
                            text={Text("Veuillez entrer le nom")},
                            buttons = {
                                Button(onClick = {showDialogNom=false },
                                    modifier=Modifier.width(80.dp)
                                        .padding(horizontal = 12.dp)) {
                                    Text("ok")
                                }
                            }
                        )
                    }
                    if(showDialogPrenom){
                        BackHandler {
                            showDialogPrenom=false
                        }
                        AlertDialog(onDismissRequest = { showDialogPrenom=false},
                            title = {Text("Champ vide")},
                            text={Text("Veuillez entrer le prenom")},
                            buttons = {
                                Button(onClick = {showDialogPrenom=false },
                                    modifier=Modifier.width(80.dp)
                                        .padding(horizontal = 12.dp)) {
                                    Text("ok")
                                }
                            }
                        )
                    }
                    if(showDialogDate){
                        BackHandler {
                            showDialogDate=false
                        }
                        AlertDialog(onDismissRequest = { showDialogDate=false},
                            title = {Text("Champ vide")},
                            text={Text("Veuillez entrer la ville")},
                            buttons = {
                                Button(onClick = {showDialogDate=false },
                                    modifier=Modifier.width(80.dp)
                                        .padding(horizontal = 12.dp)) {
                                    Text("ok")
                                }
                            }
                        )
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

