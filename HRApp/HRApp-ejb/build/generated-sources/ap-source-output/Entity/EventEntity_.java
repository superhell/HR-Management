package Entity;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-07T23:23:05")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-08T03:37:08")
>>>>>>> f0e16e48c94eb183f20950b8f84d5a6c5a76883d
@StaticMetamodel(EventEntity.class)
public class EventEntity_ { 

    public static volatile SingularAttribute<EventEntity, String> eventVenue;
    public static volatile SingularAttribute<EventEntity, String> eventDescription;
    public static volatile SingularAttribute<EventEntity, String> eventName;
    public static volatile SingularAttribute<EventEntity, Calendar> startTime;
    public static volatile SingularAttribute<EventEntity, Long> id;
    public static volatile SingularAttribute<EventEntity, Calendar> endTime;
    public static volatile SingularAttribute<EventEntity, Calendar> createDate;

}