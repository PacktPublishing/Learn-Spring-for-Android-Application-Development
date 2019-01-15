package com.sunnat629.clientside.util

import android.content.Context
import android.text.format.DateFormat
import android.text.format.DateUtils
import android.text.format.DateFormat.getTimeFormat
import com.sunnat629.clientside.R
import java.util.*


class UIHelper {

    private val SHORT_DATE_FLAGS = (DateUtils.FORMAT_SHOW_DATE
            or DateUtils.FORMAT_NO_YEAR or DateUtils.FORMAT_ABBREV_ALL)
    private val FULL_DATE_FLAGS = (DateUtils.FORMAT_SHOW_TIME
            or DateUtils.FORMAT_ABBREV_ALL or DateUtils.FORMAT_SHOW_DATE)

    fun readableTimeDifference(context: Context, time: Long): String {
        return readableTimeDifference(context, time, false)
    }

    fun readableTimeDifferenceFull(context: Context, time: Long): String {
        return readableTimeDifference(context, time, true)
    }

    private fun readableTimeDifference(
        context: Context, time: Long,
        fullDate: Boolean
    ): String {
        if (time == 0L) {
            return context.getString(R.string.just_now)
        }
        val date = Date(time)
        val difference = (System.currentTimeMillis() - time) / 1000
        if (difference < 60) {
            return context.getString(R.string.just_now)
        } else if (difference < 60 * 2) {
            return context.getString(R.string.minute_ago)
        } else if (difference < 60 * 15) {
            return context.getString(R.string.minutes_ago, Math.round(difference / 60.0))
        } else if (today(date)) {
            val df = DateFormat.getTimeFormat(context)
            return df.format(date)
        } else {
            return if (fullDate) {
                DateUtils.formatDateTime(
                    context, date.time,
                    FULL_DATE_FLAGS
                )
            } else {
                DateUtils.formatDateTime(
                    context, date.time,
                    SHORT_DATE_FLAGS
                )
            }
        }
    }

    private fun today(date: Date): Boolean {
        return sameDay(date, Date(System.currentTimeMillis()))
    }

    fun today(date: Long): Boolean {
        return sameDay(date, System.currentTimeMillis())
    }

    fun yesterday(date: Long): Boolean {
        val cal1 = Calendar.getInstance()
        val cal2 = Calendar.getInstance()
        cal1.add(Calendar.DAY_OF_YEAR, -1)
        cal2.time = Date(date)
        return cal1.get(Calendar.YEAR) === cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR) === cal2
            .get(Calendar.DAY_OF_YEAR)
    }

    fun sameDay(a: Long, b: Long): Boolean {
        return sameDay(Date(a), Date(b))
    }

    private fun sameDay(a: Date, b: Date): Boolean {
        val cal1 = Calendar.getInstance()
        val cal2 = Calendar.getInstance()
        cal1.time = a
        cal2.time = b
        return cal1.get(Calendar.YEAR) === cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR) === cal2
            .get(Calendar.DAY_OF_YEAR)
    }
}