package com.example.summaytask12.model.employee

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.summaytask12.companion.Ultils
import com.example.summaytask12.model.enumclass.Position
import java.time.LocalDate
import java.time.Period
import java.util.Random

@RequiresApi(Build.VERSION_CODES.O)
class Employee(
    name: String?,
    var position: Position,
    var joinDate: String,
    private var salary: Double?
) : BaseEmployee(Random().nextInt(10000), name) {
    override fun bonus(): Double = salary?.times(0.1) ?: 0.0
    constructor(name: String?, position: Position) : this(name, position, LocalDate.now().toString(),6000.0)

    fun thamNien(): String {
        val ngayHienTai = LocalDate.now()
        val period = Period.between(LocalDate.parse(joinDate), ngayHienTai)
        return "${period.years}-${period.months}-${period.days}"
    }
    fun getSalary(): Double = this.salary?:0.0
    fun setSlary(salary: Double?){
        if(salary!=null&&salary>=0.0){
            this.salary=salary
        }else{
            throw Exception("Lương không hợp lệ")
        }
    }

    override fun toString(): String {
        return "Employee(name=$name ,position=${position.displayName}, joinDate='${Ultils.formatDate(joinDate)}', salary=$salary)"
    }


}