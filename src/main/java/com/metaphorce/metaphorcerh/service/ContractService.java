/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.metaphorce.metaphorcerh.service;

import com.metaphorce.metaphorcerh.dto.ContractAddDto;
import com.metaphorce.metaphorcerh.dto.ResponseContractsDTO;
import java.util.List;

/**
 *
 * @author ramse
 */
public interface ContractService {
    
    public ResponseContractsDTO addContract(ContractAddDto contractAddDto);
    
     public boolean hasContract(Integer employeeId);
     
     public List<String> terminateContractByEmployee(Integer employeeId);
}
