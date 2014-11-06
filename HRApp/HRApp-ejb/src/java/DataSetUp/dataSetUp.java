/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSetUp;

import Entity.CheckInEntity;
import Entity.EmployeeEntity;
import Entity.EventEntity;
import Entity.LeaveEntity;
import Entity.SalaryEntity;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Yoky
 */
@Singleton
@LocalBean
@Startup
public class dataSetUp {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void init() {
        createDatabase();
    }

    public void createDatabase() {
        //employee Entity
        EmployeeEntity superUser = new EmployeeEntity("admin", "123", "Mr", "Admin", "Super", "", "Admin", 40, "93727960", "God");
        EmployeeEntity e1 = new EmployeeEntity("e1", "123", "Ms", "Consultant", "EMPLOYEE1", "", "employee1", 25, "12345678", "SOC");
        EmployeeEntity e2 = new EmployeeEntity("e2", "123", "Ms", "Manager", "EMPLOYEE2", "", "employee2", 23, "87654321", "SCI");
        EmployeeEntity e3 = new EmployeeEntity("e3", "123", "Mr", "Entertainment Leader", "EMPLOYEE3", "", "employee3", 21, "12345678", "ENG");

        em.persist(superUser);
        em.flush();
        em.persist(e1);
        em.flush();
        em.persist(e2);
        em.flush();
        em.persist(e3);
        em.flush();

        //salary Entity
        Calendar c1 = Calendar.getInstance();
        c1.set(2014, Calendar.AUGUST, 31);
        Calendar c2 = Calendar.getInstance();
        c1.set(2014, Calendar.SEPTEMBER, 30);
        Calendar c3 = Calendar.getInstance();
        c1.set(2014, Calendar.OCTOBER, 31);

        SalaryEntity s1 = new SalaryEntity("Monthly", 1000.0D, c1, e1);
        SalaryEntity s2 = new SalaryEntity("Monthly", 2000.0D, c2, e1);
        SalaryEntity s3 = new SalaryEntity("Monthly", 3000.0D, c3, e1);

        em.persist(s1);
        em.flush();
        em.persist(s2);
        em.flush();
        em.persist(s3);
        em.flush();

        e1.getSalaryList().add(s1);
        e1.getSalaryList().add(s2);
        e1.getSalaryList().add(s3);
        em.persist(e1);
        em.flush();

        SalaryEntity s4 = new SalaryEntity("Monthly", 3000.0D, c1, e2);
        SalaryEntity s5 = new SalaryEntity("Monthly", 2000.0D, c2, e2);
        SalaryEntity s6 = new SalaryEntity("Monthly", 1000.0D, c3, e2);

        em.persist(s4);
        em.flush();
        em.persist(s5);
        em.flush();
        em.persist(s6);
        em.flush();

        e2.getSalaryList().add(s4);
        e2.getSalaryList().add(s5);
        e2.getSalaryList().add(s6);
        em.persist(e2);
        em.flush();

        SalaryEntity s7 = new SalaryEntity("Monthly", 3000.0D, c1, e3);
        SalaryEntity s8 = new SalaryEntity("Monthly", 3000.0D, c2, e3);
        SalaryEntity s9 = new SalaryEntity("Monthly", 3000.0D, c3, e3);

        em.persist(s7);
        em.flush();
        em.persist(s8);
        em.flush();
        em.persist(s9);
        em.flush();

        e3.getSalaryList().add(s7);
        e3.getSalaryList().add(s8);
        e3.getSalaryList().add(s9);
        em.persist(e3);
        em.flush();

        //Event Entity
        Calendar c4 = Calendar.getInstance();
        c4.set(2014, Calendar.DECEMBER, 1, 17, 0, 0);
        Calendar c5 = Calendar.getInstance();
        c5.set(2014, Calendar.DECEMBER, 1, 19, 0, 0);

        EventEntity event1 = new EventEntity(c4, c5, "exam", "SOC or MPSH", "IS3261 Exam");

        em.persist(event1);
        em.flush();

        //leaveEntity
        Calendar c6 = Calendar.getInstance();
        c6.set(2014, Calendar.DECEMBER, 10, 8, 0, 0);
        Calendar c7 = Calendar.getInstance();
        c7.set(2014, Calendar.DECEMBER, 15, 18, 0, 0);
        Calendar c8 = Calendar.getInstance();
        c8.set(2014, Calendar.DECEMBER, 1, 8, 0, 0);
        Calendar c9 = Calendar.getInstance();
        c9.set(2014, Calendar.DECEMBER, 31, 18, 0, 0);

        LeaveEntity leave1 = new LeaveEntity(c6, c7, "Feel sick", e1);
        LeaveEntity leave2 = new LeaveEntity(c8, c9, "honeymoon", e2);

        em.persist(leave1);
        em.flush();
        em.persist(leave2);
        em.flush();

        List<LeaveEntity> leaveList1 = e1.getLeaveList();
        leaveList1.add(leave1);
        e1.setLeaveList(leaveList1);
        em.persist(e1);
        em.flush();

        List<LeaveEntity> leaveList2 = e2.getLeaveList();
        leaveList2.add(leave2);
        e2.setLeaveList(leaveList2);
        em.persist(e2);
        em.flush();

        //check In entity
        Calendar c10 = Calendar.getInstance();
        c10.set(2014, Calendar.NOVEMBER, 11, 8, 35, 47);
        Calendar c11 = Calendar.getInstance();
        c11.set(2014, Calendar.NOVEMBER, 10, 8, 25, 15);
        Calendar c12 = Calendar.getInstance();
        c12.set(2014, Calendar.NOVEMBER, 9, 7, 30, 36);
        Calendar c13 = Calendar.getInstance();
        c13.set(2014, Calendar.NOVEMBER, 8, 8, 59, 59);

        CheckInEntity checkIn1 = new CheckInEntity(c10, e1);
        em.persist(checkIn1);
        em.flush();
        CheckInEntity checkIn2 = new CheckInEntity(c11, e1);
        em.persist(checkIn2);
        em.flush();
        CheckInEntity checkIn3 = new CheckInEntity(c12, e1);
        em.persist(checkIn3);
        em.flush();
        CheckInEntity checkIn4 = new CheckInEntity(c13, e1);
        em.persist(checkIn4);
        em.flush();

        CheckInEntity checkIn5 = new CheckInEntity(c10, e2);
        em.persist(checkIn5);
        em.flush();
        CheckInEntity checkIn6 = new CheckInEntity(c11, e2);
        em.persist(checkIn6);
        em.flush();
        CheckInEntity checkIn7 = new CheckInEntity(c12, e2);
        em.persist(checkIn7);
        em.flush();
        CheckInEntity checkIn8 = new CheckInEntity(c13, e2);
        em.persist(checkIn8);
        em.flush();

        List<CheckInEntity> checkInList1 = e1.getCheckInList();
        checkInList1.add(checkIn4);
        checkInList1.add(checkIn3);
        checkInList1.add(checkIn2);
        checkInList1.add(checkIn1);
        e1.setCheckInList(checkInList1);
        em.persist(e1);
        em.flush();
        
        List<CheckInEntity> checkInList2 = e2.getCheckInList();
        checkInList2.add(checkIn8);
        checkInList2.add(checkIn7);
        checkInList2.add(checkIn6);
        checkInList2.add(checkIn5);
        e2.setCheckInList(checkInList1);
        em.persist(e2);
        em.flush();

    }

}
