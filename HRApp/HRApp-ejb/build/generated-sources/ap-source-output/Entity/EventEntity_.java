package Entity;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-08T08:12:33")
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