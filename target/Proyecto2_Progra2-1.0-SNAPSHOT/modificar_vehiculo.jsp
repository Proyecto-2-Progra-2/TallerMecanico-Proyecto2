<%@page import="com.mycompany.proyecto2_progra2.domain.Vehiculo"%>
<%@page import="com.mycompany.proyecto2_progra2.domain.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Vehiculo vehiculo = (Vehiculo) request.getAttribute("vehiculo");
    Cliente duenno = null;
    if (vehiculo != null) {
        duenno = vehiculo.getDuenno();
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Modificar Vehículo</title>
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
        input[type="number"] {
            width: 100%;
            padding: 10px;
            border-radius: 6px;
            border: 1px solid #ccc;
        }

        input[type="submit"] {
            background-color: #2980b9;
            color: white;
            border: none;
            padding: 12px;
            font-size: 1em;
            border-radius: 6px;
            cursor: pointer;
            width: 100%;
        }

        input[type="submit"]:hover {
            background-color: #1c5980;
        }

        .error {
            color: red;
            text-align: center;
            margin-top: 20px;
        }

    </style>
</head>
<body>
    <header>
        <h1>Modificar Vehículo</h1>
    </header>

    <%
        if (vehiculo == null) {
    %>
        <p class="error">No se encontró el vehículo para modificar.</p>
        <p style="text-align:center;"><a href="listaVehiculos.jsp">Volver a lista de vehículos</a></p>
    <%
        } else {
    %>

    <form action="modificarVehiculo" method="post">
        <div>
            <label for="placa">Placa:</label>
            <input type="text" id="placa" name="placa" value="<%= vehiculo.getPlaca() %>" readonly>
        </div>
        <div>
            <label for="color">Color:</label>
            <input type="text" id="color" name="color" value="<%= vehiculo.getColor() %>" required>
        </div>
        <div>
            <label for="marca">Marca:</label>
            <input type="text" id="marca" name="marca" value="<%= vehiculo.getMarca() %>" required>
        </div>
        <div>
            <label for="estilo">Estilo:</label>
            <input type="text" id="estilo" name="estilo" value="<%= vehiculo.getEstilo() %>" required>
        </div>
        <div>
            <label for="vin">VIN:</label>
            <input type="text" id="vin" name="vin" value="<%= vehiculo.getVin() %>" required>
        </div>
        <div>
            <label for="cilindraje">Cilindraje:</label>
            <input type="text" id="cilindraje" name="cilindraje" value="<%= vehiculo.getCilindraje() %>" required>
        </div>
        <div>
            <label for="annio">Año:</label>
            <input type="number" id="annio" name="annio" value="<%= vehiculo.getAnnio() %>" required>
        </div>
        <div>
            <label for="duennoId">ID Dueño:</label>
            <input type="text" id="duennoId" name="duennoId" value="<%= (duenno != null) ? duenno.getId() : "" %>" required>
        </div>
        <div>
            <input type="submit" value="Guardar Cambios">
        </div>
    </form>

    <%
        }
    %>
</body>
</html>
