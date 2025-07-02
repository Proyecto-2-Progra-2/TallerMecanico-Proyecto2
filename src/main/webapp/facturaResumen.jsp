<%-- 
    Document   : facturaResumen
    Created on : 2 jul 2025, 11:07:01
    Author     : jimen
--%>

<%@page import="com.mycompany.proyecto2_progra2.domain.Repuesto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    ArrayList<Repuesto> repuestosAgregados = (ArrayList<Repuesto>) sesion.getAttribute("repuestosAgregados");
    if (repuestosAgregados == null) {
        repuestosAgregados = new ArrayList<>();
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Resumen de Repuestos</title>
    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f6f9;
            color: #333;
        }

        header {
            background-color: #2c3e50;
            color: white;
            padding: 20px;
            text-align: center;
            border-bottom: 4px solid #3498db;
        }

        h1 {
            display: inline-block;
            font-size: 2em;
            margin: 0;
            font-weight: 700;
            letter-spacing: 1px;
        }

        main {
            padding: 30px;
            max-width: 900px;
            margin: auto;
            background-color: white;
            box-shadow: 0 4px 20px rgba(0,0,0,0.1);
            border-radius: 12px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            border-radius: 10px;
            overflow: hidden;
            margin-bottom: 25px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.05);
        }

        th, td {
            padding: 14px 16px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #3498db;
            color: white;
            font-weight: 600;
            text-transform: uppercase;
            letter-spacing: 0.05em;
        }

        tr:hover {
            background-color: #f0f8ff;
        }

        .total {
            text-align: right;
            font-weight: bold;
            font-size: 1.3em;
            color: #27ae60;
            margin-top: 20px;
        }

        .volver-btn {
            display: inline-block;
            background-color: #3498db;
            color: white;
            padding: 12px 24px;
            border: none;
            border-radius: 8px;
            font-size: 1em;
            font-weight: 600;
            text-decoration: none;
            transition: background-color 0.3s ease;
            margin-top: 20px;
        }

        .volver-btn:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
<header>
    <h1>Resumen de Repuestos Registrados</h1>
</header>
<main>
<%
    if (repuestosAgregados.isEmpty()) {
%>
    <p><em>No hay repuestos registrados en esta sesión.</em></p>
<%
    } else {
        double totalFactura = 0;
%>
    <table>
        <thead>
            <tr>
                <th>Identificación</th>
                <th>Nombre</th>
                <th>Cantidad</th>
                <th>Precio (₡)</th>
                <th>Subtotal (₡)</th>
            </tr>
        </thead>
        <tbody>
        <%
            for (Repuesto r : repuestosAgregados) {
                double subtotal = r.getCantidad() * r.getPrecio();
                totalFactura += subtotal;
        %>
            <tr>
                <td><%= r.getId() %></td>
                <td><%= r.getNombre() %></td>
                <td><%= r.getCantidad() %></td>
                <td>₡ <%= String.format("%.2f", r.getPrecio()) %></td>
                <td>₡ <%= String.format("%.2f", subtotal) %></td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
     
    <div class="total">Total: ₡ <%= String.format("%.2f", totalFactura) %></div>
   <a href="agregar_repuestos.jsp" class="volver-btn">← Volver</a>
  
   

<%
    }
%>
</main>
</body>
</html>
