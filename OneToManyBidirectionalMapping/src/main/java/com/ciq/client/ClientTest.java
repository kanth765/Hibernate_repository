package com.ciq.client;

import java.util.ArrayList;
import java.util.List;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.Add;
import org.hibernate.Session;

import com.ciq.entity.Address;
import com.ciq.entity.Employee;
import com.ciq.util.HibernateUtil;

public class ClientTest {

	public static void addEmployee() {
		Session session = HibernateUtil.getseSession();
		session.getTransaction().begin();
		Address currentAddress = new Address();
		currentAddress.setCity("Hyd");
		currentAddress.setState("Ts");
		currentAddress.setZipCode("500038");
		Address permenentAddress = new Address();
		permenentAddress.setCity("Srikakulam");
		permenentAddress.setState("AP");
		permenentAddress.setZipCode("200043");
//		List<Address> addressess = new ArrayList<>();
//		addressess.add(address);
		Employee employee = new Employee();
		employee.setFirstName("balu");
		employee.setLastName("g");
		employee.setEmail("balu@ciq.com");
		employee.setCell_phone(1234567l);
		employee.getAddressess().add(permenentAddress);
		employee.getAddressess().add(currentAddress);
		currentAddress.setEmployee(employee);
		permenentAddress.setEmployee(employee);
		session.persist(employee);
//		session.persist(currentAddress);
//		session.persist(permenentAddress);
//		session.delete(employee);
		session.getTransaction().commit();
		HibernateUtil.closeSession(session);
	}

	public static void main(String[] args) {

		Session session = HibernateUtil.getseSession();
		session.getTransaction().begin();
//		Employee employee = session.get(Employee.class, 1l);
//		System.out.println(employee.getFirstName());
//		System.out.println(employee.getLastName());
//		System.out.println(employee.getEmail());
//		System.out.println(employee.getSalaryry());
//		employee.getAddressess().forEach(System.out::println);
		
		Address address=session.get(Address.class, 1l);
		System.out.println(address);
		System.out.println(address.getEmployee().getFirstName());

	}
}
