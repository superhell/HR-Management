/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author hangsun
 */
@Entity
public class LeaveEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar generatedDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar fromDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar toDate;
    private Integer leaveResult;// 0 not decided yet, 1 for approve, -1 for reject
    private String reason;
    
    @ManyToOne
    private EmployeeEntity employee;

    public LeaveEntity() {
    }

    public LeaveEntity(Calendar fromDate, Calendar toDate, String reason,EmployeeEntity employee){
        this.generatedDate = Calendar.getInstance();
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.reason = reason;
        this.leaveResult = 0;
        this.employee = employee;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
    
    
    public Calendar getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(Calendar generatedDate) {
        this.generatedDate = generatedDate;
    }

    public Calendar getFromDate() {
        return fromDate;
    }

    public void setFromDate(Calendar fromDate) {
        this.fromDate = fromDate;
    }

    public Calendar getToDate() {
        return toDate;
    }

    public void setToDate(Calendar toDate) {
        this.toDate = toDate;
    }

    public Integer getLeaveResult() {
        return leaveResult;
    }

    public void setLeaveResult(Integer leaveResult) {
        this.leaveResult = leaveResult;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LeaveEntity)) {
            return false;
        }
        LeaveEntity other = (LeaveEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.LeaveEntity[ id=" + id + " ]";
    }
    
}
