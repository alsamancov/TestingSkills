package com.springapp.mvc.service.impl;

import com.springapp.mvc.entity.Question;
import com.springapp.mvc.repository.QuestionDao;
import com.springapp.mvc.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;

    @Override
    @Transactional
    public void insert(Question question) {
        questionDao.insert(question);
    }

    @Override
    @Transactional
    public void delete(int id) {
        questionDao.delete(id);
    }

    @Override
    @Transactional
    public Question findQuestionById(int id) {
        return this.questionDao.findQuestionById(id);
    }

    @Override
    @Transactional
    public void updateQuestion(Question question) {
        questionDao.updateQuestion(question);
    }

    @Override
    @Transactional
    public List<Question> getAllQuestion() {
        return this.questionDao.getAllQuestion();
    }
}
