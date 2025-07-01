<%@page import="com.mycompany.proyecto2_progra2.domain.Repuesto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Detalle de Orden de Trabajo</title>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">
        <style>
            
            body {
                margin: 0;
                font-family: 'Roboto', sans-serif;
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
            main {
                display: flex;
                justify-content: center;
                padding: 40px 20px;
            }
            form {
                background-color: white;
                padding: 40px;
                border-radius: 12px;
                box-shadow: 0 8px 25px rgba(0,0,0,0.15);
                width: 100%;
                max-width: 800px;
                display: grid;
                grid-template-columns: 1fr 1fr;
                gap: 20px 30px;
            }
            /* Resto del CSS... */
        </style>
    </head>
    <body>
        <header>
            <img src="https://cdn-icons-png.flaticon.com/512/2972/2972528.png" alt="Icono de Orden de Trabajo">
            <h1>Detalle de Orden de Trabajo</h1>
        </header>

        <main>
            <%-- Aquí deberías recibir el objeto "ordenDetalle" con toda la info para mostrar --%>
            <%
                com.mycompany.proyecto2_progra2.domain.OrdenTrabajoDetalle ordenDetalle =
                    (com.mycompany.proyecto2_progra2.domain.OrdenTrabajoDetalle) request.getAttribute("ordenDetalle");

                ArrayList<Repuesto> repuestosList =
                    (ArrayList<Repuesto>) request.getAttribute("repuestosList");
                if (repuestosList == null) {
                    repuestosList = new ArrayList<>();
                }
            %>

            <form>
                <div>
                    <label>ID de Detalle:</label>
                    <input type="text" value="<%= ordenDetalle != null ? ordenDetalle.getId() : "" %>" readonly>
                </div>

                <div>
                    <label>Descripción:</label>
                    <textarea readonly rows="4"><%= ordenDetalle != null ? ordenDetalle.getDescripcion() : "" %></textarea>
                </div>

                <div style="grid-column: 1 / -1;">
                    <label>Repuestos Asociados:</label>
                    <ul>
                        <% for (Repuesto r : repuestosList) { %>
                            <li><%= r.getNombre() %> - ₡<%= String.format("%,.2f", r.getPrecio()) %></li>
                        <% } %>
                    </ul>
                </div>

                <div style="grid-column: 1 / -1; text-align: right;">
                    <button onclick="window.history.back(); return false;">Volver</button>
                </div>
            </form>
        </main>
    </body>
</html>
