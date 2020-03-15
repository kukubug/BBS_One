/**
 * 
 */
package com.chen.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chen.bean.Announces;
import com.chen.dao.AnnounceDao;

/**
 * @author chenguoji
 * @email chenguo_ji@163.com
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class AnnounceDaoImpl implements AnnounceDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Announces> getIndexAnno(int index) {
		String hql = "from Announces anno order by anno.id desc";
		Session session = sessionFactory.getCurrentSession();
		List<Announces> listAnno = null;
		try {
			Query q = session.createQuery(hql);
			q.setMaxResults(index);
			listAnno = q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return listAnno;
	}

	@Override
	public List<Announces> getAll() {
		String hql = "from Announces anno order by anno.id desc";
		Session session = sessionFactory.getCurrentSession();
		List<Announces> listAnno = null;
		try {
			Query q = session.createQuery(hql);
			listAnno = q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return listAnno;
	}

	@Override
	public Announces find(int id) {
		Session session = sessionFactory.getCurrentSession();
		Announces anno = (Announces) session.get(Announces.class, id);
		return anno;
	}

	@Override
	public void update(Announces announce) {
		Session session = sessionFactory.getCurrentSession();
		session.update(announce);
	}

	@Override
	public void add(Announces announce) {
		Session session = sessionFactory.getCurrentSession();
		session.save(announce);
	}

}
