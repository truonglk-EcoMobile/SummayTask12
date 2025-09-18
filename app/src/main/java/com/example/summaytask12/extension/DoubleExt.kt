package com.example.summaytask12.extension

import java.text.NumberFormat
import java.util.Locale

fun Double?.toVND(): String{
    if (this==null){
        return "0 ₫"
    }else{
        val formater = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"))
        return formater.format(this)
    }
}