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
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.android.openpressing.ui.component.AppTextField

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FinitionScreen( navController: NavHostController) {
    val focusManager = LocalFocusManager.current
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordObscure by remember { mutableStateOf(true) }

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
    ){
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Box(modifier = Modifier.height(24.dp))
            Image(
                painter = painterResource(id = com.android.openpressing.R.drawable.logopressing),
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
                    text = "Confirmation", style = MaterialTheme.typography.h4.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                AppTextField(
                    onValueChange = {
                        username = it
                    },
                    hint = "Username",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Username Field",
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next,
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Next) }
                    ),
                    value = username,
                )
                AppTextField(
                    onValueChange = {
                        email = it
                    },
                    hint = "Email Address",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Email,
                            contentDescription = "Email Field",
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done,
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    ),
                    value = email,
                )
                AppTextField(
                    onValueChange = {
                        password = it
                    },
                    hint = "Password",
                    obscure = passwordObscure,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Lock,
                            contentDescription = "Password Field",
                        )
                    },
                    trailingIcon = {
                        Icon(painter = if (passwordObscure) painterResource(id = com.android.openpressing.R.drawable.ic_outline_visibility) else painterResource(
                            id = com.android.openpressing.R.drawable.ic_outline_visibility_off
                        ), contentDescription = "Show Password", modifier = Modifier.clickable {
                            passwordObscure = !passwordObscure
                        })
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done,
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    ),
                    value = password,
                )

                Text(
                    text = buildAnnotatedString {
                        append("By Signing up, you're agree to our ")
                        withStyle(style = SpanStyle(color = Color.Blue)) {
                            append("Terms & Conditions")
                        }
                        append(" and ")
                        withStyle(style = SpanStyle(color = Color.Blue)) {
                            append("Privacy Policy")
                        }
                    },
                    style = MaterialTheme.typography.caption
                )
                // Row(verticalAlignment = Alignment.CenterVertically) {
                //   Checkbox(
                //     checked = checked,
                //   onCheckedChange = onCheckedChange
                //)
                //Spacer(modifier = Modifier.width(8.dp))
                //Text(text = "text")
                //}


                //Button(
                //    onClick = {
                //    },
                //    shape = RoundedCornerShape(16.dp),
                //    modifier = Modifier
                //        .height(48.dp)
                //        .fillMaxWidth(),
                // ) {
                //    Text(
                //       text = "S'inscrire", style = MaterialTheme.typography.body1,
                //        modifier = Modifier.clickable {
                //            navController.navigate(FINITION_ROUTE)
                //        }
                //    )
                // }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier.width(130.dp)
                    ) {
                        Text("Précédent", style = MaterialTheme.typography.body1)
                    }

                    var showSnackbar by remember {
                        mutableStateOf(false)
                    }
                    Button(
                        onClick = {
                            if (email.isNotEmpty() && password.isNotEmpty() && username.isNotEmpty()) {
                            } else {
                                showSnackbar =true
                            }


                        },
                        modifier = Modifier.width(150.dp)
                    ) {
                        Text("S'inscrire", style = MaterialTheme.typography.body1)
                    }
                    if (showSnackbar){
                        Snackbar(
                            action = {
                                Button(onClick = {  showSnackbar = false }) {
                                    Text("OK")
                                }
                            }
                        ) {
                            Text("Veuillez remplir tous les champs.")
                        }
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
            }
        }
    }
}