package com.packtpub.sunnat629.social_network.controller;

import com.packtpub.sunnat629.social_network.data.model.Comment;
import com.packtpub.sunnat629.social_network.data.model.LikeObj;
import com.packtpub.sunnat629.social_network.data.model.Post;
import com.packtpub.sunnat629.social_network.data.model.User;
import com.packtpub.sunnat629.social_network.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class LeopardController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserExistRepository userExist;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private LikeRepository likeRepository;

    @RequestMapping("/store")
    public Object add(@RequestParam(required = false) String name,
                      @RequestParam(required = false) Long id,
                      @RequestParam(required = false) Long postId,
                      @RequestParam(required = false) String text,
                      @RequestParam StoreType type) {

        switch (type) {
            case USER:
                User user = new User(name);
                if (!userExist.isUserExist(name)) {
                    userRepository.save(user);
                    return user;
                }else{
                    return "{\"duplicate\": \""+name+" is taken. Try another\"}";
                }


            case POST:
                Post post = new Post(text, new User(id));
                postRepository.save(post);
                return post;

            case COMMENT:
                Optional<Post> optionalPost = postRepository.findById(postId);

                if (optionalPost.isPresent()) {
                    Comment comment = new Comment(text, new User(id));
                    commentRepository.save(comment);

                    post = optionalPost.get();
                    post.getComments().add(comment);
                    postRepository.save(post);

                    return post;
                } else {
                    return "Error";
                }

//            case LIKE:
//                optionalPost = postRepository.findById(postId);
//
//                if (optionalPost.isPresent()) {
//                    LikeObj likeObj = new LikeObj(new User(id));
//                    likeRepository.save(likeObj);
//
//                    post = optionalPost.get();
//                    post.getLikeList().add(likeObj);
//                    postRepository.save(post);
//
//                    return post;
//
//                } else {
//                    return "Error";
//                }
        }

        return null;
    }

    @RequestMapping("/find")
    public List find(@RequestParam StoreType type) {
        switch (type) {
            case USER:
                List<User> userList = new ArrayList<>();
                userRepository.findAll().forEach(userList::add);
                return userList;

            case POST:
                List<Post> postList = new ArrayList<>();
                postRepository.findAll().forEach(postList::add);
                return postList;
        }

        return null;
    }

    public enum StoreType {
        USER, POST, COMMENT,  LIKE
    }
}
