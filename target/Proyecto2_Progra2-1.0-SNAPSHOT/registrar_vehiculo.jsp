<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Vehículo</title>
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
        input[type="number"] {
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
        <img src="https://cdn-icons-png.flaticon.com/512/744/744465.png" alt="Icono Vehículo">
        <h1>Registrar Vehículo</h1>
    </header>

    <main>
        <form action="registrarVehiculo" method="POST">
            <div>
                <label for="placa">Placa:</label>
                <input type="text" id="placa" name="placa" required>
            </div>
            <div>
                <label for="color">Color:</label>
                <input type="text" id="color" name="color" required>
            </div>
            <div>
                <label for="marca">Marca:</label>
                <input type="text" id="marca" name="marca" required>
            </div>
            <div>
                <label for="estilo">Estilo:</label>
                <input type="text" id="estilo" name="estilo" required>
            </div>
            <div>
                <label for="VIN">VIN:</label>
                <input type="text" id="VIN" name="VIN" required>
            </div>
            <div>
                <label for="cilindraje">Cilindraje:</label>
                <input type="text" id="cilindraje" name="cilindraje" required>
            </div>
            <div>
                <label for="annio">Año:</label>
                <input type="number" id="annio" name="annio" required>
            </div>
            <div>
                <label for="duennio">Identificación del dueño:</label>
                <input type="text" id="duennio" name="duennio" required>
            </div>
            <div>
                <input type="submit" name="registrar" value="Registrar">
            </div>
        </form>
    </main>
</body>
</html>
