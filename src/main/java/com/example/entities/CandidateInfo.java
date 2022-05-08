package com.example.entities;

import com.example.request.CreateCandidateModel;
import com.example.request.CreateCommentModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidate_info")
public class CandidateInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "featured")
    private boolean featured;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidateInfo")
    private List<Comment> commentList;

    public CandidateInfo (CreateCandidateModel createCandidateModel) {
        this.name = createCandidateModel.getName();
        this.image = createCandidateModel.getImage();
        this.description = createCandidateModel.getDescription();
        this.featured = createCandidateModel.isFeatured();
    }
}
