<%-- 
    Document   : menuSesion
    Created on : 18-oct-2020, 12:17:53
    Author     : Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estiloFormSimple.css">
    </head>
    <body>
        <div>
            <form action="menuSesionAux.jsp">
                <div style="margin-left: auto; margin-right: auto; border: none; text-align: center;">
                    
                    <strong>Nombre del atributo</strong>
                    <br><input type="text" name="nombre" placeholder="Ej: CONTADOR" required><br><br>
                    <strong>Valor</strong>
                    <br><input type="text" name="valor"><br><br>
                    <h3><%=request.getParameter("mensaje")==(null)?"":request.getParameter("mensaje")%></h3>
                </div>
                <div class="botones">
                    <input type="submit" name="enviar" value="Crear">
                    <input type="submit" name="enviar" value="Visualizar">
                    <input type="submit" name="enviar" value="Modificar">
                    <input type="submit" name="enviar" value="Eliminar">
                    <br><br><input type="submit" name="enviar" value="Inicio">
                </div>
            </form>
        </div>
    </body>
</html>
