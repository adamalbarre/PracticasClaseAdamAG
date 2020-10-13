<%-- 
    Document   : monedero
    Created on : 13-oct-2020, 12:09:45
    Author     : Adam
--%>

<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Monedero</title>
        <link rel="stylesheet" type="text/css" href="../CSS/estiloFormSimple.css">
    </head>
    <body>        
        <div class="caja">
            <form action="monedero.jsp" method="post">
                <%
                 Map<String, String[]> parametros = request.getParameterMap();
                 boolean enviado = false;
                 
                 for (Map.Entry<String, String[]> entrada : parametros.entrySet()) {
                     if (entrada.getValue()[0].equals("Enviar")){
                         enviado = true;
                         break;
                     }
                 }
                
                if (enviado) {
                     double num1, num2;
                     double res;
                     String vuelta = "";
                     try {
                         num1 = Double.parseDouble(request.getParameter("entrada1"));
                         num2 = Double.parseDouble(request.getParameter("entrada2"));
                         res = num1 - num2;
                         
                         
                         if (res == 0){
                             %><h2><span style="color:red;">Has pagado el precio integro.</span></h2><%
                         }

                         if (res >= 200) {
                         res -= 200;
                         vuelta += "1 de 200";
                         }
                         
                         if (res >= 100) {
                         res -= 100;
                         vuelta += "1 de 100";
                         }

                         if (res >= 50){
                         res -= 50;
                         vuelta += "1 de 50";
                         }

                         if (res >= 20) {
                         res -= 20;
                         vuelta += "1 de 20";
                         }

                         if (res >= 10){
                         res -= 10;
                         vuelta += "1 de 10";
                         }

                         if (res >= 5) {
                         res -= 5;
                         vuelta += "1 de 5";
                         }
                         
                         if (res >= 2) {
                         res -= 2;
                         vuelta += "1 de 2";
                         }

                         if (res >= 1) {
                         res -= 1;
                         vuelta += "1 de 2";
                         }

                     } catch (NumberFormatException e){
                         %><h3><span style="color:red;">Las entradas deben ser números, y ambas rellenas</span></h3> <%
                         vuelta = "";
                     }
                     %><h3><%= !vuelta.equals("")?vuelta:""%></h3><%
                 }%>
                 
                 
                <h1>Entrada de datos</h1>
                    <div class="entrada">
                        Precio del producto<br>
                        <input type="text" name="entrada1" size="8"><br><br>
                    </div>
                    <div class="entrada">
                        Entregado<br>
                        <input type="text" name="entrada2" size="8"><br><br>
                    </div>
                    
                    <div id="botones">
                        <input type="submit" value="Enviar" name="Enviar">&emsp;
                        <input type="reset" value="Limpiar">&emsp;
                        <input type="button" value="Inicio" onclick="location.href='../index.html'">
                    </div>  
            </form>
        </div>
    </body>
</html>
