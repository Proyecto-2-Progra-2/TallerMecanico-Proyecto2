<%--
    Document   : mostrar_ordenes_trabajo
    Created on : 27 jun 2025, 18:37:33
    Author     : jeffr
--%>

<%@page import="com.mycompany.proyecto2_progra2.domain.OrdenTrabajo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Ordenes de Trabajo</title>
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

            header img {
                width: 50px;
                vertical-align: middle;
                margin-right: 10px;
            }

            h1 {
                display: inline-block;
                font-size: 2em;
                margin: 0;
            }

            main {
                padding: 30px;
            }

            .mensaje {
                background-color: #d4edda;
                color: #155724;
                padding: 10px 15px;
                border-radius: 5px;
                margin-bottom: 20px;
                border: 1px solid #c3e6cb;
                font-weight: bold;
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

            .modificar-btn {
                background-color: #f39c12;
            }
            .modificar-btn:hover {
                background-color: #e67e22;
            }

            .cliente-btn {
                background-color: #2980b9;
            }
            .cliente-btn:hover {
                background-color: #2471a3;
            }

            /* Nuevo estilo para el botón de ver detalle */
            .detalle-btn {
                background-color: #17a2b8; /* Un color más de "información" o "azul claro" */
            }
            .detalle-btn:hover {
                background-color: #138496;
            }

            .eliminar-btn {
                background-color: #e74c3c;
            }
            .eliminar-btn:hover {
                background-color: #c0392b;
            }

            form {
                display: inline;
            }

            @media screen and (max-width: 768px) {
                table, thead, tbody, th, td, tr {
                    display: block;
                }

                th {
                    text-align: right;
                    padding-right: 50%;
                }

                td {
                    text-align: right;
                    padding-left: 50%;
                    position: relative;
                }

                td::before {
                    content: attr(data-label);
                    position: absolute;
                    left: 16px;
                    font-weight: bold;
                    color: #555;
                }
            }
        </style>
    </head>
    <body>
        <header>
            <img src="https://cdn-icons-png.flaticon.com/512/1995/1995574.png" alt="Ícono Vehículo">
            <h1>Mostrar Ordenes de Trabajo</h1>
        </header>
        <main>
            <%
                String mensaje = request.getParameter("mensaje");
                if ("eliminado".equals(mensaje)) {
            %>
            <div class="mensaje">🚗 Orden de trabajo eliminada correctamente.</div>
            <% } %>

            <% ArrayList<OrdenTrabajo> ordenes = (ArrayList<OrdenTrabajo>) request.getAttribute("ordenes"); %>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Descripción</th>
                        <th>Fecha de Ingreso</th>
                        <th>Estado</th>
                        <th>Detalle de Recepción del Vehículo</th>
                        <th>Fecha Estimada de Devolución</th>
                        <th>Precio</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% if (ordenes != null) {
                            for (OrdenTrabajo orden : ordenes) {%>
                    <tr>
                        <td data-label="ID"><%= orden.getId()%></td>
                        <td data-label="Descripción"><%= orden.getDescripcion()%></td>
                        <td data-label="Fecha de Ingreso"><%= orden.getFechaIngreso()%></td>
                        <td data-label="Estado"><%= orden.getEstado()%></td>
                        <td data-label="Detalle de Recepción"><%= orden.getDetalleRecepcionVehiculo()%></td>
                        <td data-label="Fecha de Devolución"><%= orden.getFechaDevolucion()%></td>
                        <td data-label="Precio">₡<%= String.format("%,.2f", orden.getPrecio())%></td>
                        <td>
                            <form action="${pageContext.request.contextPath}/modificarOrdenTrabajo" method="GET">
                                <input type="hidden" name="id" value="<%= orden.getId()%>">
                                <button type="submit" class="action-btn modificar-btn">Modificar</button>
                            </form>
                            <form action="${pageContext.request.contextPath}/mostrarVehiculo" method="GET">
                                <input type="hidden" name="vehiculo" value="<%= orden.getVehiculo().getPlaca()%>">
                                <button type="submit" class="action-btn cliente-btn">Ver Vehículo</button>
                            </form>
                            <form action="${pageContext.request.contextPath}/mostrarDetalleOrden" method="GET">
                                <input type="hidden" name="idDetalleOrden" value="<%= orden.getDetalleOrden().getId()%>"> <%-- Cambié el nombre del parámetro a 'idDetalleOrden' --%>
                                <button type="submit" class="action-btn detalle-btn">Ver Detalle</button>
                            </form>
                            <form action="${pageContext.request.contextPath}/eliminarOrdenTrabajo" method="POST" onsubmit="return confirm('¿Está seguro que desea eliminar esta orden de trabajo?');">
                                <input type="hidden" name="id" value="<%= orden.getId()%>">
                                <button type="submit" class="action-btn eliminar-btn">Eliminar</button>
                            </form>
                        </td>
                    </tr>
                    <% }
                    } else { %>
                    <tr><td colspan="8" style="text-align:center;">No hay órdenes registradas.</td></tr>
                    <% }%>
                </tbody>
            </table>
        </main>
    </body>
</html>