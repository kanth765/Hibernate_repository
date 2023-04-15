package com.ciq.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ciq.entity.Person;

public class PersonTest {

	public static void main(String[] args) throws ParseException {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		// yyyy/mm/dd
		String dob = "1990/01/01";
		String dob2 = "1991/02/02";
		String dob3 = "1992/03/03";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
		Date date = dateFormat.parse(dob);
		Date date2 = dateFormat.parse(dob2);
		Date date3 = dateFormat.parse(dob3);
		Person person = new Person("balu", "g", "balu@ciq.com", date);
		Person person2 = new Person("ram", "rr", "ram@ciq.com", date2);
		Person person3 = new Person("sita", "sr", "sita@ciq.com", date3);
//		session.persist(person3);
//		session.getTransaction().commit();
		Person p = session.get(Person.class, 1l);
		System.out.println(p);

		System.out.println("start HQL----------------------------");
		// hibernate query language(HQL)
		Query query = session.createQuery("from Person");
		List<Person> persons = query.list();
		persons.forEach(System.out::println);
		System.out.println("END HQL----------------------------");
		
		
		System.out.println("start NativeSQl----------------------------");
		// hibernate query language(HQL)
		Query query2 = session.createNativeQuery("select * from persons");
		List<Object[]> prs = query2.list();
		for (Object[] objects : prs) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);
			System.out.println(objects[2]);
			System.out.println(objects[3]);
			System.out.println(objects[4]);
		}
		System.out.println("END Native sql----------------------------");
		session.close();
	}

}
