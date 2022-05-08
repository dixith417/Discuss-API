package com.example.response;

import com.example.entities.CandidateInfo;
import com.example.entities.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CandidateResponse {
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("image")
    private String image;

    @JsonProperty( "featured")
    private boolean featured;

    @JsonProperty( "description")
    private String description;

    @JsonProperty("comment_list")
    private List<CommentResponse> commentList;

    public CandidateResponse(CandidateInfo candidate) {
        this.id = candidate.getId();
        this.name = candidate.getName();
        this.featured = candidate.isFeatured();
        this.description = candidate.getDescription();
        this.image = candidate.getImage();
        if(candidate.getCommentList() != null) {
            commentList = new ArrayList<>();
            for (Comment comment : candidate.getCommentList()) {
                commentList.add(new CommentResponse(comment));
            }
        }
    }
}
