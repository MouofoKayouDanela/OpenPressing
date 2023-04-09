package com.android.openpressing.client_module.presentation.besoin



import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.openpressing.R
@Preview
@Composable
fun AddRequirementScreen(){

    val scrollState = rememberLazyListState()
    Box{
       MainScreen( scrollState)

    }



}

@Composable
fun MainScreen(scrollstate: LazyListState) {

  TopAppBar(
      backgroundColor = Color.White,
      modifier= Modifier.height(100.dp)
  ) {
      Row(
          modifier = Modifier.padding(start = 4.dp, top = 4.dp, end = 4.dp, bottom = 4.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.spacedBy(100.dp)
      )
      {
          IconButton(
              onClick = { /*TODO*/ },
              modifier = Modifier.size(32.dp, 32.dp)


          ) {
              Image(imageVector = Icons.Default.ArrowBack, contentDescription ="" )
          }
          Text(
              text = "General",
              color = Color.DarkGray,
              style= MaterialTheme.typography.h5,
              modifier = Modifier.fillMaxWidth()
          )
      }

  }

}





