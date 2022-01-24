package com.varun.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.varun.model.Employee;

@Repository
public class EmplyoeeDao {

	@Autowired
	JdbcTemplate jdbc;

	public List<Employee> getDao() {
		List<Employee> listemp = jdbc.query("select *from employee", new BeanPropertyRowMapper(Employee.class));
		return listemp;
	}

	public void insertEmpDao(Employee e) {
		jdbc.update("insert into employee values(?,?,?)", e.getId(), e.getName(), e.getEmp_dept());
	}

	public void updateEmpDao(Employee ee, int id) {
		jdbc.update("update employee set name=?,emp_dept=? where id=?", ee.getName(), ee.getEmp_dept(), id);
		System.out.println("Successfully inserted");
	}

	public Employee singleDao(@PathVariable int id) {
		Employee em = (Employee) jdbc.queryForObject("select *from employee where id=?", new Object[] { id },
				new BeanPropertyRowMapper(Employee.class));
		return em;
	}

	public void deleteDao(int id) {
		jdbc.update("delete from employee where id=?", id);

	}

}
