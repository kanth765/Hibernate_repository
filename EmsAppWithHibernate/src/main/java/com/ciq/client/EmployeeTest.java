package com.ciq.client;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.ciq.entity.Employee;
import com.ciq.util.HibernateUtil;

public class EmployeeTest {

	public static void getAllEmps() {
		Session session = HibernateUtil.getseSession();
		Criteria ccApi = session.createCriteria(Employee.class);
		List<Employee> emps = ccApi.list();
		for (Employee employee : emps) {
			System.out.println(employee);
		}

	}

	public static void addPerson() {
		Session session = HibernateUtil.getseSession();
		session.getTransaction().begin();
		Employee employee = new Employee("anil", "b", "anil@ciq.com", 23000.00, 100);
		Employee employee2 = new Employee("ram", "s", "ram@ciq.com", 35000.00, 0);
		Employee employee3 = new Employee("asif", "md", "asif@ciq.com", 33000.00, 2100);
		Employee employee4 = new Employee("bramma", "cj", "bramma@ciq.com", 42000.00, 3000);
		Employee employee5 = new Employee("balu", "g", "balu@ciq.com", 55000.00, 10000);
		session.save(employee5);
		session.getTransaction().commit();
		session.close();
	}

	// select * from employee where id =1
	public static void getEmpById() {
		Session session = HibernateUtil.getseSession();
		Criteria criteria = session.createCriteria(Employee.class);
		Criterion cr = Restrictions.eq("id", 1l);
		criteria.add(cr);
		Employee employee = (Employee) criteria.uniqueResult();
		System.out.println(employee);

	}

	// select email from employees;
	public static void getEmpBySelectedColm() {
		Session session = HibernateUtil.getseSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.property("email"));
		List<String> emps = criteria.list();
		for (String employee : emps) {
			System.out.println(employee);
		}
	}

	// select firstName, lastName, email, salary from employee;
	public static void getEmpBySelectedCols() {
		Session session = HibernateUtil.getseSession();
		Criteria criteria = session.createCriteria(Employee.class);
		ProjectionList pList = Projections.projectionList();
		pList.add(Projections.property("firstName"));
		pList.add(Projections.property("lastName"));
		pList.add(Projections.property("email"));
		pList.add(Projections.property("salary"));
		criteria.setProjection(pList);
		List<Object[]> names = criteria.list();
		for (Object[] objects : names) {
			System.out.println(Arrays.toString(objects));
		}
	}

	public static void getEmpBySalary() {
		Session session = HibernateUtil.getseSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.lt("salary", 55000.00));
//		Employee employee = (Employee) criteria.uniqueResult();
//		System.out.println(employee.getId());
//		System.out.println(employee.getFirstName());
//		System.out.println(employee.getLastName());
//		System.out.println(employee.getSalary());
		session.beginTransaction().commit();
		List<Employee> emps = criteria.list();
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}

	public static void main(String[] args) {
//		addPerson();
//		Session session = HibernateUtil.getseSession();
//
//		List<Employee> employees = session.createQuery("from Employee").list();
//		for (Employee employee : employees) {
//			System.out.println(employee);
//		}

//	getAllEmps();
//		getEmpById();

//		getEmpBySelectedColm();
//		getEmpBySelectedCols();
		getEmpBySalary();

	}

}
