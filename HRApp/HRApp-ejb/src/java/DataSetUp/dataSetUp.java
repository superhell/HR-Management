/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSetUp;

import Entity.EmployeeEntity;
import Entity.SalaryEntity;
import java.util.Calendar;
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

    public void createDatabase(){
        
        EmployeeEntity e1 = new EmployeeEntity("e1","123","Ms","Consultant","Mengdan","","Zhao",21,"12345678","IT");
        EmployeeEntity e2 = new EmployeeEntity("e2","123","Ms","BOSS","Shiyu","","Zhang",21,"87654321","IS");
        EmployeeEntity e3 = new EmployeeEntity("e3","123","Mr","Xiao Di","Hang","","Sun",21,"12345678","Sky");
        
        em.persist(e1); em.flush();
        em.persist(e2); em.flush();
        em.persist(e3); em.flush();
        
        Calendar c1 = Calendar.getInstance();
        c1.set(2014,Calendar.AUGUST,31);
        Calendar c2 = Calendar.getInstance();
        c1.set(2014,Calendar.SEPTEMBER,30);        
        Calendar c3 = Calendar.getInstance();
        c1.set(2014,Calendar.OCTOBER,31);      
        
        SalaryEntity s1 = new SalaryEntity("Monthly",1000.0D,c1,e1);
        SalaryEntity s2 = new SalaryEntity("Monthly",2000.0D,c2,e1);
        SalaryEntity s3 = new SalaryEntity("Monthly",3000.0D,c3,e1);
        
        em.persist(s1); em.flush();
        em.persist(s2); em.flush();
        em.persist(s3); em.flush();
        
        e1.getSalaryList().add(s1); e1.getSalaryList().add(s2); e1.getSalaryList().add(s3);
        em.persist(e1); em.flush();
        
        SalaryEntity s4 = new SalaryEntity("Monthly",3000.0D,c1,e2);
        SalaryEntity s5 = new SalaryEntity("Monthly",2000.0D,c2,e2);
        SalaryEntity s6 = new SalaryEntity("Monthly",1000.0D,c3,e2);
        
        em.persist(s4); em.flush();
        em.persist(s5); em.flush();
        em.persist(s6); em.flush();
        
        e2.getSalaryList().add(s4); e2.getSalaryList().add(s5); e2.getSalaryList().add(s6);
        em.persist(e2); em.flush();
        
        SalaryEntity s7 = new SalaryEntity("Monthly",3000.0D,c1,e3);
        SalaryEntity s8 = new SalaryEntity("Monthly",3000.0D,c2,e3);
        SalaryEntity s9 = new SalaryEntity("Monthly",3000.0D,c3,e3);
        
        em.persist(s7); em.flush();
        em.persist(s8); em.flush();
        em.persist(s9); em.flush();
        
        e3.getSalaryList().add(s7); e3.getSalaryList().add(s8); e3.getSalaryList().add(s9);
        em.persist(e3); em.flush();
    }

}
