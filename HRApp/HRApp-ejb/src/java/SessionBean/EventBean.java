/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.EmployeeEntity;
import Entity.EventEntity;
import java.util.ArrayList;
import java.util.Calendar;
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
public class EventBean implements EventBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    @WebMethod(exclude = true)
    public void createEvent(Calendar eventDate,String eventName, String eventVenue, String eventDescription){
        EventEntity newEvent = new EventEntity(eventDate,eventName,eventVenue,eventDescription);
        em.persist(newEvent);
        em.flush();
    }
    
    @Override
    @WebMethod(operationName = "getAllEvent")
    public List<EventEntity> getAllEvent(){
        Query q = em.createQuery("SELECT e FROM EventEntity e");
        List<EventEntity> eventList = new ArrayList();
        for (Object o : q.getResultList()) {
            EventEntity event = (EventEntity) o;
            eventList.add(event);
        }
        return eventList;
    }
    
    @Override
    @WebMethod(exclude = true)
    public void editEvent(Long eventId,String field,Object content){
        EventEntity event = em.find(EventEntity.class, eventId);
        
        switch(field){
            case "eventDate":
                event.setEventDate((Calendar)content);
                break;
            case "eventName":
                event.setEventName((String)content);
                break;
            case "eventVenue":
                event.setEventVenue((String)content);
                break;
            case "eventDescription":
                event.setEventDescription((String)content);
                break;
        }
        
    }
    
    @Override
    @WebMethod(exclude = true)
    public void deleteEvent(Long eventId){
        EventEntity event = em.find(EventEntity.class, eventId);
        em.remove(event);
        em.flush();
    }
}
