<%-- 
    Document   : registrar_repuesto
    Created on : 17 jun 2025, 21:00:51
    Author     : luiss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Repuesto</title>
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
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 30px;
        }

        form {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            width: 100%;
            max-width: 500px;
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
            border: 1px solid #ccc;
            border-radius: 6px;
        }

        input[type="submit"] {
            background-color: #3498db;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 1em;
            width: 100%;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <header>
        <img src="https://i.pinimg.com/736x/0f/24/36/0f243658b7ad1e72dfaef6b7a6b541c2.jpg" alt="Icono Repuesto">
        <h1>Registrar Repuestos</h1>
    </header>
    <main>
        <form action="registrarRepuesto" method="POST">
            <div>
                <label for="id">Identificación:</label>
                <input type="text" id="id" name="id" required>
            </div>
            <div>
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" required>
            </div>
            <div>
                <label for="cantidad">Cantidad del repuesto (Stock):</label>
                <input type="text" id="cantidad" name="cantidad" required>
            </div>
            <div>
                <label for="precio">Precio del repuesto :</label>
                <input type="text" id="precio" name="precio" required>
            </div>
            <div>
                <input type="submit" name="registrar" value="Registrar">
            </div>
        </form>
    </main>
</body>
</html>

