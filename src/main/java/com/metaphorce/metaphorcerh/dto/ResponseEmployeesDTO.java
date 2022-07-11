/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metaphorce.metaphorcerh.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ramse
 */
public class ResponseEmployeesDTO {
    
    @Setter@Getter
    private Boolean Sucess;
    @Setter@Getter
    private List<EmployeeDto> data;
    @Setter@Getter
    private List<String> message;
    
}
