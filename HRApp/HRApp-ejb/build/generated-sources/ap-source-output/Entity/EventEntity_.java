package Entity;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-06T17:22:45")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-06T18:49:14")
>>>>>>> 7c722535f91f2ef313deed5b9df93efb8d100522
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-06T18:49:14")
>>>>>>> 7c722535f91f2ef313deed5b9df93efb8d100522
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