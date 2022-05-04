package com.example.controller;

import com.example.entities.Comment;
import com.example.repository.CommentRepository;
import com.example.request.CreateCommentModel;
import com.example.request.UpdateCommentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/discuss/comment")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("getAllComments")
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @PostMapping("addComment")
    public Comment addComment (@RequestBody CreateCommentModel createCommentModel) {
        Comment comment = new Comment(createCommentModel);
        return commentRepository.save(comment);
    }

    @PutMapping("updateComment")
    public Comment updateComment (@Valid @RequestBody UpdateCommentModel updateCommentModel) {
        Comment oldComment = commentRepository.findById(updateCommentModel.getId()).get();
        oldComment.setComment(updateCommentModel.getComment());
        oldComment.setRating(updateCommentModel.getRating());
        return commentRepository.save(oldComment);
    }

    @DeleteMapping("deleteComment/{id}")
    public String deleteComment (@PathVariable Integer id) {
        if(!commentRepository.existsById(id)) {
            return "Comment already deleted or it does not exist";
        }
        commentRepository.deleteById(id);
        return "Comment deleted successfully";
    }
}
