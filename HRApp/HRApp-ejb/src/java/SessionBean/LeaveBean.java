/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.EmployeeEntity;
import Entity.LeaveEntity;
import Entity.SalaryEntity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author hangsun
 */
@Stateless
@WebService
public class LeaveBean implements LeaveBeanLocal {

    
    @PersistenceContext
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @WebMethod(operationName = "createLeave")
    public void createLeave(
            @WebParam(name = "email") String email, 
            @WebParam(name = "fromDate") Calendar fromDate, 
            @WebParam(name = "toDate") Calendar toDate, 
            @WebParam(name = "reason") String reason){
        EmployeeEntity employee = em.find(EmployeeEntity.class,email);
        
        LeaveEntity newLeave = new LeaveEntity(fromDate,toDate,reason,employee);
        em.persist(newLeave);
        em.flush();
        
        List<LeaveEntity> leaveList = employee.getLeaveList();
        leaveList.add(newLeave);
        
        employee.setLeaveList(leaveList);
        em.persist(employee);      
        em.flush();
        
    }
    
    @WebMethod(operationName = "viewLeaveHistory")
    public List<LeaveEntity> viewLeaveHistory(
            @WebParam(name = "email") String email){
        EmployeeEntity employee = em.find(EmployeeEntity.class,email);
        
        return employee.getLeaveList();
    }
    
    @WebMethod(operationName = "getLeave")
    public LeaveEntity getLeave(
            @WebParam(name = "leaveId") Long leaveId){
        LeaveEntity leave = em.find(LeaveEntity.class,leaveId);
        return leave;
    }
    
    @Override
    @WebMethod(exclude = true)
    public void editLeave(Long leaveId,Integer leaveResult){
        LeaveEntity leave = em.find(LeaveEntity.class,leaveId);
        leave.setLeaveResult(leaveResult);
        em.persist(leave);
        em.flush();
    }
    
    @Override
    @WebMethod(exclude = true)
    public List<LeaveEntity> getAllLeaveRequest(){
        Query q = em.createQuery("SELECT l FROM LeaveEntity l");
        List<LeaveEntity> leaveList = new ArrayList();
        for(Object o : q.getResultList()){
            LeaveEntity leave = (LeaveEntity) o;
            if(leave.getLeaveResult() == 0)//get all leaves request that are not been decided
                leaveList.add(leave);
        }
        return leaveList;
    }
 
    
}
