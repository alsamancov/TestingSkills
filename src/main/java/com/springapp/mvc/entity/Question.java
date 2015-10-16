package com.springapp.mvc.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id")
    private int id;

    @Column(name = "text_question")
    private String textQuestion;

    @Column(name = "level")
    private int level;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="question")
    private List<Answer> hisAnswers = new ArrayList<Answer>();

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "APPLICANT_ANSWERS",
            joinColumns = @JoinColumn(name = "QUESTION_ID"),
            inverseJoinColumns = @JoinColumn(name = "APPLICANT_ID"))
    private List<Applicant> applicantList;

    public Question() {
    }

    public Question(String textQuestion, int level) {
        this.textQuestion = textQuestion;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
