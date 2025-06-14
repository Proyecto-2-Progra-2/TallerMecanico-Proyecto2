<%@page import="com.mycompany.proyecto2_progra2.domain.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Clientes</title>
    </head>
    <body>
        <h1>Mostrar Clientes</h1>
        <% ArrayList<Cliente> clientes = (ArrayList<Cliente>) request.getAttribute("clientes"); %>

        <table>
            <thead>
                <tr>
                    <th>Identificación</th>
                    <th>Nombre</th>
                    <th>Primer apellido</th>
                    <th>Segundo apellido</th>
                    <th>Telefono</th>
                    <th>Direccion</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                <% for (Cliente cliente : clientes) {%>
                <tr>
                    <th><%= cliente.getId()%></th>
                    <th><%= cliente.getNombre()%></th>
                    <th><%= cliente.getPrimerApellido()%></th>
                    <th><%= cliente.getSegundoApellido()%></th>
                    <th><%= cliente.getTelefono()%></th>
                    <th><%= cliente.getDireccion()%></th>
                    <th><%= cliente.getEmail()%></th>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
