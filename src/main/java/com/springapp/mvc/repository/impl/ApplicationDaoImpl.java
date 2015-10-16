package com.springapp.mvc.repository.impl;

import com.springapp.mvc.entity.Applicant;
import com.springapp.mvc.repository.ApplicantDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ApplicationDaoImpl implements ApplicantDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(Applicant applicant) {
        sessionFactory.getCurrentSession().saveOrUpdate(applicant);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession().delete(id);
    }

    @Override
    public Applicant findApplicantbyId(int id) {
        return (Applicant)this.sessionFactory.getCurrentSession().get(Applicant.class, id);
    }

    @Override
    public void updateApplicant(Applicant applicant) {
        sessionFactory.getCurrentSession().update(applicant);
    }

    @Override
    public List<Applicant> getAllApplicant() {
        return this.sessionFactory.getCurrentSession().createCriteria(Applicant.class).list();
    }
}
