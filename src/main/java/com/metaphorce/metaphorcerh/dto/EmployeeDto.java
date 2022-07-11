
package com.metaphorce.metaphorcerh.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ramse
 */
public class EmployeeDto {


    @Setter@Getter
    private String name;

    @Setter@Getter
    private String lastName;

    @Setter@Getter
    private String taxIdNumber;

    @Setter@Getter
    private String email;

    @Setter@Getter
    private String contractType;

    @Setter@Getter
    private Date dateStartContract;

    @Setter@Getter
    private Date dateEndContract;

    @Setter@Getter
    private Long salary;

}
