package com.example.dome

import android.graphics.Color
import android.os.Bundle
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.graphics.Typeface
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {

    private lateinit var tasksContainer: LinearLayout
    private lateinit var addTaskButton: FloatingActionButton
    private lateinit var titleTextView: TextView
    private lateinit var itemTextView: EditText
    private lateinit var itemCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item)

        addTaskButton = findViewById(R.id.addTaskButton)
        titleTextView = findViewById(R.id.titleTextView)
        itemTextView = findViewById(R.id.taskEditText)
        itemCheckBox = findViewById(R.id.itemCheckBox)
        tasksContainer = findViewById(R.id.tasksContainer)

        val itemTextView: EditText = findViewById(R.id.taskEditText)

        // Carga la fuente personalizada desde los recursos
        val typeface: Typeface? = ResourcesCompat.getFont(this, R.font.montserrat_regular)

        // Verifica si la fuente se cargó correctamente y establece la fuente en el EditText
        if (typeface != null) {
            itemTextView.typeface = typeface
        }

        addTaskButton.setOnClickListener {
            agregarNuevaTarea()
        }

        titleTextView.text = "DoMe"
        itemCheckBox.isChecked = false

        val backButton: ImageButton = findViewById(R.id.backButton)
        val alarmButton: ImageButton = findViewById(R.id.alarmButton)
        val settingsButton: ImageButton = findViewById(R.id.settingsButton)

        backButton.setOnClickListener {
            onBackPressed()
        }

        alarmButton.setOnClickListener {
            showAlarmMessage()
        }

        settingsButton.setOnClickListener {
            // Lógica para el botón de configuraciones
        }
    }
    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }

    private fun showAlarmMessage() {
        Toast.makeText(this, "¡Alarma configurada!", Toast.LENGTH_SHORT).show()
    }

    private fun agregarNuevaTarea() {
        val tarea = itemTextView.text.toString().trim()

        if (tarea.isNotEmpty()) {
            val nuevaTareaLayout = LinearLayout(this)
            nuevaTareaLayout.orientation = LinearLayout.HORIZONTAL

            val nuevaTareaEditText = EditText(this)
            nuevaTareaEditText.layoutParams =
                LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f)
            nuevaTareaEditText.hint = "Tarea"
            nuevaTareaEditText.textSize = 18f
            nuevaTareaEditText.setPadding(14, 14, 14, 14)
            nuevaTareaEditText.setBackgroundColor(Color.TRANSPARENT)
            nuevaTareaEditText.text = Editable.Factory.getInstance().newEditable(tarea)

            val nuevaCheckBox = CheckBox(this)
            nuevaCheckBox.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            nuevaTareaLayout.addView(nuevaTareaEditText)
            nuevaTareaLayout.addView(nuevaCheckBox)

            tasksContainer.addView(nuevaTareaLayout)
            itemTextView.text.clear()
        } else {
            Toast.makeText(this, "Ingrese una tarea", Toast.LENGTH_SHORT).show()
        }
    }

}











