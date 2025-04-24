package com.demo.crud.service;

import com.demo.crud.model.Employee;
import com.demo.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int empId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(empId);
        if (employeeOptional.isPresent())
            return employeeOptional.get();
        else
            return null;
    }

    @Override
    public String updateEmployee(int empId, Employee employee) {
        // fetch the data pf the user using pk
        Optional<Employee> employeeOptional = employeeRepository.findById(empId);
        Employee emp = null;
        if (employeeOptional.isPresent())
            emp = employeeOptional.get();
        if (emp != null) {
            // set data
            if (employee != null) {
                if (employee.getAge() != null) emp.setAge(employee.getAge());
                else if (employee.getFirstName() != null) emp.setFirstName(employee.getFirstName());
                else if (employee.getLastName() != null) emp.setLastName(employee.getLastName());
                else if (employee.getSalary() != null) emp.setSalary(employee.getSalary());
            }
        } else
            return "Employee doesn't exist with the emp Id : " + empId;

        // save update
        return employeeRepository.save(emp) != null ? "Employee data updated Successfully" : "Employee data not updated";
    }

    @Override
    public void deleteEmployee(int empId) {
        employeeRepository.deleteById(empId);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteAllEmployee() {
        employeeRepository.deleteAll();
    }

    @Override
    public List<Employee> getAllEmployeeAgeInBetween(int startAge, int endAge) {
        return employeeRepository.getEmployeesInBetweenAge(startAge, endAge);
    }

    @Override
    public List<Employee> getEmployeesByFirstName(String firstName) {
        return employeeRepository.getEmployeeByFirstName(firstName);
    }
}