package com.example.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddCommentModel {
    @JsonProperty("candidate_id")
    private Integer candidateId;

    @JsonProperty("rating")
    private String rating;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("author")
    private String author;

}
