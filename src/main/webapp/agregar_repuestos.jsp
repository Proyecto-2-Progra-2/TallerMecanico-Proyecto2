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
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Repuestos</title>
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
        }

        h1 {
            display: inline-block;
            font-size: 2em;
            margin: 0;
        }

        main {
            padding: 30px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            border-radius: 10px;
            overflow: hidden;
        }

        th, td {
            padding: 14px 16px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #3498db;
            color: white;
        }

        tr:hover {
            background-color: #f0f8ff;
        }

        .action-btn {
            margin: 2px;
            padding: 6px 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            color: white;
            font-size: 0.9em;
        }

        .agregar-btn {
            background-color: #3498db;
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

        .enviar {
            margin-top: 20px;
            display: flex;
            justify-content: center;
        }

        .quitar-btn {
            background-color: transparent;
            border: none;
            color: red;
            font-weight: bold;
            cursor: pointer;
            font-size: 1.3em;
            line-height: 1;
            padding: 0 8px;
            transition: color 0.3s ease;
        }

        .quitar-btn:hover {
            color: darkred;
        }
    </style>
</head>
<body>
<header>
    <h1>Agregar Repuestos</h1>
</header>
<main>
    <%
        ArrayList<Repuesto> repuestos = (ArrayList<Repuesto>) request.getAttribute("repuestos");
        if (repuestos != null) {
    %>
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
        <% for (Repuesto repuesto : repuestos) {
            boolean yaAgregado = repuestosAgregados.stream().anyMatch(r -> r.getId().equalsIgnoreCase(repuesto.getId()));
        %>
            <tr>
                <td><%= repuesto.getId() %></td>
                <td><%= repuesto.getNombre() %></td>
                <td><%= repuesto.getCantidad() %></td>
                <td>₡<%= String.format("%.2f", repuesto.getPrecio()) %></td>
                <td>
                    <% if (yaAgregado) { %>
                        <button type="button" class="action-btn agregado-btn" disabled>Repuesto Agregado</button>
                    <% } else { %>
                        <form action="ingresaListaRepuestos" method="GET" style="margin:0;">
                            <input type="hidden" name="id" value="<%= repuesto.getId() %>">
                            <button type="submit" class="action-btn modificar-btn">Agregar Repuesto</button>
                        </form>
                    <% } %>
                </td>
            </tr>
        <% } %>
        </tbody>
    </table>
    <% } %>

   <% if (!repuestosAgregados.isEmpty()) { %>
    <h3>Repuestos agregados:</h3>
    <table>
        <thead>
            <tr>
                <th>Identificación</th>
                <th>Nombre</th>
                <th>Cantidad</th>
                <th>Precio (₡)</th>
                <th>Quitar</th> 
            </tr>
        </thead>
        <tbody>
        <% for (Repuesto r : repuestosAgregados) { %>
            <tr>
                <td><%= r.getId() %></td>
                <td><%= r.getNombre() %></td>
                <td><%= r.getCantidad() %></td>
                <td>₡<%= String.format("%.2f", r.getPrecio()) %></td>
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
   <% } %>

    <div class="enviar">
        <form action="registrarOrdenTrabajo" method="POST">
            <% for (Repuesto r : repuestosAgregados) { %>
                <input type="hidden" name="repuestosAgregados" value="<%= r.getId() %>">
            <% } %>
            <button type="submit" class="action-btn agregar-btn">Volver a Orden de Trabajo</button>
        </form>
    </div>
</main>

<%-- BOTÓN FLOTANTE --%>
<% if (!repuestosAgregados.isEmpty()) { %>
    <div style="
        position: fixed;
        bottom: 30px;
        right: 30px;
        z-index: 1000;
    ">
        <form action="registrarRepuestosSeleccionados" method="POST">
            <% for (Repuesto r : repuestosAgregados) { %>
                <input type="hidden" name="repuestosAgregados" value="<%= r.getId() %>">
            <% } %>
            <button type="submit" style="
                background-color: #27ae60;
                color: white;
                padding: 14px 22px;
                border: none;
                border-radius: 10px;
                font-size: 1em;
                font-weight: bold;
                cursor: pointer;
                box-shadow: 0 4px 10px rgba(0,0,0,0.2);
                transition: background-color 0.3s ease;
            ">
                Registrar todos los repuestos seleccionados
            </button>
        </form>
    </div>
<% } %>

</body>
</html>
