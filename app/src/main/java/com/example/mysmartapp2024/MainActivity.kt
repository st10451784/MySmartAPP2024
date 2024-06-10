package com.example.mysmartapp2024

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val dates = ArrayList<String>()
    private val maximumScreenTimes = ArrayList<Int>()
    private val minimumScreenTimes = ArrayList<Int>()
    private val weatherCondition = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dateEditText = findViewById<EditText>(R.id.dateEditText)
        val maximumScreenTimeEditText = findViewById<EditText>(R.id.maximumScreenTimeEditText)
        val minimumScreenTimeEditText = findViewById<EditText>(R.id.minimumScreenTimeEditText)
        val weatherCondition = findViewById<EditText>(R.id.weatherConditionEditText)
        val addButton = findViewById<Button>(R.id.addButton)
        val clearButton = findViewById<Button>(R.id.clearButton)
        val viewDetailsButton = findViewById<Button>(R.id.viewDetailsButton)

        addButton.setOnClickListener {
            val date = dateEditText.text.toString()
            val maximumScreenTime = maximumScreenTimeEditText.text.toString().toIntOrNull()
            val minimumScreenTime = minimumScreenTimeEditText.text.toString().toIntOrNull()
            val weatherConditionEditText = null
            val weatherCondition = weatherConditionEditText.toString()

            if (date.isNotEmpty() && maximumScreenTime != null && minimumScreenTime != null && weatherCondition.isNotEmpty()) {
                dates.add(date)
                maximumScreenTimes.add(maximumScreenTime)
                minimumScreenTimes.add(minimumScreenTime)
                val weatherConditions = null
                weatherConditions?.append(weatherCondition)
                Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show()
                clearFields(
                    dateEditText,
                    maximumScreenTimeEditText,
                    minimumScreenTimeEditText,
                    weatherConditionEditText
                )
            } else {
                Toast.makeText(this, "please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
        //The code that is commented out below will clear all data saved in the arraylists!
        clearButton.setOnClickListener {
            //dates.clear()
            //maximumScreenTimes.clear()
            //minimumScreenTimes.clear()
            //weatherCondition.clear()
            //Toast.makeText(this, "Data Cleared", Toast.LENGTH_SHORT).show()
            clearFields(
                dateEditText,
                maximumScreenTimeEditText,
                minimumScreenTimeEditText,
                weatherConditionEditText = null
            )
        }
        viewDetailsButton.setOnClickListener {
            val intent = Intent(this, DetailedViewActivity::class.java)
            intent.putStringArrayListExtra("dates", dates)

            intent.putStringArrayListExtra("maximumScreenTimes", maximumScreenTimes)

            intent.putStringArrayListExtra("minimumScreenTimes", minimumScreenTimes)

            intent.putStringArrayListExtra("weatherCondition", weatherCondition)
            startActivity(intent)
        }
    }

    private fun clearFields(dateEditText: EditText?, maximumScreenTimeEditText: EditText?, minimumScreenTimeEditText: EditText?, weatherConditionEditText: Nothing?) {
        TODO("Not yet implemented")
    }
}

private fun Intent.putStringArrayListExtra(s: String, weatherCondition: EditText?) {

}


private fun Intent.putStringArrayListExtra(s: String, maximumScreenTimes: ArrayList<Int>) {

}
