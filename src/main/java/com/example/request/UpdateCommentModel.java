package com.example.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class UpdateCommentModel {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("rating")
    private String rating;

    @JsonProperty( "comment")
    private String comment;

    @JsonProperty( "author")
    private String author;
}
