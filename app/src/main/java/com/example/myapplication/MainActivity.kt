package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var textView: TextView? = null
    private var editTextData: EditText? = null
    private var buttonMostrar: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById<TextView>(R.id.textView_id)
        editTextData = findViewById<EditText>(R.id.editText_id)
        buttonMostrar = findViewById<Button>(R.id.button_id)

        buttonMostrar?.setOnClickListener(View.OnClickListener{
            val texto = editTextData!!.text
            textView!!.setText(texto)
        })

    }

}
