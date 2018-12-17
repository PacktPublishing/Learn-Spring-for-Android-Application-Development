package com.packtpub.sunnat629.jpa_db_test.jpa_db_test.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name="users")
class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private var id: Long = 0

    @Column(name = "name")
    var name: String ?= null

    @Column(name = "email")
    var email: String ?= null

    @Column(name = "contact_number")
    var contact_number: String ?= null

    override fun toString(): String {
        return "UserModel(id=$id, name=$name, email=$email, contact_number=$contact_number)"
    }


}