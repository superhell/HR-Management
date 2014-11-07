package Entity;

import Entity.CheckInEntity;
import Entity.LeaveEntity;
import Entity.SalaryEntity;
import java.io.File;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-11-07T12:32:51")
@StaticMetamodel(EmployeeEntity.class)
public class EmployeeEntity_ { 

    public static volatile SingularAttribute<EmployeeEntity, String> lastName;
    public static volatile SingularAttribute<EmployeeEntity, File> photo;
    public static volatile SingularAttribute<EmployeeEntity, String> title;
    public static volatile SingularAttribute<EmployeeEntity, String> contactNum;
    public static volatile SingularAttribute<EmployeeEntity, String> firstName;
    public static volatile ListAttribute<EmployeeEntity, CheckInEntity> checkInList;
    public static volatile SingularAttribute<EmployeeEntity, String> password;
    public static volatile ListAttribute<EmployeeEntity, SalaryEntity> salaryList;
    public static volatile ListAttribute<EmployeeEntity, LeaveEntity> leaveList;
    public static volatile SingularAttribute<EmployeeEntity, String> middleName;
    public static volatile SingularAttribute<EmployeeEntity, String> position;
    public static volatile SingularAttribute<EmployeeEntity, String> department;
    public static volatile SingularAttribute<EmployeeEntity, String> email;
    public static volatile SingularAttribute<EmployeeEntity, Integer> age;

}