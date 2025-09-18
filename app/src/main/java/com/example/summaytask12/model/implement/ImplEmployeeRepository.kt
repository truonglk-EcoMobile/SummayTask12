package com.example.summaytask12.model.implement

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.summaytask12.interfaces.EmployeeRepository
import com.example.summaytask12.model.sealedclass.Result
import com.example.summaytask12.model.employee.Employee
import com.example.summaytask12.singleton.EmployeeData

@RequiresApi(Build.VERSION_CODES.O)

class ImplEmployeeRepository : EmployeeRepository {
    private val employees = EmployeeData.employees
    override fun addEmployee(employee: Employee): Result<String> {
        return if (employee.name != null && employee.name.length <= 30) {
            employees.add(employee)
            Result.Success<String>(data = "Thêm nhân viên mới thành công")
        } else {
            Result.Error(message = "Tên nhân viên không hợp lệ")
        }
    }

    override fun deleteEmployee(employee: Employee): Result<String> {
        if (employees.contains(employee)){
            employees.remove(employee)
            return Result.Success(data = "Xóa nhân viên thành công")
        }else{
            return Result.Error(message = "Không tìm thấy nhân viên có id là ${employee.id}")
        }
    }

    override fun updateEmployee(employee: Employee): Result<String> {
        val index = employees.indexOfFirst { it.id == employee.id }
        return if (index != -1) {
            employees[index] = employee
            Result.Success(data = "Sửa thông tin nhân viên thành côngg")
        } else {
            Result.Error(message = "Không tìm thấy nhân viên có id là ${employee.id}")
        }
    }


    override fun getAllEmployees(): Result<List<Employee>> {
        return if (employees.isEmpty()){
            Result.Error(message = "Không có nhân viên nào")
        }else{
            Result.Success(data = employees)
        }
    }
}