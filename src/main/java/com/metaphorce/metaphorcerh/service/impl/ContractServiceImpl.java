/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metaphorce.metaphorcerh.service.impl;

import com.metaphorce.metaphorcerh.dto.ContractAddDto;
import com.metaphorce.metaphorcerh.dto.ResponseContractsDTO;
import com.metaphorce.metaphorcerh.model.Contract;
import com.metaphorce.metaphorcerh.model.Contracttype;
import com.metaphorce.metaphorcerh.repository.ContractRepository;
import com.metaphorce.metaphorcerh.repository.ContractTypeRepository;
import com.metaphorce.metaphorcerh.service.ContractService;
import com.metaphorce.metaphorcerh.service.EmployeeService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ramse
 */

@Service
public class ContractServiceImpl implements ContractService{
    
    @Autowired
    private ContractRepository contractRepository;
    
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private ContractTypeRepository contractTypeRepository;
    
    private List<String> messages;
    
    private ResponseContractsDTO response;

    @Override
    public ResponseContractsDTO addContract(ContractAddDto contractAddDto) {
        messages = new ArrayList<>();
        response = new ResponseContractsDTO();
        if(passValidations(contractAddDto)){
           validateContracts(contractAddDto.getEmployeeId());
           saveNewContract(contractAddDto);
        }
        response.setMessages(messages);
        return response;
    }

    private boolean passValidations(ContractAddDto contractAddDto) {
          boolean passValidations = true;
          if(contractAddDto.getEmployeeId() == null){
              messages.add("No valid id");
              passValidations = false;
          }else if(!existEmployye(contractAddDto.getEmployeeId())){
                messages.add("Employee with found");
                passValidations = false;
          }
          if(contractAddDto.getContractTypeId() == null){
              messages.add("No valid contract type");
              passValidations = false;
          }else if(!existContractType(contractAddDto.getContractTypeId())){
              messages.add("The contract type value is not found in the catalog.");
              passValidations = false;
          }
          
          response.setSucces(passValidations);
          return passValidations;
    }


    private boolean existEmployye(Integer employyeId) {
       return employeeService.existEmployye(employyeId);
    }

    private void validateContracts(Integer employeeId) {
        if(hasContract(employeeId)){
            terminateContracts(employeeId);
        }
    }

    @Override
    public boolean hasContract(Integer employeeId) {
        return contractRepository.contActiveContractsByEmployee(employeeId) > 0;
    }

    private void terminateContracts(Integer employeeId) {
        List<Contract> lstContracts = contractRepository.findbyEmployyeId(employeeId);
        for(Contract c : lstContracts){
            c.setDateTo(new Date());
            c.setIsActive(false);
            messages.add(String.format("Contract %s terminated ", c.getContractId()));
        }
        contractRepository.saveAll(lstContracts);
    }

    private void saveNewContract(ContractAddDto contractAddDto) {
        Contract contract = new Contract();
        contract.setEmployeeId(employeeService.getEmployeeById(contractAddDto.getEmployeeId()));
        contract.setContractTypeId(gieContractTypeById(contractAddDto.getContractTypeId()));
        contract.setDateFrom(contractAddDto.getDateFrom());
        contract.setDateTo(contractAddDto.getDateTo());
        contract.setSalaryPerDay(contractAddDto.getSalaryPerDay());
        contract.setIsActive(Boolean.TRUE);
        contract.setDateCreated(new Date());
        contractRepository.save(contract);
        messages.add(String.format("New contract (%s) successfully registered", contract.getContractId()));
        response.setSucces(Boolean.TRUE);
    }

    private Contracttype gieContractTypeById(Integer contractTypeId) {
        return contractTypeRepository.giveContractTypeById(contractTypeId);
    }

    private boolean existContractType(Integer contractTypeId) {
       return contractTypeRepository.contExistContractType(contractTypeId) > 0;
    }

    @Override
    public List<String> terminateContractByEmployee(Integer employeeId) {
        messages = new ArrayList<>();
        terminateContracts(employeeId);
        return messages;
    }
    
}
