package com.example.summaytask12.singleton

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.summaytask12.model.employee.Employee
import com.example.summaytask12.model.enumclass.Position
@RequiresApi(Build.VERSION_CODES.O)
object EmployeeData{
    val employees = mutableListOf<Employee>(
        Employee("Nhan vien 1", Position.TRUONG_PHONG, "2022-11-01", 10000.0),
        Employee("Nhan vien 2", Position.ANDROID_DEV, "2024-07-01", 8000.0),
        Employee("Nhan vien 3", Position.IOS_DEV, "2021-12-09", 7000.0),
        Employee("Nhan vien 4", Position.QA, "2023-04-01", 6000.0),
        Employee("Nhan vien 5", Position.MKT, "2023-05-01", 5000.0),
        Employee("Nhan vien 6", Position.PM, "2023-06-01", 4000.0),
        Employee("Nhan vien 7", Position.ANDROID_DEV, "2023-06-23", 4100.0),
        Employee("Nhan vien 8", Position.ANDROID_DEV, "2023-06-12", 5100.0),
        Employee("Nhan vien 9", Position.QA, "2022-02-04", 7000.0),
        Employee("Nhan vien 10", Position.MKT, "2021-06-21", 5000.0),
        Employee("Nhan vien 11", Position.MKT, "2019-06-25", 6000.0),
        Employee("Nhan vien 12", Position.IOS_DEV, "2018-08-12", 11000.0),
        Employee("Nhan vien 13", Position.ANDROID_DEV, "2020-01-31", 14000.0),
        Employee("Nhan vien 14", Position.PM, "2022-04-01", 24000.0),
    )
}