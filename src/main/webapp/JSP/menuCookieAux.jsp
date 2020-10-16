<%-- 
    Document   : menuCookieAux
    Created on : 15-oct-2020, 12:41:07
    Author     : Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    Cookie cookie = null;
    Cookie[] cookies = request.getCookies();
    String nombre = null, valor = null;
    StringBuilder mensaje = new StringBuilder("menuCookie.jsp?mensaje=");

    switch (request.getParameter("enviar")) {
        case "modificar":
            try {
                boolean found = false;
                nombre = request.getParameter("nombre");
                valor = request.getParameter("valor");
                for (Cookie c : cookies) {
                    if (c.getName().equals(nombre)) {
                        cookie = c;
                        found = true;
                        break;
                    }
                }

                cookie.setValue(valor);
                response.addCookie(cookie);

                mensaje.append("La cookie ").append(nombre).append(" tiene ahora valor ").append(valor);
            } catch (NullPointerException e) {
                mensaje.append("La cookie ").append(nombre).append(" no se encontro o el valor está vacío");
            }
            break;
        case "eliminar":
            try {
                boolean found = false;
                nombre = request.getParameter("nombre");
                for (Cookie c : cookies) {
                    if (c.getName().equals(nombre)) {
                        cookie = c;
                        found = true;
                        break;
                    }
                }

                cookie.setMaxAge(0);

                response.addCookie(cookie);

                if (found) {
                    mensaje.append("La cookie ").append(nombre).append(" se ha eliminado");
                }
            } catch (NullPointerException e) {
                mensaje.append("La cookie ").append(nombre).append(" no se encontr&oacute;");
            }

            break;
        case "visualizar":
            try {
                nombre = request.getParameter("nombre");
                for (Cookie c : cookies) {
                    if (c.getName().equals(nombre)) {
                        cookie = c;
                        break;
                    }
                }

                nombre = cookie.getName();
                valor = cookie.getValue();
                mensaje .append("La cookie ").append(nombre).append(" tiene valor ").append(valor);
            } catch (NullPointerException e) {
                mensaje.append("La cookie ").append(nombre).append(" no se encontr&oacute;");
            }

            break;
        case "crear":
            nombre = request.getParameter("nombre");
            valor = request.getParameter("valor");
            cookie = new Cookie(nombre, valor);
            response.addCookie(cookie);
            mensaje.append("Se ha creado la cookie ").append(nombre).append(" con valor ").append(valor);
            break;
        default:

            break;
    }

    response.sendRedirect(mensaje.toString());

%>