package com.example.controller;

import com.example.entities.CandidateInfo;
import com.example.entities.Comment;
import com.example.repository.CandidateInfoRepository;
import com.example.repository.CommentRepository;
import com.example.request.CreateCandidateModel;
import com.example.request.CreateCommentModel;
import com.example.request.UpdateCandidateModel;
import com.example.response.CandidateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/discuss/candidate")
public class CandidateInfoController {

    @Autowired
    CandidateInfoRepository candidateInfoRepository;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("getAllCandidates")
    public List<CandidateResponse> getAllCandidates () {

        List<CandidateInfo> candidateInfoList = candidateInfoRepository.findAll();
        List<CandidateResponse> candidateResponses = new ArrayList<>();
        candidateInfoList.forEach(candidateInfo -> {
            candidateResponses.add(new CandidateResponse(candidateInfo));
        });
        return candidateResponses;
    }

    @PostMapping("addCandidate")
    public CandidateResponse addCandidate (@RequestBody CreateCandidateModel createCandidateModel) {
        CandidateInfo candidate = new CandidateInfo(createCandidateModel);
        candidate = candidateInfoRepository.save(candidate);

        List<Comment> commentList = new ArrayList<>();
        if(createCandidateModel.getCommentList() != null) {
            for (CreateCommentModel createCommentModel : createCandidateModel.getCommentList()) {
                Comment comment = new Comment();
                comment.setComment(createCommentModel.getComment());
                comment.setAuthor(createCommentModel.getAuthor());
                comment.setRating(createCommentModel.getRating());
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                comment.setDate(dtf.format(now));
//                Setting FK
                comment.setCandidateInfo(candidate);
                commentList.add(comment);
            }
            commentRepository.saveAll(commentList);
        }

        candidate.setCommentList(commentList);
        return new CandidateResponse(candidate);
    }

    @PutMapping("updateCandidate")
    public CandidateResponse updateCandidate (@Valid @RequestBody UpdateCandidateModel updateCandidateModel) {
        CandidateInfo candidate = candidateInfoRepository.findById(updateCandidateModel.getId()).get();
        candidate.setImage(updateCandidateModel.getImage());
        candidate.setFeatured(updateCandidateModel.isFeatured());
        candidate.setDescription(updateCandidateModel.getDescription());
        candidate = candidateInfoRepository.save(candidate);
        return new CandidateResponse(candidate);
    }

    @DeleteMapping("delete/{id}")
    public String deleteCandidate (@PathVariable Integer id) {
        if(!candidateInfoRepository.existsById(id)) {
            return "Candidate already deleted or does not exist";
        }
        candidateInfoRepository.deleteById(id);
        return "Candidate deleted successfully";
    }
}
