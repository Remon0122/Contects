package com.example.contects.activities.Splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.contects.activities.contacts.ActivityContact
import com.example.contects.databinding.ActivityMainBinding

class SplashScreen : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper())
            .postDelayed({
                StartApp()
            },3000)
    }

    private fun StartApp() {
        val intent = Intent(this, ActivityContact::class.java)
        startActivity(intent)
        finish()
    }

}