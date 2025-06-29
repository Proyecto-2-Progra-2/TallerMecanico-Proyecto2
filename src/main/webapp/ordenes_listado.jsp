<%@page import="com.mycompany.proyecto2_progra2.domain.OrdenTrabajo"%>
<%@page import="com.mycompany.proyecto2_progra2.domain.Repuesto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Listado de Órdenes de Trabajo</title>
    <style>
        /* Reset básico */
        * {
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f9fafb;
            color: #333;
            margin: 40px auto;
            max-width: 1100px;
            padding: 0 20px;
        }

        h1 {
            color: #2c3e50;
            text-align: center;
            margin-bottom: 40px;
            font-weight: 700;
            letter-spacing: 1px;
        }

        table {
            width: 100%;
            border-collapse: separate;
            border-spacing: 0 10px;
            margin-bottom: 50px;
        }

        thead tr {
            background-color: #3498db;
            color: white;
            font-weight: 600;
            text-align: left;
            border-radius: 10px;
        }

        thead tr th {
            padding: 15px 20px;
            /* Para que los bordes redondeados no se corten */
            position: relative;
            z-index: 1;
        }

        tbody tr {
            background-color: white;
            box-shadow: 0 2px 5px rgb(0 0 0 / 0.1);
            transition: background-color 0.3s ease;
            cursor: pointer;
        }

        tbody tr:hover {
            background-color: #ecf6fc;
        }

        tbody tr td {
            padding: 15px 20px;
            vertical-align: middle;
            border-left: 4px solid transparent;
            transition: border-left-color 0.3s ease;
        }

        tbody tr:hover td {
            border-left-color: #3498db;
        }

        /* Estilo para la tabla de repuestos */
        .repuestos-table {
            width: 95%;
            margin: 15px auto 35px auto;
            border-collapse: collapse;
            box-shadow: 0 2px 8px rgb(0 0 0 / 0.1);
            border-radius: 10px;
            overflow: hidden;
            font-size: 0.95rem;
        }

        .repuestos-table thead {
            background-color: #2980b9;
            color: white;
        }

        .repuestos-table th, .repuestos-table td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        .repuestos-table tbody tr:hover {
            background-color: #d6eaf8;
        }

        .no-orders {
            text-align: center;
            font-size: 1.25rem;
            color: #777;
            margin-top: 50px;
        }

        /* Precio con formato especial */
        .precio {
            font-weight: 600;
            color: #27ae60;
        }
    </style>
</head>
<body>
    <h1>Listado de Órdenes de Trabajo</h1>

    <%
        ArrayList<OrdenTrabajo> ordenesList = (ArrayList<OrdenTrabajo>) request.getAttribute("ordenesList");

        if (ordenesList != null && !ordenesList.isEmpty()) {
    %>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Fecha</th>
                <th>Cliente</th>
                <th>Vehículo</th>
                <th>Estado</th>
            </tr>
        </thead>
        <tbody>
        <%
            for (OrdenTrabajo orden : ordenesList) {
        %>
            <tr>
                <td><%= orden.getId() %></td>
                <td><%= orden.getFechaIngreso() %></td>
                <td><%= (orden.getVehiculo() != null && orden.getVehiculo().getDuenno() != null) 
                            ? orden.getVehiculo().getDuenno().getNombre() 
                            : "N/A" %></td>
                <td><%= orden.getVehiculo() != null ? orden.getVehiculo().getPlaca() : "N/A" %></td>
                <td><%= orden.getEstado() %></td>
            </tr>
            <tr>
                <td colspan="5">
                    <strong>Repuestos y costos:</strong>
                    <table class="repuestos-table">
                        <thead>
                            <tr>
                                <th>Nombre Repuesto</th>
                                <th>Cantidad</th>
                                <th>Precio Unitario</th>
                                <th>Subtotal</th>
                            </tr>
                        </thead>
                        <tbody>
                        <%
                            if (orden.getDetalleOrden() != null && orden.getDetalleOrden().getRepuestos() != null && !orden.getDetalleOrden().getRepuestos().isEmpty()) {
                                for (Repuesto repuesto : orden.getDetalleOrden().getRepuestos()) {
                                    double subtotal = repuesto.getCantidad() * repuesto.getPrecio();
                        %>
                            <tr>
                                <td><%= repuesto.getNombre() %></td>
                                <td><%= repuesto.getCantidad() %></td>
                                <td class="precio"><%= String.format("₡%,.2f", repuesto.getPrecio()) %></td>
                                <td class="precio"><%= String.format("₡%,.2f", subtotal) %></td>
                            </tr>
                        <%
                                }
                            } else {
                        %>
                            <tr>
                                <td colspan="4" style="text-align:center; font-style: italic; color:#999;">
                                    No hay repuestos asociados a esta orden.
                                </td>
                            </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <%
        } else {
    %>
        <p class="no-orders">No hay órdenes de trabajo registradas.</p>
    <%
        }
    %>

</body>
</html>
