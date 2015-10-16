package com.springapp.mvc.repository.impl;


import com.springapp.mvc.entity.Answer;
import com.springapp.mvc.repository.AnswerDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class AnswerDaoImpl implements AnswerDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override

    public void insert(Answer answer) {
        sessionFactory.getCurrentSession().saveOrUpdate(answer);
    }

    @Override

    public void delete(int id) {
        sessionFactory.getCurrentSession().delete(id);
    }

    @Override

    public Answer findAnswerById(int id) {
        return (Answer)this.sessionFactory.getCurrentSession().get(Answer.class, id);
    }

    @Override

    public void updateAnswer(Answer answer) {
        sessionFactory.getCurrentSession().update(answer);
    }

    @Override

    public List<Answer> getAllAnswer() {
        return this.sessionFactory.getCurrentSession().createCriteria(Answer.class).list();
    }

    @Override

    public Answer findAnswerByQuestionId(int questionId) {
        return (Answer)this.sessionFactory.getCurrentSession().get(Answer.class, questionId);
    }
}
