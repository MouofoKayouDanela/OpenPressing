package com.android.openpressing.client_module.presentation.module

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Place
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import com.android.openpressing.R
import com.android.openpressing.ui.component.AppTextField
import com.android.openpressing.ui.theme.OpenPressingTheme
import com.android.openpressing.utils.Screen
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.openpressing.data.models.city.CityData
import com.android.openpressing.data.models.quarter.QuarterData
import com.android.openpressing.ui.theme.Gris
import com.android.openpressing.viewmodels.city.CityViewModel
import com.android.openpressing.viewmodels.city.state.CityState
import com.android.openpressing.viewmodels.quarter.QuarterViewModel
import com.android.openpressing.viewmodels.quarter.state.QuarterState


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RegisterScreen(
    navController: NavHostController,
    quarterViewModel : QuarterViewModel = hiltViewModel(),
    cityViewModel : CityViewModel = hiltViewModel()
) {
    val focusManager = LocalFocusManager.current
    var nom by remember { mutableStateOf("") }
    var prenom by remember { mutableStateOf("") }
    var Ville by remember { mutableStateOf("") }
    var showDialogNom by remember { mutableStateOf(false) }
    var showDialogPrenom by remember { mutableStateOf(false) }
    var showDialogDate by remember { mutableStateOf(false) }

    cityViewModel.getAll()
    quarterViewModel.getAll()
    var quarters by remember {
        mutableStateOf<List<QuarterData>?>(null)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Gris,
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
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Gris)
                .padding(horizontal = 24.dp)
        ) {
            Box(modifier = Modifier.height(24.dp))
            Image(
                painter = painterResource(id = R.drawable.registre),
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
                Text(
                    text = "",
                    style = MaterialTheme.typography.h4.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                OutlinedTextField(
                    value = nom,
                     colors= TextFieldDefaults.outlinedTextFieldColors(
                         unfocusedBorderColor = Black,
                         placeholderColor = LightGray
                     )   ,
                    onValueChange = {
                        nom = it
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Nom",
                            tint=Color.Black
                        )
                    },
                    label={
                        Text(
                            text="Nom"
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
                    value = prenom,
                    colors= TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Black,
                        placeholderColor = LightGray
                    )   ,
                    onValueChange = {
                        prenom = it
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Prenom",
                            tint=Color.Black
                        )
                    },
                    label={
                        Text(
                            text="Prenom"
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next,
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Next) }
                    ),

                    )
                ListeVille(
                    state = cityViewModel.availableCities.collectAsState().value,
                    updatedQuarters = {
                        quarters = it
                    }
                )
                ListeQuartier(
                    state= quarterViewModel.availableQuarter.collectAsState().value,
                    quartiers = quarters
                )
                //Button(
                // onClick = {
                // },
                //shape = RoundedCornerShape(16.dp),
                //modifier = Modifier
                //  .height(48.dp)
                //  .fillMaxWidth(),
                //) {
                //   Text(
                //       text = "Continue", style = MaterialTheme.typography.body1,
                //       modifier = Modifier.clickable {
                //           navController.navigate(FINITION_ROUTE)
                //       }
                //   )
                //  }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { navController.navigate(Screen.Login.road) },
                        enabled = false // Griser le bouton précédent,

                    ) {
                        Text(text = "Précédent", style = MaterialTheme.typography.body1)
                    }
                    Button(
                        onClick = {
                            if(nom.isEmpty()){
                                showDialogNom=true
                            }
                            else if (prenom.isEmpty()){
                                showDialogPrenom=true
                            }
                            else if(Ville.isEmpty()){
                                showDialogDate=true
                            }
                            else{
                                navController.navigate(Screen.Finition.road)
                            }
                        /* Gérer l'événement du bouton continuer */ }
                    ) {
                        Text(text = "Continuer", style = MaterialTheme.typography.body1,
                        )
                    }
                    if(showDialogNom){
                        BackHandler {
                            showDialogNom=false
                        }
                        AlertDialog(onDismissRequest = { showDialogNom=false},
                            title = {Text("Champ vide")},
                            text={Text("Veuillez entrer le nom")},
                            buttons = {
                                Button(onClick = {showDialogNom=false },
                                    modifier= Modifier
                                        .width(80.dp)
                                        .padding(horizontal = 12.dp)) {
                                    Text("ok")
                                }
                            }
                        )
                    }
                    if(showDialogPrenom){
                        BackHandler {
                            showDialogPrenom=false
                        }
                        AlertDialog(onDismissRequest = { showDialogPrenom=false},
                            title = {Text("Champ vide")},
                            text={Text("Veuillez entrer le prenom")},
                            buttons = {
                                Button(onClick = {showDialogPrenom=false },
                                    modifier= Modifier
                                        .width(80.dp)
                                        .padding(horizontal = 12.dp)) {
                                    Text("ok")
                                }
                            }
                        )
                    }
                    if(showDialogDate){
                        BackHandler {
                            showDialogDate=false
                        }
                        AlertDialog(onDismissRequest = { showDialogDate=false},
                            title = {Text("Champ vide")},
                            text={Text("Veuillez entrer la ville")},
                            buttons = {
                                Button(onClick = {showDialogDate=false },
                                    modifier= Modifier
                                        .width(80.dp)
                                        .padding(horizontal = 12.dp)) {
                                    Text("ok")
                                }
                            }
                        )
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
                    Box(modifier = Modifier.width(8.dp))
                    Text(
                        "Login",
                        style = MaterialTheme.typography.body2.copy(
                            color = Blue,
                        ),
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    )

                }
            }
        }
    }
}

@Composable
fun ListeVille(
    updatedQuarters: (List<QuarterData>?) -> Unit,
    viewModel : CityViewModel = hiltViewModel(),
    state: CityState
){

    var expanded by remember {mutableStateOf(false) }
   // var selectedIndex by remember { mutableStateOf(false) }
    var selectedText by remember {mutableStateOf("")}
    var textfieldSize by  remember { mutableStateOf(Size.Zero) }

   val icone = if (expanded)
       Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column (
        modifier= Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth()
            ){
        OutlinedTextField(value = selectedText,
            colors= TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Black,
                placeholderColor = LightGray
            ),
            onValueChange =
        {selectedText=it},
        modifier= Modifier
            .fillMaxWidth(),
            /*.onGloballyPositioned { coordinates ->
                textfieldSize = coordinates.size.toSize()
            },*/
        label={
            Text("pays")
        },
        enabled = false,
        trailingIcon = {
            Icon(icone,
            contentDescription = "",
            Modifier.clickable { expanded = !expanded})
        })
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded=false },
           /* modifier=Modifier.width(with(LocalDensity.current){
                textfieldSize.width.toDp()
            })*/
      ) {
            if( state is CityState.Success.CitiesSuccess)
            {
                val options = state.data

                options.forEach{label->
                    DropdownMenuItem(
                        onClick = {
                            selectedText=label.attributes.name
                            updatedQuarters(label.attributes.quarters?.data)
                            expanded=false
                        }
                    ) {
                    Text(text=label.attributes.name)
                }}
            }

        }
    }


}

@Composable
fun ListeQuartier(
    state : QuarterState,
    quartiers: List <QuarterData>?
){
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }

    val icone = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth()
    ) {
        OutlinedTextField(value = selectedText,
            colors= TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Black,
                placeholderColor = LightGray
            ),
            onValueChange =
        { selectedText = it },
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text("Quartier")
            },
            enabled = false,
            trailingIcon = {
                Icon(icone,
                    contentDescription = "",
                    Modifier.clickable { expanded = !expanded })
            })
        DropdownMenu(
            expanded = expanded, onDismissRequest = { expanded = false },

        ) {
            if (state is QuarterState.Success.QuartersSuccess) {

                val options = state.data.filter{ oneOfAllQuarter ->
                    quartiers!!.any { wantedQuarter ->
                        oneOfAllQuarter.id == wantedQuarter.id
                    }
                }
                options.forEach { label ->
                    DropdownMenuItem(onClick = {
                        selectedText = label.attributes.name
                        expanded = false
                    }) {
                        Text(text = label.attributes.name)
                    }
                }
            }

        }
    }
}


