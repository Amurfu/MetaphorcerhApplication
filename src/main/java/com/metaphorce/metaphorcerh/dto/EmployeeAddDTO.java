/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metaphorce.metaphorcerh.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ramse
 */
public class EmployeeAddDTO {
    
    
    @Setter@Getter
    private Integer employeeId;
    
    @Setter@Getter
    private String name;

    @Setter@Getter
    private String lastName;

    @Setter@Getter
    private String taxIdNumber;

    @Setter@Getter
    private String email;
    
    @Setter@Getter
    private Date birthDate;
    
    @Setter@Getter
    private String cellPhone;
}
