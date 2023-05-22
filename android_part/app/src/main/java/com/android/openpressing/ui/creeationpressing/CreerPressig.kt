package com.android.openpressing.ui.creeationpressing


import android.annotation.SuppressLint
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.provider.MediaStore
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.core.app.ActivityCompat.startActivityForResult

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Screen() {

    Scaffold(
        topBar = { TopBar() }
    ) {
        MyApp()
        // ProfilePictureChanger()
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Enregistrer un pressing ") },
        backgroundColor = Color(0xFFFFFFFF),
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


    Box(Modifier.fillMaxSize().padding(1.dp))
    {
        Surface(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(13.dp),
            border = BorderStroke(1.dp, Color.White)
        )
        {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                TextField(
                    value = textState.value,
                    onValueChange = { newValue -> textState.value = newValue },
                    label = { Text("Entrez le nom du pressing") },
                    modifier = Modifier.padding(32.dp),
                    textStyle = MaterialTheme.typography.body1
                )

                Spacer(modifier = Modifier.padding(16.dp))

                TextField(
                    value = textState.value,
                    onValueChange = { newValue -> textState.value = newValue },
                    label = { Text("Entrez le nom du propriertaire") },
                    modifier = Modifier.padding(9.dp),
                    textStyle = MaterialTheme.typography.body1
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(vertical = 93.dp, horizontal = 40.dp),
            //.width(18.dp)
        ) {
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
/*@Composable
fun ProfilePictureChanger() {
    val REQUEST_CODE_PICK_IMAGE = 1
    val currentProfilePicture = painterResource(R.drawable.)
    var newProfilePicture: Painter? by remember { mutableStateOf(null) }

    Column(Modifier.padding(16.dp)) {
        Image(
            painter = newProfilePicture ?: currentProfilePicture,
            contentDescription = "Current profile picture",
            modifier = Modifier.size(48.dp)
        )

        Button(
            onClick = {
                val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE)
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Ajouter un logo")
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            val uri = data.data ?: return
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)
            newProfilePicture = rememberImagePainter(bitmap)
        }
    }
}*/






@Preview
@Composable
fun ScreenPreview() {
    Screen()
}