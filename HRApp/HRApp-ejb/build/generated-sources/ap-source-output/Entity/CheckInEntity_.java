package Entity;

import Entity.EmployeeEntity;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-10-29T18:17:53")
@StaticMetamodel(CheckInEntity.class)
public class CheckInEntity_ { 

    public static volatile SingularAttribute<CheckInEntity, Calendar> checkInTime;
    public static volatile SingularAttribute<CheckInEntity, Long> id;
    public static volatile SingularAttribute<CheckInEntity, EmployeeEntity> employee;

}