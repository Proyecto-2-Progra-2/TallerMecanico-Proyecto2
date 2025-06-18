<%@page import="com.mycompany.proyecto2_progra2.domain.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Mostrar Clientes</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f9;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #2c3e50;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 30px;
            background-color: white;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: center;
        }

        th {
            background-color: #3498db;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .btn-modificar {
            background-color: #f39c12;
            color: white;
            border: none;
            padding: 8px 14px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .btn-modificar:hover {
            background-color: #e67e22;
        }
    </style>
</head>
<body>
    <h1>Lista de Clientes</h1>

    <% ArrayList<Cliente> clientes = (ArrayList<Cliente>) request.getAttribute("clientes"); %>

    <table>
        <thead>
            <tr>
                <th>Identificación</th>
                <th>Nombre</th>
                <th>Primer Apellido</th>
                <th>Segundo Apellido</th>
                <th>Teléfono</th>
                <th>Dirección</th>
                <th>Email</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <% for (Cliente cliente : clientes) { %>
            <tr>
                <td><%= cliente.getId() %></td>
                <td><%= cliente.getNombre() %></td>
                <td><%= cliente.getPrimerApellido() %></td>
                <td><%= cliente.getSegundoApellido() %></td>
                <td><%= cliente.getTelefono() %></td>
                <td><%= cliente.getDireccion() %></td>
                <td><%= cliente.getEmail() %></td>
                <td>
                    <form action="modificarCliente" method="GET" style="margin:0;">
                        <input type="hidden" name="id" value="<%= cliente.getId() %>">
                        <input type="submit" class="btn-modificar" value="Modificar">
                    </form>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
