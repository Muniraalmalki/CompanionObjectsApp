package com.example.companionobjectsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val input = findViewById<EditText>(R.id.etDayOrNight)
        val changeBGButton = findViewById<Button>(R.id.changeBGButton)
        val constraint = findViewById<ConstraintLayout>(R.id.constraint)

        changeBGButton.setOnClickListener {
            val text = input.text.toString()
            if (text.isNotEmpty()){
                if (text == "Day" || text == "day"){
                    DayOrNight.day = true
                    DayOrNight.night = false
                    Background.changeBackground(constraint)
                }
                else if (text == "Night" || text == "night"){
                    DayOrNight.day = false
                    DayOrNight.night = true
                    Background.changeBackground(constraint)
                }
                else{
                    Toast.makeText(this,"Make sure you Day or Night",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
class Background{
    companion object{
        var day = false
        var night = false
        fun changeBackground(bgconstraintLayout: ConstraintLayout){
            if (DayOrNight.day){
               bgconstraintLayout.setBackgroundResource(R.drawable.day)
            }
            else{
                bgconstraintLayout.setBackgroundResource(R.drawable.night)
            }
        }
    }
}
class DayOrNight{
    companion object {
        var day = false
        var night = false
    }
}