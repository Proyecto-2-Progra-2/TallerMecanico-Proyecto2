<%-- 
    Document   : historialCliente
    Created on : 30 jun 2025, 16:25:31
    Author     : jimen
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.proyecto2_progra2.domain.OrdenTrabajo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String clienteId = (String) request.getAttribute("clienteId");
    ArrayList<OrdenTrabajo> historial = (ArrayList<OrdenTrabajo>) request.getAttribute("historial");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Historial del Cliente</title>
    <style>
        body {
            background-color: #f4f6f9;
            font-family: 'Segoe UI', sans-serif;
            margin: 0;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #2c3e50;
        }

        table {
            margin: 30px auto;
            border-collapse: collapse;
            width: 90%;
            background-color: white;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }

        th, td {
            padding: 12px 20px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #34495e;
            color: white;
        }

        tr:hover {
            background-color: #ecf0f1;
        }

        .back-button {
            display: block;
            width: 200px;
            margin: 20px auto;
            padding: 10px;
            background-color: #2980b9;
            color: white;
            text-align: center;
            text-decoration: none;
            border-radius: 6px;
            font-weight: bold;
        }

        .back-button:hover {
            background-color: #1c5980;
        }
    </style>
</head>
<body>

    <h1>Historial del Cliente: <%= clienteId %></h1>

    <% if (historial == null || historial.isEmpty()) { %>
        <p style="text-align: center;">No se encontraron órdenes para este cliente.</p>
    <% } else { %>
        <table>
            <thead>
                <tr>
                    <th>ID Orden</th>
                    <th>Fecha Ingreso</th>
                    <th>Fecha Devolución</th>
                    <th>Estado</th>
                    <th>Precio Total</th>
                    <th>Descripción</th>
                </tr>
            </thead>
            <tbody>
                <% for (OrdenTrabajo orden : historial) { %>
                    <tr>
                        <td><%= orden.getId() %></td>
                        <td><%= orden.getFechaIngreso() %></td>
                        <td><%= orden.getFechaDevolucion() %></td>
                        <td><%= orden.getEstado() %></td>
                        <td>₡<%= orden.getPrecio() %></td>
                        <td><%= orden.getDescripcion() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    <% } %>

    <a class="back-button" href="javascript:history.back()">← Volver</a>
</body>
</html>
