package com.springapp.mvc.service.impl;

import com.springapp.mvc.entity.Applicant;
import com.springapp.mvc.repository.ApplicantDao;
import com.springapp.mvc.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantDao applicantDao;

    @Override
    @Transactional
    public void insert(Applicant applicant) {
        applicantDao.insert(applicant);
    }

    @Override
    @Transactional
    public void delete(int id) {
        applicantDao.delete(id);
    }

    @Override
    @Transactional
    public Applicant findApplicantbyId(int id) {
        return this.applicantDao.findApplicantbyId(id);
    }

    @Override
    @Transactional
    public void updateApplicant(Applicant applicant) {
        applicantDao.updateApplicant(applicant);
    }

    @Override
    @Transactional
    public List<Applicant> getAllApplicant() {
        return this.applicantDao.getAllApplicant();
    }
}
