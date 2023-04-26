package com.ciq.client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.ciq.entity.Cars;
import com.ciq.entity.Person;
import com.ciq.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getseSession();
		session.getTransaction().begin();
		Cars maruthi = new Cars();
		maruthi.setBrandName("maruthi");
		maruthi.setColorName("white");
		Cars nissan = new Cars();
		nissan.setBrandName("nissan");
		nissan.setColorName("green");

		Cars tata = new Cars();
		tata.setBrandName("tata");
		tata.setColorName("red");
		List<Cars> cars = new ArrayList<>();
		cars.add(tata);
		cars.add(nissan);
		cars.add(maruthi);
		Person person = new Person();
		person.setFirstName("dhoni");
		person.setLastName("ms");
		person.setCars(cars);
		session.persist(person);
		session.getTransaction().commit();
		HibernateUtil.closeSession(session);
	}
}
