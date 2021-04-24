package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

const val EXTRA_MESSAGE = "com.example.myapplication.MESSAGE"

class MainActivity : AppCompatActivity() {
    private var btnMostrar: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMostrar = findViewById<Button>(R.id.button_id)
        btnMostrar?.setOnClickListener(View.OnClickListener {
            sendMessage()
        })
    }

    fun sendMessage() {
        val editText = findViewById<EditText>(R.id.editText_id)
        val mensaje = editText.text.toString()
        val intento = Intent(this,SecondActivity::class.java)
        intento.putExtra("mensaje", mensaje)
        startActivity(intento)
    }

}
