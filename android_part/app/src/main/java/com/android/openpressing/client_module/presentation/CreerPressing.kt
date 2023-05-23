package com.android.openpressing.client_module.presentation

import android.annotation.SuppressLint
import android.app.Activity.RESULT_OK
import android.content.ContentResolver
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.core.app.ActivityCompat.startActivityForResult
import com.android.openpressing.R
import com.android.openpressing.client_module.presentation.profile.ListBox
import com.android.openpressing.ui.theme.Violet
import com.android.openpressing.ui.theme.primaryColor

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Screen() {

    Scaffold(
        topBar = { TopBar() },
        content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                modifier = Modifier
                    .fillMaxHeight(),
            ) {

                item {
                    MyApp()
                }
            }
        }
    )
}

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Enregistrer un pressing ") },
        backgroundColor = Color(0xFF771E86),
        navigationIcon = { IconButton(onClick = {  }) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Back")

        }

        }
    )
}

@Composable
fun MyApp() {
    var selectedImage: ImageBitmap? by remember { mutableStateOf(null) }
    val textState = remember { mutableStateOf("") }
    val textVall = remember {mutableStateOf("")}

    val defaultImage = painterResource(id = R.drawable.person)

    Column(
        modifier = Modifier
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
        Surface(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(13.dp),
            border = BorderStroke(1.dp, Color.White)
        ) {

            Row(Modifier.padding(16.dp)) {
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
                    contentScale = ContentScale.FillHeight
                )

                Button(
                    onClick = {
                        launcher.launch("image/*")
                    },
                    modifier = Modifier.padding(top = 50.dp)
                ) {
                    Text("Ajouter un logo")
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical =180.dp)

            ) {
                TextField(
                    value = textState.value,
                    onValueChange = { newValue -> textState.value = newValue },
                    label = { Text("Entrez le nom du pressing") },
                    shape = RoundedCornerShape(11.dp),
                    textStyle = MaterialTheme.typography.body1
                )
            }

            Spacer(modifier = Modifier.padding(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 250.dp)
            ) {

                TextField(
                    value = textVall.value,
                    onValueChange = { newValue -> textVall.value = newValue },
                    label = { Text("Entrez le nom du propriertaire") },
                    shape = RoundedCornerShape(11.dp),
                    textStyle = MaterialTheme.typography.body1
                )
            }
            Row(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 40.dp, vertical =380.dp)

            ){

                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFF6F00)),
                    content = { Text("Confirmer") }
                )
            }
        }
    }
}






@Preview
@Composable
fun ScreenPreview() {
    Screen()
}
