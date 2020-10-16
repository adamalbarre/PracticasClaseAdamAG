<%-- 
    Document   : contador
    Created on : 13-oct-2020, 17:25:07
    Author     : Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estiloFormSimple.css">
        <title>Contador de visitas</title>
    </head>
    <body>

        <div>
            <%

                Cookie contador = new Cookie("CONTADOR", "1");
                contador.setMaxAge(3600);

                Cookie[] cookies = request.getCookies();
                try {
                    for (Cookie c : cookies) {
                        if (c.getName().equals("CONTADOR")) {
                            contador = c;
                            int visitas = Integer.parseInt(contador.getValue());
                            contador.setValue(String.valueOf(++visitas));
                            response.addCookie(contador);
                        }
                    }
                } catch (NullPointerException e) {
            %>

            <!--<h3><span style="color: red;">No hay cookies</span></h3> -->

            <%
                    response.addCookie(contador);
                }
                try {
                    if (request.getParameter("limpiar").equals("si")) {
                        contador = new Cookie("CONTADOR", "1");
                        contador.setMaxAge(3600);
                        response.addCookie(contador);
                    }
                } catch (NullPointerException e) {

                }

                if (Integer.parseInt(contador.getValue()) > 1) {

            %><h2>Ha visitado la página&nbsp;<%=contador.getValue()%>&nbsp;veces</h2>
            <%
            } else {
            %><h2>Ha visitado la página&nbsp;<%=contador.getValue()%>&nbsp;veces</h2>
            <br><p>
                <strong>Caducidad:&nbsp;</strong><%=contador.getMaxAge()%>&nbsp;segundos<br>
                <strong>Nombre:&nbsp;</strong><%=contador.getName()%><br>
                <strong>Segura:&nbsp;</strong><%=contador.getSecure() ? "Si" : "No"%><br>
                <strong>Version:&nbsp;</strong><%=contador.getVersion()%>
            </p>
            <%}%>
            <div class="botones">
                <form action="contador.jsp">
                    <input type="hidden" name="limpiar" value="no">
                    <input type="submit" value="Recargar">
                </form><br>
                <form action="contador.jsp">
                    <input type="hidden" name="limpiar" value="si">
                    <input type="submit" value="Limpiar">
                </form><br>
                <input type="button" value="Inicio" onclick="location.href='../index.html'">
            </div>
        </div>

    </body>
</html>
