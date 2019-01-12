package com.packtpub.sunnat629.social_network.controller

import com.packtpub.sunnat629.social_network.data.model.Comment
import com.packtpub.sunnat629.social_network.data.model.Post
import com.packtpub.sunnat629.social_network.data.model.User
import com.packtpub.sunnat629.social_network.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class AppController {
    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var userExist: UserExistRepository

    @Autowired
    private lateinit var postRepository: PostRepository

    @Autowired
    private lateinit var commentRepository: CommentRepository

    @Autowired
    private lateinit var likeRepository: LikeRepository

    @Autowired
    lateinit var passwordEncoder: PasswordEncoder


    @GetMapping("/")
    fun getTest(): Any {
        return "HELLO USER"
    }

    // New User registration
    @PostMapping("/user/new")
    fun registerUser(@RequestBody user: User): Any{
        if (!userExist.isUserExist(user.username)){
            user.password = passwordEncoder.encode(user.password)
            userRepository.save(user)
            return user
        }
        return "{\"duplicate\": \"${user.username} is taken. Try another\"}"
    }

    // Get User by ID
    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable("id") id: Long): Any {
        return userRepository.findById(id)
    }


    // Post status by User ID
    @PostMapping("/post/{user_id}/new")
    fun submitPost(@PathVariable("user_id") user_id: Long, @RequestParam text: String): Any {
//        val mPost: Post? = null
//        mPost!!.text = text
//        mPost.postedBy = User(user_id)
//        mPost.postCreatedTime = mPost.postCreatedTime

//        postRepository.save(mPost)
        println("$user_id : $text")
        val mPost = Post(text, User(user_id))
        postRepository.save(mPost)

        return mPost
    }

    // Get all posted status
    @GetMapping("/posts")
    fun getPostList(): Any {
        return postRepository.findAll()
    }

    // Get all posted status by User ID
    @GetMapping("/post/{user_id}")
    fun getPostById(@PathVariable("user_id") id: Long): Any {
        return postRepository.findById(id)
    }


    // Delete a posted status by User ID
    @DeleteMapping("/post/{user_id}")
    fun deletePostById(@PathVariable("user_id") id: Long): Any {
        // TODO need to delete comment, link
        return postRepository.deleteById(id)
    }


    // Post comment in a post by User ID and Post ID
    @PostMapping("/comment/new")
    fun postCommentByPostId(@RequestParam id: Long,
                            @RequestParam postId: Long ,
                            @RequestParam commentText: String): Any {
        val optionalPost: Optional<Post> = postRepository.findById(postId)



        return if(optionalPost.isPresent){
            val comment = Comment(commentText, User(id))

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
    fun getCommentListByPostId(@PathVariable("id") id: Long): Any {
        return userRepository.findById(id)
    }

    // delete comment List of a status
    @DeleteMapping("/comment/{id}")
    fun deleteCommentByPostId(@PathVariable("id") id: Long): Any {
        return userRepository.findById(id)
    }



    // post a like in a status
    @PostMapping("/like/{id}")
    fun postLikeByPostIdUserID(@PathVariable("id") id: Long): Any {
        deleteLikeByPostIdUserID(id)
        return userRepository.findById(id)
    }

    // remove a like from a status
    @GetMapping("/like/{id}")
    fun deleteLikeByPostIdUserID(@PathVariable("id") id: Long): Any {
        return userRepository.findById(id)
    }


}