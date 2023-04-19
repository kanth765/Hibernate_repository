package com.ciq.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;

import com.ciq.util.HibernateUtil;

public class NativeSqlQueriesEx {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
//		getAllPersons(session);
//		getAllPersonsWithSelectedColumns(session);
//		getParameterBinding(session);

//		getParameterBindingAliasNames(session);
		getAgreegateFunction(session);
	}

	public static void getAllPersons(Session session) {
		Query query = session.createSQLQuery("select * from persons");
		session.beginTransaction().commit();
		List<Object[]> objects = query.list();
		for (Object[] person : objects) {
			System.out.println(person[0]);
			System.out.println(person[1]);
			System.out.println(person[2]);
			System.out.println(person[3]);
			System.out.println(person[4]);

		}
	}

	public static void getAllPersonsWithSelectedColumns(Session session) {
		Query query = session.createSQLQuery("select person_id, first_name, last_name, email, dob from persons");
		session.beginTransaction().commit();
		List<Object[]> objects = query.list();
		for (Object[] person : objects) {
			System.out.println(person[0]);
			System.out.println(person[1]);
			System.out.println(person[2]);
			System.out.println(person[3]);
			System.out.println(person[4]);

		}
	}

	public static void getParameterBinding(Session session) {
		SQLQuery query = session.createSQLQuery("select * from persons");
		query.addScalar("person_id", StandardBasicTypes.LONG);
		query.addScalar("first_name", StandardBasicTypes.STRING);
		query.addScalar("last_name", StandardBasicTypes.STRING);
		query.addScalar("email", StandardBasicTypes.STRING);
		List<Object[]> objects = query.list();
		for (Object[] person : objects) {
			System.out.println(person[0]);
			System.out.println(person[1]);
			System.out.println(person[2]);
			System.out.println(person[3]);

		}
	}

	public static void getParameterBindingAliasNames(Session session) {
		SQLQuery query = session.createSQLQuery("select p.person_id as id, p.first_name as fn from persons p");
		query.addScalar("id", StandardBasicTypes.LONG);
		query.addScalar("fn", StandardBasicTypes.STRING);
//		query.addScalar("last_name", StandardBasicTypes.STRING);
//		query.addScalar("email", StandardBasicTypes.STRING);
		List<Object[]> objects = query.list();
		for (Object[] person : objects) {
			System.out.println(person[0]);
			System.out.println(person[1]);
//			System.out.println(person[2]);
//			System.out.println(person[3]);

		}
	}

	public static void getAgreegateFunction(Session session) {
		SQLQuery query = session.createSQLQuery("select count(email) as maxEmail  from persons");
		query.addScalar("maxEmail", StandardBasicTypes.LONG);
		Object objects = query.uniqueResult();
		System.out.println(objects);
	}
}
