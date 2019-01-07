package com.packtpub.sunnat629.socialmedia.data.model

import javax.persistence.*


@Entity
@Table(name = "profiles_test")
data class Profiles(

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

        @Column(name = "country")
        var country: String


//    @Column(name = "ref_id")
//    var refId: Long = 0

) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "p_id")
    var pId: Long = 0

    @OneToMany(mappedBy = "profiles", cascade = [CascadeType.ALL])
    var postStory: List<PostStory>? = null

    override fun toString(): String {
        return "Profiles(firstName='$firstName', lastName='$lastName', " +
                "country='$country', pId=$pId, postStory=$postStory)"
    }


}