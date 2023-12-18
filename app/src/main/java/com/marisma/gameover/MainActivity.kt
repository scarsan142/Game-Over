package com.marisma.gameover

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // intent para detectar si se ha pulsado salir
        if (intent.getBooleanExtra("Exit", false)) {
            finish()
        }

        // enlace al boton e incorporacion del evento click
        val btnCredits = findViewById<Button>(R.id.btnCredits)
        btnCredits.setOnClickListener {
            goToElection()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity() // Cierra la actividad actual y todas las actividades relacionadas
    }

    fun goToElection() {
        // crear el intent
        val intent = Intent(this@MainActivity, CreditActivity::class.java)
        // tomar el valor del cuadro de texto
        val etUser = this.findViewById<EditText>(R.id.etUser)
        // añadir la informacion necesaria al intent
        intent.putExtra("Name", etUser.text.toString())

        // Iniciar la actividad
        startActivity(intent)
    }
}
