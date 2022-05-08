package com.example.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class UpdateCandidateModel {
    @NotNull(message = "Id is required")
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("image")
    private String image;

    @JsonProperty("featured")
    private boolean featured;

    @JsonProperty("description")
    private String description;
}
