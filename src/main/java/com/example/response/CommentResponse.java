package com.example.response;

import com.example.entities.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CommentResponse {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("candidate_id")
    private Integer candidate_id;

    @JsonProperty("rating")
    private String rating;

    @JsonProperty( "comment")
    private String comment;

    @JsonProperty( "author")
    private String author;

    @JsonProperty( "date")
    private String date;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.candidate_id = comment.getCandidateInfo().getId();
        this.rating = comment.getRating();
        this.comment = comment.getComment();
        this.author = comment.getAuthor();
        this.date = comment.getDate();
    }
}
