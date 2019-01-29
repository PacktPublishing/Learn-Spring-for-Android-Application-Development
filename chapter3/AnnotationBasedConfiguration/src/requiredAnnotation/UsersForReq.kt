package requiredAnnotation

import org.springframework.beans.factory.annotation.Required



class UsersForReq{
    private var village: String? = null
    private var name: String? = null

    @Required
    fun setVillage(village: String?) {
        this.village = village
    }

    fun getVillage(): String? {
        return village
    }

    @Required
    fun setName(name: String) {
        this.name = name
    }

    fun getName(): String? {
        return name
    }
}
