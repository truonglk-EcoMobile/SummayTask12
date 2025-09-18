package com.example.summaytask12.model.employee

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.summaytask12.companion.Ultils
import com.example.summaytask12.extension.getLastName
import com.example.summaytask12.extension.isValidName
import com.example.summaytask12.extension.toVND
import com.example.summaytask12.model.enumclass.Position
import java.time.LocalDate
import java.time.Period

@RequiresApi(Build.VERSION_CODES.O)
open class Employee(
    val fullName: String?,
    var position: Position,
    var joinDate: String,
    protected var salary: Double?
) : BaseEmployee(Ultils.generatedId(), fullName) {
    override fun bonus(): Double{
        val tyLeBonus = position.tyLeBonus
        return salary?.times(tyLeBonus)?:0.0
    }
    constructor(name: String?, position: Position) : this(name, position, LocalDate.now().toString(),6000.0)

    init {
        if(!fullName.isValidName()){
            throw Exception("Tên không hợp lệ $fullName")
        }
    }

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
        return "Employee(id=$id name=${name.getLastName()} ,position=${position.displayName}, joinDate='${Ultils.formatDate(joinDate)}', salary=${salary.toVND()}, bonus = ${bonus().toVND()})"
    }


}