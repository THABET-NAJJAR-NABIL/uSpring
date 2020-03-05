package com.springBoot.uSpring.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    private List<Comment> Comments;
    @RequestMapping(value = "/comments", method = RequestMethod.GET, produces = "application/json")
    public List<Comment> getComment(){
        return commentService.getComments() ;
    }

    @PostMapping("/saveComment")
    public Comment addComment(@RequestBody Comment comment){
        return commentService.addComment(comment) ;
    }
    @PostMapping("/saveComments")
    public List<Comment> addComments(@RequestBody List<Comment> comments){
        return commentService.addComments(comments) ;
    }

    @GetMapping("/getComments")
    public List<Comment> getComments(){
        return commentService.getComments() ;
    }

    @GetMapping("/comment/{id}")
    public Comment getComment(@PathVariable int id){
        return commentService.getComment(id) ;
    }


    @PutMapping("/updateComment")
    public Comment updateComment(@RequestBody Comment comment){
        return commentService.updateComment(comment) ;
    }

    @DeleteMapping("/deleteComment/{id}")
    public String deleteComment(@PathVariable int id){
        return commentService.deleteComment(id) ;
    }



}
