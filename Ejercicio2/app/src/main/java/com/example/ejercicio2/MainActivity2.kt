package com.example.ejercicio2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btnCancelar = findViewById<Button>(R.id.btnCancelar)
        val btnConfirmar = findViewById<Button>(R.id.btnConfirmar)

        val infoDias = intent.getIntExtra("pDias", 0)
        val infoSemanas = intent.getIntExtra("pSemanas", 0)

        val dias = findViewById<TextView>(R.id.dias)
        dias.text = infoDias.toString()
        val semanas = findViewById<TextView>(R.id.semanas)
        semanas.text = infoSemanas.toString()

        btnCancelar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            setResult(RESULT_CANCELED)
            startActivity(intent)
        }

        btnConfirmar.setOnClickListener {

            val totalDias = infoDias * infoSemanas

            val reslutadoDias = "Dias totales: ${dias.text}"
            val resultadoSemanas = "Semanas totales: ${semanas.text}"
            val  resultadoTotal = "Dias totales: $totalDias"

            val returnIntent = Intent()
            returnIntent.putExtra("pDiasFinales", reslutadoDias)
            returnIntent.putExtra("pSemanasFinales", resultadoSemanas)
            returnIntent.putExtra("pTotalDias", resultadoTotal)
            setResult(RESULT_OK, returnIntent)
            finish()
        }

    }
}