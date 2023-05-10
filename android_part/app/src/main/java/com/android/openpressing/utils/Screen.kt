package com.android.openpressing.utils

sealed class Screen(val road: String){

    object Login: Screen("/login")
    object Register: Screen("/register")
    object Finition: Screen("/finition")
    object ForgotPassword: Screen("/forgot-password")
    object ResetPassword: Screen("/reset_password")
    object Home: Screen("/home_Screen")
    object Profile: Screen("/profile_Screen")
    object EditScreen: Screen("/edit_screen")
    object Splash: Screen("/splash_screen")
    object ListCommande: Screen("/list_commande")
    object DetailCommande: Screen("/detail_commande")
    object ListBesoin: Screen("/list_besoin")
    object AddService: Screen("/add_service")

}
