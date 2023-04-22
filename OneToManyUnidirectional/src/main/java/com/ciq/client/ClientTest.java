package com.ciq.client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.ciq.entity.Customer;
import com.ciq.entity.Product;
import com.ciq.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getseSession();
		session.getTransaction().begin();
		Product samsungTv = new Product("samsungTv", 42000.00);
		Product iphone13 = new Product("iphone13", 92000.00);
		Product fastTrack = new Product("fastTrackWatch", 1500.00);
		List<Product> products = new ArrayList<Product>();
		products.add(iphone13);
		products.add(fastTrack);
		products.add(samsungTv);

		Customer sachin = new Customer("sachin", "tendulkar", 4000.00, products);
		session.save(sachin);
		session.save(fastTrack);
		session.save(iphone13);
		session.save(samsungTv);
		session.getTransaction().commit();
		HibernateUtil.closeSession(session);
	}
}
