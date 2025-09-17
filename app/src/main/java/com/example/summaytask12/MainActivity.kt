package com.example.summaytask12

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.summaytask12.model.employee.Employee
import com.example.summaytask12.model.implement.ImplEmployeeRepository
import com.example.summaytask12.model.enumclass.Position
import com.example.summaytask12.model.sealedclass.Result

@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val repository =  ImplEmployeeRepository()
        val employees:List<Employee>
        when(val result = repository.getAllEmployees()){
            is Result.Success ->{
                employees = result.data!!
            }
            is Result.Error ->{
                Log.e(TAG,"${result.message}")
                employees = emptyList()
            }
        }


        val newEmp = Employee("Nguyen Van A", Position.ANDROID_DEV)
        addEmp(repository,employee = newEmp)
        showListEmp(employees)


        newEmp.apply {
            joinDate = "2025-06-24"
            setSlary(10000.0)
        }
        updatEmp(repository,employee = newEmp)
        showListEmp(employees)


        groupEmp(repository)


        nhanVienCoThamNien(employees,5)

    }

    fun addEmp(repository: ImplEmployeeRepository, employee: Employee){
        Log.d(TAG, "============ Add Employee ============")
        when(val result = repository.addEmployee(employee = employee)){
            is Result.Success ->{
                Log.d(TAG, " ${result.data}")
            }
            is Result.Error ->{
                Log.e(TAG, " ${result.message}")
            }
        }
    }
    fun showListEmp(employees: List<Employee>){
        Log.d(TAG, "============ LIST EMPLOYEE ============")
        employees.forEach { employee ->
            Log.d(TAG,"employee${employee.id}: ${employee.toString()}")
        }
    }

    fun updatEmp(repository: ImplEmployeeRepository, employee: Employee){
        Log.d(TAG, "============ UPDATE EMPLOYEE ============")
        when(val result = repository.updateEmployee(employee = employee)){
            is Result.Success ->{
                Log.d(TAG, " ${result.data}")
            }
            is Result.Error ->{
                Log.e(TAG, " ${result.message}")
            }
        }
    }

    //nhóm các nhân viên lại thành các nhóm theo vị trí
    fun groupEmp(repository: ImplEmployeeRepository){
        Log.d(TAG, "============ GROUP EMPLOYEE ============")
        val listGroup: LinkedHashMap<Position, List<Employee>>
        when(val result = repository.getAllEmployees()){
            is Result.Success ->{
                listGroup = result.data!!.groupBy { it.position } as LinkedHashMap<Position, List<Employee>>
                listGroup.forEach { (position, employees) ->
                    Log.d(TAG," ====== ${position.displayName} ====== ")
                    employees.forEach { employee ->
                        Log.d(TAG,"${employee.name}")
                    }
                }
            }
            is Result.Error ->{
                Log.e(TAG,"${result.message}")
            }
        }
    }

    //Danh sách các nhân viên có thâm niên theo số năm
    fun nhanVienCoThamNien(employees: List<Employee>, soNam:Int){
        Log.d(TAG, "============ NHAN VIEN CO THAM NIEN $soNam NAM ============")
        val listEmployee = employees.filter { employee->
            val thamNien = employee.thamNien().split("-")
            thamNien[0].toInt() >= soNam
        }
        listEmployee.forEach {
            val  thamNien = it.thamNien().split("-")
            Log.d(TAG,"${it.name} đã làm được ${thamNien[0]} năm ${thamNien[1]} tháng ${thamNien[2]} ngày")
        }
    }


}
