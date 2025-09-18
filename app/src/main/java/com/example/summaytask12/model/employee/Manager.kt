package com.example.summaytask12.model.employee

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.summaytask12.model.enumclass.Position

@RequiresApi(Build.VERSION_CODES.O)
class Manager(
    fullName:String?,
    position: Position = Position.TRUONG_PHONG,
    joinDate: String,
    salary: Double?,
    var teamSize:Int?
): Employee(fullName,position,joinDate,salary) {
    override fun bonus(): Double {
        val bonus = position.tyLeBonus.times(salary?:0.0)
        val teamBonus = teamSize?.times(100.0)?:0.0
        return bonus.plus(teamBonus)
    }

    override fun toString(): String {
        return super.toString() + " ,teamSize=$teamSize"
    }
}