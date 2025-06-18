<%-- 
    Document   : mostrar_repuestos
    Created on : 17 jun 2025, 22:00:54
    Author     : luiss
--%>

<%@page import="com.mycompany.proyecto2_progra2.domain.Repuesto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Mostrar Repuestos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f9;
            padding: 20px;
        }
        
        header {
            background-color: #2c3e50;
            color: white;
            padding: 20px;
            text-align: center;
        }

        header img {
            width: 50px;
            vertical-align: middle;
            margin-right: 10px;
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
    <header>
        <img src="https://i.pinimg.com/736x/0f/24/36/0f243658b7ad1e72dfaef6b7a6b541c2.jpg" alt="Icono Repuesto">
        <h1>Lista de Repuestos</h1>
    </header>
    
    <h1>Lista de Repuestos</h1>

    <% ArrayList<Repuesto> clientes = (ArrayList<Repuesto>) request.getAttribute("repuesto"); %>

    <table>
        <thead>
            <tr>
                <th>Identificación</th>
                <th>Nombre</th>
                <th>Cantidad (Stock)</th>
                <th>Precio</th> 
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <% for (Repuesto repuesto : clientes) { %>
            <tr>
                <td><%= repuesto.getId() %></td>
                <td><%= repuesto.getNombre() %></td>
                <td><%= repuesto.getCantidad() %></td>
                <td><%= repuesto.getPrecio() %></td>    
                <td>
                    <form action="modificarCliente" method="GET" style="margin:0;">
                        <input type="hidden" name="id" value="<%= repuesto.getId() %>">
                        <input type="submit" class="btn-modificar" value="Modificar">
                    </form>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
