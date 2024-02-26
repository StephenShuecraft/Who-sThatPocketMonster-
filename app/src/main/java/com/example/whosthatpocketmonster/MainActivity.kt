package com.example.whosthatpocketmonster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import kotlin.random.Random
import android.view.View
import android.widget.TextView
import android.widget.Toast

var score = 0

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rad1 = findViewById<RadioButton>(R.id.radioButton)
        val rad2 = findViewById<RadioButton>(R.id.radioButton2)
        val rad3 = findViewById<RadioButton>(R.id.radioButton3)
        val rad4 = findViewById<RadioButton>(R.id.radioButton4)
        val radioButtons = listOf(rad1, rad2, rad3, rad4)

        radioButtons.forEach { radioButton ->
            radioButton.setOnClickListener {
                radioButtons.forEach { rb ->
                    if (rb != radioButton) rb.isChecked = false
                }
            }
        }

        val imag1 = findViewById<ImageView>(R.id.imageView)
        val imag2 = findViewById<ImageView>(R.id.imageView2)
        val scoreText = findViewById<TextView>(R.id.score)
        val but1 = findViewById<Button>(R.id.button)
        val but2 = findViewById<Button>(R.id.button2)

        fun theWholeThing() {
            val pokName = arrayOf("Ekans", "Golbat", "Psyduck", "Sandshrew", "nothing")
            val randomNum = Random.nextInt(0, 4)

            if (randomNum == 0) {
                imag1.setImageResource(R.drawable.ekanssil)
                imag2.setImageResource(R.drawable.ekans)
            } else if (randomNum == 1) {
                imag1.setImageResource(R.drawable.golbatsil)
                imag2.setImageResource(R.drawable.golbat)
            } else if (randomNum == 2) {
                imag1.setImageResource(R.drawable.psyducksil)
                imag2.setImageResource(R.drawable.psyduck)
            } else {
                imag1.setImageResource(R.drawable.sandshrewsil)
                imag2.setImageResource(R.drawable.sandshrew)
            }

            rad1.text = pokName[0]
            rad2.text = pokName[1]
            rad3.text = pokName[2]
            rad4.text = pokName[3]

            but1.setOnClickListener {
                val selectedRadioButton = radioButtons.firstOrNull { it.isChecked }

                if (selectedRadioButton == null) {
                    Toast.makeText(this, "Please pick an answer.", Toast.LENGTH_SHORT).show()
                } else {

                    val answer = when (selectedRadioButton) {
                        rad1 -> 0
                        rad2 -> 1
                        rad3 -> 2
                        rad4 -> 3
                        else -> 4
                    }

                    imag1.visibility = View.INVISIBLE
                    if (pokName[answer] == pokName[randomNum]) {
                        score += 1
                    } else {
                        score -= 1
                        Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
                    }
                    scoreText.text = "score = $score"
                    but1.visibility = View.INVISIBLE
                    but2.visibility = View.VISIBLE
                    radioButtons.forEach { it.isChecked = false }
                }
            }

            but2.setOnClickListener {
                but1.visibility = View.VISIBLE
                but2.visibility = View.INVISIBLE
                imag1.visibility = View.VISIBLE
                theWholeThing()
            }
        }

        theWholeThing()
    }
}
