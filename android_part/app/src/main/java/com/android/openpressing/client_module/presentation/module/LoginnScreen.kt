package com.android.openpressing.client_module.presentation.module

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun LoginScreen(navController: NavHostController) {
    val focusManager = LocalFocusManager.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordObscure by remember { mutableStateOf(true) }

    Scaffold {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Box(modifier = Modifier.height(24.dp))
            Image(
                painter = painterResource(id = R.drawable.logopressing),
                contentDescription = "Sign in Illustration",
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
                modifier = Modifier
                    .weight(7f)
            ) {
                Text(
                    text = "", style = MaterialTheme.typography.h4.copy(
                        fontWeight = FontWeight.Bold
                    )
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
                        Icon(painter = if (passwordObscure) painterResource(id = R.drawable.ic_outline_visibility) else painterResource(
                            id = R.drawable.ic_outline_visibility_off
                        ), contentDescription = "Show Password", modifier = Modifier.clickable {
                            passwordObscure = !passwordObscure
                        }
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done,
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    ),
                    value = password,
                )
                TextButton(
                    onClick = {
                        navController.navigate(Screen.ForgotPassword.road)
                    },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Forgot Password ?")
                }
                Button(
                    onClick = {navController.navigate(Screen.Home.road)},
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "Se connecter", style = MaterialTheme.typography.body1
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Divider(
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        "OR",
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Divider(
                        modifier = Modifier.weight(1f)
                    )
                }
                OutlinedButton(
                    onClick = {},
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth(),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_google),
                        contentDescription = "",
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    Box(modifier = Modifier.width(32.dp))
                    Text(
                        text = "Login with Google",
                        style = MaterialTheme.typography.body1.copy(Color.Black)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(
                        "Don't have an account",
                        style = MaterialTheme.typography.body2,
                    )
                    Box(modifier = Modifier.width(8.dp))
                    Text(
                        "Register Here !",
                        style = MaterialTheme.typography.body2.copy(
                            color = Blue,
                        ),
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.Register.road)
                        }
                    )
                }
            }
        }
    }
}