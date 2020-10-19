<%-- 
    Document   : menuSesionAux
    Created on : 18-oct-2020, 12:34:13
    Author     : Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    HttpSession sesion = request.getSession(true);
    StringBuilder mensaje = new StringBuilder("menuSesion.jsp?mensaje=");
    String opcion = request.getParameter("enviar");
    String nombre = request.getParameter("nombre");
    String valor = request.getParameter("valor")!=null?request.getParameter("valor"):"";
    switch(opcion) {
        case "Crear":
            sesion.setAttribute(nombre, valor);
            mensaje.append("Se ha creado el atributo de sesion ").append(nombre).append(" con valor ").append(valor.equals("")?"vac&iacute;o":valor);
            break;
        case "Visualizar":
            if(sesion.getAttribute(nombre)==null){
                mensaje.append("El atributo de sesion ").append(nombre).append(" no se encontr&oacute;");
            } else {
                mensaje.append("El atributo de sesion ").append(nombre).append(" tiene valor ").append(sesion.getAttribute(nombre));
            }
            break;
        case "Modificar":
            if(sesion.getAttribute(nombre)==null){
                mensaje.append("El atributo de sesion ").append(nombre).append(" no se encontr&oacute;");
            } else {
                sesion.setAttribute(nombre, valor);
                mensaje.append("El atributo de sesion ").append(nombre).append(" tiene ahora valor ").append(sesion.getAttribute(nombre));
            }
            break;
        case "Eliminar":
            if(sesion.getAttribute(nombre)==null){
                mensaje.append("El atributo de sesion ").append(nombre).append(" no se encontr&oacute;");
            } else {
                sesion.removeAttribute(nombre);
                mensaje.append("El atributo de sesion ").append(nombre).append(" se ha eliminado");
            }
            break;
        case "Inicio":
            mensaje.replace(0, mensaje.length(), request.getContextPath());
            break;
    }
    
    response.sendRedirect(mensaje.toString());
    



%>
