package Entity;

import Entity.EmployeeEntity;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-29T16:12:25")
@StaticMetamodel(LeaveEntity.class)
public class LeaveEntity_ { 

    public static volatile SingularAttribute<LeaveEntity, Calendar> fromDate;
    public static volatile SingularAttribute<LeaveEntity, Integer> leaveResult;
    public static volatile SingularAttribute<LeaveEntity, String> reason;
    public static volatile SingularAttribute<LeaveEntity, Calendar> toDate;
    public static volatile SingularAttribute<LeaveEntity, Calendar> generatedDate;
    public static volatile SingularAttribute<LeaveEntity, Long> id;
    public static volatile SingularAttribute<LeaveEntity, EmployeeEntity> employee;

}