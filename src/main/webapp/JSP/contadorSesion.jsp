<%-- 
    Document   : contadorSesion
    Created on : 19-oct-2020, 12:11:45
    Author     : Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <%

                HttpSession sesion = request.getSession();
                String opcion = null;
                Integer contador = sesion.getAttribute("contador") != null ? (Integer) sesion.getAttribute("contador") : 1;
                StringBuilder mensaje = new StringBuilder("Ha visitado la pagina ");
                boolean limpiar = false;
                try {
                    limpiar = request.getParameter("limpiar").equals("si") ? true : false;
                } catch (NullPointerException e) {

                }
                if (limpiar) {
                    contador = 1;
                    mensaje.append(contador);
                    sesion.setAttribute("contador", ++contador);
                    
                } else {
                    contador = (Integer) sesion.getAttribute("contador") != null ? (Integer) sesion.getAttribute("contador") : 1;

                    mensaje.append(contador);
                    sesion.setAttribute("contador", ++contador);
                }


            %>
            <h2><%=mensaje+(contador==2?" vez":" veces")%></h2>
            <div class="botones">
                <form action="contadorSesion.jsp" method="post">
                    <input type="checkbox" name="limpiar" value="si" id="limp">
                    <label for="limp">Limpiar</label><br><br>
                    <input type="submit" name="enviar" value="Recargar">
                </form><br>
                <input type="button" value="Inicio" onclick="location.href='<%=request.getContextPath()%>/index.html'">
            </div>
        </div>
    </body>
</html>
