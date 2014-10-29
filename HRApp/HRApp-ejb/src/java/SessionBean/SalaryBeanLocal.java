/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import java.util.Calendar;
import javax.ejb.Local;

/**
 *
 * @author hangsun
 */
@Local
public interface SalaryBeanLocal {
    public void createSalary(String email,String type,Double amount,Calendar periodMonth);
    
}
