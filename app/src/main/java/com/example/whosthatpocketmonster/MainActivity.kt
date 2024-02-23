package com.example.whosthatpocketmonster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import kotlin.random.Random
import android.content.Context
import android.view.View
import android.widget.TextView
import android.widget.Toast

var score = 0
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rad1 =  findViewById(R.id.radioButton) as RadioButton
        val rad2 =  findViewById(R.id.radioButton2) as RadioButton
        val rad3 =  findViewById(R.id.radioButton3) as RadioButton
        val rad4 =  findViewById(R.id.radioButton4) as RadioButton

        val imag1 = findViewById<ImageView>(R.id.imageView)
        val imag2 = findViewById<ImageView>(R.id.imageView2)

        val scoreText = findViewById<TextView>(R.id.score)

        val but1 = findViewById<Button>(R.id.button)
        val but2 = findViewById<Button>(R.id.button2)



    fun theWholeThing(){
        val pokName = arrayOf("Ekans", "Golbat", "Psyduck", "Sandshrew", "nothing" )

        val randomNum = Random.nextInt(0, 4)


        var answer = 0
        if (randomNum == 0){
            imag1.setImageResource(R.drawable.ekanssil)
            imag2.setImageResource(R.drawable.ekans)
        }else if (randomNum == 1){
            imag1.setImageResource(R.drawable.golbatsil)
            imag2.setImageResource(R.drawable.golbat)
        }else if (randomNum == 2){
            imag1.setImageResource(R.drawable.psyducksil)
            imag2.setImageResource(R.drawable.psyduck)
        }else{
            imag1.setImageResource(R.drawable.sandshrewsil)
            imag2.setImageResource(R.drawable.sandshrew)
        }

        rad1.setText(pokName[0])
        rad2.setText(pokName[1])
        rad3.setText(pokName[2])
        rad4.setText(pokName[3])

        rad1.setOnClickListener {
            rad2.isChecked = false
            rad3.isChecked = false
            rad4.isChecked = false
        }
        rad2.setOnClickListener {
            rad1.isChecked = false
            rad3.isChecked = false
            rad4.isChecked = false
        }
        rad3.setOnClickListener {
            rad2.isChecked = false
            rad1.isChecked = false
            rad4.isChecked = false
        }
        rad4.setOnClickListener {
            rad2.isChecked = false
            rad3.isChecked = false
            rad1.isChecked = false
        }
        but1.setOnClickListener {
            imag1.visibility = View.INVISIBLE
            if(rad1.isChecked){
            answer = 0
            }else if (rad2.isChecked){
                answer = 1
            }else if (rad3.isChecked){
                answer = 2
            }else if (rad4.isChecked){
                answer = 3
            }else{
                answer = 4
            }
            if (pokName[answer] == pokName[randomNum]) {
                score += 1
                scoreText.setText("score = $score")
            } else {
                val message = "You suck!!!!!!"
                val duration = Toast.LENGTH_SHORT

                Toast.makeText(this, message, duration).show()
            }

            but1.visibility = View.INVISIBLE
            but2.visibility = View.VISIBLE
            rad1.isChecked = false
            rad2.isChecked = false
            rad3.isChecked = false
            rad4.isChecked = false

        }}
        but2.setOnClickListener{
            but1.visibility = View.VISIBLE
            but2.visibility = View.INVISIBLE
            imag1.visibility = View.VISIBLE
            theWholeThing()


        }
        theWholeThing()


    }
}