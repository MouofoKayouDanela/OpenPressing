package com.android.openpressing.pressing_module.register

import android.content.ContentResolver
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.PhotoCamera
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.SemanticsActions.OnClick
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.android.openpressing.R
import com.android.openpressing.ui.theme.*
import com.android.openpressing.utils.Screen

@Preview
@Composable
fun RegisterPressingScreen(){


    var bipmap  : Uri

    Scaffold(
        topBar = {
           TopAppBar(backgroundColor = Color.White,
                     elevation =3.dp)
           {
               Box{
                   Row(
                       Modifier
                           .fillMaxWidth()
                           .background(blanc)
                           .padding(horizontal = 4.dp, vertical = 5.dp),
                       horizontalArrangement = Arrangement.spacedBy(50.dp),

                       ) {
                       IconButton(onClick = { }) {
                           Icon(
                               Icons.Rounded.ArrowBack,
                               contentDescription = null,
                               modifier = Modifier.size(32.dp, 32.dp)
                           )
                       }
                       // Spacer(Modifier.weight(1f))
                       Row(
                           modifier = Modifier
                               .padding(8.dp),
                           verticalAlignment = Alignment.CenterVertically
                       ) {
                           Text(
                               text = "create Pressing",
                               style = MaterialTheme.typography.body1.copy(
                                   color = black,
                                   textAlign = TextAlign.Center,
                                   fontSize = 20.sp
                               )
                           )
                       }

                   }
               }

           }
        },
        content =  { innerPadding ->
            RegisterPressingContent(
                innerPadding =innerPadding
            )
        }



    )


}

@Composable
fun RegisterPressingContent(innerPadding: PaddingValues) {
    var selectedText1 by remember { mutableStateOf("") }
    var selectedText2 by remember { mutableStateOf("") }
    var nom by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var showDialog2 by remember { mutableStateOf(false) }
    var showDialog3 by remember { mutableStateOf(false) }
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


    val defaultImage = painterResource(id = R.drawable.defaultpressinglogo)

    Column(
        modifier = Modifier
            .padding(vertical = 80.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ///////*******BOX DE L'IMAGE*********//////
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                contentAlignment = Alignment.BottomEnd
            ) {
                selectedImageUri.value?.let { imageUri ->
                    val contentResolver: ContentResolver = context.contentResolver
                    val bitmapImg = MediaStore.Images.Media.getBitmap(contentResolver, imageUri)

                    Image(
                        bitmap = bitmapImg.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(190.dp)
                            .border(1.dp, color = Violet, CircleShape),
                        contentScale = ContentScale.FillHeight
                    )
                } ?: Image(
                    painter = defaultImage,
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(190.dp)
                        .border(1.dp, color = primaryColor, CircleShape)
                        .clickable {
                            launcher.launch("image/*")

                        },
                    contentScale = ContentScale.FillHeight
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
                            .background(primaryPrimeColor)
                            .padding(5.dp)
                            //.padding(horizontal = 5.dp)
                            .align(Alignment.BottomEnd)
                    )
                }
            }
        }
        
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Add a logo for your pressing",
            color = Color.Blue,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.clickable { launcher.launch("image/*") }
            )
            
//
        }

        Spacer(modifier = Modifier.height(48.dp))


        Row (modifier = Modifier.padding(start = 15.dp, end=15.dp)){

            OutlinedTextField(
                value =nom,
                onValueChange ={ nom=it},
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Pressing's name ")

                }
            )


        }
        Spacer(modifier = Modifier.height(10.dp))
        Row{

            var expanded by remember { mutableStateOf(false) }
            val suggestions = listOf("Douala", "Yaounde", "Bafoussam", "Ngaoundere", "Kribi","Edea","Bertoua")


            var textfieldSize by remember { mutableStateOf(Size.Zero)}

            val icon = if (expanded)
                Icons.Filled.KeyboardArrowUp
            else
                Icons.Filled.KeyboardArrowDown


            Column(Modifier.padding(start = 15.dp, end=15.dp)) {
                OutlinedTextField(
                    value = selectedText1,
                    onValueChange = { selectedText1 = it },
                    enabled = false,
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            textfieldSize = coordinates.size.toSize()
                        },
                    label = {Text("City")},
                    trailingIcon = {
                        Icon(icon,"contentDescription",
                            Modifier.clickable { expanded = !expanded })
                    }
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .width(with(LocalDensity.current){textfieldSize.width.toDp()})
                ) {
                    suggestions.forEach { label ->
                        DropdownMenuItem(onClick = {
                            selectedText1 = label
                            expanded = false
                        }) {
                            Text(text = label)
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row{

            var expanded by remember { mutableStateOf(false) }
            val suggestions = listOf("Essos", "Logpom", "Bonanjo", "Ntyo-village", "Logbessou","Mendong","Elig-essono")


            var textfieldSize by remember { mutableStateOf(Size.Zero)}

            val icon = if (expanded)
                Icons.Filled.KeyboardArrowUp
            else
                Icons.Filled.KeyboardArrowDown


            Column(Modifier.padding(start = 15.dp, end=15.dp)) {
                OutlinedTextField(
                    value = selectedText2,
                    enabled = false,
                    onValueChange = { selectedText2 = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            textfieldSize = coordinates.size.toSize()
                        },
                    label = {Text("Quarter")},
                    trailingIcon = {
                        Icon(icon,"contentDescription",
                            Modifier.clickable { expanded = !expanded })
                    }
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .width(with(LocalDensity.current){textfieldSize.width.toDp()})
                ) {
                    suggestions.forEach { label ->
                        DropdownMenuItem(onClick = {
                            selectedText2 = label
                            expanded = false
                        }) {
                            Text(text = label)
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(28.dp))

        Row {


            Button(
                onClick = {
                    if(nom.isEmpty()){
                        showDialog=true
                    }
                    if (selectedText1.isEmpty()){
                        showDialog2=true
                    }
                    if (selectedText2.isEmpty()){
                        showDialog3=true
                    }

                },
                modifier = Modifier.width(130.dp)
            ) {
                Text("Register", style = MaterialTheme.typography.body1)
            }
            if(showDialog){
                BackHandler {
                    showDialog=false
                }
                AlertDialog(
                    onDismissRequest = { showDialog=false},
                    title = {Text("Pressing's name required")},
                    text={Text("Please enter your pressing's name")},
                    confirmButton = {
                        Button(onClick = {showDialog=false },
                            modifier=Modifier.width(80.dp)
                                .padding(horizontal = 12.dp)) {
                            Text("ok")
                        }
                    }
                )
            }
            if(showDialog2){
                BackHandler {
                    showDialog2=false
                }
                AlertDialog(
                    onDismissRequest = { showDialog2=false},
                    title = {Text("Agency's city required")},
                    text={Text("Please choose a ciy for your agency")},
                    confirmButton = {
                        Button(onClick = {showDialog2=false },
                            modifier=Modifier.width(80.dp)
                                .padding(horizontal = 12.dp)) {
                            Text("ok")
                        }
                    },
                    modifier =Modifier.padding(start = 10.dp, end=10.dp)


                )
            }
            if(showDialog3){
                BackHandler {
                    showDialog3=false
                }
                AlertDialog(
                    onDismissRequest = { showDialog3=false},
                    title = {Text("Agency's quarter required")},
                    text={Text("Please choose a quarter for your agency")},
                    confirmButton = {
                        Button(onClick = {showDialog3=false },
                            modifier=Modifier.width(80.dp)
                                .padding(horizontal = 12.dp)) {
                            Text("ok")
                        }
                    },
                    modifier =Modifier.padding(start = 10.dp, end=10.dp)


                )
            }

        }





    }


}
