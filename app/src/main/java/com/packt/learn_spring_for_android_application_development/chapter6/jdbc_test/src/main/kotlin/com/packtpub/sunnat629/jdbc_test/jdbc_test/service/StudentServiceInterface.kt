package com.packtpub.sunnat629.jdbc_test.jdbc_test.service

import com.packtpub.sunnat629.jdbc_test.jdbc_test.model.StudentModel

interface StudentServiceInterface{
    fun getAllStudentList(): List<StudentModel>
}