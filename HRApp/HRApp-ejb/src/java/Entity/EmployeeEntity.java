/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author hangsun
 */
@Entity
public class EmployeeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String email;
    
    private String password;
    private String title;
    private String position;
    private String firstName;
    private String middleName;
    private String lastName;
    private Integer age;
    private String contactNum;
    private String department;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "employee")
    private List<SalaryEntity> salaryList = new ArrayList();
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "employee")
    private List<LeaveEntity> leaveList = new ArrayList();
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "employee")
    private List<CheckInEntity> checkInList = new ArrayList();

    public EmployeeEntity() {
    }
    
    public EmployeeEntity(String email,String password,String title,String position,String firstName,String middleName,String lastName,Integer age,String contactNum,String department){
        this.email = email;
        this.password = password;
        this.title = title;
        this.position = position;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.contactNum = contactNum;
        this.department = department;             
    }

    public List<CheckInEntity> getCheckInList() {
        return checkInList;
    }

    public void setCheckInList(List<CheckInEntity> checkInList) {
        this.checkInList = checkInList;
    }
    
    

    public List<LeaveEntity> getLeaveList() {
        return leaveList;
    }

    public void setLeaveList(List<LeaveEntity> leaveList) {
        this.leaveList = leaveList;
    }

    public List<SalaryEntity> getSalaryList() {
        return salaryList;
    }

    public void setSalaryList(List<SalaryEntity> salaryList) {
        this.salaryList = salaryList;
    }

    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the email fields are not set
        if (!(object instanceof EmployeeEntity)) {
            return false;
        }
        EmployeeEntity other = (EmployeeEntity) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.User[ id=" + email + " ]";
    }
    
}
