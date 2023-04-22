package com.ciq.client;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ciq.entity.Address;
import com.ciq.entity.Person;
import com.ciq.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getseSession();
		session.getTransaction().begin();
//		Person person = new Person("balu", "ram");
//		Address address = new Address("hyd", "Ts", person);
//		session.save(person);
//		session.save(address);

//		Address address = session.get(Address.class, 1l);
//		System.out.println(address);

		Criteria cr = session.createCriteria(Address.class);
		Criterion cn = Restrictions.eq("city", "HYD");
		cr.add(cn);
		Address uniqueResult = (Address) cr.uniqueResult();
		System.out.println(uniqueResult.getPerson().getFirstName());
		session.getTransaction().commit();
		HibernateUtil.closeSession(session);
	}
}
