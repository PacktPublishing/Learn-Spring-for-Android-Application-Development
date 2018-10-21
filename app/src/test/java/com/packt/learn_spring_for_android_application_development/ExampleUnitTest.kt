package com.packt.learn_spring_for_android_application_development

import com.packt.learn_spring_for_android_application_development.chapter7.loadImage
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun comicLoading() = runBlocking {
        val image = async { loadImage() }.await()
        assertNotNull(image)
    }
}
