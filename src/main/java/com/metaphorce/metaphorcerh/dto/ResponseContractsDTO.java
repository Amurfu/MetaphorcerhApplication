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
public class ResponseContractsDTO {
    
    
    @Setter@Getter
    private Boolean succes;
    @Setter@Getter
    private List<String> messages;
    
}
