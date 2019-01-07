package com.packtpub.sunnat629.socialmedia.data.model

import javax.persistence.*

@Entity
@Table(name = "post_test")
data class PostStory (
   @Column(name = "title")
    var title: String,

    @Column(name = "descrption")
    var descrption: String,

   @ManyToOne
   @JoinColumn(name = "p_id")
   var profiles: Profiles?= null

){
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    var postId: Long = 0

}