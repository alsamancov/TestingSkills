package com.springapp.mvc.repository;


import com.springapp.mvc.entity.Answer;

import java.util.List;

public interface AnswerDao {
    public void insert(Answer answer);
    public void delete(int id);
    public Answer findAnswerById(int id);
    public void updateAnswer(Answer answer);
    public List<Answer> getAllAnswer();
    public Answer findAnswerByQuestionId(int questionId);
}
