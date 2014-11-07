/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.EmployeeEntity;
import Entity.LeaveEntity;
import Entity.SalaryEntity;
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
public class LeaveBean implements LeaveBeanLocal {

    @PersistenceContext
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    //return 1 create sucessfully, 2 time problem,,3 reason is empty
    @WebMethod(operationName = "createLeave")
    public Integer createLeave(
            @WebParam(name = "userId") String email,
            @WebParam(name = "fromTime") String fromTime,
            @WebParam(name = "toTime") String toTime,
            @WebParam(name = "reason") String reason) {

        EmployeeEntity employee = em.find(EmployeeEntity.class, email);
        Calendar current = Calendar.getInstance();

        System.out.println("reason: " + reason);
        System.out.println("fromTime: " + fromTime);
        System.out.println("toTime: " + toTime);
        
        if (reason.equals("")) {
            return 3;
        } else {

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Calendar from = Calendar.getInstance();
            Calendar to = Calendar.getInstance();

            try {
                from.setTime(sdf.parse(fromTime));
                to.setTime(sdf.parse(toTime));
            } catch (ParseException ex) {
                Logger.getLogger(LeaveBean.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("fromTime" + sdf.format(from.getTime()));
            System.out.println("toTime" + sdf.format(to.getTime()));
            System.out.println("current.compareTo(from)" + current.compareTo(from));
            System.out.println("current.compareTo(to)" + current.compareTo(to));
            System.out.println("from.compareTo(to)" + from.compareTo(to));

            if (current.compareTo(from) > 0 || current.compareTo(to) > 0 ||from.compareTo(to) >= 0 ) {
                return 2;
            } else {
                LeaveEntity newLeave = new LeaveEntity(from, to, reason, employee);
                em.persist(newLeave);
                em.flush();

                List<LeaveEntity> leaveList = employee.getLeaveList();
                leaveList.add(newLeave);

                employee.setLeaveList(leaveList);
                em.persist(employee);
                em.flush();

                return 1;
            }
        }
    }

    @WebMethod(operationName = "viewLeaveHistory")
    public List<LeaveEntity> viewLeaveHistory(
            @WebParam(name = "userId") String email) {
        EmployeeEntity employee = em.find(EmployeeEntity.class, email);

        return employee.getLeaveList();
    }

    @WebMethod(operationName = "getLeave")
    public LeaveEntity getLeave(
            @WebParam(name = "leaveId") Long leaveId) {
        LeaveEntity leave = em.find(LeaveEntity.class, leaveId);
        return leave;
    }

    @Override
    @WebMethod(operationName = "editLeave")
    public void editLeave(Long leaveId, Integer leaveResult) {
        LeaveEntity leave = em.find(LeaveEntity.class, leaveId);
        leave.setLeaveResult(leaveResult);
        em.persist(leave);
        em.flush();
    }

    @Override
    @WebMethod(operationName = "getAllLeaveRequest")
    public List<LeaveEntity> getAllLeaveRequest() {
        Query q = em.createQuery("SELECT l FROM LeaveEntity l");
        List<LeaveEntity> leaveList = new ArrayList();
        for (Object o : q.getResultList()) {
            LeaveEntity leave = (LeaveEntity) o;
            if (leave.getLeaveResult() == 0)//get all leaves request that are not been decided
            {
                leaveList.add(leave);
            }
        }
        return leaveList;
    }

}
