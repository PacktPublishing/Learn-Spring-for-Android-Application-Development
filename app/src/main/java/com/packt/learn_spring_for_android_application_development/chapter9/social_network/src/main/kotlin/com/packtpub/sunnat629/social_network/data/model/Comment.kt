package com.packtpub.sunnat629.social_network.data.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*
import java.io.Serializable
import java.time.Instant

@Entity
class Comment(text: String, postedBy: User) : Serializable {

    @Id
    @GeneratedValue
    var id: Long = 0

    var text: String? = text

    @JsonIgnore
    @JsonProperty("accCreatedTime")
    var accCreatedTime: Instant? = Instant.now()


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("username","password","email","accCreatedTime","firstName","lastName",
            "contactNumber","dob","image","city","country")
    var postedBy: User? = postedBy

    companion object {

        private const val serialVersionUID = 1L
    }
}
