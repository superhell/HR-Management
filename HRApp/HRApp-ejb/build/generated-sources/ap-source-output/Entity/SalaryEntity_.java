package Entity;

import Entity.EmployeeEntity;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-29T16:12:25")
@StaticMetamodel(SalaryEntity.class)
public class SalaryEntity_ { 

    public static volatile SingularAttribute<SalaryEntity, Double> amount;
    public static volatile SingularAttribute<SalaryEntity, Calendar> periodMonth;
    public static volatile SingularAttribute<SalaryEntity, Long> id;
    public static volatile SingularAttribute<SalaryEntity, String> type;
    public static volatile SingularAttribute<SalaryEntity, EmployeeEntity> employee;

}