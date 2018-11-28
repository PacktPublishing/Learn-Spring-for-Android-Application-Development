package com.packtpub.sunnat629.jdbc_test.jdbc_test.controller

import com.packtpub.sunnat629.jdbc_test.jdbc_test.model.StudentModel
import com.packtpub.sunnat629.jdbc_test.jdbc_test.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/student"])
class StudentController {

    @Autowired
    val studentService: StudentService?= null

    @GetMapping
    fun getTest(): String{
        return "I am Sunnat..."
    }

    @GetMapping(path = ["/student_list"])
    fun getAllStudentNames(): ResponseEntity<List<StudentModel>> {
        return ResponseEntity(studentService!!.getAllStudentList(),
                HttpStatus.OK)
    }
}