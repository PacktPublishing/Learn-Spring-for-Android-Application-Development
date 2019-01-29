package com.packtpub.sunnat629.testing_application

import org.junit.*
import org.junit.Assert.*

class JUnitTestClass {

    companion object {
        @BeforeClass
        @JvmStatic
        fun runBeforeClass(){
            println("============ @BeforeClass ============\n")
        }

        @AfterClass
        @JvmStatic
        fun runAfterClass(){
            println("============ @AfterClass ============")
        }
    }


    @Before
    fun runBefore(){
        println("============ @Before ============")
    }

    @After
    fun runAfter(){
        println("============ @After ============\n")
    }

    @Test
    fun runTest1(){
        println("============ @TEST One Start ============")
        assertEquals(6, doSum(3,2))
        println("============ @TEST One End ============")
    }

    @Test
    fun runTest2(){
        println("============ @TEST Two Start ============")
        assertEquals(6, doSum(3,2))
        println("============ @TEST Two End ============")
    }

    private fun doSum(num1: Int, num2: Int): Int{
        return num1 + num2
    }

    private fun doDiv(num1: Int, num2: Int): Int{
        return num1 - num2
    }
}