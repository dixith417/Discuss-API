package com.example.request;

import com.example.entities.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateCandidateModel {
    @JsonProperty("name")
    private String name;

    @JsonProperty("image")
    private String image;

    @JsonProperty("featured")
    private boolean featured;

    @JsonProperty("description")
    private String description;

    @JsonProperty("comment_list")
    private List<CreateCommentModel> commentList;
}
