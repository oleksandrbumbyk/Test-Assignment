package com.oleksandrbumbyk.testassignment.presentation.navigation

import android.content.Context
import androidx.navigation.NavController

interface Navigator {

    fun onHomeOpenProfile(navController: NavController)

    fun onProfileGoBack(navController: NavController)

    fun onProfileOpenCall(context: Context, navController: NavController, number: String)
}
