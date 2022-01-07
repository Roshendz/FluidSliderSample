package com.roshendilan.fluidslidersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dailyIntakes = "0"
        val max = 1500
        val min = 0
        val total = max - min

        fsCaloriesIntake.startText ="$min"
        fsCaloriesIntake.endText = "$max"
        fsCaloriesIntake.position = 0.0f

        fsCaloriesIntake.beginTrackingListener = {
            Toast.makeText(applicationContext, "Started dragging $dailyIntakes", Toast.LENGTH_SHORT).show()
        }

        fsCaloriesIntake.endTrackingListener = {
            Toast.makeText(applicationContext, "Ended dragging $dailyIntakes", Toast.LENGTH_SHORT).show()
        }

        fsCaloriesIntake.positionListener = {
                pos -> fsCaloriesIntake.bubbleText = "${ min + (total * pos).toInt()}".also {  dailyIntakes = it.toString() }
        }

        btnAddCalories.setOnClickListener {
            Toast.makeText(this, "Your daily calorie intake is $dailyIntakes", Toast.LENGTH_LONG).show()
        }
    }
}