/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.CheckInEntity;
import Entity.EmployeeEntity;
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
public class CheckInBean implements CheckInBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    private EntityManager em;
    
    //Employee can check in between 7 am and 9 am and return true if check in successfully
    @WebMethod(operationName = "createCheckIn")
    public Boolean createCheckIn(
            @WebParam(name = "email")String email,
            @WebParam(name = "checkInTime")Calendar checkInTime){
        
        Integer hour = checkInTime.get(Calendar.HOUR_OF_DAY)+8;
        
        if(hour <= 9 && hour >= 7){
            EmployeeEntity employee = em.find(EmployeeEntity.class,email);
            CheckInEntity newCheckIn = new CheckInEntity(checkInTime,employee);
            em.persist(newCheckIn);
            em.flush();
            
            List<CheckInEntity> checkInList = employee.getCheckInList();
            checkInList.add(newCheckIn);
            employee.setCheckInList(checkInList);
            em.persist(employee);
            em.flush();
            return Boolean.TRUE;
        }
        else
            return Boolean.FALSE;
        
    }
}
