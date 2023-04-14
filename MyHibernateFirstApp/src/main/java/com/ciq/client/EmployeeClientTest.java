package com.ciq.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ciq.model.Employee;

public class EmployeeClientTest {

	public static void main(String[] args) {

//		configuraion db details 

		// factory of objects

		// url un pw dialect see sql query, format , ddl command

		// session --> java objects ---> db objects

		// transaction monitor commit

		// session .close()

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Employee employee = new Employee("ciq", 22000, "ciq@ciq.com");
		Employee employee2 = new Employee("ram", 32000, "ram@ciq.com");
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}

}
