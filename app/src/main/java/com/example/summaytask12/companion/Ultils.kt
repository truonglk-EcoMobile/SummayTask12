package com.example.summaytask12.companion

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.DateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Ultils {
    companion object{
        @RequiresApi(Build.VERSION_CODES.O)
        fun formatDate(date: String): String  {
            val localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            return localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        }
    }
}