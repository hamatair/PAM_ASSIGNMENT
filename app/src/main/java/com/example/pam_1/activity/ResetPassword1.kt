package com.example.pam_1.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

class ResetPassword1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ResetPassword1Screen(navController = rememberNavController())
        }
    }
}

@Composable
fun ResetPassword1Screen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp, vertical = 24.dp)
    ) {
        Text(
            text = "Reset Password",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 80.dp)
        )

        Text(
            text = "Input your username and email address to receive reset link",
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 24.dp)
                .align(Alignment.Start)
        )

        // Username
        Text(text = "Username", fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            placeholder = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            singleLine = true
        )
        // Email
        Text(text = "Email", fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("example@gmail.com") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Register → ke LOGIN (with args lengkap)
        Button(
            onClick = {
                navController.navigate(
                    "resetPassword2"
                )
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB5651D)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Next", fontSize = 18.sp, color = Color.White)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ResetPassword1ScreenPreview() {
    ResetPassword1Screen(navController = rememberNavController())
}
