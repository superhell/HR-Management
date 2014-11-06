/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.QREntity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author hangsun
 */
@Stateless
@WebService
public class QRBean implements QRBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;

    @WebMethod(operationName = "createQR")
    public String createQR() {

        String QR;
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 16; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }

        QR = sb.toString();

        QREntity qr = new QREntity(QR);
        em.persist(qr);
        em.flush();

        return QR;
    }

    //return false if qr code is already created
    @WebMethod(operationName = "checkQR")
    public Boolean checkQR(Calendar date) {
        List<QREntity> qrList = getAllQR();
        if (!qrList.isEmpty()) {
            for (QREntity qr : qrList) {
                Calendar generatedDate = qr.getGeneratedDate();

                if (generatedDate.get(Calendar.YEAR) == date.get(Calendar.YEAR)
                        && generatedDate.get(Calendar.MONTH) == date.get(Calendar.MONTH)
                        && generatedDate.get(Calendar.DATE) == date.get(Calendar.DATE)) {
                    return false;
                }

            }
            return true;
        } else {
            return true;
        }
    }

    @WebMethod(exclude = true)
    public List<QREntity> getAllQR() {
        Query q = em.createQuery("SELECT q FROM QREntity q");
        List<QREntity> QRList = new ArrayList();
        for (Object o : q.getResultList()) {
            QREntity qr = (QREntity) o;
            QRList.add(qr);
        }
        return QRList;
    }

    @WebMethod(operationName = "getTodayQR")
    public String getTodayQR(Calendar date) {
        List<QREntity> QRList = getAllQR();

        for (QREntity qr : QRList) {
            Calendar generatedDate = qr.getGeneratedDate();
            if (generatedDate.get(Calendar.YEAR) == date.get(Calendar.YEAR)
                    && generatedDate.get(Calendar.MONTH) == date.get(Calendar.MONTH)
                    && generatedDate.get(Calendar.DATE) == date.get(Calendar.DATE)) {
                return qr.getRandomString();
            }
        }

        return null;
    }
}
