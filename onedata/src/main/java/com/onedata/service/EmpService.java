package com.onedata.service;

import com.onedata.error.EmployeeNotFoundException;
import com.onedata.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface EmpService {


    public Employee saveEmp(Employee employee);

    public List<Employee> getAllEmployee();

    public Employee getByEmployeeId(Integer EmpId) throws EmployeeNotFoundException;

    public Employee updateEmployee(Employee Employee, int EmpId);


    public void deleteEmployee(int EmpId);



}
