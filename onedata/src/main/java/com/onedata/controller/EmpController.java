package com.onedata.controller;

import com.onedata.error.EmployeeNotFoundException;
import com.onedata.model.Employee;
import com.onedata.model.StatusMessage;
import com.onedata.service.EmpService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/onedata_employee")
@CrossOrigin
public class EmpController {

    @Autowired
    private EmpService empService;

    private final Logger logger = LoggerFactory.getLogger(EmpController.class);

    @PostMapping("/emp")
    public String add(@Valid @RequestBody Employee employee){
        empService.saveEmp(employee);
        return "employee has been added";
    }

    @GetMapping("/get_all_emp")
    public List<Employee> getAllStudent(){
        System.out.println("Inside return all student");
        return empService.getAllEmployee();
    }

    @GetMapping("/get_emp_by_id/{id}")
    public Employee getEmpById(@PathVariable("id") int empId) throws EmployeeNotFoundException{
        logger.info("Inside GetByIdDepartments");
        return empService.getByEmployeeId(empId);
    }

    @PutMapping("/update_emp/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") int empId){
        logger.info("Inside updateDepartments");
        Employee updatedEmployee = empService.updateEmployee(employee, empId);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete_emp/{id}")
    public void deleteEmployee(@PathVariable("id") Integer empId){
        logger.info("Inside Deleteemployee");
        this.empService.deleteEmployee(empId);

    }


//    http://127.0.0.1:8080/onedata_employee/delete_emp/22

//    http://127.0.0.1:8080/onedata_employee//update_emp/{id}

//    http://127.0.0.1:8080/onedata_employee/get_emp_by_id/{id}


}
