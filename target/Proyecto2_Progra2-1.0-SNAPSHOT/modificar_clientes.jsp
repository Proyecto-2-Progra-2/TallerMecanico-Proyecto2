<%@page import="com.mycompany.proyecto2_progra2.domain.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Cliente cliente = (Cliente) request.getAttribute("cliente");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Modificar Cliente</title>
    <style>
        body {
            background-color: #f4f6f9;
            font-family: 'Segoe UI', sans-serif;
            margin: 0;
            padding: 20px;
        }

        header {
            background-color: #2c3e50;
            color: white;
            padding: 20px;
            text-align: center;
        }

        form {
            background-color: white;
            max-width: 600px;
            margin: 30px auto;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }

        form div {
            margin-bottom: 15px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="number"],
        input[type="email"] {
            width: 100%;
            padding: 10px;
            border-radius: 6px;
            border: 1px solid #ccc;
        }

        input[type="submit"] {
            background-color: #27ae60;
            color: white;
            border: none;
            padding: 12px;
            font-size: 1em;
            border-radius: 6px;
            cursor: pointer;
            width: 100%;
        }

        input[type="submit"]:hover {
            background-color: #1e8449;
        }
    </style>
</head>
<body>
    <header>
        <h1>Modificar Cliente</h1>
    </header>

    <form action="actualizarCliente" method="POST">
        <div>
            <label for="id">Identificación:</label>
            <input type="text" id="id" name="id" value="<%= cliente.getId() %>" readonly>
        </div>
        <div>
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" value="<%= cliente.getNombre() %>" required>
        </div>
        <div>
            <label for="primerApellido">Primer Apellido:</label>
            <input type="text" id="primerApellido" name="primerApellido" value="<%= cliente.getPrimerApellido() %>" required>
        </div>
        <div>
            <label for="segundoApellido">Segundo Apellido:</label>
            <input type="text" id="segundoApellido" name="segundoApellido" value="<%= cliente.getSegundoApellido() %>" required>
        </div>
        <div>
            <label for="telefono">Teléfono:</label>
            <input type="number" id="telefono" name="telefono" value="<%= cliente.getTelefono() %>" required>
        </div>
        <div>
            <label for="direccion">Dirección:</label>
            <input type="text" id="direccion" name="direccion" value="<%= cliente.getDireccion() %>" required>
        </div>
        <div>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="<%= cliente.getEmail() %>" required>
        </div>
        <div>
            <input type="submit" value="Actualizar Cliente">
        </div>
    </form>
</body>
</html>
