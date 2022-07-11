/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.metaphorce.metaphorcerh.repository;

import com.metaphorce.metaphorcerh.model.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author ramse
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    

    @Query(value ="SELECT * FROM employee e  WHERE e.IsActive",nativeQuery = true)
    public List<Employee> findAllActive();
    
    @Query(value = "SELECT COUNT(e) FROM Employee e WHERE e.employeeId = ?1")
    public Integer countExistEmployee(Integer employeeId);
    
    /**
     *
     * @param employeeId
     * @return Employee
     */
    @Query("SELECT e FROM Employee e WHERE e.employeeId = ?1")
    public Employee findByEmployyeId(Integer employeeId);
    
    @Query("SELECT COUNT(e) FROM Employee e WHERE e.taxIdNumber = ?1")
    public Integer countTaxNumberRepeat(String taxIdNumber );
}
