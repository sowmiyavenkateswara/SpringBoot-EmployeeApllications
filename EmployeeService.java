package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeInterface;
import com.example.demo.model.Employee;

@Service

public class EmployeeService {
	@Autowired
    private EmployeeInterface dao;
	//save
	public void save(Employee e) {
		dao.save(e);
	}
	// update
	public Employee get(int id ) {
		return dao.findById(id).get();
	}
	//delete
	public void delete(int id) {
		dao.deleteById(id);
	}
	public List<Employee> listAll(){
		return dao.findAll();
		
	}
}
