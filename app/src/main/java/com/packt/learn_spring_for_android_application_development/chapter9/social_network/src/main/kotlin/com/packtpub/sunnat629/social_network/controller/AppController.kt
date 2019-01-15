package com.packtpub.sunnat629.social_network.controller

import com.packtpub.sunnat629.social_network.model.Comment
import com.packtpub.sunnat629.social_network.model.Post
import com.packtpub.sunnat629.social_network.model.Profile
import com.packtpub.sunnat629.social_network.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class AppController {
    @Autowired
    private lateinit var profileRepository: ProfileRepository

    @Autowired
    private lateinit var userExist: UserExistRepository

    @Autowired
    private lateinit var postRepository: PostRepository

    @Autowired
    private lateinit var commentRepository: CommentRepository

    @Autowired
    private lateinit var likeRepository: LikeRepository

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    @Autowired
    private lateinit var deletePCLRepository: DeletePCLRepository

    @GetMapping("/")
    fun getTest(): Any {
        return "HELLO USER"
    }

    // New Profile registration
    @PostMapping("/profile/new")
    fun registerUser(@RequestBody profile: Profile): Any {
        if (!userExist.isUserExist(profile.username)) {
            profile.password = passwordEncoder.encode(profile.password)
            profileRepository.save(profile)
            return profile
        }
        return "{\"duplicate\": \"${profile.username} is taken. Try another\"}"
    }

    // Get Profile by ID
    @GetMapping("/profile/{id}")
    fun getUserById(@PathVariable("id") id: Long): Any {
        return profileRepository.findById(id)
    }

    // Get All Profiles
    @GetMapping("/profiles")
    fun getUserById(): Any {
        return profileRepository.findAll()
    }


    //     Update Profile by ID
    @PutMapping("/profile/{id}")
    fun updateUserById(@PathVariable("id") id: Long, @RequestBody mUser: Profile): Any {
        val profile = profileRepository.getOne(id)
        if (mUser.firstName != null) profile.firstName = mUser.firstName
        if (mUser.lastName != null) profile.lastName = mUser.lastName
        if (mUser.contactNumber != null) profile.contactNumber = mUser.contactNumber
        if (mUser.city != null) profile.city = mUser.city
        if (mUser.country != null) profile.country = mUser.country
        return profileRepository.save(profile)
    }

    // Delete Profile by ID
    @DeleteMapping("/profile/{userId}")
    fun deleteUserById(@PathVariable("userId") userId: Long): Any {
        deletePostByUserId(userId)
        deletePCLRepository.deleteAllUsersInfoByUserID(userId)
        return profileRepository.deleteById(userId)
    }

    // Post status by Profile ID
    @PostMapping("/post/{profile_id}/new")
    fun submitPost(@PathVariable("profile_id") profile_id: Long, @RequestParam text: String): Any {
//        val mPost: Post? = null
//        mPost!!.text = text
//        mPost.postedBy = Profile(profile_id)
//        mPost.postCreatedTime = mPost.postCreatedTime

//        postRepository.save(mPost)
        println("$profile_id : $text")
        val mPost = Post(text, Profile(profile_id))
        postRepository.save(mPost)

        return mPost
    }

    // Get all posted status
    @GetMapping("/posts")
    fun getPostList(): Any {
        return postRepository.findAll()
    }

    // Get all posted status by Profile ID
    @GetMapping("/post/{id}")
    fun getPostById(@PathVariable("id") id: Long): Any {
        return postRepository.findById(id)
    }

    // Update all posted status by Profile ID
    @PutMapping("/post/{profile_id}")
    fun updatePostById(@PathVariable("profile_id") id: Long, @RequestParam text: String): Any {
        val modifiedPost = postRepository.getOne(id)
        modifiedPost.text = text
        return postRepository.save(modifiedPost)
    }


    // Delete a posted status by Profile ID
    @DeleteMapping("/post/{id}")
    fun deletePostByUserId(@PathVariable("id") id: Long): Any {
        return postRepository.deleteById(id)
    }


    // Post comment in a post by Profile ID and Post ID
    @PostMapping("/comment/{post_id}")
    fun postCommentByPostId(@PathVariable("post_id") postId: Long, @RequestParam id: Long, @RequestParam commentText: String): Any {
        val optionalPost: Optional<Post> = postRepository.findById(postId)
        return if (optionalPost.isPresent) {
            val comment = Comment(commentText, Profile(id))
            val post = optionalPost.get()
            post.comments.add(comment)
            postRepository.save(post)
            return post
        } else {
            "There is no post.."
        }
    }

    // get comment List of a post
    @GetMapping("/comment/{id}")
    fun getCommentListByPostId(@PathVariable("id") id: Long, @RequestParam text: String): Any {
        val modifiedComment = commentRepository.getOne(id)
        modifiedComment.text = text
        return commentRepository.save(modifiedComment)
    }

    // delete comment List of a status
    @DeleteMapping("/comment/{id}")
    fun deleteCommentByPostId(@PathVariable("id") id: Long): Any {
        return commentRepository.findById(id)
    }


//    // post a like in a status
//    @PostMapping("/like/{id}")
//    fun postLikeByPostIdUserID(@PathVariable("id") id: Long): Boolean {
//        return false
//    }
//
//    // remove a like from a status
//    @GetMapping("/like/{id}")
//    fun deleteLikeByPostIdUserID(@PathVariable("id") id: Long): Boolean {
//        return false
//    }


}