package dependenciesInjectBean

class GreetingDIBean (private val userDetails: GreetingDetailsDIBean){
    init {
        println("Inside dependenciesInjectBean.GreetingDIBean constructor.")
    }

    fun getGreeting() {
        userDetails.getGreetingDetails()
    }
}