package com.example.summaytask12.model.employee

open class BaseEmployee(val id: Int, val name:String?) {
    open fun bonus(): Double = 0.0
}