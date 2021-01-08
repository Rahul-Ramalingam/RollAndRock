package com.example.diceit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

/**main activity is the one which is executed when the app starts
 * oncreate renders the viewgroups on the screen
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        rollDice()
    }

    private fun rollDice() {
        //val resultTextView: TextView = findViewById(R.id.textView)
        //resultTextView.text = newDice.roll().toString()
        val newDice = Dice(6)
        val roll1 = newDice.roll()
        val roll2 = newDice.roll()
        val diceImage1: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)
        var drawables1 = when (roll1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        var drawables2 = when (roll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage1.setImageResource(drawables1)
        diceImage2.setImageResource(drawables2)
        diceImage1.contentDescription = roll1.toString()
        diceImage2.contentDescription = roll2.toString()
        Toast.makeText(this, "Dice Rolled!!", Toast.LENGTH_SHORT).show()

    }
}

class Dice(private val num: Int) {
    fun roll(): Int {
        return (1..num).random()
    }
}