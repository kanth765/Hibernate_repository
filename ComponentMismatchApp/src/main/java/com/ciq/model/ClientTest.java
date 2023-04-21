package com.ciq.model;

import org.hibernate.Session;

import com.ciq.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getseSession();
		session.getTransaction().begin();
		LeaveTracker lTracker = new LeaveTracker(2, 12, 90, 5);
		Employee employee = new Employee("anil", 22000, lTracker);
		session.persist(employee);
		session.getTransaction().commit();
		HibernateUtil.closeSession(session);
	}

}
