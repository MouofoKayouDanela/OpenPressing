package com.android.openpressing.client_module.presentation.module

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.android.openpressing.data.models.utils.UserInfos
import com.android.openpressing.ui.component.AppTextField
import com.android.openpressing.ui.theme.Purple500
import com.android.openpressing.utils.Screen
import com.android.openpressing.viewmodels.user.UserViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FinitionScreen(
    userInfos : UserInfos,
    navController: NavHostController
) {
    val focusManager = LocalFocusManager.current
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var ConfirmPassword by remember { mutableStateOf("") }
    var passwordObscure by remember { mutableStateOf(true) }
    var connectionState by remember { mutableStateOf(false) }
    var showDialogUsername by remember { mutableStateOf(false) }
    var showDialogEmail by remember { mutableStateOf(false) }
    var showDialogPassword by remember { mutableStateOf(false) }
    var showDialogConfirmPassword by remember { mutableStateOf(false) }

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
                    colors= TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.Black,
                        placeholderColor = Color.LightGray
                    )   ,
                    onValueChange = {
                        username = it
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "username",
                            tint=Color.Black
                        )
                    },
                    label={
                        Text(
                            text="username"
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next,
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Next) }
                    ),
                )
                OutlinedTextField(
                    value = email,
                    colors= TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.Black,
                        placeholderColor = Color.LightGray
                    )   ,
                    onValueChange = {
                        email = it
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Email,
                            contentDescription = "email",
                            tint=Color.Black
                        )
                    },
                    label={
                        Text(
                            text="email"
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next,
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Next) }
                    ),
                )
                OutlinedTextField(
                    //value = password,
                    colors= TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.Black,
                        placeholderColor = Color.LightGray
                    )   ,
                    onValueChange = {
                        password = it
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Lock,
                            contentDescription = "Password Field",
                            tint=Color.Black
                        )
                    },
                    trailingIcon = {
                        Icon(painter = if (passwordObscure) painterResource(id = com.android.openpressing.R.drawable.ic_outline_visibility) else painterResource(
                            id = com.android.openpressing.R.drawable.ic_outline_visibility_off
                        ), contentDescription = "Show Password",
                            tint=Color.Black,
                                    modifier = Modifier.clickable {
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
                OutlinedTextField(
                    //value = password,
                    colors= TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.Black,
                        placeholderColor = Color.LightGray
                    )   ,
                    onValueChange = {
                        ConfirmPassword = it
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Lock,
                            contentDescription = "Confirm Password Field",
                            tint=Color.Black
                        )
                    },
                    trailingIcon = {
                        Icon(painter = if (passwordObscure) painterResource(id = com.android.openpressing.R.drawable.ic_outline_visibility) else painterResource(
                            id = com.android.openpressing.R.drawable.ic_outline_visibility_off
                        ), contentDescription = "Show Password",
                            tint=Color.Black,
                            modifier = Modifier.clickable {
                            passwordObscure = !passwordObscure
                        })
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done,
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    ),
                    value = ConfirmPassword,
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
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(Purple500)
                    ) {
                        Icon(
                            Icons.Rounded.KeyboardArrowLeft,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(5.dp)
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
                                createUser(
                                    email = email ,
                                    password = password ,
                                    navController = navController ,
                                    getConnectionState = {
                                        connectionState = it
                                    }
                                )
                                navController.navigate(Screen.Login.road)
                            }
                         },
                        modifier = Modifier.width(150.dp)
                    ) {
                        Text("S'inscrire", style = MaterialTheme.typography.body1)
                    }
                    if(showDialogUsername){
                        BackHandler {
                            showDialogUsername=false
                        }
                        AlertDialog(onDismissRequest = { showDialogUsername=false},
                            title = {Text("Champ vide")},
                            text={Text("Veuillez entrer votre username")},
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
                            text={Text("Veuillez entrer votre email")},
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
                            text={Text("Le mot de passe et confirm mot de passe doivent etre pareil")},
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
    navController: NavController,
    getConnectionState: (Boolean) -> Unit
){
    println("L'email est $email et le mot de passe est $password")

    val auth=Firebase.auth
    try {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                task -> if(task.isSuccessful) {
                    Log.d(TAG,"createUserWithEmail:success")
                    getConnectionState(true)
                        navController.navigate(Screen.Login.road)
                    } else {
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    }
                }
    }catch (e: Exception){
        println("Erreur : $e.message")
    }
}