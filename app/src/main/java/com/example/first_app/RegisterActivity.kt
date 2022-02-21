package com.example.first_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val registro = findViewById<Button>(R.id.btn1)
        registro.setOnClickListener {
            val nombres = findViewById<EditText>(R.id.nombres)
            val apellidos = findViewById<EditText>(R.id.apellidos)
            val usuario = findViewById<EditText>(R.id.usuario)
            val password = findViewById<EditText>(R.id.password)
            val edad = findViewById<EditText>(R.id.edad)
            val telefono = findViewById<EditText>(R.id.telefono)
            val first = nombres.text
            val last = apellidos.text
            val user = usuario.text
            val pass = password.text
            val edd = edad.text
            val phone = telefono.text
            val url = "http://192.168.1.66/veterinaria/registro.php?username=${user}&password=${pass}&nombres=${first}&apellidos=${last}&edad=${edd}&telefono=${phone}"
            var queue = Volley.newRequestQueue(this)
            val jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET, url, null,
                Response.Listener { response ->
                    Toast.makeText(this, response.getString("resultado"), Toast.LENGTH_LONG).show()
                    if (response.getString("resultado") != "Registrado") {
                        Toast.makeText(this, response.getString("resultado"), Toast.LENGTH_LONG).show()
                    }else {
                        val init = Intent(this, MainActivity::class.java)
                        startActivity(init)
                    }
                }, Response.ErrorListener { error ->
                    Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show()
                }
            )
            queue.add(jsonObjectRequest)
        }


        val imgGoogle = findViewById<ImageView>(R.id.google_register)
        imgGoogle.setOnClickListener{
            Toast.makeText(
                applicationContext,
                "Redirection a Google",
                Toast.LENGTH_LONG
            ).show()
            /*val init = Intent(this, MainActivity::class.java)
            startActivity(init)*/
        }


        val imgFacebook = findViewById<ImageView>(R.id.facebook_register)
        imgFacebook.setOnClickListener{
            Toast.makeText(
                applicationContext,
                "Redirection a Facebook",
                Toast.LENGTH_LONG
            ).show()
            /*val init = Intent(this, MainActivity::class.java)
            startActivity(init)*/
        }

    }
}