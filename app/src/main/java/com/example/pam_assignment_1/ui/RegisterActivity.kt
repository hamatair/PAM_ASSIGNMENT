package com.example.pam_assignment_1.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pam_assignment_1.controller.RegisterController

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val controller = RegisterController()

        setContent {
            RegisterScreen(registerController = controller)
        }
    }
}
