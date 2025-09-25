package com.example.pam_assignment_1

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.pam_1.ui.theme.Poppins

@Composable
fun ProfilUser(
    firstName: String,
    lastName: String,
    username: String,
    email: String,
    onLogout: () -> Unit
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Icon profil
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Profile Icon",
            modifier = Modifier.size(100.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        Text(text = username)

        Spacer(modifier = Modifier.height(24.dp))

//        OutlinedTextField(
//            value = username,
//            onValueChange = {},
//            label = { Text("Username") },
//            readOnly = true,
//            modifier = Modifier.fillMaxWidth()
//        )
        Spacer(modifier = Modifier.height(8.dp))
        // Tampilkan data user
        Row {
            OutlinedTextField(
                value = firstName,
                onValueChange = {},
                label = { Text("First Name",
                    fontSize = 12.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium)
                        },
                readOnly = true,
                modifier = Modifier.width(166.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))

            OutlinedTextField(
                value = lastName,
                onValueChange = {},
                label = { Text("Last Name",
                    fontSize = 12.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium)
                        },
                readOnly = true,
                modifier = Modifier.width(166.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))


        OutlinedTextField(
            value = email,
            onValueChange = {},
            label = { Text("Email",
                        fontSize = 12.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Medium)
                    },
            readOnly = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Tombol Logout
        Button(
            onClick = {
                Toast.makeText(context, "Logout berhasil", Toast.LENGTH_SHORT).show()
                onLogout()
            },
            colors = ButtonDefaults.buttonColors(Color(0xFFB5651D))
        ) {
            Text("Logout", color = MaterialTheme.colorScheme.onError,
                    fontSize = 20.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium
                )
        }
    }
}
