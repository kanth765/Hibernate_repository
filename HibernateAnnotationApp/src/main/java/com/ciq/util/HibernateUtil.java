package com.ciq.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		sessionFactory = config.buildSessionFactory();
		System.out.println(sessionFactory);

	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}

	public static void closeSession(Session session) {
		if (session != null)
			session.close();
	}

	public static void main(String[] args) {
		System.out.println(getSession());

	}
}
