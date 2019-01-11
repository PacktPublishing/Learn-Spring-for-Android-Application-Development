package com.packtpub.sunnat629.social_network.data.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*
import java.io.Serializable
import java.time.Instant

@Entity
class Post(text: String, postedBy: User) : Serializable {

    @Id
    @GeneratedValue
    var id: Long = 0

    var text: String? = text

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("username","password", "email","accCreatedTime","firstName","lastName",
            "contactNumber","dob","image","city","country")
    var postedBy: User? = postedBy

    @JsonIgnore
    @JsonProperty("postCreatedTime")
    var postCreatedTime: Instant? = Instant.now()

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    var comments: List<Comment>? = null

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    var likes: List<LikeObj>? = null

    companion object {

        private const val serialVersionUID = 1L
    }
}
