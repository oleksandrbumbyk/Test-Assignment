package com.oleksandrbumbyk.testassignment.presentation.navigation

import android.content.Context
import androidx.navigation.NavController
import com.oleksandrbumbyk.testassignment.R
import com.oleksandrbumbyk.testassignment.presentation.util.startCallActivity

class NavigatorImpl : Navigator {

    override fun onHomeOpenProfile(navController: NavController) {
        navController.navigate(R.id.action_homeFragment_to_profileFragment)
    }

    override fun onProfileGoBack(navController: NavController) {
        navController.popBackStack()
    }

    override fun onProfileOpenCall(context: Context, navController: NavController, number: String) {
        startCallActivity(context, number)
    }
}
