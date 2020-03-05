package com.springBoot.uSpring.User;

import com.springBoot.uSpring.Comments.Comment;
import com.springBoot.uSpring.Comments.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User _user){
        return userRepository.save(_user);

    }
    public List<User> addUsers(List<User> _users){
        return userRepository.saveAll(_users);

    }
    public List<User> getUsers(){
        return userRepository.findAll();

    }
    public User getUser(int id){
        return userRepository.findById(id).orElse(null);

    }
    /*public Comment getComment(String name){
        return commentRepository.findByName(name);

    }
*/
    public String deleteUser(int id){
        userRepository.deleteById(id);
         return "Comment deleted !! " + id;
    }

    public User  updateUser(User user){
        User old_user = userRepository.findById(user.getId()).orElse(null);
        old_user.setPassword(user.getPassword());
        return userRepository.save(old_user);

    }


}
