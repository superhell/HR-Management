/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.EmployeeEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
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
public class EmployeeBean implements EmployeeBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;

    @Override
    @WebMethod(exclude = true)
    public Boolean createEmployee(String email, String password, String title, String position, String firstName, String middleName, String lastName, Integer age, String contactNum, String department) {
        if (checkEmail(email)) {
            EmployeeEntity newEmployee = new EmployeeEntity(email, password, title, position, firstName, middleName,
                    lastName, age, contactNum, department);
            em.persist(newEmployee);
            em.flush();
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    //return false if find email already exist in database
    @Override
    @WebMethod(exclude = true)
    public Boolean checkEmail(String email) {

        List<EmployeeEntity> employeeList = getEmployeeList();

        for (EmployeeEntity employee : employeeList) {
            if (employee.getEmail().equals(email)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    //return true if edit successfully
    @Override
    @WebMethod(exclude = true)
    public Boolean editEmployee(String email, String field, Object content) {
        EmployeeEntity employee = em.find(EmployeeEntity.class, email);

        switch (field) {
            case "email":
                if(checkEmail(email))
                   employee.setEmail((String) content);
                else
                    return Boolean.FALSE;
                break;
            case "password":
                employee.setPassword((String) content);
                break;
            case "title":
                employee.setTitle((String) content);
                break;
            case "position":
                employee.setPosition((String) content);
                break;
            case "firstName":
                employee.setFirstName((String) content);
                break;
            case "middleName":
                employee.setMiddleName((String) content);
                break;
            case "lastName":
                employee.setLastName((String) content);
                break;
            case "age":
                employee.setAge((Integer) content);
                break;
            case "contactNum":
                employee.setContactNum((String) content);
                break;
            case "department":
                employee.setDepartment((String) content);
                break;
        }
        
        return Boolean.TRUE;

    }

    @WebMethod(operationName = "getEmployeeList")
    public List<EmployeeEntity> getEmployeeList() {
        Query q = em.createQuery("SELECT e FROM EmployeeEntity e");
        List<EmployeeEntity> employeeList = new ArrayList();
        for (Object o : q.getResultList()) {
            EmployeeEntity employee = (EmployeeEntity) o;
            employeeList.add(employee);
        }
        return employeeList;
    }

}