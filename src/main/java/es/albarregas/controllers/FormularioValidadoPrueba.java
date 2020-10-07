/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
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
@WebServlet(name = "FormularioValidadoPrueba", urlPatterns = {"/FormularioValidadoPrueba"})
public class FormularioValidadoPrueba extends HttpServlet {
    
    private static Set<String> err = new HashSet<String>();

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
            
            Map<String, String[]> mapa = request.getParameterMap();
            Set<String> keys = mapa.keySet();
            Iterator<String> it = keys.iterator();
            
            String usuario = mapa.get("usu")[0];
            String contrasenia = mapa.get("pass")[0];
            String edad = mapa.get("edad")[0];
            String civil = mapa.get("civil")[0];
            String comentario = mapa.get("comentario")[0];
            String internet = mapa.get("internet")[0];
            String os = mapa.get("os")[0];
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FormularioValidadoPrueba</title>");
            out.println("<link rel='stylesheet' href='CSS/estiloFormSimple.css'>");
            out.println("</head>");
            
            if (comprueba(mapa, keys)) {
                
                
            String aficiones = "";
            for (String s : mapa.get("aficiones")) {
                    s = s.substring(0, 1).toUpperCase() + s.substring(1);
                    aficiones += s + " ";
                }
                
                out.println("<body><h1>Registro completado</h1><div><h2>Datos personales</h2>");
                out.println("<br><strong>Usuario: </strong>"+usuario);
                out.println("<br><strong>Password: </strong>"+contrasenia);
                out.println("<br><strong>Edad: </strong>"+edad);
                out.println("<br><h2>Otros datos</h2>");
                out.println("<br><strong>Estado civil: </strong>"+civil);
                out.println("<br><strong>Aficiones: </strong>"+aficiones);
                out.println("<br><strong>Comentarios: </strong>"+comentario);
                out.println("<br><h2>Medios tecnologicos</h2>");
                out.println("<br><strong>¿Dispones de internet?</strong>"+internet);
                out.println("<br><strong>Sistema operativo: </strong>"+os);
                out.println("<br><br><br><input type=\"button\" value=\"Volver\" onclick=\"location.href='"+ request.getContextPath()+"/index.html'\">");
                out.println("</body>");
                
            } else {
                
                String msgErr = "";
                for (String e : err) {
                    msgErr += e + "\\n";
                }
                
                out.println("<body><form action='FormularioValidadoPrueba' method='post'>");
                out.println("<div><fieldset>");
                out.println("<legend><em><strong>Datos Personales</strong></em></legend>");
                out.println("<strong>"+(err.contains("El campo usuario no puede estar vacio") ? "<span style='color:red'>Usuario</span>": "Usuario")+"</strong><br>\n");
                out.println("<input type='text' name'usu' value='"+usuario+"'><br>\n");
                out.println("<strong>"+(err.contains("El campo contraseña no puede estar vacio") ? "<span style='color:red'>Contraseña</span>": "Contraseña")+"</strong><br>\n");
                out.println("<input type='text' name'usu' value='"+contrasenia+"'><br>\n");
                out.println("<strong>"+(err.contains("El campo edad no puede estar vacio") ? "<span style='color:red'>Edad</span>": "Edad")+"</strong><br>\n");
                out.println("<input type='text' name'usu' value='"+edad+"'><br>\n");
                out.println("</fieldset></div><br>");
                
                out.println("<div><fieldset>");
                out.println("<legend><em><strong>Otros datos</strong></em></legend>");
                
                switch (civil) {
                    case "Soltero/a":
                        out.println("<strong>"+(err.contains("Debe seleccionar un estado civil") ? "<span style='color:red'>Estado civil</span>" : "Estado civil")+"</strong><br>\n");
                        out.println("<input type='radio' name='civil' value='Soltero/a' id='sol' checked='checked'>Soltero/a");
                        out.println("<input type='radio' name='civil' value='Casado/a' id='cas'>Casado/a");
                        out.println("<input type='radio' name='civil' value='Viudo/a' id='viu'>Viudo/a");
                        out.println("<input type='radio' name='civil' value='Divorciado/a' id='divor'>Divorciado/a");
                        break;
                    case "Casado/a":
                        out.println("<strong>"+(err.contains("Debe seleccionar un estado civil") ? "<span style='color:red'>Estado civil</span>" : "Estado civil")+"</strong><br>\n");
                        out.println("<input type='radio' name='civil' value='Soltero/a' id='sol'>Soltero/a");
                        out.println("<input type='radio' name='civil' value='Casado/a' id='cas' checked='checked'>Casado/a");
                        out.println("<input type='radio' name='civil' value='Viudo/a' id='viu'>Viudo/a");
                        out.println("<input type='radio' name='civil' value='Divorciado/a' id='divor'>Divorciado/a");
                        break;
                    case "Viudo/a":
                        out.println("<strong>"+(err.contains("Debe seleccionar un estado civil") ? "<span style='color:red'>Estado civil</span>" : "Estado civil")+"</strong><br>\n");
                        out.println("<input type='radio' name='civil' value='Soltero/a' id='sol'>Soltero/a");
                        out.println("<input type='radio' name='civil' value='Casado/a' id='cas'>Casado/a");
                        out.println("<input type='radio' name='civil' value='Viudo/a' id='viu' checked='checked'>Viudo/a");
                        out.println("<input type='radio' name='civil' value='Divorciado/a' id='divor'>Divorciado/a");
                        break;
                    case "Divorciado/a":
                        out.println("<strong>"+(err.contains("Debe seleccionar un estado civil") ? "<span style='color:red'>Estado civil</span>" : "Estado civil")+"</strong><br>\n");
                        out.println("<input type='radio' name='civil' value='Soltero/a' id='sol'>Soltero/a");
                        out.println("<input type='radio' name='civil' value='Casado/a' id='cas'>Casado/a");
                        out.println("<input type='radio' name='civil' value='Viudo/a' id='viu'>Viudo/a");
                        out.println("<input type='radio' name='civil' value='Divorciado/a' id='divor' checked='checked'>Divorciado/a");
                        break;
                    default:
                        out.println("<strong>"+(err.contains("Debe seleccionar un estado civil") ? "<span style='color:red'>Estado civil</span>" : "Estado civil")+"</strong><br>\n");
                        out.println("<input type='radio' name='civil' value='Soltero/a' id='sol'>Soltero/a");
                        out.println("<input type='radio' name='civil' value='Casado/a' id='cas'>Casado/a");
                        out.println("<input type='radio' name='civil' value='Viudo/a' id='viu'>Viudo/a");
                        out.println("<input type='radio' name='civil' value='Divorciado/a' id='divor'>Divorciado/a");
                        break;
                }
                
                String[] aficiones = mapa.get("aficiones[]");
                        
                out.println("<strong>"+(err.contains("Debe seleccionar una aficion como minimo") ? "<span style='color:red'>Aficiones</span>" : "Aficiones")+"</strong><br>\n");
                out.println("<select name='aficiones[]' id='afi' size='6' multiple='multiple'>");
                out.println("option value='Deporte' name='aficiones[]"+(contains("Deporte", aficiones)? "checked='checked'":"")+">Deporte</option>");
                out.println("option value='Musica' name='aficiones[]"+(contains("Musica", aficiones)? "checked='checked'":"")+">Musica</option>");
                out.println("option value='Informatica' name='aficiones[]"+(contains("Informatica", aficiones)? "checked='checked'":"")+">Informatica</option>");
                out.println("option value='Viajes' name='aficiones[]"+(contains("Viajes", aficiones)? "checked='checked'":"")+">Viajes</option>");
                out.println("option value='Tiendas' name='aficiones[]"+(contains("Tiendas", aficiones)? "checked='checked'":"")+">Tiendas</options>");
                out.println("option value='Juegos' name='aficiones[]"+(contains("Juegos", aficiones)? "checked='checked'":"")+">Juegos</options>");
                
                out.println("<strong>"+(err.contains("Debe introducir un comentario") ? "<span style='color:red'>Comentario:</span>": "Comentario:")+"</strong><br>\n");
                out.println("<textarea name'comentario' id='coment' rows='8' cols='65' placeholder='Debe introducir un comentario' value='"+comentario+"'><br>\n");
                out.println("</fieldset></div>");
                
                out.println("<div><fieldset>");
                out.println("<legend>Medios tecnologicos</legend><br>");
                out.println("<strong>"+(err.contains("Debe decir si tiene internet o no") ? "<span style='color:red'>¿Dispones de internet?</span>": "¿Dispones de internet?")+"</strong><br>\n");
                
                if (internet.contains("Si")){
                    
                    out.println("<input type='radio' name='internet' value='Si' id='si' checked='checked'><label for='si'>Si</label>");
                    out.println("<input type='radio' name='internet' value='No' id='no'><label for='no'>No</label>");
                    
                } else if (internet.contains("No")){
                    
                    out.println("<input type='radio' name='internet' value='Si' id='si'><label for='si'>Si</label>");
                    out.println("<input type='radio' name='internet' value='No' id='no' checked='checked'><label for='no'>No</label>");
                    
                } else {
                    
                    out.println("<input type='radio' name='internet' value='Si' id='si'><label for='si'>Si</label>");
                    out.println("<input type='radio' name='internet' value='No' id='no'><label for='no'>No</label>");
                    
                }
                
                out.println("<strong>"+(err.contains("Debe seleccionar un sistema operativo") ? "<span style='color:red'>Sistema operativo</span>": "Sistema operativo")+"</strong><br>\n");
                out.println("<select name='os' size='4'>");
                
                if (os.contains("Linux")){
                    
                    out.println("<option id='os' value='Linux' selected='selected'>Linux</option>");
                    out.println("<option id='os' value='Windows'>Windows</option>");
                    out.println("<option id='os' value='Macintosh'>Macintosh</option>");
                    out.println("<option id='os' value='Solaris'>Solaris</option>");
                    
                } else if (os.contains("Windows")) {
                    
                    out.println("<option id='os' value='Linux'>Linux</option>");
                    out.println("<option id='os' value='Windows' selected='selected'>Windows</option>");
                    out.println("<option id='os' value='Macintosh'>Macintosh</option>");
                    out.println("<option id='os' value='Solaris'>Solaris</option>");
                    
                } else if (os.contains("Macintosh")) {
                    
                    out.println("<option id='os' value='Linux'>Linux</option>");
                    out.println("<option id='os' value='Windows'>Windows</option>");
                    out.println("<option id='os' value='Macintosh' selected='selected'>Macintosh</option>");
                    out.println("<option id='os' value='Solaris'>Solaris</option>");
                    
                } else if (os.contains("Solaris")) {
                    
                    out.println("<option id='os' value='Linux' selected>Linux</option>");
                    out.println("<option id='os' value='Windows'>Windows</option>");
                    out.println("<option id='os' value='Macintosh'>Macintosh</option>");
                    out.println("<option id='os' value='Solaris' selected='selected'>Solaris</option>");
                    
                }
                
                out.println("</fieldset></div>");
                
                out.println("<div ='botones'><br><br>");
                out.println("<input type='submit' name='enviar' value='Enviar'>");
                out.println("<input type='reset' value='Limpiar'>");
                out.println("<br><input type='button' value='Volver' onclick='location.href='"+ request.getContextPath()+"/HTML/formValidacion.html'\">");
                out.println("</body><script type='text/javascript'>alert('"+msgErr+"'");
            }
            
        }
    }
    
    
    private boolean contains(String aficion, String[] aficiones) {
        boolean res = false;

        for (String s : aficiones) {
            if (s.equals(aficion)) {
                res = true;
            }
        }

        return res;
    }
    
    private boolean comprueba(Map<String, String[]> mapa, Set<String> keys) {
        
        if (mapa.get("usu")[0].equals("")) {
            err.add("El campo usuario no puede estar vacío");
        }
        if (mapa.get("pass")[0].equals("")) {
            err.add("El campo contraseña no puede estar vacia");
        }
        if (mapa.get("edad")[0].equals("")) {
            err.add("El campo edad no puede estar vacia");
        }
        if (mapa.get("civil")[0].equals("")) {
            err.add("Debe seleccionar un estado civil.");
        }
        if (mapa.get("comentario")[0].equals("")) {
            err.add("Debe introducir un comentario");
        }
        if (mapa.get("internet")[0].equals("")) {
            err.add("Debe decir si tiene internet o no");
        }
        if (mapa.get("os")[0].equals("")) {
            err.add("Debe seleccionar un sistema operativo");
        }
        
        if (mapa.get("aficiones")[0].equals("")){
            err.add("Debe seleccionar una aficion como minimo");
        }
        
        

        return !mapa.get("aficiones")[0].equals("") && !mapa.get("usu")[0].equals("") && !mapa.get("pass")[0].equals("") && !mapa.get("edad")[0].equals("") && !mapa.get("civil")[0].equals("") && !mapa.get("comentario")[0].equals("")&& !mapa.get("internet")[0].equals("") && !mapa.get("os")[0].equals("");
        
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
