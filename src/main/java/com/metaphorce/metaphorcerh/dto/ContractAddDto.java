/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metaphorce.metaphorcerh.dto;

import java.util.Date;

import com.metaphorce.metaphorcerh.repository.ContractRepository;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ramse
 */
public class ContractAddDto {
    
    @Setter@Getter
    private Integer employeeId;
    @Setter@Getter
    private Integer contractTypeId;
    @Setter@Getter
    private Date dateFrom;
    @Setter@Getter
    private Date dateTo;
    @Setter@Getter
    private long salaryPerDay;
    @Setter@Getter
    private Boolean isActive;
    
    
}
