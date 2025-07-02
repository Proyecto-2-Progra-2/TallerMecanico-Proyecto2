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
            <div class="mensaje">🚗 orden de trabajo eliminada correctamente.</div>
            <% } %>

            <% ArrayList<OrdenTrabajo> ordenes = (ArrayList<OrdenTrabajo>) request.getAttribute("ordenes"); %>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Descripcion</th>
                        <th>Fecha de ingreso</th>
                        <th>Estado</th>
                        <th>Detalle de recepcion del vehiculo</th>
                        <th>Fecha estimada de devolucion</th>
                        <th>Precio</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% if (ordenes != null) {
                            for (OrdenTrabajo orden : ordenes) {%>
                    <tr>
                        <td data-label="Placa"><%= orden.getId()%></td>
                        <td data-label="Color"><%= orden.getDescripcion()%></td>
                        <td data-label="Marca"><%= orden.getFechaIngreso()%></td>
                        <td data-label="Estilo"><%= orden.getEstado()%></td>
                        <td data-label="VIN"><%= orden.getDetalleRecepcionVehiculo()%></td>
                        <td data-label="Cilindraje"><%= orden.getFechaDevolucion()%></td>
                        <td data-label="Dueño"><%= orden.getDetalleOrden().getId() %></td>
                        <td>
                            <form action="${pageContext.request.contextPath}/modificarOrdenTrabajo" method="GET">
                                <input type="hidden" name="id" value="<%= orden.getId()%>">
                                <button type="submit" class="action-btn modificar-btn">Modificar</button>
                            </form>
                            <form action="${pageContext.request.contextPath}/mostrarVehiculo" method="GET">
                                <input type="hidden" name="vehiculo" value="<%= orden.getVehiculo().getPlaca()%>">
                                <button type="submit" class="action-btn cliente-btn">Ver Vehiculo</button>
                            </form>
                            <form action="${pageContext.request.contextPath}/mostrarDetalle" method="GET">
                                <input type="hidden" name="detalle" value="<%= orden.getDetalleOrden().getId() %>">
                                <button type="submit" class="action-btn eliminar-btn">Ver Detalle de la Orden</button>
                            </form>
                            <form action="${pageContext.request.contextPath}/eliminarOrdenTrabajo" method="POST" onsubmit="return confirm('¿Está seguro que desea eliminar esta orden de trabajo?');">
                                <input type="hidden" name="id" value="<%= orden.getId()%>">
                                <button type="submit" class="action-btn eliminar-btn">Eliminar</button>
                            </form>
                        </td>
                    </tr>
                    <% }
                    } else { %>
                    <tr><td colspan="10" style="text-align:center;">No hay ordenes registradas.</td></tr>
                    <% }%>
                </tbody>
            </table>
        </main>
    </body>
</html>
