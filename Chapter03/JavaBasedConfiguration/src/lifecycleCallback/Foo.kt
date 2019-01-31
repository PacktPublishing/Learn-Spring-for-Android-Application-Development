package lifecycleCallback

class Foo{
    fun init(){
        println("Foo is initializing...")
    }

    fun destroy(){
        println("Foo is destroying...")
    }
}