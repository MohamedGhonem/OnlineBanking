/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Client;
import Entity.Employee;
import Entity.Process;
import Model.HibernateOp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gohnem
 */
public class Operation extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        HibernateOp op = new HibernateOp();
        Employee employee = (Employee) session.getAttribute("employee");
        String message=null;
        Client client = null;
        String type = request.getParameter("type");
        System.out.println("الاول ");
        if (type.equals("getC")) {
            String email = request.getParameter("email");
            String nationalId = request.getParameter("nationalId");
            client = op.getClient(email, nationalId);
            session.setAttribute("client", client);
            System.out.println("الثانى ");
        } else {
            client=(Client)session.getAttribute("client");
            String opType =request.getParameter("operation");
            Process process=new Process();
            process.setProType(opType);
            process.setEmployee(employee);
            process.setAmount(Integer.parseInt(request.getParameter("amount")));
            client.setClientEmail(request.getParameter("clientEmail"));
            client.setClientAddress(request.getParameter("clientAddress"));
            client.setClientPhone(request.getParameter("clientPhone"));
            process.setClient(client);
            message=op.saveProcess(process);
            request.setAttribute("message",message);
            System.out.println("الثالث");
        }
        if(message=="The operation was successful"){
            session.setAttribute("client",null);
            System.out.println("الرابع ");
        }       
            System.out.println("الخامس ");
            RequestDispatcher disptacher=request.getRequestDispatcher("Operation.jsp");
            disptacher.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
