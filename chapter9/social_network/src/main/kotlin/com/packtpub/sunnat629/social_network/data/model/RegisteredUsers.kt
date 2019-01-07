package com.packtpub.sunnat629.social_network.data.model

import java.time.Instant
import javax.persistence.*

@Entity
data class RegisteredUser (
        @Column
        var username: String,

        @Column
        var email: String,

        @Column
        var password: String,

        @Column
        var role: String,

        @Column
        var accCreate: Instant,

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = -1,

        @OneToOne(mappedBy = "reg_user", cascade= [CascadeType.ALL], optional=false)
        val profile: Profile? = null
)