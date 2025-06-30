<%-- 
    Document   : agregarRepuestos
    Created on : 29 jun 2025, 17:50:13
    Author     : jeffr
--%>

<%@page import="com.mycompany.proyecto2_progra2.domain.Repuesto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
            <h1>Agregar Repuestos</h1>
        </header>
        <main>
            <%
                ArrayList<Repuesto> repuestosAgregados = new ArrayList<>();
                Repuesto repuestoAgregado = (Repuesto) request.getAttribute("repuestoAgregado");
                if (repuestoAgregado != null) {
                    repuestosAgregados.add(repuestoAgregado);
                    System.out.println("Repuesto recibido: " + repuestoAgregado.getId() + " - " + repuestoAgregado.getNombre());
                    System.out.println("Lista actual:");
                    for (Repuesto r : repuestosAgregados) {
                        System.out.println("-> " + r.getId() + r.getNombre());
                    }
                }
            %>

            <% if (!repuestosAgregados.isEmpty()) {%>
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
                    <% for (Repuesto repuesto : repuestosAgregados) {%>
                    <tr>
                        <td><%= repuesto.getId()%></td>
                        <td><%= repuesto.getNombre()%></td>
                        <td><%= repuesto.getCantidad()%></td>
                        <td>₡<%= String.format("%.2f", repuesto.getPrecio())%></td>
                        <td>
                            <form action="${pageContext.request.contextPath}/modificarRepuesto" method="GET" style="margin:0; display:inline-block;">
                                <input type="hidden" name="id" value="<%= repuesto.getId()%>">
                                <button type="submit" class="action-btn eliminar-btn">Eliminar Repuesto</button>
                            </form>
                        </td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
            <%}%>

            <% ArrayList<Repuesto> repuestos = (ArrayList<Repuesto>) request.getAttribute("repuestos");
                if (repuestos != null) {%>
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
                    <% for (Repuesto repuesto : repuestos) {%>
                    <tr>
                        <td><%= repuesto.getId()%></td>
                        <td><%= repuesto.getNombre()%></td>
                        <td><%= repuesto.getCantidad()%></td>
                        <td>₡<%= String.format("%.2f", repuesto.getPrecio())%></td>
                        <td>
                            <form action="${pageContext.request.contextPath}/ingresaListaRepuestos" method="GET" style="margin:0; display:inline-block;">
                                <input type="hidden" name="id" value="<%= repuesto.getId()%>">
                                <button type="submit" class="action-btn modificar-btn">Agregar Repuesto</button>
                            </form>
                        </td>
                    </tr>
                    <% }
                        }%>
                </tbody>
            </table>
        </main>
    </body>
</html>
