<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="com.mycompany.proyecto2_progra2.domain.Repuesto"%>
<%@page import="com.mycompany.proyecto2_progra2.domain.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    ArrayList<Repuesto> repuestosAgregados = (ArrayList<Repuesto>) sesion.getAttribute("repuestosAgregados");
    if (repuestosAgregados == null) {
        repuestosAgregados = new ArrayList<>();
    }

    Cliente cliente = (Cliente) request.getAttribute("cliente");
    String idOrden = (String) request.getAttribute("idOrden");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Factura de Repuestos</title>
    <style>
      
        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #ffffff;
            color: #333;
        }

        .factura-container {
            max-width: 800px;
            margin: 30px auto;
            padding: 40px;
            border: 1px solid #ccc;
            background-color: #fff;
            box-shadow: 0 4px 20px rgba(0,0,0,0.1);
        }

        .factura-header {
            text-align: center;
            border-bottom: 2px solid #3498db;
            padding-bottom: 15px;
            margin-bottom: 30px;
        }

        .factura-header h1 {
            margin: 0;
            color: #2c3e50;
            font-size: 2em;
        }

        .empresa-info {
            text-align: center;
            font-size: 0.95em;
            color: #666;
        }

        .factura-datos {
            margin-bottom: 30px;
            font-size: 1em;
            color: #444;
        }

        .factura-datos p {
            margin: 4px 0;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 25px;
        }

        th, td {
            padding: 12px 14px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #3498db;
            color: white;
            text-transform: uppercase;
            font-size: 0.9em;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .totales {
            text-align: right;
            font-size: 1.2em;
            font-weight: bold;
            margin-top: 10px;
            color: #27ae60;
        }

        .volver-btn {
            display: inline-block;
            background-color: #3498db;
            color: white;
            padding: 12px 24px;
            border-radius: 6px;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s ease;
            margin-top: 20px;
        }

        .volver-btn:hover {
            background-color: #2980b9;
        }

        .nota {
            margin-top: 40px;
            font-size: 0.85em;
            color: #888;
            text-align: center;
        }
     </style>
</head>
<body>
<div class="factura-container">
    <div class="factura-header">
        <h1>Factura de Repuestos</h1>
        <div class="empresa-info">
            Cédula Jurídica: 3-101-456789<br>
            Tel: 1234-5678 | Email: tallerMecanico@gmail.com
        </div>
    </div>

    <%
        if (repuestosAgregados.isEmpty()) {
    %>
        <p><em>No hay repuestos registrados en esta sesión.</em></p>
    <%
        } else {
            double totalFactura = 0;
    %>

    <div class="factura-datos">
        <p><strong>Fecha:</strong> <%= java.time.LocalDate.now() %></p>
        <%
            if (cliente != null) {
        %>
            <p><strong>Cliente ID:</strong> <%= cliente.getId() %></p>
            <p><strong>Nombre:</strong> <%= cliente.getNombre() + " " + cliente.getPrimerApellido() + " " + cliente.getSegundoApellido() %></p>
            <p><strong>Teléfono:</strong> <%= cliente.getTelefono() %></p>
            <p><strong>Email:</strong> <%= cliente.getEmail() %></p>
            <p><strong>Dirección:</strong> <%= cliente.getDireccion() %></p>
        <%
            } else {
        %>
            <p><strong>Cliente:</strong> Consumidor Final</p>
        <%
            }
        %>
        <p><strong>Orden de Trabajo:</strong> <%= (idOrden != null && !idOrden.isEmpty()) ? idOrden : "No especificada" %></p>
    </div>

    <table>
        <thead>
            <tr>
                <th>Código</th>
                <th>Descripción</th>
                <th>Cantidad</th>
                <th>Precio Unitario (₡)</th>
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

    <div class="totales">
        Total Factura: ₡ <%= String.format("%.2f", totalFactura) %>
    </div>

    <a href="agregar_repuestos.jsp" class="volver-btn">← Volver a Agregar Repuestos</a>

    <div class="nota">
        Factura generada para los repuestos añadidos.
    </div>

    <%
        }
    %>
</div>
</body>
</html>