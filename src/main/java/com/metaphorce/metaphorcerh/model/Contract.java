
package com.metaphorce.metaphorcerh.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ramse
 */
@Entity
@Table(name = "contract")
@XmlRootElement
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contractid")
    @Setter@Getter
    private Long contractId;
    @Basic(optional = false)
    @Column(name = "datefrom")
    @Temporal(TemporalType.TIMESTAMP)
    @Setter@Getter
    private Date dateFrom;
    @Basic(optional = false)
    @Column(name = "dateto")
    @Temporal(TemporalType.TIMESTAMP)
    @Setter@Getter
    private Date dateTo;
    @Basic(optional = false)
    @Column(name = "salaryperday")
    @Setter@Getter
    private long salaryPerDay;
    @Basic(optional = false)
    @Column(name = "isactive")
    @Setter@Getter
    private Boolean isActive;
    @Basic(optional = false)
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    @Setter@Getter
    private Date dateCreated;
    @JoinColumn(name = "contracttypeid", referencedColumnName = "ContractTypeId")
    @ManyToOne(optional = false)
    @Setter@Getter
    private Contracttype contractTypeId;
    @JoinColumn(name = "employeeid", referencedColumnName = "EmployeeId")
    @ManyToOne(optional = false)
    @Setter@Getter
    private Employee employeeId;

    public Contract() {
    }

    public Contract(Long contractId) {
        this.contractId = contractId;
    }

    public Contract(Long contractId, Date dateFrom, Date dateTo, long salaryPerDay, Boolean isActive, Date dateCreated) {
        this.contractId = contractId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.salaryPerDay = salaryPerDay;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contractId != null ? contractId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contract)) {
            return false;
        }
        Contract other = (Contract) object;
        if ((this.contractId == null && other.contractId != null) || (this.contractId != null && !this.contractId.equals(other.contractId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metaphorce.metaphorcerh.model.Contract[ contractId=" + contractId + " ]";
    }
    
}
