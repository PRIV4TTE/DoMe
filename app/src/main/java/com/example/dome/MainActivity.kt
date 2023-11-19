package com.example.dome

import android.os.Bundle
import android.widget.Toast
import android.widget.ImageButton
import android.widget.TextView
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var titleTextView: TextView
    private lateinit var itemTextView: TextView
    private lateinit var itemCheckBox: CheckBox

    private lateinit var backButton: ImageButton
    private lateinit var alarmButton: ImageButton
    private lateinit var settingsButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item)

        // Obtener referencias a los elementos de la interfaz
        titleTextView = findViewById<TextView>(R.id.titleTextView)
        itemTextView = findViewById<TextView>(R.id.taskEditText)
        itemCheckBox = findViewById<CheckBox>(R.id.itemCheckBox)

        backButton = findViewById<ImageButton>(R.id.backButton)
        alarmButton = findViewById<ImageButton>(R.id.alarmButton)
        settingsButton = findViewById<ImageButton>(R.id.settingsButton)

        // Establecer los textos y el estado del CheckBox
        titleTextView.text = "DoMe"
        itemCheckBox.isChecked = false

        // Configurar el botón de retroceso
        backButton.setOnClickListener {
            onBackPressed() // Llama al método onBackPressed para simular el botón de retroceso
        }

        alarmButton.setOnClickListener {
            showAlarmMessage()
        }

        settingsButton.setOnClickListener {
            // Lógica para el botón de configuraciones
        }

        // agregar más lógica a tu aplicación
    }

    // Manejo del botón de retroceso de la actividad
    override fun onBackPressed() {
        finish()
        super.onBackPressed() // Llama a la implementación predeterminada de onBackPressed si es necesario
    }

        private fun showAlarmMessage() {
            // Por ejemplo, mostrar un Toast sencillo
            Toast.makeText(this, "¡Alarma configurada!", Toast.LENGTH_SHORT).show()
        }
    }

