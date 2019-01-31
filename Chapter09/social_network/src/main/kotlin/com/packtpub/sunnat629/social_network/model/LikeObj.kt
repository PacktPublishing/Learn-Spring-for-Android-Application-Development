package com.packtpub.sunnat629.social_network.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable
import javax.persistence.*

@Entity
class LikeObj(mProfile: Profile) : Serializable {

    @Id
    @GeneratedValue
    var id: Long? = 0

    @ManyToOne
    @JoinColumn(name = "profile_id")
    @JsonIgnoreProperties(/*"username",*/"password","email","accCreatedTime","firstName","lastName",
            "contactNumber","dob","city","country")
    var profile: Profile? = mProfile

    companion object {

        private const val serialVersionUID = 1
    }
}
