package com.packtpub.sunnat629.social_network.data.model

import org.springframework.data.rest.core.annotation.RestResource
import java.util.*
import javax.persistence.*
import javax.persistence.FetchType




@Entity
data class Profile(

       @Column(name = "first_name")
        var firstName: String,

        @Column(name = "last_name")
        var lastName: String,

//    @Column(name = "contact_number")
//    var contactNumber: String,

//    @Column(name = "d_o_b")
//    var dOB: Date,
//
//    @Column(name = "image")
//    var image: String,
//
//    @Column(name = "type_of_reader")
//    var typeOfReader: String,
//
//    @Column(name = "address")
//    var address: String,

//    @Column(name = "city")
//    var city: String,

//        @Column(name = "country")
//        var country: String,

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var pId: Long = 0,

       @OneToOne(optional=true, fetch=FetchType.EAGER, cascade= [CascadeType.ALL])
       @PrimaryKeyJoinColumn(name="reg_user",  referencedColumnName="registered_user")
       var registeredUser: RegisteredUser? = null



//    @Column(name = "ref_id")
//    var refId: Long = 0

) {


//    @OneToMany(mappedBy = "profiles", cascade = [CascadeType.ALL])
//    var postStory: List<PostStory>? = null

}