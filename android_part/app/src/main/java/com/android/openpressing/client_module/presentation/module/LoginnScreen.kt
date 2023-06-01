package com.android.openpressing.client_module.presentation.module

import android.annotation.SuppressLint
import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.android.openpressing.R
import com.android.openpressing.ui.component.AppTextField
import com.android.openpressing.utils.Screen
import com.android.openpressing.viewmodels.client.ClientViewModel
import com.android.openpressing.viewmodels.client.state.ClientState
import com.android.openpressing.viewmodels.owner.OwnerViewModel
import com.android.openpressing.viewmodels.owner.state.OwnerState
import com.android.openpressing.viewmodels.user.state.UserState
import com.android.openpressing.viewmodels.user.UserViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginnScreen(
    getConnectedUserId: (Int) -> Unit,
    navController: NavHostController,
    userViewModel: UserViewModel = hiltViewModel(),
    ownerViewModel: OwnerViewModel = hiltViewModel(),
    clientViewModel: ClientViewModel = hiltViewModel()

) {

    val focusManager = LocalFocusManager.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordObscure by remember { mutableStateOf(true) }
    var showMessage by remember { mutableStateOf(false) }

    Scaffold {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Box(modifier = Modifier.height(24.dp))
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Sign in Illustration",
                modifier = Modifier
                    .weight(3f)
                    .padding(
                        horizontal = 32.dp,
                    ),
                contentScale = ContentScale.Fit,
            )
            LazyColumn {
                items(1) {
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .weight(7f)
                            .padding(8.dp)
                    ) {
                        Text(
                            text = "", style = MaterialTheme.typography.h4.copy(
                                fontWeight = FontWeight.Bold
                            )
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
                                    contentDescription = "Email Field",
                                    tint=Color.Black
                                )
                            },
                            label={
                                Text(
                                    text="Email"
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
                                placeholderColor = Color.Black
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
                                Icon(painter = if (passwordObscure) painterResource(id = R.drawable.ic_outline_visibility) else painterResource(
                                    id = R.drawable.ic_outline_visibility_off
                                ),
                                    contentDescription = "Show Password",
                                    tint=Color.Black,
                                    modifier = Modifier.clickable {
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

                        val userState = userViewModel.userState.collectAsState().value
                        val clientState = clientViewModel.clientState.collectAsState().value
                        val ownerState = ownerViewModel.ownerState.collectAsState().value

                        Button(
                            onClick = {

                                val auth = Firebase.auth
                                auth.signInWithEmailAndPassword(email, password)
                                    .addOnCompleteListener { task ->
                                        showMessage = if (task.isSuccessful) {
                                            Log.d(ContentValues.TAG, "signInWithEmail:success")

                                            userViewModel.getAll()
                                            if (userState is UserState.Success.UsersSuccess) {
                                                val user = userState.data.find {
                                                    it.email == email
                                                }
                                                if (user != null) {
                                                    clientViewModel.getAll()
                                                    ownerViewModel.getAll()
                                                    if (
                                                        clientState is ClientState.Success.ClientsSuccess
                                                        &&
                                                        ownerState is OwnerState.Success.OwnersSuccess
                                                    ) {
                                                        if (clientState.data.any { it.attributes.user.data.id == user.id }) {
                                                            navController.navigate(Screen.Home.road)
                                                        } else if (ownerState.data.any { it.attributes.user.data.id == user.id }) {
                                                            navController.navigate(Screen.ClientRequirement.road)
                                                        }
                                                    }

                                                }

                        val auth=Firebase.auth
                        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                            task -> showMessage = if(task.isSuccessful){
                            Log.d(ContentValues.TAG, "signInWithEmail:success")

                            if (users.value != null) {
                                val user = users.value!!.find {
                                    it.email == email
                                }
                                if(user != null){
                                    if(
                                        clients.value != null
                                        &&
                                        owners.value != null
                                    ){
                                        Log.i("", "${clients.value}")
                                        Log.i("", "${owners.value}")
                                        if (clients.value!!.any{ it.attributes.user.data.id == user.id }){
                                            getConnectedUserId(user.id!!)
                                            navController.navigate(Screen.Home.road)
                                        }
                                        else if(owners.value!!.any{it.attributes.user.data.id == user.id}){
                                            getConnectedUserId(user.id!!)
                                            navController.navigate(Screen.ClientRequirement.road)
                                        }
                                    }
                            },
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier
                                .height(48.dp)
                                .fillMaxWidth(),
                        ) {
                            Text(
                                text = "Se connecter", style = MaterialTheme.typography.body1
                            )
                        }
                        if (showMessage) {
                            AlertDialog(onDismissRequest = { showMessage = false },
                                title = { Text("Authentification invalide") },
                                text = {
                                    Text("Email ou mot de passe incorrect")
                                },
                                confirmButton = {
                                    Button(
                                        onClick = { showMessage = false },
                                        colors = ButtonDefaults.buttonColors(
                                            backgroundColor = Color.Blue
                                        )
                                    ) {
                                        Text("OK")
                                    }
                                }
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
    }
}