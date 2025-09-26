package com.example.pam_1.activity

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.pam_1.ui.theme.Poppins

@Composable
fun ProfileUser(
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
            .padding(24.dp, 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Icon profil
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    color = MaterialTheme.colorScheme.primary, // Warna latar belakang lingkaran
                    shape = CircleShape // Bentuk lingkaran
                ),
            contentAlignment = Alignment.Center // Posisikan ikon di tengah Box
        ) {
            // 2. Letakkan Icon di dalam Box
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile Icon",
                // Buat ikon sedikit lebih kecil dari lingkaran agar terlihat bagus
                modifier = Modifier.size(60.dp),
                // Gunakan warna onPrimary agar kontras dengan latar belakang primary
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
        Text(
            text = username,
            fontSize = 24.sp,
            fontFamily = Poppins,
            fontWeight = FontWeight.SemiBold

        )


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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "First Name", fontSize = 16.sp, fontFamily = Poppins, fontWeight = FontWeight.Medium)
                OutlinedTextField(
                    value = firstName,
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        unfocusedTextColor = Color.Black,
                        unfocusedLabelColor = Color((0xFFB5651D))
                    )
                    
                )
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Last Name", fontSize = 16.sp, fontFamily = Poppins, fontWeight = FontWeight.Medium)
                OutlinedTextField(
                    value = lastName,
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        unfocusedTextColor = Color.Black,
                        unfocusedLabelColor = Color((0xFFB5651D))
                )
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Email", fontSize = 16.sp, fontFamily = Poppins, fontWeight = FontWeight.Medium, modifier = Modifier.align(Alignment.Start))
        OutlinedTextField(
            value = email,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                unfocusedTextColor = Color.Black,
                unfocusedLabelColor = Color((0xFFB5651D))
            )
        )


        Spacer(modifier = Modifier.height(350.dp))

        // Tombol Logout
        Button(
            onClick = {
                Toast.makeText(context, "Logout berhasil", Toast.LENGTH_SHORT).show()
                onLogout()
            },
            colors = ButtonDefaults.buttonColors(Color(0xFFB5651D)),
            shape = RoundedCornerShape(10.dp),
            contentPadding = PaddingValues(50.dp, 12.dp)
        ) {
            Text("Logout",
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfilUser() {
    ProfileUser(
        firstName = "Ali",
        lastName = "Sulthon",
        username = "Lusthon",
        email = "Sul@gmail.com",
        onLogout = {}
    )
}
