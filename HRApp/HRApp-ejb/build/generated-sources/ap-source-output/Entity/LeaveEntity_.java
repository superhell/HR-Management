package Entity;

import Entity.EmployeeEntity;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-06T17:37:33")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-06T23:16:54")
>>>>>>> 9448e08097328a0550f44bb4d4b0c34204a70d7b
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