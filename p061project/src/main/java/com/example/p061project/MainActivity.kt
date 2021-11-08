package com.example.p061project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var countA = 0
        var countB = 0

        var counta = findViewById<TextView>(R.id.countA)
        var countb = findViewById<TextView>(R.id.countB)

        var a1 = findViewById<Button>(R.id.a1)
        var a2 = findViewById<Button>(R.id.a2)
        var a3 = findViewById<Button>(R.id.a3)
        var b1 = findViewById<Button>(R.id.b1)
        var b2 = findViewById<Button>(R.id.b2)
        var b3 = findViewById<Button>(R.id.b3)

        var reset = findViewById<Button>(R.id.reset)

        a1.setOnClickListener{
            countA +=1
            counta.text = countA.toString()
        }
        a2.setOnClickListener {
            countA+=2
            counta.text = countA.toString()
        }
        a3.setOnClickListener {
            countA +=3
            counta.text = countA.toString()
        }
        b1.setOnClickListener{
            countB +=1
            countb.text = countB.toString()
        }
        b2.setOnClickListener {
            countB+=2
            countb.text = countB.toString()
        }
        b3.setOnClickListener {
            countB +=3
            countb.text = countB.toString()
        }

        reset.setOnClickListener {
            countA = 0
            counta.text = countA.toString()
            countB = 0
            countb.text = countB.toString()
        }

    }
}