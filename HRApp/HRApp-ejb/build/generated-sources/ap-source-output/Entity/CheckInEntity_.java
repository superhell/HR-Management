package Entity;

import Entity.EmployeeEntity;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-07T23:23:05")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-08T03:37:08")
>>>>>>> f0e16e48c94eb183f20950b8f84d5a6c5a76883d
@StaticMetamodel(CheckInEntity.class)
public class CheckInEntity_ { 

    public static volatile SingularAttribute<CheckInEntity, Calendar> checkInTime;
    public static volatile SingularAttribute<CheckInEntity, Long> id;
    public static volatile SingularAttribute<CheckInEntity, EmployeeEntity> employee;

}