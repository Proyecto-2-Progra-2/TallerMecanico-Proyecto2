<%@page import="com.mycompany.proyecto2_progra2.domain.Vehiculo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Mostrar Vehículos</title>
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

        .modificar-btn { background-color: #f39c12; }
        .modificar-btn:hover { background-color: #e67e22; }

        .cliente-btn { background-color: #2980b9; }
        .cliente-btn:hover { background-color: #2471a3; }

        .eliminar-btn { background-color: #e74c3c; }
        .eliminar-btn:hover { background-color: #c0392b; }

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
        <h1>Lista de Vehículos</h1>
    </header>

    <main>

   
        <%
            String mensaje = request.getParameter("mensaje");
            if ("eliminado".equals(mensaje)) {
        %>
            <div class="mensaje">🚗 Vehículo eliminado correctamente.</div>
        <% } %>

        <% ArrayList<Vehiculo> vehiculos = (ArrayList<Vehiculo>) request.getAttribute("vehiculos"); %>

        <table>
            <thead>
                <tr>
                    <th>Placa</th>
                    <th>Color</th>
                    <th>Marca</th>
                    <th>Estilo</th>
                    <th>VIN</th>
                    <th>Cilindraje</th>
                    <th>Año</th>
                    <th>Dueño (ID)</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <% if (vehiculos != null) {
                    for (Vehiculo vehiculo : vehiculos) { %>
                <tr>
                    <td data-label="Placa"><%= vehiculo.getPlaca() %></td>
                    <td data-label="Color"><%= vehiculo.getColor() %></td>
                    <td data-label="Marca"><%= vehiculo.getMarca() %></td>
                    <td data-label="Estilo"><%= vehiculo.getEstilo() %></td>
                    <td data-label="VIN"><%= vehiculo.getVin() %></td>
                    <td data-label="Cilindraje"><%= vehiculo.getCilindraje() %></td>
                    <td data-label="Año"><%= vehiculo.getAnnio() %></td>
                    <td data-label="Dueño"><%= vehiculo.getDuenno().getId() %></td>
                    <td>
                      <form action="${pageContext.request.contextPath}/modificarVehiculo" method="GET">
    <input type="hidden" name="placa" value="<%= vehiculo.getPlaca() %>">
    <button type="submit" class="action-btn modificar-btn">Modificar</button>
</form>
<form action="${pageContext.request.contextPath}/mostrarCliente" method="GET">
    <input type="hidden" name="id" value="<%= vehiculo.getDuenno().getId() %>">
    <button type="submit" class="action-btn cliente-btn">Ver Cliente</button>
</form>
<form action="${pageContext.request.contextPath}/eliminarVehiculo" method="POST" onsubmit="return confirm('¿Está seguro que desea eliminar este vehículo?');">
    <input type="hidden" name="placa" value="<%= vehiculo.getPlaca() %>">
    <button type="submit" class="action-btn eliminar-btn">Eliminar</button>
</form>
                </td>
                </tr>
                <% }
                } else { %>
                <tr><td colspan="9" style="text-align:center;">No hay vehículos registrados.</td></tr>
                <% } %>
            </tbody>
        </table>
    </main>
</body>
</html>
