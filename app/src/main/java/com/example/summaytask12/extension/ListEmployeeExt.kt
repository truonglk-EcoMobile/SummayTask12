package com.example.summaytask12.extension

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.summaytask12.model.employee.Employee

@RequiresApi(Build.VERSION_CODES.O)
fun List<Employee>?.totalSalaryAndBonus(): Double{
    if (this.isNullOrEmpty()){
        return 0.0
    }else{
        val tongLuong = this
            .sumOf {
                it.getSalary() + it.bonus()
            }
        return tongLuong
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun List<Employee>.highestSalaryEmployee(): Employee? {
    return this.maxByOrNull { it.getSalary() }
}
