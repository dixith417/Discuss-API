package com.example.controller;

import com.example.entities.CandidateInfo;
import com.example.repository.CandidateInfoRepository;
import com.example.request.CreateCandidateModel;
import com.example.request.UpdateCandidateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/discuss/candidate")
public class CandidateInfoController {

    @Autowired
    CandidateInfoRepository candidateInfoRepository;

    @GetMapping("getAllCandidates")
    public List<CandidateInfo> getAllCandidates () {
        return candidateInfoRepository.findAll();
    }

    @PostMapping("addCandidate")
    public CandidateInfo addCandidate (@RequestBody CreateCandidateModel createCandidateModel) {
        CandidateInfo candidate = new CandidateInfo(createCandidateModel);
        return candidateInfoRepository.save(candidate);
    }

    @PutMapping("updateCandidate")
    public CandidateInfo updateCandidate (@Valid @RequestBody UpdateCandidateModel updateCandidateModel) {
        CandidateInfo candidate = candidateInfoRepository.findById(updateCandidateModel.getId()).get();
        candidate.setImage(updateCandidateModel.getImage());
        candidate.setFeatured(updateCandidateModel.isFeatured());
        candidate.setDescription(updateCandidateModel.getDescription());
        return candidateInfoRepository.save(candidate);
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
