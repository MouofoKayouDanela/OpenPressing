package com.android.openpressing

import androidx.compose.ui.tooling.preview.Preview
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.openpressing.client_module.presentation.*
import com.android.openpressing.client_module.presentation.agence.ServicesNLaundriesManager
import com.android.openpressing.ui.theme.OpenPressingTheme
import com.android.openpressing.client_module.presentation.module.FinitionScreen
import com.android.openpressing.client_module.presentation.module.ForgotPasswordScreen
import com.android.openpressing.client_module.presentation.module.LoginScreen
import com.android.openpressing.client_module.presentation.module.RegisterScreen
import com.android.openpressing.client_module.presentation.module.ResetPasswordScreen
import com.android.openpressing.client_module.presentation.profile.EditerProfil
import com.android.openpressing.client_module.presentation.requirement.details.RequirementDetailsScreen
import com.android.openpressing.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            OpenPressingTheme{
                NavHost(navController = navController, startDestination = Screen.Splash.road){
                    composable(Screen.Login.road){ LoginScreen(navController) }
                    composable(Screen.Register.road){ RegisterScreen(navController) }
                    composable(Screen.Finition.road) { FinitionScreen(navController)}
                    composable(Screen.ForgotPassword.road){ ForgotPasswordScreen(navController) }
                    composable(Screen.ResetPassword.road){ ResetPasswordScreen(navController) }
                    composable(Screen.Home.road){ ScaffoldSample(navController) }
                    composable(Screen.Profile.road){ ProfileScreen(navController) }
                    composable(Screen.EditScreen.road){ EditerProfil(navController) }
                    composable(Screen.Splash.road){ IntroScreen(navController) }
                    composable(Screen.AddService.road){ ServicesNLaundriesManager(navController) }
                    //composable(Screen.ListBesoin.road){ Besoin(navController) }
                    composable(Screen.ListCommande.road){ View(navController) }
                    composable(Screen.DetailCommande.road){ RequirementDetailsScreen(navController) }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OpenPressingTheme {

        //PageScreen()
        //FormScreen()
        //form()
        //Default()

    }
}