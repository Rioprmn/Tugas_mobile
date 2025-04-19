package com.example.input_control

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var btnPickDate: Button
    private lateinit var btnPickTime: Button
    private lateinit var txtSelectedDate: TextView
    private lateinit var txtSelectedTime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPickDate = findViewById(R.id.btnPickdate)
        btnPickTime = findViewById(R.id.btnPickTime)
        txtSelectedDate = findViewById(R.id.txtSelectedDate) // Menyambungkan ke TextView
        txtSelectedTime = findViewById(R.id.txtSelectedTime) // Menyambungkan ke TextView

        // Tanggal
        btnPickDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    txtSelectedDate.text = getString(R.string.date_selected, date) // Update TextView
                },
                year, month, day
            )
            datePickerDialog.show()
        }

        // Waktu
        btnPickTime.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(this,
                { _, selectedHour, selectedMinute ->
                    val time = String.format("%02d:%02d", selectedHour, selectedMinute)
                    txtSelectedTime.text = getString(R.string.time_selected, time) // Update TextView
                },
                hour, minute, true
            )
            timePickerDialog.show()
        }
    }
}