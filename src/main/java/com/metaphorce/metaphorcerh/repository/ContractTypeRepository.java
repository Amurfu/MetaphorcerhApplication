/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.metaphorce.metaphorcerh.repository;

import com.metaphorce.metaphorcerh.model.Contracttype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author ramse
 */
public interface ContractTypeRepository  extends JpaRepository<Contracttype, Integer>{
    
    
    @Query("SELECT COUNT(c) FROM Contracttype c WHERE c.contractTypeId = ?1")
    public Integer contExistContractType(Integer contractTypeId);
    
    @Query("SELECT t FROM Contracttype t WHERE t.contractTypeId =?1")
    public Contracttype giveContractTypeById(Integer contractTypeId);
    
}
