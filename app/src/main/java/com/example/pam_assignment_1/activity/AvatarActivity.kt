package com.example.pam_assignment_1.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pam_assignment_1.Nav.AppNavigation
import com.example.pam_assignment_1.ui.AvatarScreen

class AvatarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}