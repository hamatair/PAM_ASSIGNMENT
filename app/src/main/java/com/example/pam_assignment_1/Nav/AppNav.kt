package com.example.pam_assignment_1.Nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pam_assignment_1.LoginScreen
import com.example.pam_assignment_1.ui.AvatarScreen
import com.example.pam_assignment_1.ui.RegisterScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "login") {
        composable("register") { RegisterScreen(navController) }
        composable("login") {
            LoginScreen(
                navController = navController,
                onLoginClick = { username, password ->
                    navController.navigate("avatar")
                },
                onSignUpClick = {
                    navController.navigate("register")
                },
                onForgotPasswordClick = {
                }
            )
        }

        composable("avatar") { AvatarScreen(navController) }
    }
}