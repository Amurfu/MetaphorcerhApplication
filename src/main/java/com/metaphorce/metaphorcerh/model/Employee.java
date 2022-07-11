/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metaphorce.metaphorcerh.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ramse
 */
@Entity
@Table(name = "employee")
@XmlRootElement
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "employeeid")
    @Setter@Getter
    private Integer employeeId;
    @Basic(optional = false)
    @Column(name = "taxidnumber")
    @Setter@Getter
    private String taxIdNumber;
    @Basic(optional = false)
    @Column(name = "name")
    @Setter@Getter
    private String name;
    @Basic(optional = false)
    @Column(name = "lastname")
    @Setter@Getter
    private String lastName;
    @Basic(optional = false)
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    @Setter@Getter
    private Date birthDate;
    @Basic(optional = false)
    @Column(name = "email")
    @Setter@Getter
    private String email;
    @Basic(optional = false)
    @Column(name = "cellphone")
    @Setter@Getter
    private String cellPhone;
    @Basic(optional = false)
    @Column(name = "isactive")
    @Setter@Getter
    private Boolean isActive;
    @Basic(optional = false)
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    @Setter@Getter
    private Date dateCreated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    @Setter@Getter
    private List<Contract> contractList;

    public Employee() {
    }

    public Employee(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Employee(Integer employeeId, String taxIdNumber, String name, String lastName, Date birthDate, String email, String cellPhone, Boolean isActive, Date dateCreated) {
        this.employeeId = employeeId;
        this.taxIdNumber = taxIdNumber;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.cellPhone = cellPhone;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metaphorce.metaphorcerh.model.Employee[ employeeId=" + employeeId + " ]";
    }
    
}
