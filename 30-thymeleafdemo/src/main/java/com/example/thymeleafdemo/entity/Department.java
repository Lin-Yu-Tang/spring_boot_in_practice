package com.example.thymeleafdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dept")
public class Department {
	
	@Id
	@Column(name = "deptno")
	private int deptno;
	
	@Column(name = "dname")
	private String name;
	
	@Column(name = "location")
	private String location;
	
	public Department() {}

	public Department(int deptno, String name, String location) {
		this.deptno = deptno;
		this.name = name;
		this.location = location;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", name=" + name + ", location=" + location + "]";
	}
	
	
	
}
