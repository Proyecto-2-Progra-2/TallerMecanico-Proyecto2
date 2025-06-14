<%@page import="com.mycompany.proyecto2_progra2.domain.Vehiculo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Vehiculos</title>
    </head>
    <body>
        <h1>Mostrar Vehiculos</h1>
        <% ArrayList<Vehiculo> vehiculos = (ArrayList<Vehiculo>) request.getAttribute("vehiculos"); %>
        
        <table>
            <thead>
                <tr>
                    <th>Placa</th>
                    <th>Color</th>
                    <th>Marca</th>
                    <th>Estilo</th>
                    <th>VIN</th>
                    <th>Cilindraje</th>
                    <th>Año</th>
                    <th>Dueño</th>
                </tr>
            </thead>
            <tbody>
                <% for (Vehiculo vehiculo : vehiculos) {%>
                <tr>
                    <th><%= vehiculo.getPlaca() %></th>
                    <th><%= vehiculo.getColor() %></th>
                    <th><%= vehiculo.getMarca() %></th>
                    <th><%= vehiculo.getEstilo() %></th>
                    <th><%= vehiculo.getVin() %></th>
                    <th><%= vehiculo.getCilindraje() %></th>
                    <th><%= vehiculo.getAnnio() %></th>
                    <th><%= vehiculo.getDuenno().getId() %></th>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
