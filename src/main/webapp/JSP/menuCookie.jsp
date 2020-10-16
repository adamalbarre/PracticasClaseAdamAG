<%-- 
    Document   : menuCookie
    Created on : 15-oct-2020, 12:26:34
    Author     : Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de Cookies</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estiloFormSimple.css">
    </head>
    <body>
        <div>
            <form action="menuCookieAux.jsp">
                <div style="margin-left: auto; margin-right: auto; border: none; text-align: center;">
                    
                    <strong>Nombre de la cookie</strong>
                    <br><input type="text" name="nombre" placeholder="Ej: CONTADOR"><br><br>
                    <strong>Valor</strong>
                    <br><input type="text" name="valor"><br><br>
                    <h3><%=request.getParameter("mensaje")==(null)?"":request.getParameter("mensaje")%></h3>
                </div>
                <div class="botones">
                    <input type="submit" name="enviar" value="crear">
                    <input type="submit" name="enviar" value="visualizar">
                    <input type="submit" name="enviar" value="modificar">
                    <input type="submit" name="enviar" value="eliminar">
                    <br><br><input type="button" value="Inicio" onclick="location.href='../index.html'">
                </div>
            </form>
        </div>
    </body>
</html>
