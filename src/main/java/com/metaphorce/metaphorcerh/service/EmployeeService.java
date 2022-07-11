
package com.metaphorce.metaphorcerh.service;

import com.metaphorce.metaphorcerh.dto.EmployeeAddDTO;
import com.metaphorce.metaphorcerh.dto.ResponseEmployeesDTO;
import com.metaphorce.metaphorcerh.model.Employee;

/**
 *
 * @author ramse
 */
public interface EmployeeService {

    public ResponseEmployeesDTO getAllActive();

    boolean existEmployye(Integer employyeId);

    public Employee getEmployeeById(Integer employeeId);

    public ResponseEmployeesDTO saveEmployee(EmployeeAddDTO employeeDto);

    public ResponseEmployeesDTO updateEmployee(EmployeeAddDTO employeeDto);

    public ResponseEmployeesDTO removeContractByEmployee(Integer employeeId);

}
