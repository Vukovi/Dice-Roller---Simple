package com.vukdev.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // Umesto propertyja u metodi, zbog koriscenja R.id sto je skupa operacija, pravimo polje ovde
    // da bi imalo jednu inicijalizaciju
    // *** Varijanta 1 *** nije lose ali se onda proverava da li je null, pa onda dalje
//    var resultText: TextView? = null
    // *** Varijant 2 *** lateinit, obecanje (promise) da ce init sigurno biti uradjen kasnije
    lateinit var resultText: TextView
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // pre setContentView nema smisla inicijalizovati ni jedan UI jer jos nema povezanosti sa xml-om
        setContentView(R.layout.activity_main)

        resultText = findViewById(R.id.rezultujuci_text)
        imageView = findViewById(R.id.slika_kockice)

        val button: Button = findViewById(R.id.roll_button)
        button.text = "Let's roll"

        button.setOnClickListener {
            rollDice()
        }


    }

    private fun rollDice() {
        // ovo ce prikazati poruku u dnu ekrana sa unetim tekstom, nakon klika na dugme
        Toast.makeText(this,"dugme je pritisnuto", Toast.LENGTH_SHORT).show()

        val randomInt = java.util.Random().nextInt(6) + 1
        val slikaKockice = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // s obzirom da se korsiti R.id to je generalno skupa operacija i treba skolniti ovaj
        // property odavde i napraviti polje unutar klase (sa var)
//        val resultText: TextView = findViewById(R.id.rezultujuci_text)
        resultText.text = randomInt.toString()

//        val imageView: ImageView = findViewById(R.id.slika_kockice)
        imageView.setImageResource(slikaKockice)

    }
}
