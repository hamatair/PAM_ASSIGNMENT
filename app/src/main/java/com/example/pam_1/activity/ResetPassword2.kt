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
import com.example.pam_1.ui.theme.Poppins

class ResetPassword2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ResetPassword2Screen(navController = rememberNavController())
        }
    }
}

@Composable
fun ResetPassword2Screen(navController: NavController) {
    var password by remember { mutableStateOf("") }
    var passwordRepeat by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp, vertical = 24.dp)
    ) {
        Text(
            text = "Create New Password",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Poppins,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 80.dp)
        )

        Text(
            text = "Lets create a new and more secure password",
            fontSize = 16.sp,
            fontFamily = Poppins,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 24.dp)
                .align(Alignment.Start)
        )

        // Password
        Text(text = "Password", fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp), fontFamily = Poppins,)
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            singleLine = true
        )
        // Password Repeat
        Text(text = "Repeat Password", fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp), fontFamily = Poppins,)
        OutlinedTextField(
            value = passwordRepeat,
            onValueChange = { passwordRepeat = it },
            placeholder = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Register → ke LOGIN (with args lengkap)
        Button(
            onClick = {
                navController.navigate(
                    "login"
                )
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB5651D)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Login", fontSize = 18.sp, color = Color.White)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ResetPassword2ScreenPreview() {
    ResetPassword2Screen(navController = rememberNavController())
}
