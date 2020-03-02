package com.springBoot.uSpring.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment addComment(Comment _comment){
        return commentRepository.save(_comment);

    }
    public List<Comment> addComments(List<Comment> _comments){
        return commentRepository.saveAll(_comments);

    }
    public List<Comment> getComments(){
        return commentRepository.findAll();

    }
    public Comment getComment(int id){
        return commentRepository.findById(id).orElse(null);

    }
    /*public Comment getComment(String name){
        return commentRepository.findByName(name);

    }
*/
    public String deleteComment(int id){
         commentRepository.deleteById(id);
         return "Comment deleted !! " + id;
    }

    public Comment  updateComment(Comment comment){
        Comment old_comment = commentRepository.findById(comment.getId()).orElse(null);
        old_comment.setContent(comment.getContent());
        old_comment.setDate(comment.getDate());
        return commentRepository.save(old_comment);

    }


}
