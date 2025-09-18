package com.example.summaytask12.model.enumclass

enum class Position(val displayName: String, val tyLeBonus: Double) {
    TRUONG_PHONG("Trường phòng",0.2),
    ANDROID_DEV("Android Developer",0.15),
    IOS_DEV("IOS Developer",0.15),
    QA("Quality Assurance",0.14),
    MKT("Marketing",0.12),
    PM("Project Manager",0.18),
    INTERN("Intern",0.0),
    NV("Nhân viên thường chưa phân vị trí",0.0)
}