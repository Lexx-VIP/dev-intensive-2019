package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR


fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND) : Date{
    var time = this.time

    time +=when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date:Date = Date(), date2:Date = Date()): String {
    // Get the date in milliseconds
    val millis1: Long = date.time
    val millis2: Long = date2.time

    // Calculate difference in milliseconds
    val diff = millis2 - millis1

    val seconds = diff /1000
    val minutes = diff / (60 * 1000)
    val hours = minutes / 60
    val days = hours / 24

    val humanize = if (seconds <= 1) {
        "только что"
    } else if (seconds <= 45) {
        "несколько секунд назад"
    } else if (seconds <= 75) {
        "минуту назад"
    } else if (minutes <= 45) {
        "$minutes минут назад"
    } else if (minutes <= 75) {
        "час назад"
    } else if (hours <= 22) {
        "$hours часов назад"
    } else if (hours <= 26) {
        "день назад"
    } else if (days <= 360) {
        "$days дней назад"
    } else {
        "более года назад"
    }

    return humanize
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}