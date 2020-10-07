<%-- 
    Document   : prueba
    Created on : 06-oct-2020, 16:23:13
    Author     : Adam
--%>

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estiloFormSimple.css"
        <title>Saludo JSP</title>
    </head>
    <body>
        <div>
            <%
                int hora = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                String saludo = "";
                
                if (hora < 7){
                    saludo = "Buenas noches";
                }
                
                if (hora >= 7){
                    saludo = "Buenos dias";
                }
                
                if (hora >= 12 && hora < 19) {
                    saludo = "Buenas tardes";
                }
                
                if (hora >= 19) {
                    saludo = "Buenas noches";
                }
                
                String nombre = request.getParameter("nombre")!=null?
                request.getParameter("nombre"):"";
                String titulo;
                if (request.getParameter("sexo").equals("hombre")) {
                    titulo="señor";
                } else {
                    titulo="señora";
                }
                
                out.println("<p>"+saludo+" "+titulo+" "+nombre+"</p>");
            
            %>
            <br><br>
            <div id="botones">
                <input type="button" value="Inicio" onclick="location.href='../index.html'">
            </div>
        </div>
    </body>
</html>
