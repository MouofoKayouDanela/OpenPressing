package com.android.openpressing.client_module.presentation.module

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.rounded.ArrowLeft
import androidx.compose.material.icons.rounded.SwipeRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.android.openpressing.R
import com.android.openpressing.ui.component.AppTextField
import com.android.openpressing.ui.theme.primaryColor
import com.android.openpressing.ui.theme.secondaryColor
import com.android.openpressing.utils.Screen
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FinitionScreen( navController: NavHostController) {
    val focusManager = LocalFocusManager.current
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var ConfirmPassword by remember { mutableStateOf("") }
    var passwordObscure by remember { mutableStateOf(false) }
    var showDialogUsername by remember { mutableStateOf(false) }
    var showDialogEmail by remember { mutableStateOf(false) }
    var showDialogPassword by remember { mutableStateOf(false) }
    var showDialogConfirmPassword by remember { mutableStateOf(false) }

    Scaffold(

    ){
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Box(modifier = Modifier.height(24.dp))
            Image(
                painter = painterResource(id = com.android.openpressing.R.drawable.registre),
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

                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = {Text("Username")},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Username Field",
                            tint=Color.Black
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        cursorColor = primaryColor,
                        focusedBorderColor = primaryColor,
                        unfocusedBorderColor = Color.Black,
                        unfocusedLabelColor = Color.Gray,
                        focusedLabelColor = primaryColor
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done,
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    ),
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = {Text("Email address")},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Email,
                            contentDescription = "Email Field",
                            tint=Color.Black
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        cursorColor = primaryColor,
                        focusedBorderColor = primaryColor,
                        unfocusedBorderColor = Color.Black,
                        unfocusedLabelColor = Color.Gray,
                        focusedLabelColor = primaryColor
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    ),
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = {Text("Password")},
                    visualTransformation  = if (passwordObscure) VisualTransformation.None
                                            else PasswordVisualTransformation(),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Lock,
                            contentDescription = "Password Field",
                            tint=Color.Black,
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = { passwordObscure = !passwordObscure  }) {
                            Icon(imageVector = if(!passwordObscure) Icons.Filled.VisibilityOff
                                else Icons.Filled.Visibility,
                                contentDescription = "",
                                tint=Color.Black)
                        }
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        cursorColor = primaryColor,
                        focusedBorderColor = primaryColor,
                        unfocusedBorderColor = Color.Black,
                        unfocusedLabelColor = Color.Gray,
                        focusedLabelColor = primaryColor
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    ),
                )

                OutlinedTextField(
                    value = ConfirmPassword,
                    onValueChange = { ConfirmPassword = it },
                    label = {Text("Confirm password")},
                    visualTransformation  = if (passwordObscure) VisualTransformation.None
                                            else PasswordVisualTransformation(),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Lock,
                            contentDescription = "Password Field",
                            tint=Color.Black,
                        )
                    },
                    trailingIcon = {
                            IconButton(onClick = { passwordObscure = !passwordObscure  }) {
                                Icon(imageVector = if(!passwordObscure) Icons.Filled.VisibilityOff
                                else Icons.Filled.Visibility,
                                    contentDescription = "",
                                    tint=Color.Black)
                            }
                    },

                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        cursorColor = primaryColor,
                        focusedBorderColor = primaryColor,
                        unfocusedBorderColor = Color.Black,
                        unfocusedLabelColor = Color.Gray,
                        focusedLabelColor = primaryColor
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    ),
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

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier.width(130.dp)
                    ) {
                        Icon(
                            Icons.Rounded.ArrowLeft,
                            contentDescription = stringResource(R.string.nextPage),
                            tint = primaryColor,
                        )
                    }
                    Button(
                        onClick = {
                            if(username.isEmpty()){
                                showDialogUsername=true
                            }
                            else if (email.isEmpty()){
                                showDialogEmail=true
                            }
                            else if(password.isEmpty()){
                                showDialogPassword=true
                            }
                            else if(password != ConfirmPassword ){
                                showDialogPassword=true
                            }
                            else{
                                createUser(email, password, navController)
                                navController.navigate(Screen.Login.road)
                            }
                         },
                        modifier = Modifier.width(150.dp)
                    ) {
                        Text("Sign up", style = MaterialTheme.typography.body1)
                    }
                    if(showDialogUsername){
                        BackHandler {
                            showDialogUsername=false
                        }
                        AlertDialog(onDismissRequest = { showDialogUsername=false},
                            title = {Text("Champ vide")},
                            text={Text("Enter your username")},
                            confirmButton = {
                                Button(onClick = {showDialogUsername=false },
                                    modifier= Modifier
                                        .width(80.dp)
                                        .padding(horizontal = 12.dp)) {
                                    Text("ok")
                                }
                            }
                        )
                    }
                    if(showDialogEmail){
                        BackHandler {
                            showDialogEmail=false
                        }
                        AlertDialog(onDismissRequest = { showDialogEmail=false},
                            title = {Text("Champ vide")},
                            text={Text("Enter your mail")},
                            buttons = {
                                Button(onClick = {showDialogEmail=false },
                                    modifier= Modifier
                                        .width(80.dp)
                                        .padding(horizontal = 12.dp)) {
                                    Text("ok")
                                }
                            }
                        )
                    }
                    if(showDialogPassword){
                        BackHandler {
                            showDialogPassword=false
                        }
                        AlertDialog(onDismissRequest = { showDialogPassword=false},
                            title = {Text("Erreur")},
                            text={Text("Password and confirm password must be same")},
                            buttons = {
                                Button(onClick = {showDialogPassword=false },
                                    modifier= Modifier
                                        .width(80.dp)
                                        .padding(horizontal = 12.dp)
                                        ) {
                                    Text("ok")
                                }
                            }
                        )
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
fun createUser(
    email:String,
    password:String,
    navController: NavController
){
    println("L'email est $email et le mot de passe est $password")

    val auth=Firebase.auth
    try {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                    task ->if(task.isSuccessful){
                        Log.d(TAG,"createUserWithEmail:success")
                        navController.navigate(Screen.Login.road)
            }
                else{
                Log.w(TAG, "createUserWithEmail:failure", task.exception)
            }
        }
    }catch (e: Exception){
        println("Erreur : $e.message")
    }
}