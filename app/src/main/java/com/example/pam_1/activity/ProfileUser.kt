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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pam_1.ui.theme.Poppins

@Composable
fun ProfileUser(
    navController: NavController,
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
                modifier = Modifier.width(166.dp),
                shape = RoundedCornerShape(10.dp),

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
                modifier = Modifier.width(166.dp),
                shape = RoundedCornerShape(10.dp),

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
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),

        )

        Spacer(modifier = Modifier.height(8.dp))


        OutlinedTextField(
            value = "Halo, saya Sulthon. Mahasiswa Sistem Informasi yang tertarik di bidang data science dan mobile development. Saya suka belajar hal-hal baru, ngoprek teknologi, dan juga senang berbagi pengetahuan dengan teman-teman.",
            onValueChange = {},
            label = {
                Text(
                    "Bio",
                    fontSize = 12.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp), // agar kotaknya lebih tinggi
            shape = RoundedCornerShape(10.dp),
            readOnly = false, // bisa diisi
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            maxLines = 5 // bio bisa lebih panjang
        )


        Spacer(modifier = Modifier.height(250.dp))

        // Tombol Logout
        Button(
            onClick = {
                Toast.makeText(context, "Logout berhasil", Toast.LENGTH_SHORT).show()
                onLogout()
                navController.navigate(
                    "login"
                )
            },
            colors = ButtonDefaults.buttonColors(Color(0xFFB5651D)),
            shape = RoundedCornerShape(10.dp),
            contentPadding = PaddingValues(50.dp, 12.dp)
        ) {
            Text("Logout",
                color = Color.White,
                fontSize = 20.sp,
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
        navController = rememberNavController(),
        firstName = "Ali",
        lastName = "Sulthon",
        username = "Lusthon",
        email = "Sul@gmail.com",
        onLogout = {}
    )
}
