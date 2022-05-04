package com.example.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateCommentModel {

    @NotNull(message = "Id is required")
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("rating")
    private String rating;

    @JsonProperty("comment")
    private String comment;

}
