package com.example.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class CreateCommentModel {
    @JsonProperty("item_id")
    private Integer itemId;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("rating")
    private String rating;

    @JsonProperty("author")
    private String author;

}
