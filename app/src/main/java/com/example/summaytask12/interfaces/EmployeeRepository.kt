package com.example.summaytask12.interfaces

import com.example.summaytask12.model.employee.Employee
import com.example.summaytask12.model.sealedclass.Result

interface EmployeeRepository {
    fun addEmployee(employee: Employee): Result<String>
    fun getAllEmployees(): Result<List<Employee>>
    fun updateEmployee(employee: Employee): Result<String>
}
