package com.example.mysmartapp2024

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailedViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)
        val dates = intent.getStringArrayListExtra("dates")?: arrayListOf()
        val maximumScreenTimes = intent.getIntegerArrayListExtra("maximumScreenTimes")?: arrayListOf()
        val minimumScreenTimes = intent.getIntegerArrayListExtra("minimumScreenTimes")?: arrayListOf()
        val weatherCondition = intent.getStringArrayListExtra("weatherCondition")?: arrayListOf()

        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
        val averageScreenTimeTextView = findViewById<TextView>(R.id.averageScreenTimeTextView)
        val backButton = findViewById<Button>(R.id.backButton)

        var totalScreenTime = 0
        val i = 0
        var displayText = "" (i in dates.indices){
            val dailyScreenTimes = maximumScreenTimes[i]+minimumScreenTimes[i]
            totalScreenTime += dailyScreenTimes
            var displayText = "Date:${dates[i]}, maximum:${maximumScreenTimes[i]} degrees, minimum:${minimumScreenTimes} degrees, weatherCondition${weatherCondition[i]}\n\n"
        }
        val averageScreenTime = if (dates.isNotEmpty()) totalScreenTime / dates.size else 0

        detailsTextView.text = displayText.toString()
        averageScreenTimeTextView.text = "Average Screen Time: $averageScreenTime degrees/day"

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

private operator fun String.invoke(b: Boolean, function: () -> Unit) {

}
