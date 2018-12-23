/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Client;
import Entity.Employee;
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
public class ClientR extends HttpServlet {

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
        Employee employee=(Employee)session.getAttribute("employee");
        String type = request.getParameter("type");
        System.out.println("****************");
        if (type.equals("reg")) {
            String cofPass = request.getParameter("confpass");
            Client client = new Client();
            client.setBalance(Integer.parseInt(request.getParameter("balance")));
            client.setClientNationalId(request.getParameter("clientNationalId"));
            client.setClientPass(request.getParameter("clientPass"));
            client.setClientName(request.getParameter("clientName"));
            client.setClientEmail(request.getParameter("clientEmail"));
            client.setClientAddress(request.getParameter("clientAddress"));
            client.setClientPhone(request.getParameter("clientPhone"));
            if (client.getClientPass().equals(cofPass)) {
                HibernateOp op = new HibernateOp();
                String message = op.saveClient(client ,employee);
                System.out.println(message);
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher("AddClient.jsp");
                dispatcher.forward(request, response);

            }else {
                request.setAttribute("message", "Password not the Confirm Password <br><br>");
                RequestDispatcher dispatcher = request.getRequestDispatcher("AddClient.jsp");
                
            }
            System.out.println("*****************");
        }
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
