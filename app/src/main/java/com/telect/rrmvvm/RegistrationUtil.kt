package com.telect.rrmvvm

object RegistrationUtil {
    fun validateUser(nameName: String, password: String, confirmPassword: String): Boolean {
        val existingUser = listOf("Kshitiz", "Ram")

        if (nameName.isEmpty() || password.isEmpty()) {
            return false
        }
        if (existingUser.contains(nameName)) {
            return false
        }
        if (password != confirmPassword) {
            return false
        }
        if (password.count { it.isDigit() } < 2) {
            return false
        }

        return true
    }


}