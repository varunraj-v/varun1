package com.varun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varun.dao.EmplyoeeDao;
import com.varun.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmplyoeeDao empd;

	public List<Employee> getService() {
		return empd.getDao();

	}

	public void insertEmpService(Employee e) {
		empd.insertEmpDao(e);
	}

	public void updateEmpService(Employee ee, int id) {
		empd.updateEmpDao(ee, id);

	}

	public Employee singleService(int id) {
		return empd.singleDao(id);
	}

	public void deleteService(int id) {
		empd.deleteDao(id);
	}

}
