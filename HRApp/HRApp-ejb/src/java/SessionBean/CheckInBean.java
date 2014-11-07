/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.CheckInEntity;
import Entity.EmployeeEntity;
import Entity.QREntity;
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
public class CheckInBean implements CheckInBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    private EntityManager em;
    
    //Employee can check in between 7 am and 9 am and return true if check in successfully
    @WebMethod(operationName = "createCheckIn")
    public Boolean createCheckIn(
            @WebParam(name = "email")String email,
            @WebParam(name = "checkInTime")Calendar checkInTime,
            @WebParam(name = "QR")String QR){
        
        Integer hour = checkInTime.get(Calendar.HOUR_OF_DAY);
        String todayQR = getTodayQR(checkInTime);
        
        if(!todayQR.equals(QR))
            return Boolean.FALSE;
        
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
    
    @WebMethod(operationName = "getCheckInList")
    public List<CheckInEntity> getCheckInList(String email){
        EmployeeEntity employee = em.find(EmployeeEntity.class,email);
        return employee.getCheckInList();
    }
    
    
    @WebMethod(exclude = true)
    public List<QREntity> getAllQR() {
        Query q = em.createQuery("SELECT q FROM QREntity q");
        List<QREntity> QRList = new ArrayList();
        for (Object o : q.getResultList()) {
            QREntity qr = (QREntity) o;
            QRList.add(qr);
        }
        return QRList;
    }
    
    @WebMethod(exclude = true)
    public String getTodayQR(Calendar date){
       List<QREntity> QRList = getAllQR();
       
       for(QREntity qr : QRList){
           Calendar generatedDate = qr.getGeneratedDate();
           if ( generatedDate.get(Calendar.YEAR) == date.get(Calendar.YEAR)
                    && generatedDate.get(Calendar.MONTH) == date.get(Calendar.MONTH)
                    && generatedDate.get(Calendar.DATE) == date.get(Calendar.DATE) )
               
               return qr.getRandomString();
       }
       
       return null;
    }
    
}
