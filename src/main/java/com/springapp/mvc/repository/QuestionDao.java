package com.springapp.mvc.repository;


import com.springapp.mvc.entity.Question;

import java.util.List;

public interface QuestionDao {
    public void insert(Question question);
    public void delete(int id);
    public Question findQuestionById(int id);
    public void updateQuestion(Question question);
    public List<Question> getAllQuestion();
}
