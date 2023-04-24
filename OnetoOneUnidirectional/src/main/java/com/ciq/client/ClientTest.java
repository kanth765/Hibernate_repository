package com.ciq.client;

import org.hibernate.Session;

import com.ciq.util.HibernateUtil;

public class ClientTest {

	public static void addStudent() {
		Session session = HibernateUtil.getseSession();
		session.getTransaction().begin();

		session.getTransaction().commit();
		HibernateUtil.closeSession(session);

	}

	public static void main(String[] args) {
		addStudent();
	}
}
