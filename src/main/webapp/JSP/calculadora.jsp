<%-- 
    Document   : calculadora
    Created on : 13-oct-2020, 11:21:52
    Author     : Adam
--%>

<%@page import="java.util.Map"%>
<%@page import="java.time.format.TextStyle"%>
<%@page import="java.util.Locale"%>
<%@page import="java.time.DayOfWeek"%>
<%@page import="java.time.Month"%>
<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora JSP</title>
        <link rel="stylesheet" type="text/css" href="../CSS/estiloFormSimple.css">
    </head>
    <body>
        <div class="caja">
            <form action="calculadora.jsp" method="post">
                <%
                  LocalDate hoy = LocalDate.now();
                  String diaMes = String.valueOf(hoy.getDayOfMonth());
                  String año = String.valueOf(hoy.getYear());
                  
                  Month mes = hoy.getMonth();
                  DayOfWeek diaSemana = LocalDate.now().getDayOfWeek();
                  String nomMes = mes.getDisplayName(TextStyle.FULL, new Locale ("es", "ES"));
                  String nomDiaSemana = diaSemana.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
                  
                  String fHoy = String.format("%s, %s de %s de %s", nomDiaSemana, diaMes, nomMes, año);
                  
                %>
                
                <div class="fecha">
                    <i><b><%=fHoy%></b></i>
                </div>
                
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
                     String resultado = "El resultado de ";
                     try {
                         num1 = Double.parseDouble(request.getParameter("entrada1"));
                         num2 = Double.parseDouble(request.getParameter("entrada2"));
                         
                         switch (request.getParameter("operacion")) {
                            case "+":
                                 res = num1 + num2;
                                 resultado += " sumar ";
                                 break;
                            case "-":
                                res = num1 - num2;
                                resultado += " restar ";
                                break;
                            case "*":
                                res = num1 * num2;
                                resultado += " multiplicar ";
                                break;
                            case "/":
                                if (num2 == 0){
                                    resultado = "";
                %><h2><span style="color:red;">No se puede dividir por 0</span></h2><%
                            }
                            resultado += " dividir ";
                            res = num1 / num2;
                            break;
                            default:
                                res= 0;
                                break;
                         }
                         resultado += String.format("%.2f", num1) + " y " + String.format("%.2f", num2) + " es " + String.format("%.2f", res);
                     } catch (NumberFormatException e) {
                    %><h3><span style="color:red;">Las entradas deben ser números, y ambas rellenas</span></h3> <%
                    resultado = "";
                    }
                    %><h3><%= !resultado.equals("")?resultado:""%></h3><%
                 }%>
                 <div class="entrada">
                     Primer operando<br>
                     <input type="text" name="entrada1" size="8"><br><br>
                 </div>
                 <div class="entrada">
                     Segundo operando<br>
                     <input type="text" name="entrada2" size="8"><br><br>
                 </div>
                 
                 <div class="radio">
                     <label for="sum">Suma</label>
                     <input type="radio" id="sum" name="operacion" value="+" checked>&emsp;
                     <label for="res">Resta</label>
                     <input type="radio" id="res" name="operacion" value="-">&emsp;
                     <label for="mul">Multiplicación</label>
                     <input type="radio" id="mul" name="operacion" value="*">&emsp;
                     <label for="divi">División</label>
                     <input type="radio" id="divi" name="operacion" value="/"> &emsp;
                 </div>
                 <br><br>
                <div id="botones">
                    <input type="submit" value="Enviar" name="Enviar">&emsp;
                    <input type="reset" value="Limpiar">&emsp;
                    <input type="button" value="Inicio" onclick="location.href='../index.html'">
                </div>  
               
            </form>
        </div>
    </body>
</html>
 