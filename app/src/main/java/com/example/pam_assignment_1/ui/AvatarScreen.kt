package com.example.pam_assignment_1.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pam_assignment_1.R




@Composable
fun AvatarScreen(navController: NavController) {
    var selectedMouth by remember { mutableStateOf(R.drawable.face_0000) }
    var selectedNose by remember { mutableStateOf(R.drawable.face_0002) }
    var selectedEyes by remember { mutableStateOf(R.drawable.face_0003) }
    var selectedEyebrows by remember { mutableStateOf(R.drawable.face_0001
    ) }
    var selectedHead by remember { mutableStateOf(R.drawable.face_0004) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Avatar tampil
        Box(
            modifier = Modifier.size(500.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = selectedHead),
                contentDescription = "Head",
                modifier = Modifier.size(150.dp)
            )
            Image(
                painter = painterResource(id = selectedEyebrows),
                contentDescription = "Eyebrows",
                modifier = Modifier.fillMaxSize()
            )
            Image(
                painter = painterResource(id = selectedEyes),
                contentDescription = "Eyes",
                modifier = Modifier.fillMaxSize()
            )
            Image(
                painter = painterResource(id = selectedNose),
                contentDescription = "Nose",
                modifier = Modifier.fillMaxSize()
            )
            Image(
                painter = painterResource(id = selectedMouth),
                contentDescription = "Mouth",
                modifier = Modifier.fillMaxSize()
            )
        }

        // Tombol ganti-ganti resource
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { selectedMouth = R.drawable.face_0000 }) { Text("Mouth 1") }
            Button(onClick = { selectedMouth = R.drawable.face_0001 }) { Text("Mouth 2") }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { selectedEyes = R.drawable.face_0003 }) { Text("Eyes 1") }
            Button(onClick = { selectedEyes = R.drawable.face_0002 }) { Text("Eyes 2") }
        }
    }
}