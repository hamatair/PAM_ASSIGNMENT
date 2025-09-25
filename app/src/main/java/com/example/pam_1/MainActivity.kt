package com.example.pam_assignment_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ProfilUser(
//                firstName = firstname,
//                lastName = lastname,
//                username = username,
//                email = email,
//                onLogout = {}
//            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfilUser() {
    ProfilUser(
        firstName = "Ali",
        lastName = "Sulthon",
        username = "Lusthon",
        email = "Sul@gmail.com",
        onLogout = {}
    )
}
