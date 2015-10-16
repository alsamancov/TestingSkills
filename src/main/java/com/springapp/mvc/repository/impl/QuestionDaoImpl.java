package com.springapp.mvc.repository.impl;

import com.springapp.mvc.entity.Question;
import com.springapp.mvc.repository.QuestionDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDaoImpl implements QuestionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(Question question) {
        sessionFactory.getCurrentSession().saveOrUpdate(question);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession().delete(id);
    }

    @Override
    public Question findQuestionById(int id) {
        return (Question) this.sessionFactory.getCurrentSession().get(Question.class, id);
    }

    @Override
    public void updateQuestion(Question question) {
        sessionFactory.getCurrentSession().update(question);
    }

    @Override
    public List<Question> getAllQuestion() {
        return this.sessionFactory.getCurrentSession().createCriteria(Question.class).list();
    }
}
