package com.packtpub.sunnat629.social_network.data.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import java.time.Instant
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
//@JsonIgnoreProperties( "email","accCreatedTime","firstName","lastName",
//        "contactNumber","dob","image","city","country")
class User : Serializable {

    constructor(id: Long) {
        this.id = id
    }

    constructor(name: String) {
        this.username = name
    }

    constructor(username: String, email: String, accCreatedTime: Instant, firstName: String?, lastName: String?, contactNumber: String?, dOB: Date?, image: String?, city: String?, country: String?) {
        this.username = username
        this.email = email
        this.accCreatedTime = accCreatedTime
        this.firstName = firstName
        this.lastName = lastName
        this.contactNumber = contactNumber
        this.dOB = dOB
        this.image = image
        this.city = city
        this.country = country
    }

    @Id
    @GeneratedValue
    var id: Long = 0

    @JsonProperty("username")
    var username: String? = null

    @JsonIgnore
    var password: String? = null

    @JsonProperty("email")
    var email: String? = null

    @JsonProperty("accCreatedTime")
    var accCreatedTime: Instant? = Instant.now()

    @JsonProperty("firstName")
    var firstName: String? = null

    @JsonProperty("lastName")
    var lastName: String? = null

    @JsonProperty("contactNumber")
    var contactNumber: String? = null

    @JsonProperty("dob")
    var dOB: Date? = null

    @JsonProperty("image")
    var image: String? = null

    @JsonProperty("city")
    var city: String? = null

    @JsonProperty("country")
    var country: String? = null

    companion object {

        private const val serialVersionUID = 1L
    }
}
