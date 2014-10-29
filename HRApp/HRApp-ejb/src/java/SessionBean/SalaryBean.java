/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.EmployeeEntity;
import Entity.SalaryEntity;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hangsun
 */
@Stateless
@WebService
public class SalaryBean implements SalaryBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    @WebMethod(exclude = true)
    public void createSalary(String email,String type,Double amount,Calendar periodMonth){
        EmployeeEntity employee = em.find(EmployeeEntity.class,email);
        SalaryEntity newSalary = new SalaryEntity(type, amount, periodMonth, employee);
        em.persist(newSalary);
        em.flush();
        
        List<SalaryEntity> salaryList = employee.getSalaryList();
        salaryList.add(newSalary);
        employee.setSalaryList(salaryList);
        em.persist(employee);
        em.flush();
    
    }
    
    @WebMethod(operationName = "viewSalary")
    public List<SalaryEntity> viewSalary(
            @WebParam(name = "email") String email){
        
        EmployeeEntity employee = em.find(EmployeeEntity.class,email);
        
        return employee.getSalaryList();
    }
}
