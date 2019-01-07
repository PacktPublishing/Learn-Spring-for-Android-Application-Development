//package com.packtpub.sunnat629.ebb.eborrowbooks.data.model
//
//import java.sql.Timestamp
//import javax.persistence.*
//
//@Entity
//@Table(name = "registered_user")
//class RegisteredUser {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "r_user_id")
//    var rUserId: Long = 0
//
//    @Column(name = "username")
//    var username: String? = null
//
//    @Column(name = "email")
//    var email: String? = null
//
//    @Column(name = "password")
//    var password: String? = null
//
//    @Column(name = "role")
//    var role: String? = null
//
//    @Column(name = "acc_create")
//    var accCreate: Timestamp? = null
//
//
//    @OneToOne(cascade = [CascadeType.ALL])
//    @JoinColumn(name = "r_user_id", referencedColumnName = "p_id")
//    lateinit var profiles: Profiles
//
//
//}
