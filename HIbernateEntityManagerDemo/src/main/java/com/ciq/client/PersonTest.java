package com.ciq.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ciq.entity.Name;
import com.ciq.entity.Person;

public class PersonTest {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.ciq.entity");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
//		Name name = new Name("sachin", "tendulkar");
//		Person person = new Person(name);
//		entityManager.persist(person);
//		Person person = entityManager.find(Person.class, 1l);
//		System.out.println(person);
//		tx.commit();

		Query query = entityManager.createQuery("from Person");
		List<Person> persons = query.getResultList();
		persons.forEach(System.out::println);
		entityManager.close();

	}

}
