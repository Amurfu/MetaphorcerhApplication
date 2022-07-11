package com.metaphorce.metaphorcerh.rest;

import com.metaphorce.metaphorcerh.dto.EmployeeAddDTO;
import com.metaphorce.metaphorcerh.dto.EmployeeDto;
import com.metaphorce.metaphorcerh.dto.ResponseContractsDTO;
import com.metaphorce.metaphorcerh.dto.ResponseEmployeesDTO;
import com.metaphorce.metaphorcerh.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ramse
 */
@RestController
public class EmployeeController {

    private static Logger log = LogManager.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    
     @Operation(summary = "Return all active employees.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns the success field as true,a list with the employees found and a message of the number of employees found.",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEmployeesDTO.class))})})
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/api/employee/actives")
    public ResponseEntity<ResponseEmployeesDTO> giveAllActives() {
        ResponseEmployeesDTO message = employeeService.getAllActive();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    
    @Operation(summary = "Register an employee.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns the success field as true and with a message with the employee id.",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEmployeesDTO.class))}),
        @ApiResponse(responseCode = "400", description = "Returns the success field as false and and with the message value with the validation errors ",content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEmployeesDTO.class))}
               )})
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/api/employye/new")
    public ResponseEntity<ResponseEmployeesDTO> saveEmployye(@RequestBody EmployeeAddDTO employeeDto) {
        ResponseEmployeesDTO message = employeeService.saveEmployee(employeeDto);
        if (message.getSucess()) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

    
    
    @Operation(summary = "Update an employee.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns the success field as true and with a message with the employee id.",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEmployeesDTO.class))}),
        @ApiResponse(responseCode = "400", description = "Returns the success field as false and and with the message value with the validation errors ",content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEmployeesDTO.class))}
               )})
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/api/employye/update")
    public ResponseEntity<ResponseEmployeesDTO> updateEmployye(@RequestBody EmployeeAddDTO employeeDto) {
        ResponseEmployeesDTO message = employeeService.updateEmployee(employeeDto);
        if (message.getSucess()) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }
    
    
    @Operation(summary = "Removes the active contract of the indicated employee.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns the success field as true and with and a message with the terminated contract id.",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEmployeesDTO.class))}),
        @ApiResponse(responseCode = "400", description = "Returns the success field as false and with and a message with the error encountered.",content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEmployeesDTO.class))}
               )})
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/api/employye/contract/remove")
     public ResponseEntity<ResponseEmployeesDTO> removeContractByEmployee(@RequestBody Integer employeeId) {
        ResponseEmployeesDTO message = employeeService.removeContractByEmployee(employeeId);
        if (message.getSucess()) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

}
