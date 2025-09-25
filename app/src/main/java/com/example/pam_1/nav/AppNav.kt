package com.example.pam_1.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pam_1.ui.LoginScreen
import com.example.pam_1.ui.RegisterScreen
import com.example.pam_1.activity.ProfileUser

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "register") {

        // REGISTER → setelah sukses ke LOGIN (dengan argumen lengkap)
        composable("register") {
            RegisterScreen(navController = navController)
        }

        // LOGIN (no-args) → dipakai dari "Already account? Log in"
        composable("login") {
            LoginScreen(
                navController = navController,
                onLoginClick = { inputUsername, _ ->
                    // Tanpa data register: boleh langsung ke profile dengan placeholder nama
                    val firstName = "User"
                    val lastName = "Guest"
                    val email = "${inputUsername}@gmail.com"
                    navController.navigate("profile/$firstName/$lastName/$inputUsername/$email")
                },
                onSignUpClick = {
                    navController.navigate("register")
                },
                onForgotPasswordClick = { }
            )
        }

        // LOGIN (with args) → dipakai setelah Register, bisa validasi kredensial
        composable(
            route = "login/{firstName}/{lastName}/{username}/{email}/{password}",
            arguments = listOf(
                navArgument("firstName") { type = NavType.StringType },
                navArgument("lastName") { type = NavType.StringType },
                navArgument("username") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType },
                navArgument("password") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val firstName = backStackEntry.arguments?.getString("firstName") ?: ""
            val lastName = backStackEntry.arguments?.getString("lastName") ?: ""
            val username = backStackEntry.arguments?.getString("username") ?: ""
            val email = backStackEntry.arguments?.getString("email") ?: ""
            val password = backStackEntry.arguments?.getString("password") ?: ""

            LoginScreen(
                navController = navController,
                onLoginClick = { inputUsername, inputPassword ->
                    // Validasi sederhana sesuai data dari Register
                    if (inputUsername == username && inputPassword == password) {
                        navController.navigate("profile/$firstName/$lastName/$username/$email")
                    }
                },
                onSignUpClick = {
                    navController.navigate("register")
                },
                onForgotPasswordClick = { }
            )
        }

        // PROFILE
        composable(
            route = "profile/{firstName}/{lastName}/{username}/{email}",
            arguments = listOf(
                navArgument("firstName") { type = NavType.StringType },
                navArgument("lastName") { type = NavType.StringType },
                navArgument("username") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val firstName = backStackEntry.arguments?.getString("firstName") ?: ""
            val lastName = backStackEntry.arguments?.getString("lastName") ?: ""
            val username = backStackEntry.arguments?.getString("username") ?: ""
            val email = backStackEntry.arguments?.getString("email") ?: ""

            ProfileUser(
                firstName = firstName,
                lastName = lastName,
                username = username,
                email = email,
                onLogout = {
                    // Logout kembali ke login (no-args) dan hapus profile dari backstack
                    navController.navigate("login") {
                        popUpTo("profile") { inclusive = true }
                    }
                }
            )
        }
    }
}
