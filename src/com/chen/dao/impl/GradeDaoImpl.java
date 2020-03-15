/**
 * 
 */
package com.chen.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.chen.bean.Grades;
import com.chen.dao.GradeDao;

/**
 * @author chenguoji
 * @email chenguo_ji@163.com
 */
public class GradeDaoImpl implements GradeDao{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public Grades find(int id) {
		Session session = sessionFactory.getCurrentSession();
		Grades grade = (Grades) session.get(Grades.class, id);
		return grade;
	}

}
