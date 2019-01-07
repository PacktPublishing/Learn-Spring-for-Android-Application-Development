//package com.packtpub.sunnat629.socialmedia.controller
//
//import com.packtpub.sunnat629.socialmedia.data.model.PostStory
//import com.packtpub.sunnat629.socialmedia.data.model.Profiles
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.web.bind.annotation.*
//
//@RestController
//class UserController{
//
//
//    @Autowired
//    private lateinit var postStoryRepository: PostStoryRepository
//
//    @Autowired
//    private lateinit var profileRepository: ProfileRepository
////    init {
////        profileRepository.save(Profiles( "Mohi-Us",
////                "Sunnat", "Bangladesh"))
////    }
//
//
//    @GetMapping(value = ["/{id}"])
//    fun update(@PathVariable(name = "id") id: Long): Profiles {
//
//        var profile = profileRepository.getOne(id)
////
//        profile.postStory = postStoryRepository.findAll()
//
//        return profile
//    }
//    @GetMapping(value = ["/"])
//    fun updateL(): String{
//
//        val profile = profileRepository.getOne(1)
////        val postStory = postStoryRepository.findAll()
////        profile.postStory = postStory
//
//        return profile.toString()
//    }
//
//    @GetMapping(value = ["/a/{name}"])
//    fun add(@PathVariable(name = "name") name: String): List<Profiles>{
//        profileRepository.save(Profiles("Mohi-Us", name, "Bangladesh"))
//        return profileRepository.findAll()
//    }
//
//    @GetMapping(value = ["/q/{id}"])
//    fun updateU(@PathVariable(name = "id") id: Long): List<PostStory>{
//
//        val profile = profileRepository.getOne(id)
//
//        val postStory = PostStory("First Blog",
//                "I am Trying to best to do something.", profile)
//
//        postStory.profiles = profile
//
//        postStoryRepository.save(postStory)
//        return postStoryRepository.findAll()
//    }
//
//
///*//    This is for all means there is no security issue for this URL path
//    @GetMapping(value = ["/", "","/open_for_all"])
//    fun home(): String{
//        return "This area can be accessed by all."
//    }
//
//    //    Yu have to use token to get this URL path
//    @GetMapping("/private")
//    fun securedArea(): String{
//        return "You used an access token to enter this area."
//    }
//
//    @Autowired
//    private lateinit var userRepository: UserRepository
//
//    // to get all the users details
//    @GetMapping("/users")
//    fun getAllUsers(): List<UserModel>{
//        return userRepository.findAll()
//    }
//
//    // to get one specific user details
//    @GetMapping("/user/{id}")
//    fun getUser(@PathVariable(name = "id") id: Long): UserModel {
//        return userRepository.findById(id)
//                .orElseThrow { ResourceNotFoundException("User", "id", id) }
//    }
//
//    // to add a user
//    @PostMapping("/user/new")
//    fun addUser(@Valid @RequestBody userModel: UserModel): UserModel {
//        return userRepository.save(userModel)
//    }
//
//    // to update a user
//    @PutMapping("/user/{id}")
//    fun updateUser(@PathVariable(name = "id")id: Long, @Valid @RequestBody userDetails: UserModel): UserModel {
//        val currentUser: UserModel = userRepository.findById(id)
//                .orElseThrow { ResourceNotFoundException("User", "id", id)}
//
//        currentUser.name = userDetails.name
//        currentUser.email = userDetails.email
//        currentUser.contact_number = userDetails.contact_number
//
//        return userRepository.save(currentUser)
//    }
//
//    // to delete a user
//    @DeleteMapping("/user/{id}")
//    fun deleteUser(@PathVariable(name = "id")id: Long): ResponseEntity<*> {
//        userRepository.delete(userRepository.findById(id).get())
//        return ResponseEntity.ok().build<Any>()
//    }*/
//}