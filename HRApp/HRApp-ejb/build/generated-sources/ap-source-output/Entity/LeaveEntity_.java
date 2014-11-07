package Entity;

import Entity.EmployeeEntity;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-07T20:31:21")
@StaticMetamodel(LeaveEntity.class)
public class LeaveEntity_ { 

    public static volatile SingularAttribute<LeaveEntity, Integer> leaveResult;
    public static volatile SingularAttribute<LeaveEntity, String> reason;
    public static volatile SingularAttribute<LeaveEntity, Calendar> generatedDate;
    public static volatile SingularAttribute<LeaveEntity, Calendar> fromTime;
    public static volatile SingularAttribute<LeaveEntity, Long> id;
    public static volatile SingularAttribute<LeaveEntity, EmployeeEntity> employee;
    public static volatile SingularAttribute<LeaveEntity, Calendar> toTime;

}