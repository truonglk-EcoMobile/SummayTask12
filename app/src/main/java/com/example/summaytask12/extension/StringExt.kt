package com.example.summaytask12.extension

fun String?.isValidName():Boolean{
    if(this.isNullOrEmpty()){
        return false
    }else{
        val regex = Regex("^[A-Z][a-zA-Z ]*$")
        return regex.matches(this)
    }
}

fun String?.getLastName(): String{
    if (this.isNullOrEmpty()){
        return ""
    }else{
        return this.split(" ").last()
    }
}