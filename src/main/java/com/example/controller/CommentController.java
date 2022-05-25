package com.example.controller;

import com.example.entities.CandidateInfo;
import com.example.entities.Comment;
import com.example.repository.CandidateInfoRepository;
import com.example.repository.CommentRepository;
import com.example.request.AddCommentModel;
import com.example.request.CreateCommentModel;
import com.example.request.UpdateCommentModel;
import com.example.response.CommentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/discuss/comment")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CandidateInfoRepository candidateInfoRepository;

    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:1234"})
    @GetMapping("getAllComments")
    public List<CommentResponse> getAllComments() {

        List<Comment> commentList = commentRepository.findAll();
        List<CommentResponse> commentResponseList = new ArrayList<>();
        commentList.forEach(comment -> {
            commentResponseList.add(new CommentResponse(comment));
        });
        return commentResponseList;
    }

    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:1234"})
    @PostMapping("addComment")
    public CommentResponse addComment(@RequestBody AddCommentModel addCommentModel) {
        CandidateInfo candidate = candidateInfoRepository.findById(addCommentModel.getCandidateId()).get();
        Comment comment = new Comment();
        comment.setComment(addCommentModel.getComment());
        comment.setRating(addCommentModel.getRating());
//        Setting FK
        comment.setCandidateInfo(candidate);
        comment.setAuthor(addCommentModel.getAuthor());
//        set date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        comment.setDate(dtf.format(now));

        commentRepository.save(comment);
        return new CommentResponse(comment);
    }

    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:1234"})
    @PutMapping("updateComment")
    public CommentResponse updateComment (@RequestBody UpdateCommentModel updateCommentModel) {
        Comment comment = commentRepository.getById(updateCommentModel.getId());
        comment.setComment(updateCommentModel.getComment());
        comment.setRating(updateCommentModel.getRating());
        comment.setAuthor(updateCommentModel.getAuthor());
        commentRepository.save(comment);
        return new CommentResponse(comment);
    }
}
