package com.example.tp1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val EXTRA_TEXT = "text_to_display"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.secondary)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val firstButton = findViewById<Button>(R.id.button)
        val editText= findViewById<EditText>(R.id.editText)
        val textView = findViewById<TextView>(R.id.textView)
        val layoutPrincipal = findViewById<ConstraintLayout>(R.id.secondary)
        val deuxiemeTextView = TextView(this)
        val secondButton = findViewById<Button>(R.id.button2)

        firstButton.setOnClickListener {
            if (editText.text.toString()=="afficher nouveau TextView"){
                deuxiemeTextView.text=editText.text.toString()
                layoutPrincipal.addView(deuxiemeTextView)

            }
            else{textView.text = editText.text.toString()}
        }
        secondButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra(EXTRA_TEXT, textView.text.toString())
            startActivity(intent)
        }



    }
}