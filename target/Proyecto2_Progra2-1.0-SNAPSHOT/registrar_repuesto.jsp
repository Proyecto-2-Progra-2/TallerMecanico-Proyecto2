<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Repuesto</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">
    <style>
        body {
            margin: 0;
            font-family: 'Roboto', 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f6f9;
            color: #333;
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
            flex-direction: column;
            align-items: center;
            padding: 40px 20px;
        }

        form {
            background-color: white;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 8px 25px rgba(0,0,0,0.15);
            width: 100%;
            max-width: 550px;
        }

        form div {
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-weight: 600;
            margin-bottom: 8px;
            color: #555;
            font-size: 0.95em;
        }

        input[type="text"],
        input[type="number"],
        input[type="email"] {
            width: calc(100% - 24px);
            padding: 12px;
            border: 1px solid #dcdcdc;
            border-radius: 8px;
            font-size: 1em;
            transition: border-color 0.3s ease, box-shadow 0.3s ease;
        }

        input[type="text"]:focus,
        input[type="number"]:focus,
        input[type="email"]:focus {
            border-color: #3498db;
            box-shadow: 0 0 0 3px rgba(52, 152, 219, 0.2);
            outline: none;
        }

        input[type="submit"] {
            background-color: #3498db;
            color: white;
            padding: 15px 25px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 1.1em;
            font-weight: 700;
            width: 100%;
            transition: background-color 0.3s ease, transform 0.2s ease;
            margin-top: 30px;
        }

        input[type="submit"]:hover {
            background-color: #2980b9;
            transform: translateY(-2px);
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>
    <header>
        <img src="https://cdn-icons-png.flaticon.com/512/3233/3233481.png" alt="Icono Repuesto">
        <h1>Registrar Repuestos</h1>
    </header>
    <main>

        <% String error = (String) request.getAttribute("error"); %>
        <% if (error != null) { %>
            <script>
                alert("<%= error %>");
            </script>
        <% } %>

        <form action="registrarRepuesto" method="POST">
            <div>
                <label for="id">Identificación del Repuesto:</label>
                <input type="text" id="id" name="id" value="${id}" readonly required>
            </div>
            <div>
                <label for="nombre">Nombre del Repuesto:</label>
                <input type="text" id="nombre" name="nombre" required placeholder="Ej: Filtro de Aire">
            </div>
            <div>
                <label for="cantidad">Cantidad en Stock:</label>
                <input type="number" id="cantidad" name="cantidad" required min="0" placeholder="Ej: 50">
            </div>
            <div>
                <label for="precio">Precio Unitario (₡):</label>
                <input type="number" id="precio" name="precio" required min="0.01" step="0.01" placeholder="Ej: 15500.75">
            </div>
            <div>
                <input type="submit" name="registrar" value="Registrar Repuesto">
            </div>
        </form>
    </main>

    <!-- Botón registrar todos  -->
    <div style="
        position: fixed;
        bottom: 30px;
        right: 30px;
        z-index: 999;
    ">
       <form action="registrarTodosRepuestos" method="POST">
    <% for (Repuesto r : repuestosAgregados) { %>
        <input type="hidden" name="repuestosAgregados" value="<%= r.getId() %>">
        <input type="hidden" name="cantidades" value="<%= r.getCantidad() %>">
    <% } %>
    <button type="submit" class="btn-registrar-todos">
        Registrar todos los repuestos seleccionados
    </button>
</form>
    </div>
</body>
</html>
