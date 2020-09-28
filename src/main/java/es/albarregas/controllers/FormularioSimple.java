/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adam
 */
@WebServlet(name = "FormularioSimple", urlPatterns = {"/FormularioSimple"})
public class FormularioSimple extends HttpServlet {

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
            
            Map<String, String[]> mapa = request.getParameterMap();
            Set<String> keys = mapa.keySet();
            Iterator<String> it = keys.iterator();
            
                out.println("<!DOCTYPE html>");
                out.println("<html lang='es'>");
                out.println("<head>");

                out.println("<title>Servlet Formulario Simple</title>");
                out.println("<link rel=\"stylesheet\" href=\"CSS/estiloFormSimple.css\">"); 
                out.println("</head>");
                out.println("<body><div>");
                out.println("<fieldset><legend>Datos</legend>");
                out.println("<strong>Usuario:</strong> " + mapa.get(it.next())[0]);
                out.println("<strong><br>Contraseña:</strong> " + mapa.get(it.next())[0]);
                out.println("<strong><br>Edad:</strong> " + mapa.get(it.next())[0]);
                out.println("<strong><br>Estado civil:</strong> " + mapa.get(it.next())[0]);
                out.println("<strong><br>Aficiones:</strong> ");
                String[] aficiones = mapa.get(it.next());

                    for (String i : aficiones) {
                    out.println(i + " ");
                    }

                out.println();
                out.println("<strong><br>Comentarios:</strong> " + mapa.get(it.next())[0]);
                out.println("<strong><br>Internet?:</strong> " + mapa.get(it.next())[0]);
                out.println("<strong><br>Sistema operativo:</strong> " + mapa.get(it.next())[0]);
                out.println("</fieldset>");

                out.println("<div id='botones'>"
                    + "<br><br>"
                    + "<input type=\"button\" value=\"Volver\" onclick=\"location.href='"+ request.getContextPath()+"/index.html'\">"
                    + "</div></div></body>");
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
