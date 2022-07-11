/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.metaphorce.metaphorcerh.repository;

import com.metaphorce.metaphorcerh.model.Contract;
import com.metaphorce.metaphorcerh.model.Contracttype;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author ramse
 */
public interface ContractRepository extends JpaRepository<Contract, Long>{
    
    
    @Query( value = "SELECT COUNT(*) FROM Contract c WHERE c.employeeId = ?1 AND c.isActive",nativeQuery = true)
    public Integer contActiveContractsByEmployee(Integer employeeId);
    
    
    @Query(value = "SELECT * FROM contract c WHERE c.employeeId =?1 AND c.isActive",nativeQuery = true)
    public List<Contract>findbyEmployyeId(Integer employeeId);
    
    
    
    
    
}
