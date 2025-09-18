package com.example.summaytask12.singleton

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.summaytask12.model.employee.Employee
import com.example.summaytask12.model.employee.Intern
import com.example.summaytask12.model.employee.Manager
import com.example.summaytask12.model.enumclass.Position
@RequiresApi(Build.VERSION_CODES.O)
object EmployeeData{
    val employees = mutableListOf(
        Employee("Nhan vien A", Position.TRUONG_PHONG, "2022-11-01", 10000.0),
        Employee("Nhan vien B", Position.ANDROID_DEV, "2024-07-01", 8000.0),
        Employee("Nhan vien C", Position.IOS_DEV, "2021-12-09", 7000.0),
        Employee("Nhan vien D", Position.QA, "2023-04-01", 6000.0),
        Employee("Nhan vien E", Position.MKT, "2023-05-01", 5000.0),
        Employee("Nhan vien F", Position.PM, "2023-06-01", 4000.0),
        Employee("Nhan vien G", Position.ANDROID_DEV, "2023-06-23", 4100.0),
        Employee("Nhan vien H", Position.ANDROID_DEV, "2023-06-12", 5100.0),
        Employee("Nhan vien I", Position.QA, "2022-02-04", 7000.0),
        Employee("Nhan vien J", Position.MKT, "2021-06-21", 5000.0),
        Employee("Nhan vien K", Position.MKT, "2019-06-25", 6000.0),
        Employee("Nhan vien L", Position.IOS_DEV, "2018-08-12", 11000.0),
        Employee("Nhan vien M", Position.ANDROID_DEV, "2020-01-31", 14000.0),
        Employee("Nhan vien N", Position.PM, "2022-04-01", 2000.0),
        Employee("Nhan vien Q", Position.NV),

        //Manager
        Manager("Manager A", Position.TRUONG_PHONG, "2018-02-28", 20000.0, 9),
        Manager("Manager B", Position.TRUONG_PHONG, "2020-10-15", 17000.0, 5),
        Manager("Manager C", Position.TRUONG_PHONG, "2019-03-19", 18500.0, 6),

        //Intern
        Intern("Intern A", Position.INTERN, "2023-06-01", 2000.0, "HOU",),
        Intern("Intern B", Position.INTERN, "2023-06-01", 2000.0, "PIT",),
        Intern("Intern C", Position.INTERN, "2023-06-01", 2000.0, "BKU",),
        Intern("Intern D", Position.INTERN, "2023-06-01", 2000.0, "HUST",),
    )
}