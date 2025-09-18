package com.example.summaytask12.model.employee

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.summaytask12.model.enumclass.Position

@RequiresApi(Build.VERSION_CODES.O)
class Intern(
    fullName: String?,
    position: Position = Position.INTERN,
    joinDate: String,
    salary: Double? = 2000.0,
    var school: String = "Unknown",
    var internshipDuration: Int = 3
) : Employee(fullName, position, joinDate, salary) {

    override fun bonus(): Double {
        return 0.0
    }

    fun requestTraining(topic: String): String {
        return "Intern $name yêu cầu đào tạo về: $topic"
    }

    override fun toString(): String {
        return super.toString() + ", school='$school', internshipDuration=${internshipDuration} tháng"
    }
}
