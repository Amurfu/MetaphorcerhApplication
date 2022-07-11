package com.metaphorce.metaphorcerh.service.impl;

import com.metaphorce.metaphorcerh.dto.EmployeeAddDTO;
import com.metaphorce.metaphorcerh.dto.EmployeeDto;
import com.metaphorce.metaphorcerh.dto.ResponseEmployeesDTO;
import com.metaphorce.metaphorcerh.model.Contract;
import com.metaphorce.metaphorcerh.model.Employee;
import com.metaphorce.metaphorcerh.repository.EmployeeRepository;
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
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepo;
    
    @Autowired
    ContractService contractService;
    
    private ResponseEmployeesDTO responseEmployeesDTO;
    
    private List<String> messages;

    //obtains all acrtive employees and converts them to a DTO
    @Override
    public ResponseEmployeesDTO getAllActive() {
        responseEmployeesDTO = new ResponseEmployeesDTO();
        messages = new ArrayList<>();
        List<Employee> lstEmployees = employeeRepo.findAllActive();
        List<EmployeeDto> lstEmployeeDtos = new ArrayList<>();
        for (Employee empl : lstEmployees) {
            EmployeeDto emplDto = new EmployeeDto();
            emplDto.setName(empl.getName());
            emplDto.setLastName(empl.getLastName());
            emplDto.setTaxIdNumber(empl.getTaxIdNumber());
            emplDto.setEmail(empl.getEmail());
            validate(empl, emplDto);
            lstEmployeeDtos.add(emplDto);
        }
        messages.add(String.format("%s records successfully found", lstEmployeeDtos.size()));
        responseEmployeesDTO.setData(lstEmployeeDtos);
        responseEmployeesDTO.setSucess(Boolean.TRUE);
        responseEmployeesDTO.setMessage(messages);
        return responseEmployeesDTO;
    }
    
    private void validate(Employee empl, EmployeeDto emplDto) {
        Contract contract = null;
        for (Contract c : empl.getContractList()) {
            if (c.getIsActive()) {
                contract = c;
            }
        }
        if (contract == null) {
            emplDto.setContractType(null);
            emplDto.setDateStartContract(null);
            emplDto.setDateEndContract(null);
            emplDto.setSalary(null);
        } else {
            emplDto.setContractType(contract.getContractTypeId().getName());
            emplDto.setDateStartContract(contract.getDateFrom());
            emplDto.setDateEndContract(contract.getDateTo());
            emplDto.setSalary(contract.getSalaryPerDay());
        }
    }
    
    @Override
    public boolean existEmployye(Integer employyeId) {
        return employeeRepo.countExistEmployee(employyeId) > 0;
    }
    
    @Override
    public Employee getEmployeeById(Integer employeeId) {
        return employeeRepo.findByEmployyeId(employeeId);
    }
    
    @Override
    public ResponseEmployeesDTO saveEmployee(EmployeeAddDTO employeeDto) {
        messages = new ArrayList<>();
        responseEmployeesDTO = new ResponseEmployeesDTO();
        if (passValidations(employeeDto, true)) {
            save(convertEmployee(employeeDto), true);
        }
        responseEmployeesDTO.setMessage(messages);
        return responseEmployeesDTO;
    }
    
    private boolean passValidations(EmployeeAddDTO employeeDto, Boolean isNew) {
        boolean passValidations = true;
        if (employeeDto.getTaxIdNumber() == null) {
            messages.add("You must enter a value in field TaxIdNumber.");
            passValidations = false;
        } else if (employeeDto.getTaxIdNumber().length() != 13) {
            messages.add("The TaxIdNumber field does not comply with the established 13 characters.");
            passValidations = false;
        } else if (!validateFormatTaxNumber(employeeDto.getTaxIdNumber())) {
            messages.add("Invalid TaxIdNumber field.");
            passValidations = false;
        } else if (validateExistTaxNumber(employeeDto.getTaxIdNumber()) && isNew) {
            messages.add("The TaxIdNumber field has already been registered with another employee.");
            passValidations = false;
        }
        if (employeeDto.getName() == null) {
            messages.add("You must enter a name.");
            passValidations = false;
        } else if (employeeDto.getName().length() > 60) {
            messages.add("Exceeded the number of characters allowed in the name field.");
            passValidations = false;
        }
        if (employeeDto.getLastName() == null) {
            messages.add("You must enter the last name.");
            passValidations = false;
        } else if (employeeDto.getLastName().length() > 120) {
            messages.add("Exceeded the number of characters allowed in the last name field.");
            passValidations = false;
        }
        if (employeeDto.getEmail() == null) {
            messages.add("You must enter an email address.");
            passValidations = false;
        } else if (employeeDto.getEmail().length() > 60) {
            messages.add("Exceeded the number of characters allowed in the email field.");
            passValidations = false;
        }
        if (employeeDto.getBirthDate() == null) {
            messages.add("You must enter a birthday date.");
            passValidations = false;
        }
        if (employeeDto.getCellPhone() == null) {
            messages.add("You must enter a phone number.");
            passValidations = false;
        } else if (employeeDto.getCellPhone().length() > 20) {
            messages.add("Exceeded the number of characters allowed in the cellphone field.");
            passValidations = false;
        }
        responseEmployeesDTO.setSucess(passValidations);
        return passValidations;
    }
    
    private boolean validateFormatTaxNumber(String taxIdNumber) {
        String re = "^([A-ZÑ&]{3,4}) ?(?:- ?)?(\\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[12]\\d|3[01])) ?(?:- ?)?([A-Z\\d]{2})([A\\d])$";
        return taxIdNumber.matches(re);
    }
    
    private boolean validateExistTaxNumber(String taxIdNumber) {
        return employeeRepo.countTaxNumberRepeat(taxIdNumber) > 0;
    }
    
    private Employee convertEmployee(EmployeeAddDTO employeeDto) {
        Employee empl = new Employee();
        empl.setTaxIdNumber(employeeDto.getTaxIdNumber());
        empl.setName(employeeDto.getName());
        empl.setLastName(employeeDto.getLastName());
        empl.setBirthDate(employeeDto.getBirthDate());
        empl.setEmail(employeeDto.getEmail());
        empl.setCellPhone(employeeDto.getCellPhone());
        empl.setIsActive(true);
        empl.setDateCreated(new Date());
        return empl;
    }
    
    private void save(Employee convertEmployee, boolean isNew) {
        employeeRepo.save(convertEmployee);
        responseEmployeesDTO.setSucess(Boolean.TRUE);
        messages.add(String.format("Successfully %s employee [%s].", isNew ? "registered" : "updated", convertEmployee.getEmployeeId()));
    }
    
    @Override
    public ResponseEmployeesDTO updateEmployee(EmployeeAddDTO employeeDto) {
        responseEmployeesDTO = new ResponseEmployeesDTO();
        messages = new ArrayList<>();
        if (passValidations(employeeDto, Boolean.FALSE) && employeeDto.getEmployeeId() != null) {
            if (passNewTaxValidations(employeeDto)) {
                Employee employee = convertEmployee(employeeDto);
                employee.setEmployeeId(employeeDto.getEmployeeId());
                save(employee, false);
            } else {
                responseEmployeesDTO.setSucess(Boolean.FALSE);
            }
        } else if (employeeDto.getEmployeeId() == null) {
            messages.add("You must enter a valid id");
        }
        responseEmployeesDTO.setMessage(messages);
        return responseEmployeesDTO;
    }
    
    private Boolean passNewTaxValidations(EmployeeAddDTO employeeDto) {
        boolean pass = true;
        if (existEmployye(employeeDto.getEmployeeId())) {
            Employee employee = getEmployeeById(employeeDto.getEmployeeId());
            if (!employeeDto.getTaxIdNumber().equals(employee.getTaxIdNumber())) {
                if (validateExistTaxNumber(employeeDto.getTaxIdNumber())) {
                    pass = false;
                    messages.add("The TaxIdNumber field has already been registered with another employee.");
                }
            }
        } else {
            pass = false;
            messages.add("Employee not found.");
        }
        return pass;
    }

    @Override
    public ResponseEmployeesDTO removeContractByEmployee(Integer employeeId) {
       responseEmployeesDTO = new ResponseEmployeesDTO();
       messages = new ArrayList<>();
       if(existEmployye(employeeId)){
           if(contractService.hasContract(employeeId)){
               messages = contractService.terminateContractByEmployee(employeeId);
               responseEmployeesDTO.setSucess(Boolean.TRUE);
           }else{
               messages.add("The employee has no active contracts.");
               responseEmployeesDTO.setSucess(false);
           }
       }else{
          messages.add("Employee not found.");
          responseEmployeesDTO.setSucess(Boolean.FALSE);
       }
       responseEmployeesDTO.setMessage(messages);
       return responseEmployeesDTO;
    }
    
}
