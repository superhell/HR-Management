/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.EmployeeEntity;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.imageio.ImageIO;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author hangsun
 */
@Stateless
@WebService
public class EmployeeBean implements EmployeeBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;

    @Override
    @WebMethod(operationName = "createEmployee")
    public Boolean createEmployee(
            @WebParam(name = "userId")String email, 
            @WebParam(name = "password")String password, 
            @WebParam(name = "title")String title, 
            @WebParam(name = "position")String position,
            @WebParam(name = "firstName")String firstName, 
            @WebParam(name = "middleName")String middleName, 
            @WebParam(name = "lastName")String lastName, 
            @WebParam(name = "age")Integer age, 
            @WebParam(name = "contactNum")String contactNum, 
            @WebParam(name = "department")String department, 
            @WebParam(name = "photo")String photoPath) {
        if (checkEmail(email)) {
            File photo = new File(photoPath);
            EmployeeEntity newEmployee = new EmployeeEntity(email, password, title, position, firstName, middleName,
                    lastName, age, contactNum, department, photo);
            em.persist(newEmployee);
            em.flush();
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    //return false if find email already exist in database
    @Override
    @WebMethod(exclude = true)
    public Boolean checkEmail(String email) {

        List<EmployeeEntity> employeeList = getEmployeeList();

        for (EmployeeEntity employee : employeeList) {
            if (employee.getEmail().equals(email)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    //return true if edit successfully
    @Override
    @WebMethod(exclude = true)
    public Boolean editEmployee(String email, String field, Object content) {
        EmployeeEntity employee = em.find(EmployeeEntity.class, email);

        switch (field) {
            case "email":
                if (checkEmail(email)) {
                    employee.setEmail((String) content);
                } else {
                    return Boolean.FALSE;
                }
                break;
            case "password":
                employee.setPassword((String) content);
                break;
            case "title":
                employee.setTitle((String) content);
                break;
            case "position":
                employee.setPosition((String) content);
                break;
            case "firstName":
                employee.setFirstName((String) content);
                break;
            case "middleName":
                employee.setMiddleName((String) content);
                break;
            case "lastName":
                employee.setLastName((String) content);
                break;
            case "age":
                employee.setAge((Integer) content);
                break;
            case "contactNum":
                employee.setContactNum((String) content);
                break;
            case "department":
                employee.setDepartment((String) content);
                break;
        }

        return Boolean.TRUE;

    }

    @WebMethod(operationName = "getEmployeeList")
    public List<EmployeeEntity> getEmployeeList() {
        Query q = em.createQuery("SELECT e FROM EmployeeEntity e");
        List<EmployeeEntity> employeeList = new ArrayList();
        for (Object o : q.getResultList()) {
            EmployeeEntity employee = (EmployeeEntity) o;
            employeeList.add(employee);
        }
        return employeeList;
    }

    @WebMethod(operationName = "getEmployeeInfo")
    @Override
    public String[] getEmployeeInfo(@WebParam(name = "userId") String userId) {
        EmployeeEntity ee = em.find(EmployeeEntity.class, userId);
        String[] result = new String[10];
        result[0] = ee.getFirstName() + " " + ee.getLastName();
        result[1] = ee.getPosition();
        result[2] = ee.getContactNum();
        result[3] = ee.getEmail();
        result[4] = ee.getDepartment();
        result[5]=getEmployeeImage(ee.getPhoto());
        
        //File image = new File("/Resources/sample.JPG");
        //image = getClass().getResource("/resources/singapore-logo0.1.jpg");
        //result[5] = getEmployeeImage(image);
        return result;
    }

    @Override
    public String getEmployeeImage(File imageFile) {
        byte[] imageBytes = null;
        try {
            if (imageFile == null) {
                System.out.println("this image file is null!");
            }
            BufferedImage img = ImageIO.read(imageFile.toURI().toURL());
            ByteArrayOutputStream baos = new ByteArrayOutputStream(1000);
            ImageIO.write(img, "jpg", baos);
            baos.flush();
            imageBytes = baos.toByteArray();
            baos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println("Base64 encode?: " + Base64.encodeBase64String(imageBytes));
        return (imageBytes != null) ? Base64.encodeBase64String(imageBytes) : "";
    }
    
    @WebMethod(operationName = "getContacts")
    @Override
    public List<EmployeeEntity> getContacts(){
        Query q = em.createQuery("SELECT e FROM EmployeeEntity e");
        List<EmployeeEntity> employeeList = q.getResultList();
        
        return employeeList;
    }
}
