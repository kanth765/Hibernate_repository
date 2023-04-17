package com.ciq.client;

import java.util.Date;

import org.hibernate.Session;

import com.ciq.entity.Person;
import com.ciq.util.HibernateUtil;

public class PersistantObjectLifecycleWithSessionMethods {

	public static void main(String[] args) {
//		sessionSave();
//		sessionMerge();
		Session session = HibernateUtil.getSession();
		Person person1 = (Person) session.load(Person.class, 2l);
		System.out.println(person1);
		HibernateUtil.closeSession(session);
	}

	public static void sessionSave() {
		System.out.println("1. ---------------------session starting here");
		Session session = HibernateUtil.getSession();
		session.getTransaction().begin();
		System.out.println("2. ---------------------begin");
		Person person = new Person("sachin", "t", "ramesh@ciq.com", new Date());
		System.out.println("3. ---------------------");
		System.out.println(person);
		session.persist(person);
		person.setFirstName("sachin");
		System.out.println("4. ---------------------");
		session.getTransaction().commit();
		System.out.println("5. ---------------------");
		HibernateUtil.closeSession(session);
		System.out.println("6. ---------------------");
	}

	public static void sessionMerge() {
		System.out.println("1. ---------------------session starting here");
		Session session = HibernateUtil.getSession();
		session.getTransaction().begin();
		System.out.println("2. ---------------------begin");
		Person person1 = (Person) session.get(Person.class, 2l);
		System.out.println("3. ---------------------");
		System.out.println(person1);
		session.detach(person1);
		System.out.println("4. ---------------------");
		person1.setFirstName("sitaRam");
		session.merge(person1);
		Person person2 = (Person) session.get(Person.class, 2l);
		System.out.println("5. ---------------------");
		System.out.println(person2);
		session.close();
		System.out.println("6. ---------------------");

	}
}
