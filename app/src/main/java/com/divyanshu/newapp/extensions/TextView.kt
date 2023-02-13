package com.divyanshu.newapp.extensions

import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

val isoDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
val appDateFromat = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())

//fun TextView.showFormattedDate(timestamp: String) {
//
//  val date = isoDateFormat.parse(timestamp)
//  text = appDateFromat.format(date)
//}

var TextView.timestamp: String
  set(value) {
    val date = isoDateFormat.parse(value)
  }
  get() {
    val date = appDateFromat.parse(text.toString())
    return isoDateFormat.format(date)
  }