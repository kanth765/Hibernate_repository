package com.ciq.client;

import java.util.List;
import java.util.stream.Stream;

import org.hibernate.Session;

import com.ciq.entity.Person;
import com.ciq.util.HibernateUtil;

public class HQlQueriesTest {

	public static void main(String[] args) {
//		getAllWithPositions();
//		getById();
		getByIdBugResolve(1l);
	}

	public static void getAllPersons() {
		Session session = HibernateUtil.getSession();
		String selectAll = "from Person";
		List<Person> persons = session.createQuery(selectAll).list();
		persons.forEach(System.out::println);
//		persons.forEach(((p) -> p.getFirstName().startsWith("v")))
	}

	public static void getAllWithPositions() {
		Session session = HibernateUtil.getSession();
		List<Object[]> persons = session.createQuery("select p.id, p.firstName, p.dob from Person p").list();
		for (Object[] person : persons) {
			System.out.println(person[0]);
			System.out.println(person[1]);
			System.out.println(person[2]);

		}
	}

	public static void getById() {
		Session session = HibernateUtil.getSession();
		List<Object[]> persons = session.createQuery("select  p.firstName, p.email from Person p where p.id=1").list();
		for (Object[] person : persons) {
			System.out.println(person[0]);
			System.out.println(person[1]);

		}

	}

	public static void getByIdBugResolve(long pid) {
		Session session = HibernateUtil.getSession();
		String getById = "select  p.firstName, p.email from Person p where p.id=:id";
		List<Object[]> persons = session.createQuery(getById).setLong("id", pid).list();
		for (Object[] person : persons) {
			System.out.println(person[0]);
			System.out.println(person[1]);

		}

	}

}
