<%-- 
    Document   : modificar_Repuesto
    Created on : 28 jun 2025, 17:27:10
    Author     : luiss
--%>

<%@page import="com.mycompany.proyecto2_progra2.domain.Repuesto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Repuesto repuesto = (Repuesto) request.getAttribute("repuesto");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Modificar Repuesto</title>
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
        <h1>Modificar Repuesto</h1>
    </header>

    <form action="actualizarRepuesto" method="POST">
        <div>
            <label for="id">Identificación:</label>
            <input type="text" id="id" name="id" value="<%= repuesto.getId() %>" readonly>
        </div>
        <div>
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" value="<%= repuesto.getNombre() %>" required>
        </div>
        <div>
            <label for="cantidad">Cantidad del Repuesto (Stock):</label>
            <input type="text" id="cantidad" name="cantidad" value="<%= repuesto.getCantidad() %>" required>
        </div>
        <div>
            <label for="precio">Precio del repuesto: </label>
            <input type="text" id="precio" name="precio" value="<%= repuesto.getPrecio() %>" required>
        </div>    
        <div>
            <input type="submit" value="Actualizar Repuesto">
        </div>
    </form>
</body>
</html>

