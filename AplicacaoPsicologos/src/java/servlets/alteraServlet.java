/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.UserBean;
import static dao.TimeDao.adicionaAlteraTime;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marc
 */
@WebServlet(name = "alteraServlet", urlPatterns = {"/alteraServlet"})
public class alteraServlet extends HttpServlet {

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
        
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        UserBean loginBean = (UserBean) request.getSession().getAttribute("loginBean");
        String respostaSql = adicionaAlteraTime(startTime, endTime, loginBean.getID());
        request.setAttribute("respostaSql", respostaSql);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/altera.jsp");
        dispatcher.forward(request, response);
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet alteraServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet alteraServlet at " + request.getContextPath() + "</h1>");
            out.println("<p> Start time: " + startTime + " endTime: " + endTime + "</p>");
            out.println("<p>" + loginBean.getNome()  + "</p>");
            out.println("<p>Resposta do sql: " + "</p>;</body>");
            out.println("<p>Start Time: " + startTime + "</p>");
            out.println("<p>End Time: " + endTime + "</p>");
            out.println("</body>");
            out.println("</body>");
            out.println("</html>");
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
