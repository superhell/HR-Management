/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.EmployeeEntity;
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
public class LoginBean implements LoginBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;

    //login, return -1 if user not found, 0 user found but password incorrect, 1 user found and password correct
    @WebMethod(operationName = "login")
    public Integer login(
            @WebParam(name = "email") String email, 
            @WebParam(name = "password") String password) {
        EmployeeEntity employee = em.find(EmployeeEntity.class, email);
        if (employee == null) {
            return -1; //user not found
        } else {
            if (employee.getPassword().equals(password)) {
                return 1; //user login successful
            } else {
                return 0; //password incorrect
            }
        }
    }
}
