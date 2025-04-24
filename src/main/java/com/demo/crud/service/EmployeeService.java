package com.demo.crud.service;

import com.demo.crud.model.Employee;

import java.util.List;

public interface EmployeeService {

    public abstract Employee addEmployee(Employee employee);

    public abstract Employee getEmployee(int empId);

    public abstract String updateEmployee(int empId, Employee employee);

    public abstract void deleteEmployee(int empId);

    public abstract List<Employee> getAllEmployee();

    public abstract void deleteAllEmployee();

    public abstract List<Employee> getAllEmployeeAgeInBetween(int startAge, int endAge);

    public abstract List<Employee> getEmployeesByFirstName(String firstName);
}
