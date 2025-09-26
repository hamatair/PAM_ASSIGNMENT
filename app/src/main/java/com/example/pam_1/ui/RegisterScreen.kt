package com.example.pam_1.ui

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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pam_1.ui.theme.Poppins

@Composable
fun RegisterScreen(navController: NavController) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp, vertical = 24.dp)
    ) {
        Text(
            text = "Sign Up",
            fontSize = 40.sp,
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 80.dp)
        )

        Text(
            text = "Lets Create a New Account",
            fontSize = 16.sp,
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 24.dp)
                .align(Alignment.Start)
        )

        // Firstname & Lastname
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp, top = 40.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "First Name", fontSize = 16.sp, fontFamily = Poppins, modifier = Modifier.padding(bottom = 8.dp))
                OutlinedTextField(
                    value = firstName,
                    onValueChange = { firstName = it },
                    placeholder = { Text("First Name",
                        fontSize = 12.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Medium) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        unfocusedTextColor = Color.Black,
//                    focusedLabelColor = Color.Transparent,
                        unfocusedLabelColor = Color(0xFFB5651D)
                    )
                )
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Last Name", fontSize = 16.sp, fontFamily = Poppins, modifier = Modifier.padding(bottom = 8.dp))
                OutlinedTextField(
                    value = lastName,
                    onValueChange = { lastName = it },
                    placeholder = { Text("Last Name",
                        fontSize = 12.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Medium) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        unfocusedTextColor = Color.Black,
//                    focusedLabelColor = Color.Transparent,
                        unfocusedLabelColor = Color(0xFFB5651D)
                    )
                )
            }
        }

        // Username
        Text(text = "Username", fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp), fontFamily = Poppins)
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            placeholder = { Text("username",
                fontSize = 12.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                unfocusedTextColor = Color.Black,
//                    focusedLabelColor = Color.Transparent,
                unfocusedLabelColor = Color(0xFFB5651D)
        )
        )

        // Email
        Text(text = "Email", fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp), fontFamily = Poppins)
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("example@gmail.com",
                fontSize = 12.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                unfocusedTextColor = Color.Black,
//                    focusedLabelColor = Color.Transparent,
                unfocusedLabelColor = Color(0xFFB5651D)
        )
        )

        // Password
        Text(text = "Password", fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp), fontFamily = Poppins)
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Password",
                fontSize = 12.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                    unfocusedTextColor = Color.Black,
//                    focusedLabelColor = Color.Transparent,
                    unfocusedLabelColor = Color(0xFFB5651D)
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Register → ke LOGIN (with args lengkap)
        Button(
            onClick = {
                navController.navigate(
                    "login/$firstName/$lastName/$username/$email/$password"
                )
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB5651D)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Register", fontSize = 18.sp, color = Color.White, fontFamily = Poppins, fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sudah punya akun → LOGIN (no-args)
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Already have an account? ",
                fontSize = 12.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium)
            Text(
                text = "Sign in",
                fontSize = 12.sp,
                fontFamily = Poppins,
                color = Color(0xFFB5651D),
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable {
                    navController.navigate("login")
                }
            )
        }
    }
}
