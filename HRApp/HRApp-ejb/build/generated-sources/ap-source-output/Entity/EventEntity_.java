package Entity;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-06T17:37:33")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-06T23:16:54")
>>>>>>> 9448e08097328a0550f44bb4d4b0c34204a70d7b
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