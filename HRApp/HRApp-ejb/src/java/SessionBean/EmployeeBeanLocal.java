/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.EmployeeEntity;
import java.io.File;
import javax.ejb.Local;

/**
 *
 * @author hangsun
 */
@Local
public interface EmployeeBeanLocal {

    public Boolean editEmployee(String email, String field, Object content);

    public Boolean createEmployee(String email, String password, String title, String position,
            String firstName, String middleName, String lastName, Integer age, String contactNum, String department, String photoPath);

    public Boolean checkEmail(String email);
    
    public String[] getEmployeeInfo(String userId);
    
    public String getEmployeeImage(File imageFile);
    
    public String[][] getContacts();
}
