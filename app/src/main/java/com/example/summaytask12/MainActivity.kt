package com.example.summaytask12

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.summaytask12.extension.highestSalaryEmployee
import com.example.summaytask12.extension.toVND
import com.example.summaytask12.extension.totalSalaryAndBonus
import com.example.summaytask12.model.employee.Employee
import com.example.summaytask12.model.implement.ImplEmployeeRepository
import com.example.summaytask12.model.enumclass.Position
import com.example.summaytask12.model.sealedclass.Result
import com.example.summaytask12.singleton.Constants

@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : AppCompatActivity() {
    val repository by lazy { ImplEmployeeRepository() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val employees:List<Employee> = getAllEmp()

        //Add employee
        val newEmp = Employee("Nguyen Van A", Position.ANDROID_DEV).also {
            Log.d(Constants.TAG_MAINACTIVITY,"Tạo mới nhân viên thành công")
        }
        addEmp(employee = newEmp)
        showListEmp(employees)

        //Update employee
        newEmp.apply {
            joinDate = "2025-06-24"
            setSlary(10000.0)
        }
        updatEmp(employee = newEmp)
        showListEmp(employees)

        //Delete employee
        val empNeedDelete = employees[12]
        deleteEmp(empNeedDelete)
        showListEmp(employees)
        groupEmp()
        employeeSeniority(employees,5)
        totalSalaryAndBonus(employees)
        highestSalaryEmployee(employees)

    }

    fun getAllEmp():List<Employee>{
        return when(val result = repository.getAllEmployees()){
            is Result.Success ->{
                result.data!!
            }
            is Result.Error ->{
                Log.e(Constants.TAG_MAINACTIVITY,"${result.message}")
                emptyList()
            }
        }
    }

    fun addEmp(employee: Employee){
        Log.d(Constants.TAG_MAINACTIVITY, "============ Add Employee ============")
        when(val result = repository.addEmployee(employee = employee)){
            is Result.Success ->{
                Log.d(Constants.TAG_MAINACTIVITY, " ${result.data}")
            }
            is Result.Error ->{
                Log.e(Constants.TAG_MAINACTIVITY, " ${result.message}")
            }
        }
    }
    fun showListEmp(employees: List<Employee>){
        Log.d(Constants.TAG_MAINACTIVITY, "============ LIST EMPLOYEE ============")
        employees.forEach { employee ->
            Log.d(Constants.TAG_MAINACTIVITY,"employee${employee.id}: $employee")
        }
    }

    fun updatEmp(employee: Employee){
        Log.d(Constants.TAG_MAINACTIVITY, "============ UPDATE EMPLOYEE ============")
        when(val result = repository.updateEmployee(employee = employee)){
            is Result.Success ->{
                Log.d(Constants.TAG_MAINACTIVITY, " ${result.data}")
            }
            is Result.Error ->{
                Log.e(Constants.TAG_MAINACTIVITY, " ${result.message}")
            }
        }
    }

    fun deleteEmp(employee: Employee){
        Log.d(Constants.TAG_MAINACTIVITY, "============ DELETE EMPLOYEE ============")
        when(val result = repository.deleteEmployee(employee = employee)){
            is Result.Success ->{
                Log.d(Constants.TAG_MAINACTIVITY, " ${result.data}")
            }
            is Result.Error ->{
                Log.e(Constants.TAG_MAINACTIVITY, " ${result.message}")
            }
        }
    }

    //nhóm các nhân viên lại thành các nhóm theo vị trí
    fun groupEmp(){
        Log.d(Constants.TAG_MAINACTIVITY, "============ GROUP EMPLOYEE ============")
        val listGroup: LinkedHashMap<Position, List<Employee>>
        when(val result = repository.getAllEmployees()){
            is Result.Success ->{
                listGroup = result.data!!.groupBy { it.position } as LinkedHashMap<Position, List<Employee>>
                listGroup.forEach { (position, employees) ->
                    Log.d(Constants.TAG_MAINACTIVITY," ====== ${position.displayName} ====== ")
                    employees.forEach { employee ->
                        Log.d(Constants.TAG_MAINACTIVITY,"${employee.name}")
                    }
                }
            }
            is Result.Error ->{
                Log.e(Constants.TAG_MAINACTIVITY,"${result.message}")
            }
        }
    }

    //Danh sách các nhân viên có thâm niên theo số năm
    fun employeeSeniority(employees: List<Employee>, soNam:Int){
        Log.d(Constants.TAG_MAINACTIVITY, "============ NHÂN VIÊN CÓ THÂM NIÊN TỪ $soNam NĂM ============")
        val listEmployee = employees.filter { employee->
            val thamNien = employee.thamNien().split("-")
            thamNien[0].toInt() >= soNam
        }
        listEmployee.forEach {
            val  thamNien = it.thamNien().split("-")
            Log.d(Constants.TAG_MAINACTIVITY,"${it.name} đã làm được ${thamNien[0]} năm ${thamNien[1]} tháng ${thamNien[2]} ngày")
        }
    }

    //Tổng lương và thưởng phải trả cho toàn bộ nhân vien
    fun totalSalaryAndBonus(employees:List<Employee>){
        Log.d(Constants.TAG_MAINACTIVITY, "============ TỔNG TIỀN CẦN TRẢ ============")
        val total = employees.totalSalaryAndBonus()
        Log.d(Constants.TAG_MAINACTIVITY,"Tổng tiền cần trả là: ${total.toVND()}")
    }

    fun highestSalaryEmployee(employees:List<Employee>){
        Log.d(Constants.TAG_MAINACTIVITY, "============ NHÂN VIÊN CÓ LƯƠNG CAO NHẤT ============")
        val emp = employees.highestSalaryEmployee()
        Log.d(Constants.TAG_MAINACTIVITY,"${emp?.name} có lương là ${emp?.getSalary().toVND()}")
    }

}
