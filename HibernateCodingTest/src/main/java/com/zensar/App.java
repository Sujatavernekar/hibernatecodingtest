package com.zensar;

import javax.persistence.EntityManager;

import com.zensar.bean.Address;
import com.zensar.bean.BankAccount;
import com.zensar.bean.Employee;
import com.zensar.bean.Skill;
import com.zensar.util.JPAUtil;



public class App {

	public static void loadTesting() {
//write code here to load employee object

		EntityManager em = JPAUtil.createEntityManager("PU");
		Employee employee = em.find(Employee.class, 101);

		JPAUtil.shutDown();
	}

	public static void insertTesting() {
//write code here to persist employee object
		Employee employee = new Employee(101, "adity", 2000.00, null, null);

		Address address = new Address("bbsr", "761104", null);
		employee.setAddress(address);

		employee.addSkill(new Skill("java", 8));
		employee.addSkill(new Skill("spring", 6));

		BankAccount bankAccount = new BankAccount("12GF24");
		employee.setAccount(bankAccount);

		employee.setAddress(address);

		EntityManager em = JPAUtil.createEntityManager("PU");

		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
		JPAUtil.shutDown();
		System.out.println("successful inserted");

	}

	public static void main(String[] args) {
		System.out.println("Hello World!");

		insertTesting();
//loadTesting();
	}
}