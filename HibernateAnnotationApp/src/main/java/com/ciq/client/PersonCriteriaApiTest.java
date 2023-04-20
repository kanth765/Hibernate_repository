package com.ciq.client;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;
import org.hibernate.criterion.Restrictions;

import com.ciq.entity.Person;
import com.ciq.util.HibernateUtil;

public class PersonCriteriaApiTest {

	public static void main(String[] args) {
		getAllPersons();
//		getEmails();
//		getById(1l);
//		getSelectedListOfData();
	}

	// select * from persons
	public static void getAllPersons() {
		Session session = HibernateUtil.getSession();
		Criteria crApi = session.createCriteria(Person.class);
		List<Person> persons = crApi.list();
		for (Person person : persons) {
			System.out.println(person);
		}

	}

	// select email from persons;
	public static void getEmails() {
		Session session = HibernateUtil.getSession();
		Criteria crApi = session.createCriteria(Person.class);
		crApi.setProjection(Projections.property("email"));
		List<String> emails = crApi.list();
		for (String email : emails) {
			System.out.println(email);
		}
	}

	// select * from persons where id=?
	public static void getById(long id) {
		Session session = HibernateUtil.getSession();
		Criteria crApi = session.createCriteria(Person.class);
		Criterion cn = Restrictions.eq("id", id);
		crApi.add(cn);
		Object objec = crApi.uniqueResult();
		Person person = (Person) objec;
		System.out.println(person);

	}

//	select firstName, lastName, email from persons

	public static void getSelectedListOfData() {
		Session session = HibernateUtil.getSession();
		Criteria crApi = session.createCriteria(Person.class);
		ProjectionList pLlist = Projections.projectionList();
		pLlist.add(Projections.property("firstName"));
		pLlist.add(Projections.property("lastName"));
		pLlist.add(Projections.property("email"));
		crApi.setProjection(pLlist);
		List<Object[]> list = crApi.list();
		for (Object[] person : list) {
			System.out.println(person[0]);
			System.out.println(person[1]);
			System.out.println(person[2]);
		}

	}

	// select * from persons where dob >1992-01-01
	//select count(email) from persons
	//select * from emp where salary>250000
	//select * from person, emp where firstName like 'a%';
}
