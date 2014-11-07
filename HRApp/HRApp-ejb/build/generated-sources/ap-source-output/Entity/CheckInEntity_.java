package Entity;

import Entity.EmployeeEntity;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-06T21:52:23")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T19:04:20")
>>>>>>> 596f52fc94017be69420a52ee8013e89f6a0f6a5
@StaticMetamodel(CheckInEntity.class)
public class CheckInEntity_ { 

    public static volatile SingularAttribute<CheckInEntity, Calendar> checkInTime;
    public static volatile SingularAttribute<CheckInEntity, Long> id;
    public static volatile SingularAttribute<CheckInEntity, EmployeeEntity> employee;

}