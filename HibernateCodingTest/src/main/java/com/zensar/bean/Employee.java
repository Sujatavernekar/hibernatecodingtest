package com.zensar.bean;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	int employeeId;

	@Column
	String name;
	@Column
	Double basicSalary;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "employeeId30_addressId30", joinColumns = @JoinColumn(name = "employee_Id", referencedColumnName = "employeeId"), inverseJoinColumns = @JoinColumn(name = "addressId_Id", referencedColumnName = "addressId", unique = true))

	Address address;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CourseId_SubjectId", joinColumns = @JoinColumn(name = "Employee_id"), inverseJoinColumns = @JoinColumn(name = "Skill_Id"))
	List<Skill> skillList;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Bank_ID", referencedColumnName = "bankId")
	BankAccount account;

	private void init() {
		if (this.skillList == null) {
			skillList = new ArrayList<Skill>();
		}
	}

	public Employee(int employeeId, String name, Double basicSalary, Address address, BankAccount account) {
		super();
		init();
		this.employeeId = employeeId;
		this.name = name;
		this.basicSalary = basicSalary;
		this.address = address;

		this.account = account;
	}

	public Employee(String name, Double basicSalary, Address address, List<Skill> skillList, BankAccount account) {
		super();
		this.name = name;
		this.basicSalary = basicSalary;
		this.address = address;
		init();
		this.account = account;
	}

	public Employee(int employeeId) {
		super();
		init();
		this.employeeId = employeeId;
	}

	public Employee() {
		super();
		init();
// TODO Auto-generated constructor stub
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(Double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<Skill> skillList) {
		this.skillList = skillList;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", basicSalary=" + basicSalary + ", address="
				+ address + ", skillList=" + skillList + ", account=" + account + "]";
	}

	public void addSkill(Skill skill) {
		this.skillList.add(skill);
	}
}