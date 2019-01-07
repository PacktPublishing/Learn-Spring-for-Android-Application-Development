package com.packtpub.sunnat629.socialmedia.data

import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name="user_jpa")
/**JPA entity listener to capture auditing information on persiting and updating entities.
 * To get this one flying be sure you configure it as entity listener in your orm.xml as follows:
 * */
@EntityListeners(AuditingEntityListener::class)

data class UserModel(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        var id: Long = 0,

        @NotBlank
        @Column(name = "name")
        var name: String ?= null,

        @NotBlank
        @Column(name = "email")
        var email: String ?= null,

        @NotBlank
        @Column(name = "contact_number")
        var contact_number: String ?= null
)