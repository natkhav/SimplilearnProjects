package com.project.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.project.model.Subject;
import com.project.model.Teacher;
import com.project.util.HibernateUtil;

public class SubjectService {
	public void save(Subject subject) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        
        session.save(subject);
        
        session.getTransaction().commit();
        
        session.close();
	}
	
	public List<Teacher> getTeacherList() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Teacher> criteria = builder.createQuery(Teacher.class);
        criteria.from(Teacher.class);
        List<Teacher> teacherList = session.createQuery(criteria).getResultList();
        
        session.getTransaction().commit();
        
        session.close();
        
        return teacherList;
	}
}
