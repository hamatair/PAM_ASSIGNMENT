// file: RegisterController.kt
package com.example.pam_assignment_1.controller

class RegisterController {
    fun register(username: String, email: String, password: String, confirmPassword: String): String {
        if (username.isBlank() || email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
            return "Semua field harus diisi"
        }

        if (!email.contains("@")) {
            return "Email tidak valid"
        }

        if (password.length < 6) {
            return "Password minimal 6 karakter"
        }

        if (password != confirmPassword) {
            return "Password tidak sama"
        }

        return "Registrasi berhasil"
    }
}
