package com.ciq.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	}

	public static Session getseSession() {
		Session session = sessionFactory.openSession();
		return session;
	}

	public static void closeSession(Session session) {
		if (session != null) {
			session.close();
		}

	}

	public static void main(String[] args) {
		System.out.println(getseSession());
	}
}
