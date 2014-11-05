/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.EventEntity;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hangsun
 */
@Local
public interface EventBeanLocal {

    public void createEvent(Calendar startTime,Calendar endTime, String eventName, String eventVenue, String eventDescription);

    public List<EventEntity> getAllEvent();
    
    public void editEvent(Long eventId,String field,Object content);
    
    public void deleteEvent(Long eventId);
}
