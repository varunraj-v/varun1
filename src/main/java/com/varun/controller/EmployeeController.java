package com.varun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varun.model.Employee;
import com.varun.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

@Autowired
EmployeeService emps;

@GetMapping("/all")
public List <Employee> getController(){
return emps.getService();
}

@PostMapping("/add")
public void insertEmpCon(@RequestBody Employee e) {
emps.insertEmpService(e);
}

@PutMapping("/update/{id}")
public void updateEmpCon(@RequestBody Employee ee,@PathVariable int id) {
emps.updateEmpService(ee,id);
}

@GetMapping("/single/{id}")
public Employee singleCon(@PathVariable int id){
return emps.singleService(id);
}
    
@DeleteMapping("/delete/{id}")
public void deleteCon(@PathVariable int id) {
emps.deleteService(id);
System.out.println("deleted");
}
}

