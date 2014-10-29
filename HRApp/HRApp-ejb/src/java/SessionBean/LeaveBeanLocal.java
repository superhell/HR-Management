/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.LeaveEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hangsun
 */
@Local
public interface LeaveBeanLocal {
    public void editLeave(Long leaveId,Integer leaveResult);
    public List<LeaveEntity> getAllLeaveRequest();
}
