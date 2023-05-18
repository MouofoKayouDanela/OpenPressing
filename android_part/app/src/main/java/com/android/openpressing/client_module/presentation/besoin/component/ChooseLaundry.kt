package com.android.openpressing.client_module.presentation.besoin.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.openpressing.client_module.presentation.agence.utils.services
import com.android.openpressing.client_module.presentation.besoin.component.uil.Data
import com.android.openpressing.client_module.presentation.besoin.component.uil.laundries
import com.android.openpressing.ui.theme.Purple200




@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChooseLaundryScreen(

    updateDialogState: (Boolean) -> Unit,
    datas: List<Data>,
    updatelaundry: (List<Data>) -> Unit
) {

    val addedLaundryy = datas.toMutableList()

    val allDatas = mutableListOf<Data>()
    laundries   .forEach { allDatas.add(
        Data(
            it.name,
            it.icon
        )
    ) }

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
                            text = "Select Laundry" ,
                            style = MaterialTheme.typography.h5.copy(
                                fontSize = 22.sp
                            ) ,
                            color = Purple200
                        )
                    }
                }

                items(allDatas) { data ->

                    var isChecked by remember { mutableStateOf(false) }
                    val enabled by remember { mutableStateOf(!datas.contains(data)) }

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
                                        addedLaundryy.add(data)
                                    } else {
                                        addedLaundryy.remove(data)
                                    }
                                    isChecked = !isChecked
                                }
                            ) ,
                        verticalAlignment = Alignment.CenterVertically ,
                        horizontalArrangement = Arrangement.Center ,
                    ) {
                        data.icon?.let {
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
                            text = data.name ,
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
                    updatelaundry(addedLaundryy.toList())
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


