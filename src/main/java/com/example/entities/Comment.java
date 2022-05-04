package com.example.entities;

import com.example.request.CreateCommentModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "rating")
    private String rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "author")
    private String author;

    @Column(name = "date")
    private String date;

    public Comment(CreateCommentModel createCommentModel) {
        this.author = createCommentModel.getAuthor();
        this.rating = createCommentModel.getRating();
        this.itemId = createCommentModel.getItemId();
        this.comment = createCommentModel.getComment();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.date = dtf.format(now);
    }
}
