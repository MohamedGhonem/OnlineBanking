/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

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
import org.hibernate.Session;

/**
 *
 * @author gohnem
 */
public class LogIn extends HttpServlet {

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

        String type = request.getParameter("type");
        if (type.equals("log")) {

            String employeeEmail = request.getParameter("email");
            String employeePass = request.getParameter("pass");
            Employee employee = op.logIn(employeeEmail, employeePass);
            System.out.println("nn");
            if (employee == null) {
                request.setAttribute("message", "LogIn is failed try again please <br><br>");
                RequestDispatcher despater = request.getRequestDispatcher("LogIn.jsp");
                despater.forward(request, response);
            } else {
                session.setAttribute("employee", employee);
                RequestDispatcher despater = request.getRequestDispatcher("ClientHome.jsp");
                despater.forward(request, response);
            }
        } else if (type.equals("reg")) {
            String confPass=request.getParameter("confpass");
            Employee employee = new Employee();
            employee.setEmployeePass(request.getParameter("employeePass"));
            if(!employee.getEmployeePass().equals(confPass)){
                   request.setAttribute("message","Password not the Confirm Password <br><br>");
                RequestDispatcher dispatcher=request.getRequestDispatcher("Register.jsp");
                dispatcher.forward(request, response);
            }else {
                
            
            employee.setEmployeeEmail(request.getParameter("employeeEmail"));
            employee.setEmployeeAddress(request.getParameter("employeeAddress"));
            employee.setEmployeeName(request.getParameter("employeeName"));
            employee.setEmployeePhone(request.getParameter("employeePhone"));
            String message=op.saveEmployee(employee);
            if(message.equals("The operation was successful")){
                 RequestDispatcher despater = request.getRequestDispatcher("LogIn.jsp");
                despater.forward(request, response);
            }else {
                request.setAttribute("message",message);
                RequestDispatcher dispatcher=request.getRequestDispatcher("Register.jsp");
                dispatcher.forward(request, response);
            
            }
            
            }
            
            
            
        }else {
            System.out.println("ggggggggggggggg");
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
