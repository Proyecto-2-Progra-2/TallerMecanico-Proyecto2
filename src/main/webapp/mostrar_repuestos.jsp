<%@page import="com.mycompany.proyecto2_progra2.domain.Repuesto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Inventario de Repuestos</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">
    <style>
        body {
            margin: 0;
            font-family: 'Roboto', 'Arial', sans-serif;
            background-color: #eef2f7;
            padding: 0;
            color: #333;
            line-height: 1.6;
        }
        
        header {
            background-color: #2c3e50;
            color: white;
            padding: 25px 0;
            text-align: center;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            margin-bottom: 30px;
        }

        header img {
            width: 60px;
            vertical-align: middle;
            margin-right: 15px;
            filter: invert(1);
        }

        h1 {
            display: inline-block;
            font-size: 2.2em;
            margin: 0;
            font-weight: 700;
        }

        .page-title {
            text-align: center;
            color: #2c3e50;
            font-size: 2em;
            margin-top: 30px;
            margin-bottom: 30px;
            font-weight: 700;
        }

        .container {
            max-width: 1000px;
            margin: 0 auto;
            padding: 0 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 0;
            background-color: white;
            box-shadow: 0 8px 25px rgba(0,0,0,0.1);
            border-radius: 12px;
            overflow: hidden;
        }

        th, td {
            border: 1px solid #e0e0e0;
            padding: 15px;
            text-align: left;
        }

        th {
            background-color: #3498db;
            color: white;
            font-weight: 600;
            text-transform: uppercase;
            font-size: 0.95em;
        }

        tr:nth-child(even) {
            background-color: #f8fafd;
        }

        tr:hover {
            background-color: #eef7ff;
            transition: background-color 0.3s ease;
        }

        .btn-modificar {
            background-color: #f39c12;
            color: white;
            border: none;
            padding: 10px 18px;
            border-radius: 6px;
            cursor: pointer;
            font-size: 0.9em;
            font-weight: 600;
            transition: background-color 0.3s ease, transform 0.2s ease;
            text-decoration: none;
            display: inline-block;
        }

        .btn-modificar:hover {
            background-color: #e67e22;
            transform: translateY(-1px);
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        
        .btn-eliminar {
            background-color: #f39c12;
            color: white;
            border: none;
            padding: 8px 14px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .btn-eliminar {
            background-color: #e67e22;
        }
    </style>
</head>
<body>
    <header>
        <img src="https://cdn-icons-png.flaticon.com/512/3233/3233481.png" alt="Icono Repuesto">
        <h1>Gestión de Repuestos</h1>
    </header>
    
    <h2 class="page-title">Inventario Actual de Repuestos</h2>

<<<<<<< HEAD
    <div class="container">
        <% ArrayList<Repuesto> repuestosList = (ArrayList<Repuesto>) request.getAttribute("repuesto"); %>

        <% if (repuestosList != null && !repuestosList.isEmpty()) { %>
            <table>
                <thead>
                    <tr>
                        <th>Identificación</th>
                        <th>Nombre</th>
                        <th>Cantidad (Stock)</th>
                        <th>Precio (₡)</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Repuesto repuesto : repuestosList) { %>
                    <tr>
                        <td><%= repuesto.getId() %></td>
                        <td><%= repuesto.getNombre() %></td>
                        <td><%= repuesto.getCantidad() %></td>
                        <td>₡<%= String.format("%.2f", repuesto.getPrecio()) %></td>
                        <td>
                            <form action="modificarRepuesto" method="GET" style="margin:0; display:inline-block;">
                                <input type="hidden" name="id" value="<%= repuesto.getId() %>">
                                <button type="submit" class="btn-modificar">Modificar</button>
                            </form>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        <% } else { %>
            <p style="text-align: center; font-size: 1.2em; color: #777; margin-top: 50px;">
                No hay repuestos registrados en el inventario.
            </p>
        <% } %>
    </div>

    <% ArrayList<Repuesto> repuestos = (ArrayList<Repuesto>) request.getAttribute("repuestos"); %>

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
            <% for (Repuesto repuesto : repuestos) { %>
            <tr>
                <td><%= repuesto.getId() %></td>
                <td><%= repuesto.getNombre() %></td>
                <td><%= repuesto.getCantidad() %></td>
                <td><%= repuesto.getPrecio() %></td>    
                <td>                 
                    <form action="${pageContext.request.contextPath}/modificarRepuesto" method="GET">
                        <input type="hidden" name="id" value="<%= repuesto.getId()%>">
                        <input type="submit" class="btn-modificar" value="Modificar">
                    </form>    
                    <form action="${pageContext.request.contextPath}/eliminarRepuesto" method="POST" style="display:inline-block; margin:0;" onsubmit="return confirm('¿Está seguro de que desea eliminar este repuesto?');">
                        <input type="hidden" name="id" value="<%= repuesto.getId() %>">
                        <input type="submit" class="btn-eliminar" value="Eliminar">
                    </form>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>

</body>
</html>