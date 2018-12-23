
import Entity.Client;
import Entity.Employee;
import Entity.Process;
import Model.HibernateOp;
import Untity.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gohnem
 */
public class Test {
   static int  a=20;
    public static void main(String[] args) {
//        Client client=new Client();
//        client.setAccountNumber("12345");
//        client.setBalance(5000);
//        client.setClientAddress("tanat");
//        client.setClientEmail("ghonem@gmail.com");
//        client.setClientName("mohamed ahmed ghonem");
//        client.setClientNationalId("123456789");
//        client.setClientPass("12345");
//        client.setClientPhone("01001234");
//        Employee employee=new Employee();
//        employee.setEmployeeAddress("tanta");
//        employee.setEmployeeEmail("Ahmedghonem@gmail.com");
//        employee.setEmployeeName("ahmed ghonem");
//        employee.setEmployeePass("54321ahmed");
//        employee.setEmployeePhone("12344555556");
//        Process process= new Process();
//        process.setProDate(new Date());
//        process.setProType("create");
//        process.setEmployee(employee);
//        process.setClient(client);
//        SessionFactory factory=HibernateUtil.getSessionFactory();
//        Session session=factory.openSession();
//        session.beginTransaction();
//        session.save(client);
//        session.save(employee);
//        session.save(process);
//        session.getTransaction().commit();
//        session.close();
        HibernateOp op=new HibernateOp();
//        Employee employee=op.logIn("Ahmed@gmail.com","54321");
//       Client client=op.getClient("mohamed@gmail.com","1234560891234567891234");
        System.out.println();
        ArrayList<Process> processes= op.getdata(1);
        for (int i = 0; i <processes.size(); i++) {
            System.out.println(processes.get(i).getEmployee().getEmployeeName());
        }
    
    }
}
