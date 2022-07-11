package com.metaphorce.metaphorcerh.service.impl;

import com.metaphorce.metaphorcerh.dto.ContractAddDto;
import com.metaphorce.metaphorcerh.model.Contract;
import com.metaphorce.metaphorcerh.model.Contracttype;
import com.metaphorce.metaphorcerh.model.Employee;
import com.metaphorce.metaphorcerh.repository.ContractRepository;
import com.metaphorce.metaphorcerh.repository.ContractTypeRepository;
import com.metaphorce.metaphorcerh.service.ContractService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ContractServiceImplTest {

    @Mock
    private ContractRepository contractRepository;

    @Autowired
    private ContractTypeRepository contractTypeRepository;

    @InjectMocks
    private ContractServiceImpl contractService;

    private Contract contract;

    private Contracttype contracttype;

    private Integer idReturn = 1;



    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        contract = new Contract();
        contract.setContractTypeId(new Contracttype(1,"Test",true,new Date()));
        contract.setDateCreated(new Date());
        contract.setDateFrom(new Date());
        contract.setDateTo(new Date());
        contract.setContractId(1l);
        contract.setEmployeeId(new Employee());
        contract.setIsActive(true);
        contract.setSalaryPerDay(1l);

        contracttype = new Contracttype();
        contracttype.setContractTypeId(1);
        contracttype.setDescription("Test");
        contracttype.setName("Test");
        contracttype.setIsActive(true);
        contracttype.setDateCreated(new Date());

    }

    @Test
    void addContract() {
        when(contractRepository.save(any(Contract.class))).thenReturn(contract);
        //when(contractTypeRepository.contExistContractType(any())).thenReturn(1);
        ContractAddDto add = new ContractAddDto();
        add.setContractTypeId(1);
        add.setDateFrom(new Date());
        add.setDateTo(new Date());
        add.setEmployeeId(1);
        add.setIsActive(true);
        add.setSalaryPerDay(1l);
       // assertNotNull(contractService.addContract(add));
    }

    @Test
    void hasContract() {
    }

    @Test
    void terminateContractByEmployee() {
    }
}