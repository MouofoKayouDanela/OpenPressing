package com.android.openpressing.client_module.presentation.profile


import android.content.ContentResolver
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalLaundryService
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Reorder
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.android.openpressing.R
import com.android.openpressing.client_module.presentation.BottomBar
import com.android.openpressing.ui.theme.*
import com.android.openpressing.utils.Screen

var id : Int = 0

@Composable
fun EditerProfil(navController: NavHostController
                 //userViewModel: UserViewModel = hiltViewModel()
                 //ownerViewModel: OwnerViewModel = hiltViewModel(),
                // clientViewModel: ClientViewModel = hiltViewModel()
) {

    var bipmap  : Uri
    Scaffold(
        topBar = {
            FixBare(navController)
        },

        content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                modifier = Modifier
                    .fillMaxHeight(),
            ) {

                item {
                    ListBox( navController,onImageSelected ={imageUri -> bipmap = imageUri})
                }
            }
        },

        bottomBar = {BottomBar(navController)}
    )


}




@Composable
fun FixBare(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(height = 50.dp, width = 230.dp) /////taille du box bleue/////
            .clip(
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomEnd = 10.dp,
                    bottomStart = 10.dp
                )
            )//////forme arrondie de la box/////
            .background(color = fourthColor)
        //shape=RoundedCornerShape(32.dp)
    ){
        Column() {
            /////Ligne de l'icone de notification/////
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(50.dp),
                verticalAlignment = Alignment.CenterVertically

            ){
                IconButton(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Icon(
                        Icons.Rounded.NavigateBefore,
                        contentDescription = stringResource(R.string.previewPage),
                        tint = Color.White
                    )
                }

                Text(
                    text = "Mon Profil",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                IconButton(
                    onClick = {
                         navController.navigate(Screen.Login.road)
                    }
                ) {
                    Icon(
                        Icons.Rounded.Logout,
                        contentDescription = stringResource(R.string.previewPage),
                        tint = thirdColor
                    )
                }
            }
        }
    }

}

@Composable
fun ListBox(navController: NavHostController,
    onImageSelected: (Uri) -> Unit
) {
    var name by remember {
        mutableStateOf("")
    }

    var adresse by remember {
        mutableStateOf("")
    }

    var mail by remember {
        mutableStateOf("")
    }

    var phone by remember {
        mutableStateOf(0)
    }

    var defaultname by remember { mutableStateOf("") }
    var defaultmail by remember { mutableStateOf("") }
    var defaultphone by remember { mutableStateOf(0) }
    var defaultadress by remember { mutableStateOf("") }

    val showDialogName = remember { mutableStateOf(false) }
    val showDialogMail = remember { mutableStateOf(false) }
    val showDialogPhone = remember { mutableStateOf(false) }
    val showDialogLocal = remember { mutableStateOf(false) }

    var textename by remember { mutableStateOf("") }
    var textemail by remember { mutableStateOf("") }
    var textephone by remember { mutableStateOf("") }
    var textelocal by remember { mutableStateOf("") }

    val context = LocalContext.current
    val selectedImageUri = remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            uri?.let { selectedUri ->
                selectedImageUri.value = selectedUri
            }
        }
    )

    //////////////VARIABLE DE L'IMAGE PAR DEFAUT/////////////////
    val defaultImage = painterResource(id = R.drawable.person)

    Column(
        modifier = Modifier
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ///////*******BOX DE L'IMAGE*********//////
        Row(
        ) {
            Box(
                contentAlignment = Alignment.BottomEnd
            ){
                    selectedImageUri.value?.let { imageUri ->
                        val contentResolver: ContentResolver = context.contentResolver
                        val bitmapImg = MediaStore.Images.Media.getBitmap(contentResolver, imageUri)

                        Image(
                            bitmap = bitmapImg.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(130.dp)
                                .border(1.dp, color = Violet, CircleShape),
                            contentScale = ContentScale.FillHeight
                        )
                    } ?: Image(
                        painter = defaultImage,
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(130.dp)
                            .border(1.dp, color = primaryColor, CircleShape),
                        contentScale = ContentScale.Crop
                    )

                ///////////icone de modification de l'image////////////
                IconButton(onClick = {
                    launcher.launch("image/*")
                }) {
                    Icon(
                        Icons.Rounded.PhotoCamera,
                        contentDescription = stringResource(R.string.nextPage),
                        tint = primaryColor,
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(fourthColor)
                            .padding(5.dp)
                            //.padding(horizontal = 5.dp)
                            .align(Alignment.BottomEnd)
                    )
                }
            }
        }

///////////DIFFERENTS ELEMENTS///////////////
        Spacer(modifier = Modifier.height(10.dp))

        ///////////////GRANDE ROW////////////
        Column(
            modifier = Modifier .fillMaxHeight(0.5f),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            // horizontalAlignment = Alignment.CenterHorizontally
        ){

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .weight(0.7f)
                        .padding(horizontal = 20.dp),
                ) {

                    Text(
                        "FullName : ",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black.copy(alpha = 0.5f),
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        " $textename",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                    )
                }
                IconButton(
                    modifier = Modifier .weight(0.3f),
                    onClick = {
                        showDialogName.value = true
                        //navController.navigate(Screen.EditScreen.road)
                    }
                ) {
                    Icon(
                        Icons.Rounded.Edit,
                        contentDescription = stringResource(R.string.nextPage),
                        tint = thirdColor,
                        modifier = Modifier
                            .clip(CircleShape)
                            //.background(VioletPal)
                            .padding(5.dp)
                    )
                }
                if (showDialogName.value) {
                    AlertDialog(

                        onDismissRequest = { showDialogName.value = false },
                        title = { Text("Enter your new name") },
                        text = {
                            TextField(
                                value = textename,
                                onValueChange = { textename=it},
                                modifier = Modifier
                                    .fillMaxWidth(),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                                singleLine = true,
                                placeholder = {Text(text = "$name")},
                            )
                        },

                        confirmButton = {
                            Button(
                                onClick = {
                                    defaultname = textename
                                    showDialogName.value = false
                                },
                                modifier = Modifier.padding(end = 15.dp)

                            ) {
                                Text("Validate")
                            }
                        },
                        dismissButton = {
                            Button(
                                modifier = Modifier.padding(end = 55.dp),
                                onClick = {
                                    showDialogName.value = false
                                }
                            ) {
                                Text("Cancel")
                            }
                        }
                    )
                }
            }

            ////////////LIGNE DE SEPARATION////////
            Canvas(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp)
            ) {
                drawLine(
                    color = Color.Black,
                    alpha = 0.1f,
                    start = Offset(3f, 3f),
                    end = Offset(size.width, size.height / 2),
                    strokeWidth = 1.dp.toPx()
                )
            }
            ////

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column(
                    modifier = Modifier
                        .weight(0.7f)
                        .padding(horizontal = 20.dp),
                    //horizontalArrangement = Arrangement.SpaceBetween,
                    //verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        "Email : ",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black.copy(alpha = 0.5f),
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        " $textemail",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                    )
                }

                IconButton(
                    modifier = Modifier .weight(0.3f),
                    onClick = {
                        showDialogMail.value = true
                        //navController.navigate(Screen.EditScreen.road)
                    }
                ) {
                    Icon(
                        Icons.Rounded.Edit,
                        contentDescription = stringResource(R.string.nextPage),
                        tint = thirdColor,
                        modifier = Modifier
                            .clip(CircleShape)
                            //.background(VioletPal)
                            .padding(5.dp)
                    )
                }

                //////////FONCTION DE VERIFICATION DU FORMAT DE L'EMAIL////////////////////
                fun isEmailValid(email: String): Boolean {
                    val regex = Regex("^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})")
                    return regex.matches(email)
                }

                if (showDialogMail.value) {
                    AlertDialog(

                        onDismissRequest = { showDialogMail.value = false },
                        title = { Text("Enter your new mail") },
                        text = {
                            TextField(
                                value = textemail,
                                onValueChange = { textemail=it},
                                modifier = Modifier
                                    .fillMaxWidth(),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                                singleLine = true,
                                placeholder = {Text(text = "$mail")},
                            )
                        },

                        confirmButton = {
                            Button(
                                onClick = {
                                    /*val email = "example@email.com"
                                    val isEmailValid = isEmailValid(email)

                                    if (isEmailValid) {
                                        Text("Validate", color = Color.Green)
                                    } else {
                                        Text("Validate", color = Color.Red)
                                    }*/
                                    defaultmail = textemail
                                    showDialogMail.value = false

                                },
                                modifier = Modifier.padding(end = 15.dp)

                            ) {
                                Text("Validate")
                            }
                        },
                        dismissButton = {
                            Button(
                                modifier = Modifier.padding(end = 55.dp),
                                onClick = {
                                    showDialogMail.value = false
                                }
                            ) {
                                Text("Cancel")
                            }
                        }
                    )
                }
            }

            ////////////LIGNE DE SEPARATION////////
            Canvas(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp)
            ) {
                drawLine(
                    color = Color.Black,
                    alpha = 0.1f,
                    start = Offset(3f, 3f),
                    end = Offset(size.width, size.height / 2),
                    strokeWidth = 1.dp.toPx()
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .weight(0.7f)
                        .padding(horizontal = 20.dp),
                    //horizontalArrangement = Arrangement.SpaceBetween,
                    //verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        "Contact : ",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black.copy(alpha = 0.5f),
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row() {
                        Text(
                            " +237 ",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black,
                        )
                        Text(
                            " $textephone",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black,
                        )
                    }


                }
                IconButton(
                    modifier = Modifier .weight(0.3f),
                    onClick = { showDialogPhone.value = true
                        //navController.navigate(Screen.EditScreen.road)
                    },
                ) {
                    Icon(
                        Icons.Rounded.Edit,
                        contentDescription = stringResource(R.string.nextPage),
                        tint = thirdColor,
                        modifier = Modifier
                            .clip(CircleShape)
                            //.background(VioletPal)
                            .padding(5.dp)
                    )
                }
                if (showDialogPhone.value) {
                    AlertDialog(

                        onDismissRequest = { showDialogPhone.value = false },
                        title = { Text("Enter your new phone") },
                        text = {
                            TextField(
                                value = textephone,
                                onValueChange = { textephone = it },
                                modifier = Modifier
                                    .fillMaxWidth(),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                singleLine = true,
                                placeholder = {Text(text = "$phone")},
                            )
                        },

                        confirmButton = {
                            Button(
                                onClick = {
                                    defaultphone = textephone.toInt()
                                    showDialogPhone.value = false
                                },
                                modifier = Modifier.padding(end = 15.dp)

                            ) {
                                Text("Validate")
                            }
                        },
                        dismissButton = {
                            Button(
                                modifier = Modifier.padding(end = 55.dp),
                                onClick = {
                                    showDialogLocal.value = false
                                }
                            ) {
                                Text("Cancel")
                            }
                        }
                    )
                }
            }

            ////////////LIGNE DE SEPARATION////////
            Canvas(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp)
            ) {
                drawLine(
                    color = Color.Black,
                    alpha = 0.1f,
                    start = Offset(3f, 3f),
                    end = Offset(size.width, size.height / 2),
                    strokeWidth = 1.dp.toPx()
                )
            }


            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .weight(0.7f),
                    //horizontalArrangement = Arrangement.SpaceBetween,
                    //verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        "Adresse de residence : ",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black.copy(alpha = 0.5f),
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        " $textelocal",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                    )
                }
                IconButton(
                    modifier = Modifier .weight(0.3f),
                    onClick = { showDialogLocal.value = true
                        //navController.navigate(Screen.EditScreen.road)
                    }) {
                    Icon(
                        Icons.Rounded.Edit,
                        contentDescription = stringResource(R.string.nextPage),
                        tint = thirdColor,
                        modifier = Modifier
                            .clip(CircleShape)
                            //.background(VioletPal)
                            .padding(5.dp)
                    )
                }



                if (showDialogLocal.value) {
                    AlertDialog(

                        onDismissRequest = { showDialogLocal.value = false },
                        title = { Text("Enter your new adress") },
                        text = {
                            TextField(
                                value = textelocal,
                                onValueChange = { textelocal=it},
                                modifier = Modifier
                                    .fillMaxWidth(),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                                singleLine = true,
                                placeholder = {Text(text = "$adresse")},
                            )
                        },

                        confirmButton = {
                            Button(
                                onClick = {
                                    defaultadress = textelocal
                                    showDialogLocal.value = false
                                },
                                modifier = Modifier.padding(end = 15.dp)

                            ) {
                                Text("Validate")
                            }
                        },
                        dismissButton = {
                            Button(
                                modifier = Modifier.padding(end = 55.dp),
                                onClick = {
                                    showDialogLocal.value = false
                                }
                            ) {
                                Text("Cancel")
                            }
                        }
                    )
                }
            }

            ////////////LIGNE DE SEPARATION////////
            Canvas(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp)
            ) {
                drawLine(
                    color = Color.Black,
                    alpha = 0.1f,
                    start = Offset(3f, 3f),
                    end = Offset(size.width, size.height / 2),
                    strokeWidth = 1.dp.toPx()
                )
            }
        }
    }


}




@Composable
fun BottomBar(navController: NavHostController) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 2.dp,
        backgroundColor = blanc
    ) {

        BottomNavigationItem(icon = {
            Icon(
                imageVector = Icons.Default.LocalLaundryService,
                "",
                tint = if(selectedIndex.value == 0) primaryColor
                else Color.DarkGray
            )
        },
            label = {
                Text(
                    text = "Laundry",
                    color = if(selectedIndex.value == 0) primaryColor
                    else Color.DarkGray
                )
            },
            selected = (selectedIndex.value == 0),
            onClick = {
                navController.navigate(Screen.Home.road)
                selectedIndex.value = 0
            })
        BottomNavigationItem(icon = {
            Icon(
                imageVector = Icons.Default.Reorder,
                "",
                tint = if(selectedIndex.value == 1) primaryColor
                else Color.DarkGray
            )
        },
            label = {
                Text(
                    text = "Order",
                    color = if(selectedIndex.value == 1) primaryColor
                    else Color.DarkGray
                )
            },
            selected = (selectedIndex.value == 1),
            onClick = {
                navController.navigate(Screen.ListCommande.road)
                selectedIndex.value = 1
            })

        BottomNavigationItem(icon = {
            Icon(
                imageVector = Icons.Default.ShoppingBasket,
                "",
                tint = if(selectedIndex.value == 2) primaryColor
                else Color.DarkGray
            )
        },
            label = {
                Text(
                    text = "Needs",
                    color = if(selectedIndex.value == 2) primaryColor
                    else Color.DarkGray
                )
            },
            selected = (selectedIndex.value == 2),
            onClick = {
                navController.navigate(Screen.ConsulterBesoin.road)
                selectedIndex.value = 2
            })

        BottomNavigationItem(icon = {
            Icon(
                imageVector = Icons.Default.Person,
                "",
                tint = if(selectedIndex.value == 3) primaryColor
                else Color.DarkGray
            )
        },
            label = {
                Text(
                    text = "Profile",
                    color = if(selectedIndex.value == 3) primaryColor
                    else Color.DarkGray
                )
            },
            selected = (selectedIndex.value == 3),
            onClick = {
                navController.navigate(Screen.Profile.road)
                selectedIndex.value = 3
            })
    }
}


@Composable
fun EditionView() {
    val navController = rememberNavController()
    val uri : Uri
    EditerProfil(navController)
}