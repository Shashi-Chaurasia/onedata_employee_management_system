package com.onedata.service;

import com.onedata.error.EmployeeNotFoundException;
import com.onedata.model.Employee;
import com.onedata.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmpServiceImp implements EmpService{

    @Autowired
    private EmpRepository EmpRepository;

    @Override
    public Employee saveEmp(Employee Employee) {
        return EmpRepository.save(Employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return EmpRepository.findAll();
    }

    @Override
    public Employee getByEmployeeId(Integer EmpId) throws EmployeeNotFoundException {
        Optional<Employee> dOptional = EmpRepository.findById(EmpId);
        if (!dOptional.isPresent()) {
            throw new EmployeeNotFoundException("Employee Not Available !");

        }
        return dOptional.get();
      
    }


    @Override
    public Employee updateEmployee(Employee Employee, int EmpId) {
        Employee EmpDB = EmpRepository.findById(EmpId).get();

        if (Objects.nonNull(Employee.getEmpName()) &&
                !"".equalsIgnoreCase(Employee.getEmpName())) {
            EmpDB.setEmpName(Employee.getEmpName());
        }
        if (Objects.nonNull(Employee.getEmpAddress()) &&
                !"".equalsIgnoreCase(Employee.getEmpAddress())) {
            EmpDB.setEmpAddress(Employee.getEmpAddress());
        }
        if (Objects.nonNull(Employee.getEmpDeptId()) &&
        !"".equalsIgnoreCase(Employee.getEmpDeptId())){
            EmpDB.setEmpDeptId(Employee.getEmpDeptId());
        }
        if (Objects.nonNull(Employee.getEmpSalary()) &&
                !"".equals(Employee.getEmpSalary())){
            EmpDB.setEmpSalary(Employee.getEmpSalary());
        }
        if (Objects.nonNull(Employee.getEmpEmail()) &&
                !"".equalsIgnoreCase(Employee.getEmpEmail())){
            EmpDB.setEmpEmail(Employee.getEmpEmail());
        }
        return EmpRepository.save(EmpDB);

    }

    @Override
    public void deleteEmployee(int EmpId) {
        EmpRepository.deleteById(EmpId);

    }
}
