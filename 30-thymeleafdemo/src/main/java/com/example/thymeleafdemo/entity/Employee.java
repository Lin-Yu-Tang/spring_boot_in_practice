package com.example.thymeleafdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class Employee {
	
	@Id
	@Column(name = "empno")
	private int id;
	
	@Column(name = "ename")
	private String name;
	
	@Column(name = "job")
	private String job;
	
	@Column(name = "manager")
	private Integer manager;
	
	@Column(name = "hiredate")
	private String hiredate;
	
	@Column(name = "salary")
	private Float salary;
	
	@Column(name = "comm")
	private Float commission;
	
	@Column(name = "deptno")
	private Integer deptno;
	
	public Employee() {}

	public Employee(int id, String name, String job, Integer manager, String hiredate, Float salary, Float commission,
			Integer deptno) {
		this.id = id;
		this.name = name;
		this.job = job;
		this.manager = manager;
		this.hiredate = hiredate;
		this.salary = salary;
		this.commission = commission;
		this.deptno = deptno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getManager() {
		return manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Float getCommission() {
		return commission;
	}

	public void setCommission(Float commission) {
		this.commission = commission;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", job=" + job + ", manager=" + manager + ", hiredate="
				+ hiredate + ", salary=" + salary + ", commission=" + commission + ", deptno=" + deptno + "]";
	}
	
	
}
