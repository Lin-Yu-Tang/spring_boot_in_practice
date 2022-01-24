package com.example.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.thymeleafdemo.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
