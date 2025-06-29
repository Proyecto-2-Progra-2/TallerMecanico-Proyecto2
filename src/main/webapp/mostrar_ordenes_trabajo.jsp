<%@page import="com.mycompany.proyecto2_progra2.domain.OrdenTrabajo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Listado de Órdenes de Trabajo</title>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">
        <style>
            body {
                margin: 0;
                font-family: 'Roboto', 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background-color: #eef2f7;
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
                max-width: 1200px;
                margin: 0 auto;
                padding: 0 20px;
            }

            .mensaje {
                background-color: #d4edda;
                color: #155724;
                padding: 12px 20px;
                border-radius: 8px;
                margin-bottom: 25px;
                border: 1px solid #c3e6cb;
                font-weight: 500;
                text-align: center;
                box-shadow: 0 2px 4px rgba(0,0,0,0.05);
            }

            table {
                width: 100%;
                border-collapse: collapse;
                background-color: white;
                box-shadow: 0 8px 25px rgba(0,0,0,0.1);
                border-radius: 12px;
                overflow: hidden;
            }

            th, td {
                padding: 15px;
                text-align: left;
                border-bottom: 1px solid #e0e0e0;
            }

            th {
                background-color: #3498db;
                color: white;
                font-weight: 600;
                text-transform: uppercase;
                font-size: 0.95em;
            }
            
            tbody tr:last-child td {
                border-bottom: none;
            }

            tr:hover {
                background-color: #f0f8ff;
                transition: background-color 0.3s ease;
            }

            .action-btn {
                margin: 4px;
                padding: 8px 14px;
                border: none;
                border-radius: 6px;
                cursor: pointer;
                color: white;
                font-size: 0.9em;
                font-weight: 600;
                transition: background-color 0.3s ease, transform 0.2s ease;
                text-decoration: none;
                display: inline-block;
            }
            .action-btn:hover {
                transform: translateY(-1px);
                box-shadow: 0 2px 5px rgba(0,0,0,0.1);
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

            .detalle-btn {
                background-color: #17a2b8;
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
                display: inline-block;
                margin: 0;
            }

            .no-orders-message {
                text-align: center;
                font-size: 1.2em;
                color: #777;
                margin-top: 50px;
                padding: 20px;
                background-color: #fff;
                border-radius: 8px;
                box-shadow: 0 4px 12px rgba(0,0,0,0.05);
            }

            @media screen and (max-width: 992px) {
                th, td {
                    padding: 12px;
                }
                .action-btn {
                    padding: 7px 12px;
                    font-size: 0.85em;
                }
            }

            @media screen and (max-width: 768px) {
                table, thead, tbody, th, td, tr {
                    display: block;
                }

                thead tr {
                    position: absolute;
                    top: -9999px;
                    left: -9999px;
                }

                td {
                    border: none;
                    border-bottom: 1px solid #e0e0e0;
                    position: relative;
                    padding-left: 50%;
                    text-align: right;
                }
                
                td:last-child {
                    border-bottom: none;
                }

                td::before {
                    content: attr(data-label);
                    position: absolute;
                    left: 15px;
                    width: calc(50% - 30px);
                    white-space: nowrap;
                    font-weight: bold;
                    color: #2c3e50;
                    text-align: left;
                }
                
                .action-btn {
                    display: block;
                    width: calc(100% - 8px);
                    margin: 4px auto;
                }
            }
        </style>
    </head>
    <body>
        <header>
            <img src="https://cdn-icons-png.flaticon.com/512/2972/2972528.png" alt="Icono Orden de Trabajo">
            <h1>Gestión de Órdenes de Trabajo</h1>
        </header>

        <h2 class="page-title">Listado Actual de Órdenes</h2>

        <div class="container">
            <%
                String mensaje = request.getParameter("mensaje");
                if ("eliminado".equals(mensaje)) {
            %>
            <div class="mensaje">✅ Orden de trabajo eliminada correctamente.</div>
            <% } %>

            <% ArrayList<OrdenTrabajo> ordenes = (ArrayList<OrdenTrabajo>) request.getAttribute("ordenes"); %>

            <% if (ordenes != null && !ordenes.isEmpty()) { %>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Descripción</th>
                        <th>Fecha Ingreso</th>
                        <th>Estado</th>
                        <th>Detalle Recepción</th>
                        <th>Fecha Devolución</th>
                        <th>Precio Total</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (OrdenTrabajo orden : ordenes) {%>
                    <tr>
                        <td data-label="ID"><%= orden.getId()%></td>
                        <td data-label="Descripción"><%= orden.getDescripcion()%></td>
                        <td data-label="Fecha Ingreso"><%= orden.getFechaIngreso()%></td>
                        <td data-label="Estado"><%= orden.getEstado()%></td>
                        <td data-label="Detalle Recepción"><%= orden.getDetalleRecepcionVehiculo()%></td>
                        <td data-label="Fecha Devolución"><%= orden.getFechaDevolucion()%></td>
                        <td data-label="Precio Total">₡<%= String.format("%,.2f", orden.getPrecio())%></td>
                        <td data-label="Acciones">
                            <form action="${pageContext.request.contextPath}/modificarOrdenTrabajo" method="GET">
                                <input type="hidden" name="id" value="<%= orden.getId()%>">
                                <button type="submit" class="action-btn modificar-btn">Modificar</button>
                            </form>
                            <form action="${pageContext.request.contextPath}/mostrarVehiculo" method="GET">
                                <input type="hidden" name="vehiculoPlaca" value="<%= orden.getVehiculo().getPlaca()%>">
                                <button type="submit" class="action-btn cliente-btn">Ver Vehículo</button>
                            </form>
                            <form action="${pageContext.request.contextPath}/mostrarDetalleOrden" method="GET">
                                <input type="hidden" name="idDetalleOrden" value="<%= orden.getDetalleOrden().getId()%>">
                                <button type="submit" class="action-btn detalle-btn">Ver Detalle</button>
                            </form>
                            <form action="${pageContext.request.contextPath}/eliminarOrdenTrabajo" method="POST" onsubmit="return confirm('¿Está seguro que desea eliminar esta orden de trabajo?');">
                                <input type="hidden" name="id" value="<%= orden.getId()%>">
                                <button type="submit" class="action-btn eliminar-btn">Eliminar</button>
                            </form>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
            <% } else { %>
                <div class="no-orders-message">
                    <p>No hay órdenes de trabajo registradas en el sistema.</p>
                </div>
            <% }%>
        </div>
    </body>
</html>