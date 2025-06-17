<%@page import="com.mycompany.proyecto2_progra2.domain.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Cliente cliente = (Cliente) request.getAttribute("cliente");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Información del Cliente</title>
    <style>
        body {
            background-color: #f4f6f9;
            font-family: 'Segoe UI', sans-serif;
            margin: 0;
            padding: 20px;
        }
        header {
            background-color: #34495e;
            color: white;
            padding: 20px;
            text-align: center;
        }
        .container {
            background-color: white;
            max-width: 600px;
            margin: 30px auto;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }
        .info {
            margin-bottom: 20px;
        }
        .info label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
            color: #2c3e50;
        }
        .buttons {
            display: flex;
            justify-content: space-between;
        }
        button {
            background-color: #2980b9;
            color: white;
            border: none;
            padding: 12px 20px;
            border-radius: 6px;
            cursor: pointer;
            font-size: 1em;
            width: 48%;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #1c5980;
        }
    </style>
</head>
<body>
    <header>
        <h1>Información del Cliente</h1>
    </header>

    <div class="container">
        <% if (cliente == null) { %>
            <p>No se encontró información del cliente.</p>
        <% } else { %>
            <div class="info">
                <label>Identificación:</label>
                <p><%= cliente.getId() %></p>
            </div>
            <div class="info">
                <label>Nombre:</label>
                <p><%= cliente.getNombre() %></p>
            </div>
            <div class="info">
                <label>Primer Apellido:</label>
                <p><%= cliente.getPrimerApellido() %></p>
            </div>
            <div class="info">
                <label>Segundo Apellido:</label>
                <p><%= cliente.getSegundoApellido() %></p>
            </div>
            <div class="info">
                <label>Teléfono:</label>
                <p><%= cliente.getTelefono() %></p>
            </div>
            <div class="info">
                <label>Dirección:</label>
                <p><%= cliente.getDireccion() %></p>
            </div>
            <div class="info">
                <label>Email:</label>
                <p><%= cliente.getEmail() %></p>
            </div>

            <div class="buttons">
                <form action="modificarCliente" method="get" style="width:48%;">
                    <input type="hidden" name="id" value="<%= cliente.getId() %>"/>
                    <button type="submit">Modificar</button>
                </form>

                <form action="historialCliente" method="get" style="width:48%;">
                    <input type="hidden" name="id" value="<%= cliente.getId() %>"/>
                    <button type="submit">Ver Historial</button>
                </form>
            </div>
        <% } %>
    </div>
</body>
</html>
