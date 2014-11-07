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
@StaticMetamodel(SalaryEntity.class)
public class SalaryEntity_ { 

    public static volatile SingularAttribute<SalaryEntity, Double> amount;
    public static volatile SingularAttribute<SalaryEntity, Calendar> periodMonth;
    public static volatile SingularAttribute<SalaryEntity, Long> id;
    public static volatile SingularAttribute<SalaryEntity, String> type;
    public static volatile SingularAttribute<SalaryEntity, EmployeeEntity> employee;

}