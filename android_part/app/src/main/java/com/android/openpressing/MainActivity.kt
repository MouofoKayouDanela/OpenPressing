package com.android.openpressing

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.tooling.preview.Preview
import com.android.openpressing.ui.theme.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.openpressing.viewmodels.services.ServiceViewModel
import com.android.openpressing.ui.theme.OpenPressingTheme
import com.android.openpressing.client_module.presentation.module.FinitionScreen
import com.android.openpressing.client_module.presentation.module.ForgotPasswordScreen
import com.android.openpressing.client_module.presentation.module.LoginScreen
import com.android.openpressing.client_module.presentation.module.RegisterScreen
import com.android.openpressing.client_module.presentation.module.ResetPasswordScreen

//@AndroidEntryPoint
const val LOGIN_ROUTE = "/login"
const val REGISTER_ROUTE = "/register"
const val FINITION_ROUTE = "/finition"
const val FORGOT_PASSWORD_ROUTE = "/forgot-password"
const val RESET_PASSWORD_ROUTE = "/reset_password"



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            OpenPressingTheme{
                NavHost(navController = navController, startDestination = LOGIN_ROUTE){
                    composable(LOGIN_ROUTE){ LoginScreen(navController) }
                    composable(REGISTER_ROUTE){ RegisterScreen(navController) }
                    composable(FINITION_ROUTE) { FinitionScreen(navController)}
                    composable(FORGOT_PASSWORD_ROUTE){ ForgotPasswordScreen(navController) }
                    composable(RESET_PASSWORD_ROUTE){ ResetPasswordScreen(navController) }
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