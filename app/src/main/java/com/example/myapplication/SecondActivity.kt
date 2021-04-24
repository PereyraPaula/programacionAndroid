package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val mensajeRecibido = this.intent.getStringExtra("mensaje")
        val textView = findViewById<TextView>(R.id.textView_id).apply{
            text = "Resultado: $mensajeRecibido"
        }
    }
}