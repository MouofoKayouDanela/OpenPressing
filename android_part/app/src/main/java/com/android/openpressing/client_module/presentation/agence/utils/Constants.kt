package com.android.openpressing.client_module.presentation.agence.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocalLaundryService
import androidx.compose.material.icons.rounded.Wash
import androidx.compose.ui.graphics.vector.ImageVector


data class AgenceInfo(
    val name: String ,
    val icon: ImageVector ,
    val quarter: String
)

data class Service(
    val name: String = "",
    val icon: ImageVector? = null,
)

data class Laundry(
    val name: String = "" ,
    val icon: ImageVector? = null ,
)

data class Data(
    val name: String ,
    val icon: ImageVector? ,
)


val laundries = listOf(
        Laundry("Pantalon jean", Icons.Rounded.LocalLaundryService) ,
        Laundry("Culotte jean", Icons.Rounded.LocalLaundryService) ,
        Laundry("Robe en Nylon", Icons.Rounded.LocalLaundryService) ,
        Laundry("Echarpe en coton", Icons.Rounded.LocalLaundryService) ,
        Laundry("Pull en cuire", Icons.Rounded.LocalLaundryService) ,
        Laundry("Cravate en soie", Icons.Rounded.LocalLaundryService) ,
        Laundry("Veste en soie", Icons.Rounded.LocalLaundryService) ,
        Laundry("Jacket jean", Icons.Rounded.LocalLaundryService) ,
        Laundry("Jupe Nylon", Icons.Rounded.LocalLaundryService) ,
        Laundry("Chemise coton", Icons.Rounded.LocalLaundryService)
)

val services = listOf(
        Service("Nettoyage à sec" , Icons.Rounded.Wash) ,
        Service("Nettoyage à eau" , Icons.Rounded.Wash) ,
        Service("Lavage à sec" , Icons.Rounded.Wash) ,
        Service("Déttachage" , Icons.Rounded.Wash) ,
        Service("Blanchissage" , Icons.Rounded.Wash) ,
        Service("Amidonnage" , Icons.Rounded.Wash)
)