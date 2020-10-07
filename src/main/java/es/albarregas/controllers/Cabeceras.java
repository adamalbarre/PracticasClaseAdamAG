/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adam
 */
@WebServlet(name = "Cabeceras", urlPatterns = {"/Cabeceras"})
public class Cabeceras extends HttpServlet {
    
    static String[] ing = {"host", "connection", "cache-control", "upgrade-insecure-requests", "user-agent", "accept", "sec-fetch-site",
                            "sec-fetch-mode", "sec-fetch-user", "sec-fetch-dest", "referer", "accept-encoding", "accept-language"};
    static String[] esp = {"Anfitrión", "Conexión", "Control de cache", "Permiso de peticiones inseguras", "Agente usuario", "Aceptar", "Sitio de búsqueda",
                            "Modo de búsqueda", "Usuario de búsqueda", "Destino de búsqueda", "Referencia", "Aceptar codificación", "Aceptar idioma"};

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Cabeceras</title>");
            out.println("\n" 
            + "<link rel=\"stylesheet\" href=\"CSS/estilos.css\">");             
            out.println("</head>");
            out.println("<body><div>");
            out.println("<h1>Cabeceras</h1>");
            Enumeration<String> cabeceras = request.getHeaderNames();
            out.println("<table>"
                    +"<tr>"
                    +"<th>Nombre</th>"
                    +"<th>Valor</th>"
                    +"</tr>");
            while (cabeceras.hasMoreElements()){
                String c = cabeceras.nextElement();
                out.println("<tr><td>"+traduce(c)+"</td><td>"+request.getHeader(c)+"</td></tr>");
            }
            out.println("</table>");
            out.println("<div id='botones'>"
                    + "<br><br>"
                    + "<input type=\"button\" value=\"Volver\" onclick=\"location.href='"+ request.getContextPath()+"/index.html'\">"
                    + "</div></div></body>");
            out.println("</html>");
        }
    }
    
    private String traduce (String tr) {
        String res = tr;
       
        for (int i = 0; i<esp.length;i++){
            if (tr.equals(ing[i])){
                return esp[i];
            }
        }
        return res;
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
