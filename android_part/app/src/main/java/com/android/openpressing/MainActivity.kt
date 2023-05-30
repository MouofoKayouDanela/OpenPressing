package com.android.openpressing

import androidx.compose.ui.tooling.preview.Preview
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.android.openpressing.client_module.presentation.*
import com.android.openpressing.client_module.presentation.agence.ServicesNLaundriesManager
import com.android.openpressing.client_module.presentation.besoin.AddRequirementScreen
import com.android.openpressing.client_module.presentation.besoin.DetailBesoin
import com.android.openpressing.client_module.presentation.besoin.MyNeed
import com.android.openpressing.client_module.presentation.client.MySMS
import com.android.openpressing.client_module.presentation.client.OfferScreen
import com.android.openpressing.client_module.presentation.module.*
import com.android.openpressing.ui.theme.OpenPressingTheme
import com.android.openpressing.client_module.presentation.profile.EditerProfil
import com.android.openpressing.client_module.presentation.profile.MyScreenPreview
import com.android.openpressing.client_module.presentation.requirement.details.RequirementDetailsScreen
import com.android.openpressing.pressing_module.requirement.ClRequirementConsulting
import com.android.openpressing.pressing_module.requirement.RequirementDetail
import com.android.openpressing.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            //val pressingModel : PressingViewModel = viewModel()

            OpenPressingTheme{
                NavHost(navController = navController, startDestination = Screen.Login.road){
                    composable(Screen.Login.road){ LoginnScreen(navController) }
                    composable(Screen.Register.road){ RegisterScreen(navController) }
                    composable(Screen.Finition.road) { FinitionScreen(navController)}
                    composable(Screen.ForgotPassword.road){ ForgotPasswordScreen(navController) }
                    composable(Screen.ResetPassword.road){ ResetPasswordScreen(navController) }
                    composable(Screen.Home.road){
                        ScaffoldSample(navController)
                    }
                    composable(Screen.Profile.road){ ProfileScreen(navController) }
                    composable(Screen.EditScreen.road){ EditerProfil(navController) }
                    composable(Screen.Splash.road){ IntroScreen(navController) }
                    composable(Screen.AddService.road){ ServicesNLaundriesManager(navController) }
                    composable(Screen.ListBesoin.road){ Default(navController) }
                    composable(Screen.ListCommande.road){ View(navController) }
                    composable(Screen.DetailCommande.road){ RequirementDetailsScreen(navController) }
                    composable(Screen.ListOffer.road){ OfferScreen(navController) }
                    composable(Screen.AddBesoin.road){ AddRequirementScreen(navController) }
                    composable(Screen.ConsulterMessage.road){ MySMS(navController) }
                    composable(Screen.Parametre .road){ MyScreenPreview(navController) }
                    composable(Screen.ClientRequirement.road) { ClRequirementConsulting( navController) }
                    composable(
                            route = "${Screen.ClientRequirementDetails.road}/{requirementId}",
                            arguments = listOf(navArgument("requirementId") { type = NavType.IntType })
                    ) { backStackEntry ->

                        RequirementDetail(
                                requirementId = backStackEntry.arguments?.getInt("requirementId")!!,
                                navController = navController
                        )
                    }
                    composable(Screen.ConsulterBesoin.road){
                        MyNeed(
                                navController = navController
                        )
                    }
                    composable(
                            route ="${Screen.DetailBesoin.road}/{requirementId}",
                            arguments = listOf(navArgument("requirementId") { type = NavType.IntType })
                    ){
                        DetailBesoin(
                                requirementId = it.arguments?.getInt("requirementId")!!,
                                navController = navController
                        )
                    }
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