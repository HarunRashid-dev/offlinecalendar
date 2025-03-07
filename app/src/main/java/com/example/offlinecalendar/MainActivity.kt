import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

fun generateCalendar(year: Int, startMonth: Int, endMonth: Int): String {
    val locale = Locale("en", "IN") // Fix applied
    val stringBuilder = StringBuilder()

    for (month in startMonth..endMonth) {
        val firstDayOfMonth = LocalDate.of(year, month, 1)
        val monthName = firstDayOfMonth.month.getDisplayName(TextStyle.FULL, locale)

        stringBuilder.append("Calendar for $monthName $year (India)\n")
        stringBuilder.append("$monthName\n")
        stringBuilder.append("Sun Mon Tue Wed Thu Fri Sat\n")

        val firstDayOfWeek = firstDayOfMonth.dayOfWeek.value % 7 // Convert to Sunday start index
        val daysInMonth = firstDayOfMonth.lengthOfMonth()

        // Print leading spaces
        for (i in 0 until firstDayOfWeek) {
            stringBuilder.append("    ")
        }

        // Print calendar days
        for (day in 1..daysInMonth) {
            stringBuilder.append(String.format("%3d ", day))

            if ((day + firstDayOfWeek) % 7 == 0 || day == daysInMonth) {
                stringBuilder.append("\n")
            }
        }
        stringBuilder.append("\n\n")
    }
    return stringBuilder.toString()
}

fun main() {
    val calendarText = generateCalendar(2024, 3, 12)
    println(calendarText)
}
