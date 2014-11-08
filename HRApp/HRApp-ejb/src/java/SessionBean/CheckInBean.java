/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.CheckInEntity;
import Entity.EmployeeEntity;
import Entity.QREntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    //return 1 if successful, 2 if qr is not correct, 3 if already check in, 4 if it's not correct time
    @WebMethod(operationName = "createCheckIn")
    public Integer createCheckIn(
            @WebParam(name = "userId") String email,
            // @WebParam(name = "checkInTime")String checkInTime,/* dd/MM/yyyy HH:mm:ss*/
            @WebParam(name = "QR") String QR) {

        Calendar checkInTime = Calendar.getInstance();
        Integer hour = checkInTime.get(Calendar.HOUR_OF_DAY);
        String todayQR = getTodayQR(checkInTime);
        System.out.println("todayQR: " + todayQR);
        System.out.println("QR: "+ QR);
        
        if (!todayQR.equals(QR)) {
            return 2; //wrong qr
        }
        
        if(!checkInAvailablity(email,checkInTime)){
           return 3;//check whether already checked in
        }

        if (hour <= 9 && hour >= 7) {
            EmployeeEntity employee = em.find(EmployeeEntity.class, email);
            CheckInEntity newCheckIn = new CheckInEntity(checkInTime, employee);
            em.persist(newCheckIn);
            em.flush();

            List<CheckInEntity> checkInList = employee.getCheckInList();
            checkInList.add(newCheckIn);
            employee.setCheckInList(checkInList);
            em.persist(employee);
            em.flush();
            return 1; //successful
        } else {
            return 4;//wrong time
        }

    }

    @WebMethod(operationName = "getCheckInList")
    public List<CheckInEntity> getCheckInList(String email) {
        EmployeeEntity employee = em.find(EmployeeEntity.class, email);
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

    //return false if already check in
    @WebMethod(exclude = true)
    public Boolean checkInAvailablity(String email, Calendar time) {

        List<CheckInEntity> checkInList = getCheckInList(email);
        if (checkInList != null) {
            for (CheckInEntity ci : checkInList) {
                Calendar checkInTime = ci.getCheckInTime();
                if (checkInTime.get(Calendar.YEAR) == time.get(Calendar.YEAR)
                        && checkInTime.get(Calendar.MONTH) == time.get(Calendar.MONTH)
                        && checkInTime.get(Calendar.DATE) == time.get(Calendar.DATE)) {
                    return false;
                }
            }
        } 

        return true;
    }

    @WebMethod(exclude = true)
    public String getTodayQR(Calendar date) {
        List<QREntity> QRList = getAllQR();

        for (QREntity qr : QRList) {
            Calendar generatedDate = qr.getGeneratedDate();
            if (generatedDate.get(Calendar.YEAR) == date.get(Calendar.YEAR)
                    && generatedDate.get(Calendar.MONTH) == date.get(Calendar.MONTH)
                    && generatedDate.get(Calendar.DATE) == date.get(Calendar.DATE)) {
                return qr.getRandomString();
            }
        }

        return null;
    }

}
