/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Client;
import Entity.Employee;
import Entity.Process;
import Untity.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sun.font.EAttribute;

/**
 *
 * @author gohnem
 */
public class HibernateOp {

    public String saveClient(Client client, Employee employee) {
        Process process = new Process();
        process.setProType("create");
        process.setClient(client);
        process.setEmployee(employee);
        process.setProDate(new Date());
        process.setAmount(client.getBalance());

        String message = "";
        if (client.getBalance() < 0) {
            message = message + "* Balance can't by Negative <br><br>";
        }
        if (!client.getClientEmail().endsWith(".com") || !client.getClientEmail().contains("@")) {
            message = message + "* Email shoud be like Examble@gmail.com <br><br>";

        }
        if (client.getClientNationalId().length() != 22) {
            message = message + "* National id shoud be 22 number <br><br>";
        }
        if (client.getClientPass().length() < 5) {
            message = message + "* password weakly   <br><br>";
        }
        if (client.getClientPhone().length() != 11) {
            message = message + "* Invald  phone numbe <br><br>";
        }
         
        
        
        if(getClient(client.getClientEmail(),client.getClientNationalId())!=null){
             message =  "* The acount actually exists  <br><br>";
        }
        if (message != "") {
            return message;
        } else {
            try {
                SessionFactory factory = HibernateUtil.getSessionFactory();
                Session session = factory.openSession();
                session.beginTransaction();
                session.save(client);
                session.save(process);
                session.getTransaction().commit();
                session.close();
                return "The operation was successful <br><br>";
            } catch (Exception e) {
                return "The operation was faild";
            }
        }
    }

    public String saveEmployee(Employee employee) {
        String message = "";

        if (!employee.getEmployeeEmail().endsWith(".com") || !employee.getEmployeeEmail().contains("@")) {
            message = message + "* Email shoud be like Examble@gmail.com <br><br>";

        }

        if (employee.getEmployeePass().length() < 5) {
            message = message + "* password weakly   <br><br>";
        }
        if (employee.getEmployeePhone().length() != 11) {
            message = message + "* Invald  phone numbe <br><br>";
        }
         if(logIn(employee.getEmployeeEmail(),employee.getEmployeePass())!=null){
             message =  "* The acount actually exists  <br><br>";
        }
        if (message != "") {
            return message;
        } else {

            try {
                SessionFactory factory = HibernateUtil.getSessionFactory();
                Session session = factory.openSession();
                session.beginTransaction();
                session.save(employee);
                session.getTransaction().commit();
                session.close();
                return "The operation was successful";
            } catch (Exception e) {
                return "The operation was faild";
            }

        }
    }

    public String saveProcess(Process process) {
        String message = "";
        if (!process.getClient().getClientEmail().endsWith(".com") || !process.getClient().getClientEmail().contains("@")) {
            message = message + "* Email shoud be like Examble@gmail.com <br><br>";

        }
        if (process.getClient().getClientPhone().length() != 11) {
            message = message + "* Invald  phone numbe <br><br>";
        }
        if (process.getClient().getBalance() < process.getAmount() && process.getProType().equals("Withdrawal")) {
            message = message + "* The balance is less than the amount of withdrawal<br><br>";
        }
        if (message != "") {
            return message;
        } else {
            if (process.getProType().equals("Withdrawal")) {
                process.getClient().setBalance(process.getClient().getBalance() - process.getAmount());

            } else if (process.getProType().equals("Deposit")) {
                process.getClient().setBalance(process.getClient().getBalance() + process.getAmount());
            }
            try {
                process.setProDate(new Date());
                SessionFactory factory = HibernateUtil.getSessionFactory();
                Session session = factory.openSession();
                session.beginTransaction();
                session.save(process);
                session.update(process.getClient());
                session.getTransaction().commit();
                session.close();
                return "The operation was successful";
            } catch (Exception e) {
                return "The operation was faild";
            }
        }
    }

    public Employee logIn(String email, String pass) {
        Employee employee = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Employee where employeeEmail=? and employeePass=?");
        query.setParameter(0, email);
        query.setParameter(1, pass);
        List<Employee> listEmployee = query.list();
        System.out.println(listEmployee.size() + "***************");

        session.getTransaction().commit();
        session.close();
        for (Employee e : listEmployee) {
            employee = new Employee();
            employee.setEmployeeAddress(e.getEmployeeAddress());
            employee.setEmployeeEmail(e.getEmployeeEmail());
            employee.setEmployeeId(e.getEmployeeId());
            employee.setEmployeeName(e.getEmployeeName());
            employee.setEmployeePass(e.getEmployeePass());
            employee.setEmployeePhone(e.getEmployeePhone());
            System.out.println(e.getEmployeeName());
        }
        System.out.println("LLLLLLLLLLL");

        return employee;

    }

    public Client getClient(String email, String id) {
        Client client = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
//        clientId, balance, clientAddress, clientEmail, clientName, clientNationalId, clientPass, clientPhone
        Query query = session.createQuery("from Client where clientEmail=? and clientNationalId=?");
        query.setParameter(0, email);
        query.setParameter(1, id);
        List<Client> listClients = query.list();
        System.out.println(listClients.size() + "***************");

        session.getTransaction().commit();
        session.close();
        for (Client e : listClients) {
            client = new Client();
            client.setBalance(e.getBalance());
            client.setClientId(e.getClientId());
            client.setClientAddress(e.getClientAddress());
            client.setClientEmail(e.getClientEmail());
            client.setClientName(e.getClientName());
            client.setClientPass(e.getClientPass());
            client.setClientPhone(e.getClientPhone());
            client.setClientNationalId(e.getClientNationalId());
            System.out.println(e.getClientName());
        }
        System.out.println("LLLLLLLLLLL");

        return client;

    }

    public ArrayList<Process> getdata(int id) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
//proId, amount, proDate, proType, client_clientId, employee_employeeId
        Query query = session.createQuery("from Process where client_clientId=?");
        query.setParameter(0, id);
        ArrayList<Process> cl = (ArrayList<Process>)query.list();
        System.out.println(cl.size() + "***************");
        session.getTransaction().commit();
        session.close();
           System.out.println(cl.get(0).getEmployee().getEmployeeName());

        return cl;

    }
static {
    System.out.println("jjfjf");
}
        public static void main(String[] args) {
        
    }
}
