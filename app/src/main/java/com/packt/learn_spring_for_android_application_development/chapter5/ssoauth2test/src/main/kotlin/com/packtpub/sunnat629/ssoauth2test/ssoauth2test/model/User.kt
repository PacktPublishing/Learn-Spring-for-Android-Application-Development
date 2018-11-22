package com.packtpub.sunnat629.ssoauth2test.ssoauth2test.model


import org.codehaus.jackson.annotate.JsonIgnore

import javax.persistence.*

@Entity
class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    @Column
    var firstName: String? = null
    @Column
    var lastName: String? = null
    @Column
    var username: String? = null
    @Column
    @JsonIgnore
    var password: String? = null
    @Column
    var salary: Long = 0
    @Column
    var age: Int = 0
}
