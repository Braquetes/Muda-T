package com.example.first_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.first_app.ui.login.LoginActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(2000)

        setTheme(R.style.Theme_First_App)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val boton1 = findViewById<Button>(R.id.btn1)
        boton1.setOnClickListener{
            val init = Intent(this, LoginActivity::class.java)
            startActivity(init)
        }

        val boton2 = findViewById<Button>(R.id.btn2)
        boton2.setOnClickListener{
            val init = Intent(this, RegisterActivity::class.java)
            startActivity(init)
        }

    }
}