<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Vehiculo</title>
    </head>
    <body>
        <h1>Registrar Vehiculo</h1>
        <form action="registrarVehiculo" method="POST">
            <div>
                <label>Placa:</label>
                <input type="text" name="placa" required="true">
            </div>
            <div>
                <label>Color:</label>
                <input type="text" name="color" required="true">
            </div>
            <div>
                <label>Marca:</label>
                <input type="text" name="marca" required="true">
            </div>
            <div>
                <label>Estilo:</label>
                <input type="text" name="estilo" required="true">
            </div>
            <div>
                <label>VIN:</label>
                <input type="text" name="VIN" required="true">
            </div>
            <div>
                <label>Cilindraje:</label>
                <input type="text" name="direccion" required="true">
            </div>
            <div>
                <label>Año:</label>
                <input type="number" name="annio" required="true">
            </div>
            <div>
                <label>Identificación del dueño:</label>
                <input type="text" name="duennio" required="true">
            </div>
            <div>
                <input type="submit" name="registrar" value="Registrar">
            </div>
        </form>
    </body>
</html>
