/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Entity.Client;
import Entity.Process;
import Entity.Employee;
import Model.HibernateOp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class GetData extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
         HttpSession session = request.getSession();
        HibernateOp op = new HibernateOp();
        Employee employee = (Employee) session.getAttribute("employee");
        String message=null;
        Client client = null;
        String type = request.getParameter("type");
        System.out.println("1111 ");
        if (type.equals("getC")) {
            String email = request.getParameter("email");
            String nationalId = request.getParameter("nationalId");
            client = op.getClient(email, nationalId);
            session.setAttribute("client", client);
           
        ArrayList <Process> ps=op.getdata(client.getClientId());
        session.setAttribute("processs",ps);
            System.out.println("3333333");
        }
        System.out.println("");
         RequestDispatcher disptacher=request.getRequestDispatcher("ShowOperation.jsp");
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
