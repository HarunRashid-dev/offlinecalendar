package com.example.offlinecalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import com.example.offlinecalendar.ui.theme.OfflineCalendarTheme
import java.time.LocalDate
import java.time.Month

fun generateCalendar(year: Int, startMonth: Int, endMonth: Int): String {
    val locale = Locale("en", "IN")
    val stringBuilder = StringBuilder()

    for (month in startMonth..endMonth) {
        val firstDayOfMonth = LocalDate.of(year, month, 1)
        val monthName = firstDayOfMonth.month.getDisplayName(TextStyle.FULL, locale)

        stringBuilder.append("Calendar for $monthName $year (India)\n")
        stringBuilder.append("$monthName\n")
        stringBuilder.append("Sun Mon Tue Wed Thu Fri Sat\n")

        val firstDayOfWeek = firstDayOfMonth.dayOfWeek.value % 7
        val daysInMonth = firstDayOfMonth.lengthOfMonth()

        // Print leading spaces
        for (i in 0 until firstDayOfWeek) {
            stringBuilder.append("")
        }
        // Print calendar days
        for (day in 1..daysInMonth) {
            stringBuilder.append(String.format("%3d", day))

            if ((day + firstDayOfWeek) % 7 == 0 || day == daysInMonth) {
                stringBuilder.append("\n")
            }
        }
        stringBuilder.append("\n\n")
    }
    return stringBuilder.toString()
}
fun main(){
val calendarText = generateCalendar(2024, 3, 12)
println(calendarText)
    }