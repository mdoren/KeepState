package com.example.keepstate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import com.google.android.material.chip.Chip

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var textInfo: TextView
    lateinit var chip: Chip
    lateinit var radioButton: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById<Button>(R.id.button)
        textInfo = findViewById<TextView>(R.id.textView)
        chip = findViewById<Chip>(R.id.chip4)
        radioButton = findViewById<RadioButton>(R.id.radioButton)

        button.setOnClickListener {
            textInfo.setText("I have been clicked")
        }

        chip.setOnClickListener {
            textInfo.setText("I have been checked")
        }

        radioButton.setOnClickListener {
            textInfo.setText("I have been pressed")
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("saved_text", textInfo.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textInfo.setText(savedInstanceState.getString("saved_text"))
    }

}
