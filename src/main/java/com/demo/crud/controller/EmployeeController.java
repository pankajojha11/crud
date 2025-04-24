package com.demo.crud.controller;

import com.demo.crud.model.Employee;
import com.demo.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // https://en-gb.facebook.com/r.php?entry_point=login
@RequestMapping("/employees")   // http://localhost:8080/test/print
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;

    @GetMapping("/print")
    public String printMessage() {
        return "Hello World";
    }

    // create //    insert
    //    into
    //        "employee-table"
    //        (age, first_name, last_name, salary, emp_id)
    //    values
    //        (300, 'aaa', 'v', 5000, 40)
    @PostMapping("/create") // // http://localhost:8080/employees/create
    public String createEmployee(@RequestBody Employee employee) {
        Employee emp = employeeService.addEmployee(employee);
        if (emp != null) {
            return "Employee created successfully";
        } else {
            return "Employee Not created";
        }
    }

    // get // Select * from database.employee_table where emp_id = 52
    @GetMapping("/get/{empId}") // http://localhost:8080/employees/get/1
    public String getEmployee(@PathVariable int empId) {
        Employee emp = employeeService.getEmployee(empId);
        if (emp != null) {
            return emp.toString();
        } else {
            return "Employee doesn't exist with the emp Id : " + empId;
        }
    }

    // update
    @PutMapping("/update/{empId}") // http://localhost:8080/employees/update/1
    public String updateEmployee(@PathVariable int empId, @RequestBody Employee employee) {
        return employeeService.updateEmployee(empId, employee);
    }

    // delete
    @DeleteMapping("/delete/{empId}") // http://localhost:8080/employees/delete/1
    public String deleteEmployee(@PathVariable int empId) {
        employeeService.deleteEmployee(empId);
        return "Employee Deleted Successfully";
    }

    // get all employees // SELECT * FROM "employee-table"
    @GetMapping("/get-all")  // http://localhost:8080/employees/get-all
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    // delete all the employees
    @DeleteMapping("/delete-all")  // http://localhost:8080/employees/delete-all
    public String deleteAllEmployee() {
        employeeService.deleteAllEmployee();
        return "Deleted all the employees data";
    }

    // all the employee age is in between 40  to 50
    @GetMapping("/get-in-between/{startingAge}/{finalAge}") //http://localhost:8080/employees/get-in-between/30/40
    public String getAllEmployeeAgeInBetween(@PathVariable int startingAge, @PathVariable int finalAge) {
        if (startingAge < finalAge) {
            List<Employee> employees = employeeService.getAllEmployeeAgeInBetween(startingAge, finalAge);
            return employees.toString();
        } else {
            return "Start age must be smaller than final age";
        }
    }

    @GetMapping("/get-by-firstname/{firstName}") //http://localhost:8080/employees/get-in-between/30/40
    public List<Employee> getEmployeesByFirstName(@PathVariable String firstName) {
        List<Employee> employees = employeeService.getEmployeesByFirstName(firstName);
        return employees;
    }

}

// predefined methods
//jpql
//native query