package com.packtpub.sunnat629.jdbc_test.jdbc_test.service

import com.packtpub.sunnat629.jdbc_test.jdbc_test.model.StudentModel
import com.packtpub.sunnat629.jdbc_test.jdbc_test.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentService: StudentServiceInterface {
    @Autowired
    private val studentRepository: StudentRepository?= null

    override fun getAllStudentList(): List<StudentModel> {
       return studentRepository!!.getAllStudentDetails()
    }
}