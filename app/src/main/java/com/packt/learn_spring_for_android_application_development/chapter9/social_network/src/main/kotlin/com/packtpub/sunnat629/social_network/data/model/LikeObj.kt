package com.packtpub.sunnat629.social_network.data.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import java.io.Serializable

@Entity
class LikeObj(user: User) : Serializable {

    @Id
    @GeneratedValue
    var id: Long? = 0

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("username","password","email","accCreatedTime","firstName","lastName",
            "contactNumber","dob","image","city","country")
    var user: User? = user

    companion object {

        private const val serialVersionUID = 1
    }
}
