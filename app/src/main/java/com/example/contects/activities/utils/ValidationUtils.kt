package com.example.contects.activities.utils

import android.util.Patterns

object ValidationUtils {
    fun validateName(name: String): String? {
        if (name.isBlank()) {
            return "isRequired"
        }
        if (!name.all { it.isLetter() }) {
            return "name should only contain letters"
        }
        return null
    }

    fun validateEmail(email: String): String? {
        if (email.isBlank()) {
            return "isRequired"
        }
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return "inValid Email Format"
        }
        return null
    }
    fun validatePhone(phone:String): String?{
        if (phone.isBlank()){
            return "isRequired"
        }

        return null
    }

}