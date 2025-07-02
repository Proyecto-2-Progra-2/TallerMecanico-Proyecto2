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
    <meta charset="UTF-8" />
    <title>Agregar Repuestos - Factura</title>
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

        .action-btn {
            margin: 2px;
            padding: 6px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            color: white;
            font-size: 0.9em;
            font-weight: 600;
            transition: background-color 0.3s ease;
        }

        .agregar-btn {
            background-color: #3498db;
        }

        .agregar-btn:hover {
            background-color: #2980b9;
        }

        .agregado-btn {
            background-color: #92a396;
        }

        .modificar-btn {
            background-color: #f39c12;
        }

        .modificar-btn:hover {
            background-color: #e67e22;
        }

        .quitar-btn {
            background-color: transparent;
            border: none;
            color: #e74c3c;
            font-weight: bold;
            cursor: pointer;
            font-size: 1.3em;
            line-height: 1;
            padding: 0 8px;
            transition: color 0.3s ease;
        }

        .quitar-btn:hover {
            color: #c0392b;
        }

        .btn-registrar-todos {
            position: fixed;
            bottom: 30px;
            right: 30px;
            background-color: #27ae60;
            color: white;
            padding: 14px 26px;
            border: none;
            border-radius: 10px;
            font-size: 1.1em;
            font-weight: bold;
            cursor: pointer;
            box-shadow: 0 6px 12px rgba(0,0,0,0.2);
            transition: background-color 0.3s ease;
            z-index: 1000;
        }

        .btn-registrar-todos:hover {
            background-color: #219150;
        }

        input[type=number] {
            width: 60px;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 1em;
        }

        /* Estilo factura: totales */
        .subtotal, .total {
            text-align: right;
            font-weight: 700;
            padding-right: 20px;
            font-size: 1em;
            color: #555;
        }

        .total {
            font-size: 1.3em;
            color: #27ae60;
            margin-top: 10px;
        }

        /* Título subtítulos */
        h3 {
            border-bottom: 2px solid #3498db;
            padding-bottom: 6px;
            margin-bottom: 15px;
            color: #2c3e50;
            letter-spacing: 1px;
        }
    </style>
</head>
<body>
<header>
    <h1>Factura de Repuestos</h1>
</header>
<main>
    <%
        ArrayList<Repuesto> repuestos = (ArrayList<Repuesto>) request.getAttribute("repuestos");
        if (repuestos != null && !repuestos.isEmpty()) {
    %>
    <h3>Repuestos Disponibles</h3>
    <table>
        <thead>
            <tr>
                <th>Identificación</th>
                <th>Nombre</th>
                <th>Cantidad Disponible</th>
                <th>Precio (₡)</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
        <% for (Repuesto repuesto : repuestos) { %>
            <tr>
                <td><%= repuesto.getId() %></td>
                <td><%= repuesto.getNombre() %></td>
                <td><%= repuesto.getCantidad() %></td>
                <td>₡ <%= String.format("%.2f", repuesto.getPrecio()) %></td>
                <td>
                    <% if (repuesto.getCantidad() > 0) { %>
                    <form action="AgregarRepuestoSeleccionadoServlet" method="GET" style="margin:0; display:flex; align-items:center; gap:8px;">
                        <input type="hidden" name="id" value="<%= repuesto.getId() %>">
                        <input type="number" name="cantidad" min="1" max="<%= repuesto.getCantidad() %>" value="1" required>
                        <button type="submit" class="action-btn modificar-btn">Agregar</button>
                    </form>
                    <% } else { %>
                    <button type="button" class="action-btn agregado-btn" disabled>Sin Stock</button>
                    <% } %>
                </td>
            </tr>
        <% } %>
        </tbody>
    </table>
    <% } else { %>
        <p><em>No hay repuestos disponibles.</em></p>
    <% } %>

    <% if (!repuestosAgregados.isEmpty()) { %>
    <h3>Repuestos Agregados</h3>
    <table>
        <thead>
            <tr>
                <th>Identificación</th>
                <th>Nombre</th>
                <th>Cantidad Seleccionada</th>
                <th>Precio (₡)</th>
                <th>Subtotal (₡)</th>
                <th>Quitar</th>
            </tr>
        </thead>
        <tbody>
        <%
            double totalFactura = 0;
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
                <td>
                   <form action="quitarRepuesto" method="POST" style="margin:0;">
                        <input type="hidden" name="id" value="<%= r.getId() %>">
                        <button type="submit" class="quitar-btn" title="Quitar repuesto" onclick="return confirm('¿Está seguro de quitar este repuesto?');">×</button>
                    </form>
                </td>
            </tr>
        <% } %>
        </tbody>
    </table>
    <div class="total">Total: ₡ <%= String.format("%.2f", totalFactura) %></div>

    <form action="registrarOrdenTrabajo" method="POST">
        <% for (Repuesto r : repuestosAgregados) { %>
            <input type="hidden" name="repuestosAgregados" value="<%= r.getId() %>">
            <input type="hidden" name="cantidades" value="<%= r.getCantidad() %>">
        <% } %>
        <button type="submit" class="btn-registrar-todos">Registrar todos los repuestos seleccionados</button>
    </form>
    <% } else { %>
        <p><em>No hay repuestos seleccionados.</em></p>
    <% } %>
</main>
</body>
</html>
