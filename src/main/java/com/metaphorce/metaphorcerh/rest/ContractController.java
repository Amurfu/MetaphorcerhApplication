/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metaphorce.metaphorcerh.rest;

import com.metaphorce.metaphorcerh.dto.ContractAddDto;
import com.metaphorce.metaphorcerh.dto.ResponseContractsDTO;
import com.metaphorce.metaphorcerh.service.ContractService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ramse
 */
@RestController
public class ContractController {

    private static Logger log = LogManager.getLogger(EmployeeController.class);

    @Autowired
    ContractService contractService;

    @Operation(summary = "Saves a new contract.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns the success field as true and with a message with the contract id.",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseContractsDTO.class))}),
        @ApiResponse(responseCode = "400", description = "Returns the success field as false and and with the message value with the validation errors ",content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseContractsDTO.class))}
               )})
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/api/contracts/add/")
    public ResponseEntity<ResponseContractsDTO> saveContract(@RequestBody ContractAddDto contractAddDto) {
        ResponseContractsDTO message = contractService.addContract(contractAddDto);
        if (message.getSucces()) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }
}
