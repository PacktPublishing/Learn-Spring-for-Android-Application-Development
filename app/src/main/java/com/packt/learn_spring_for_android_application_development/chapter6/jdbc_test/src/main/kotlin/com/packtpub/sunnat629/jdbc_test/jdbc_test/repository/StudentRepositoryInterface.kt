package com.packtpub.sunnat629.jdbc_test.jdbc_test.repository

import com.packtpub.sunnat629.jdbc_test.jdbc_test.model.StudentModel

interface StudentRepositoryInterface {
    fun getAllStudentDetails(): List<StudentModel>
}


