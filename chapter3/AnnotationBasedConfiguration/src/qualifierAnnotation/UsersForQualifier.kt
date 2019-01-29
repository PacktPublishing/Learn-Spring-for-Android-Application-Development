package qualifierAnnotation

class UsersForQualifier{
    private var village: String? = null
    private var name: String? = null

    fun setVillage(village: String?) {
        this.village = village
    }

    fun getVillage(): String? {
        return village
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getName(): String? {
        return name
    }
}
