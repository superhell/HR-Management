package Entity;

import Entity.EmployeeEntity;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T19:59:33")
=======
@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-07T20:31:21")
>>>>>>> 5e8343ce8c4b6a3b1f5c5b818903f98be4c2aa95
@StaticMetamodel(CheckInEntity.class)
public class CheckInEntity_ { 

    public static volatile SingularAttribute<CheckInEntity, Calendar> checkInTime;
    public static volatile SingularAttribute<CheckInEntity, Long> id;
    public static volatile SingularAttribute<CheckInEntity, EmployeeEntity> employee;

}