package com.example.full_vacancy_feature_api

import android.net.Uri
import androidx.navigation.NavController

interface FullVacancyLauncher {

fun startSearchFragment (navController : NavController, deepLink: Uri)

}