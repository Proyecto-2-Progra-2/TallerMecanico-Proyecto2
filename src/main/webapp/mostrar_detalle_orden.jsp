<%--
    Document   : mostrar_detalle_orden
    Created on : 28 jun 2025, 09:00:00
    Author     : jimss
--%>

<%@page import="com.mycompany.proyecto2_progra2.domain.Repuesto"%>
<%@page import="com.mycompany.proyecto2_progra2.domain.DetalleOrden"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle de la Orden</title>
        <style>
            body {
                margin: 0;
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background-color: #f4f6f9;
                color: #333;
                display: flex;
                flex-direction: column;
                min-height: 100vh;
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
                flex-grow: 1;
                padding: 30px;
                display: flex;
                justify-content: center;
                align-items: flex-start; /* Align items to the top */
            }

            .detalle-container {
                background-color: white;
                padding: 30px;
                border-radius: 10px;
                box-shadow: 0 4px 12px rgba(0,0,0,0.1);
                width: 100%;
                max-width: 800px; /* Limita el ancho para mejor lectura */
            }

            .detalle-section {
                margin-bottom: 20px;
            }

            .detalle-section h2 {
                color: #3498db;
                border-bottom: 2px solid #3498db;
                padding-bottom: 10px;
                margin-bottom: 15px;
            }

            .detalle-item {
                display: flex;
                margin-bottom: 8px;
            }

            .detalle-item strong {
                width: 180px; /* Ancho fijo para las etiquetas */
                flex-shrink: 0;
                color: #555;
            }

            .detalle-item span {
                flex-grow: 1;
            }

            .repuestos-table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 15px;
            }

            .repuestos-table th, .repuestos-table td {
                border: 1px solid #ddd;
                padding: 10px;
                text-align: left;
            }

            .repuestos-table th {
                background-color: #5a7d9a; /* Un color un poco diferente para la tabla de repuestos */
                color: white;
            }

            .repuestos-table tbody tr:nth-child(even) {
                background-color: #f9f9f9;
            }
            .repuestos-table tbody tr:hover {
                background-color: #eaf6ff;
            }

            .total-precio {
                text-align: right;
                font-size: 1.2em;
                font-weight: bold;
                margin-top: 20px;
                padding-top: 10px;
                border-top: 1px dashed #ccc;
            }
            .back-btn {
                display: inline-block;
                background-color: #6c757d; /* Gris para volver */
                color: white;
                padding: 10px 20px;
                border-radius: 5px;
                text-decoration: none;
                margin-top: 20px;
                font-size: 1em;
            }

            .back-btn:hover {
                background-color: #5a6268;
            }

            /* Responsive adjustments for tables on smaller screens */
            @media screen and (max-width: 600px) {
                .detalle-item {
                    flex-direction: column;
                    align-items: flex-start;
                }
                .detalle-item strong {
                    width: auto;
                    margin-bottom: 5px;
                }
                .repuestos-table, .repuestos-table thead, .repuestos-table tbody, .repuestos-table th, .repuestos-table td, .repuestos-table tr {
                    display: block;
                }
                .repuestos-table thead tr {
                    position: absolute;
                    top: -9999px;
                    left: -9999px;
                }
                .repuestos-table tr {
                    border: 1px solid #ccc;
                    margin-bottom: 10px;
                }
                .repuestos-table td {
                    border: none;
                    border-bottom: 1px solid #eee;
                    position: relative;
                    padding-left: 50%;
                    text-align: right;
                }
                .repuestos-table td::before {
                    content: attr(data-label);
                    position: absolute;
                    left: 6px;
                    width: 45%;
                    padding-right: 10px;
                    white-space: nowrap;
                    font-weight: bold;
                    color: #555;
                    text-align: left;
                }
            }
        </style>
    </head>
    <body>
        <header>
            <img src="https://cdn-icons-png.flaticon.com/512/1995/1995574.png" alt="Ícono Vehículo">
            <h1>Detalle de la Orden de Trabajo</h1>
        </header>
        <main>
            <div class="detalle-container">
                <% DetalleOrden detalleOrden = (DetalleOrden) request.getAttribute("detalleOrden"); %>

                <% if (detalleOrden != null) { %>
                <div class="detalle-section">
                    <h2>Información General</h2>
                    <div class="detalle-item">
                        <strong>ID del Detalle:</strong> <span><%= detalleOrden.getId()%></span>
                    </div>
                    <div class="detalle-item">
                        <strong>Observaciones:</strong> <span><%= detalleOrden.getObservaciones()%></span>
                    </div>
                    <div class="detalle-item">
                        <strong>Mano de Obra:</strong> <span>₡<%= String.format("%,.2f", detalleOrden.getManoObra())%></span>
                    </div>
                </div>

                <div class="detalle-section">
                    <h2>Repuestos Utilizados</h2>
                    <% if (detalleOrden.getRepuestos() != null && !detalleOrden.getRepuestos().isEmpty()) { %>
                    <table class="repuestos-table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Precio Unitario</th>
                                <th>Subtotal</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Repuesto repuesto : detalleOrden.getRepuestos()) { %>
                            <tr>
                                <td data-label="ID"><%= repuesto.getId()%></td>
                                <td data-label="Nombre"><%= repuesto.getNombre()%></td>
                                <td data-label="Precio Unitario">₡<%= String.format("%,.2f", repuesto.getPrecio())%></td>
                                <td data-label="Subtotal">₡<%= String.format("%,.2f", detalleOrden.getPrecioTotal())%></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                    <% } else { %>
                    <p>No se registraron repuestos para esta orden.</p>
                    <% } %>
                </div>

                <div class="total-precio">
                    Precio Total del Detalle: ₡<%= String.format("%,.2f", detalleOrden.getPrecioTotal())%>
                </div>

                <% } else { %>
                <div class="mensaje" style="background-color: #fff3cd; color: #856404; border: 1px solid #ffeeba;">
                    ⚠️ No se encontró el detalle de la orden.
                </div>
                <% } %>
                <a href="${pageContext.request.contextPath}/listadoOrdenes" class="back-btn">Volver a Órdenes de Trabajo</a>
            </div>
        </main>
    </body>
</html>