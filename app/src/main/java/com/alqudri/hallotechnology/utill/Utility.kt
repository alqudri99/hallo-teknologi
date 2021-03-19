package com.alqudri.hallotechnology.utill

import android.app.Activity
import android.content.Context
import android.icu.math.BigDecimal
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.math.BigInteger
import java.text.NumberFormat
import java.util.*

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}


fun getRupiah(value: BigInteger): String? {
    val format: NumberFormat = NumberFormat.getCurrencyInstance()
    format.setMaximumFractionDigits(0)
    format.setCurrency(Currency.getInstance("IDR"))
    return format.format(value)
}