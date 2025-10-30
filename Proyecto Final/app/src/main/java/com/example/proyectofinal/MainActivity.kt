package com.example.proyectofinal

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.button1)
        val url = "https://www.cide.es/"


        btnLogin.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            Log.d(TAG, "El valor actual de la variable es: $intent")
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        val btnVisualizar = findViewById<Button>(R.id.button2)

        btnVisualizar.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "La activity es visible")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "La activity es activa")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "La activity esta pausada")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "La activity esta pausada y no es visible")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "La activity esta destriuda")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "La activity vuelve a estar visible ")
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "La activity restaura en el instante. ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "La activity se guarda en el instante. ")
    }

}