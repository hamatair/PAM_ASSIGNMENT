package com.example.pam_1.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pam_1.activity.LoginScreen
import com.example.pam_1.activity.RegisterScreen
import com.example.pam_1.activity.ProfileUser
import com.example.pam_1.activity.ResetPassword1Screen
import com.example.pam_1.activity.ResetPassword2Screen

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
            LoginScreen(navController = navController)
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

            LoginScreen(navController = navController)
        }

        composable("resetPassword1") {
            ResetPassword1Screen(navController = navController)
        }

        composable("resetPassword2") {
            ResetPassword2Screen(navController = navController)
        }

        composable("profile") {
            ProfileUser(
                navController = navController,
                firstName = "Ali",
                lastName = "Sulthon",
                username = "Lusthon",
                email = "Sul@gmail.com",
                onLogout = {}
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
                navController = navController,
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
