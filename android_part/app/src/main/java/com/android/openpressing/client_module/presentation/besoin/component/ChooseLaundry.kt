package com.android.openpressing.client_module.presentation.besoin.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.openpressing.client_module.presentation.besoin.component.uil.Laundry
import com.android.openpressing.client_module.presentation.besoin.component.uil.laundries
import com.android.openpressing.ui.theme.Purple200




@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChooseLaundriesScreen(

    updateDialogState: (Boolean) -> Unit,
    Laundries:List<Laundry>,
    updateLaundry: (List<Laundry>) -> Unit
) {

    val addedLaundries = Laundries.toMutableList()

    val allLaundries = mutableListOf<Laundry>()
    laundries.forEach { allLaundries.add(Laundry(it.name, it.icon)) }

    AlertDialog(
        onDismissRequest = { updateDialogState(false) },
        text = {
            LazyColumn {

                stickyHeader {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White) ,
                        verticalAlignment = Alignment.CenterVertically ,
                        horizontalArrangement = Arrangement.Center
                    ){
                        Text(
                            text = "Select service(s)" ,
                            style = MaterialTheme.typography.h5.copy(
                                fontSize = 22.sp
                            ) ,
                            color = Purple200
                        )
                    }
                }

                items(allLaundries) { Laundry ->

                    var isChecked by remember { mutableStateOf(false) }
                    val enabled by remember { mutableStateOf(!Laundries.contains(Laundry)) }

                    Row(
                        Modifier
                            .padding(
                                horizontal = 4.dp ,
                                vertical = 8.dp
                            )
                            .clickable(
                                enabled = enabled ,
                                onClick = {

                                    if (!isChecked) {
                                        addedLaundries.add(Laundry)
                                    } else {
                                        addedLaundries.remove(Laundry)
                                    }
                                    isChecked = !isChecked
                                }
                            ) ,
                        verticalAlignment = Alignment.CenterVertically ,
                        horizontalArrangement = Arrangement.Center ,
                    ) {
                        Laundry.icon?.let {
                            Icon(
                                it ,
                                contentDescription = null ,
                                modifier = Modifier
                                    .size(48.dp)
                                    .weight(0.2f),
                                tint = if(enabled) Color.Black
                                else Color.LightGray
                            )
                        }

                        Text(
                            text = Laundry.name ,
                            modifier = Modifier
                                .weight(0.6f),
                            style = if (enabled) MaterialTheme.typography.body1
                            else MaterialTheme.typography.body1.copy(fontStyle = FontStyle.Italic),
                            color = if (enabled) Color.Black
                            else Color.LightGray
                        )

                        if (isChecked) {

                            Icon(
                                Icons.Rounded.Check ,
                                contentDescription = null ,
                                tint = Purple200 ,
                                modifier = Modifier
                                    .weight(0.2f)
                            )
                        }
                    }
                }

            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    updateLaundry(addedLaundries.toList())
                    updateDialogState(false)
                },
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Purple200
                )
            ) {
                Text(
                    text = "Add"
                )
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    updateDialogState(false)
                },
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Purple200
                )
            ) {
                Text(
                    text = "Cancel"
                )
            }
        },
        modifier = Modifier
            .height(400.dp),
        shape = RoundedCornerShape(10)
    )
}

