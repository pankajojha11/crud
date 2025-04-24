package com.demo.crud.repository;

import com.demo.crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


//    @Query(nativeQuery = true, value = "SELECT * FROM \"employee-table\" WHERE age BETWEEN :startAge AND :endAge")
//    public List<Employee> getEmployeesInBetweenAge(int startAge, int endAge); // natve qury

    @Query("SELECT e FROM Employee e WHERE e.age BETWEEN ?1 AND ?2") //jpql
    public List<Employee> getEmployeesInBetweenAge(int startAge, int endAge);

    @Query("SELECT e FROM Employee e WHERE e.firstName = ?1") //jpql
    public List<Employee> getEmployeeByFirstName(String firstName);
}
// 30 , 40, 50, 60

// age1, age