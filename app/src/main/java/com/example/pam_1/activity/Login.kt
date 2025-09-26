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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pam_1.ui.theme.Poppins

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen(navController = rememberNavController())
        }
    }
}

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp, vertical = 24.dp)
    ) {
        Text(
            text = "Login",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Poppins,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 80.dp)
        )

        Text(
            text = "Enter your existing account",
            fontSize = 16.sp,
            fontFamily = Poppins,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 24.dp)
                .align(Alignment.Start)
        )


        // Email
        Text(text = "Email", fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp), fontFamily = Poppins,)
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("example@gmail.com") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            singleLine = true
        )

        // Password
        Text(text = "Password", fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp), fontFamily = Poppins,)
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
        )
        Text(
            text = "Forgot Password?",
            fontSize = 16.sp,
            color = Color(0xFFB5651D),
            fontWeight = FontWeight.SemiBold,
            fontFamily = Poppins,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                navController.navigate("resetPassword1")
                },
            textAlign = TextAlign.Right,

        )

        Spacer(modifier = Modifier.height(24.dp))

        // Register → ke LOGIN (with args lengkap)
        Button(
            onClick = {
                navController.navigate(
                    "profile"
                )
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB5651D)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Login", fontSize = 18.sp, color = Color.White, fontFamily = Poppins,)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sudah punya akun → LOGIN (no-args)
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Haven't any account? ", fontFamily = Poppins,)
            Text(
                text = "Sign up",
                color = Color(0xFFB5651D),
                fontWeight = FontWeight.SemiBold,
                fontFamily = Poppins,
                modifier = Modifier.clickable {
                    navController.navigate("register")
                }
            )
        }

        }
    }

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
        LoginScreen(navController = rememberNavController())
}
