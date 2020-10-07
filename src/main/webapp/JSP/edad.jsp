<%-- 
    Document   : edad
    Created on : 06-oct-2020, 17:47:25
    Author     : Adam
--%>

<%@page import="java.time.Period"%>
<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../CSS/estiloFormSimple.css">
        <title>Edad</title>
    </head>
    <body>
        <div>
            <%
              String res = "";
              LocalDate fNac = LocalDate.parse(request.getParameter("fNac"));
              LocalDate hoy = LocalDate.now();
              
              Period edad = Period.between(fNac, hoy);
              
              if (hoy.isEqual(fNac)){
                  
                  %><h3><%=request.getParameter("nombre")%>&nbsp;ha nacido hoy. ¡Felicidades!</h3>
            <%
                  
              } else
              
              if (hoy.isBefore(fNac)) {
               
            %><h3><%=request.getParameter("nombre")%>&nbsp;aún no ha nacido</h3>
            <%
              } else {
                    res = "Saludos, "+
                    request.getParameter("nombre")+" tiene "
                    +(edad.getYears()== 0? "":(edad.getYears()+" años, "))
                    +(edad.getMonths()==0?"":(edad.getMonths()+" meses, "))
                    +(edad.getDays()==0?"":(edad.getDays()+" dias"));
                }
            %>
            <p style="text-align:center;"><%=res%></p>
            <br><br>
            <div id="botones">
                <input type="button" value="Inicio" onclick="location.href='../index.html'">
            </div>
        </div>
    </body>
</html>
