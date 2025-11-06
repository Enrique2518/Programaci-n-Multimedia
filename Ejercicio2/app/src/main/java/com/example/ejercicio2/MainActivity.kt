package com.example.ejercicio2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var resultadoLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCrearPla = findViewById<Button>(R.id.btnCrearPla)
        val numeroDias = findViewById<EditText>(R.id.numeroDias)
        val numeroSemanas = findViewById<EditText>(R.id.numeroSemanas)
        val infoResumen = findViewById<TextView>(R.id.infoResumen)

        resultadoLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val datos = result.data
                val mensaje1 = datos?.getStringExtra("pDiasFinales")
                val mensaje2 = datos?.getStringExtra("pSemanasFinales")
                val mesnaje3 = datos?.getStringExtra("pTotalDias")

                infoResumen.text = "$mensaje1 \n$mensaje2 \n$mesnaje3"
            }

        }

        btnCrearPla.setOnClickListener {

            val numDias = numeroDias.text.toString();
            val numSemanas = numeroSemanas.text.toString();

            if (numDias.isEmpty() || numSemanas.isEmpty()){
                infoResumen.text = "Hay una o varias casillas vacias"
            }else{
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("pDias", numeroDias.text.toString().toInt())
                //text.toString.toInt
                intent.putExtra("pSemanas", numeroSemanas.text.toString().toInt())
                //startActivity(intent)
                //Iniciamos el launcher donde nos devolvera los datos de lo que hemos introducido anteriormente
                //y espera a que nos devuelva datos, porque se queda escuchando, es un escuchador.
                resultadoLauncher.launch(intent)
            }
        }

    }

}