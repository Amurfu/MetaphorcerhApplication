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
@Table(name = "contracttype")
@XmlRootElement
public class Contracttype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contracttypeid")
    @Setter@Getter
    private Integer contractTypeId;
    @Basic(optional = false)
    @Column(name = "name")
    @Setter@Getter
    private String name;
    @Column(name = "description")
    @Setter@Getter
    private String description;
    @Basic(optional = false)
    @Column(name = "isactive")
    @Setter@Getter
    private Boolean isActive;
    @Basic(optional = false)
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    @Setter@Getter
    private Date dateCreated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contractTypeId")
    @Setter@Getter
    private List<Contract> contractList;

    public Contracttype() {
    }

    public Contracttype(Integer contractTypeId) {
        this.contractTypeId = contractTypeId;
    }

    public Contracttype(Integer contractTypeId, String name, Boolean isActive, Date dateCreated) {
        this.contractTypeId = contractTypeId;
        this.name = name;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
    }

 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contractTypeId != null ? contractTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contracttype)) {
            return false;
        }
        Contracttype other = (Contracttype) object;
        if ((this.contractTypeId == null && other.contractTypeId != null) || (this.contractTypeId != null && !this.contractTypeId.equals(other.contractTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metaphorce.metaphorcerh.model.Contracttype[ contractTypeId=" + contractTypeId + " ]";
    }
    
}
