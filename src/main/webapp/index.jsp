<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Pagina Principal</title>
    </head>
    <body>
        <h1>Taller Mecánico</h1>
        <div class="cliente-container">
            <form action="registrarCliente" method="GET">
                <input type="submit" value="Registrar Cliente" />
            </form>
            <form action="mostrarClientes" method="GET">
                <input type="submit" value="Mostrar Clientes" />
            </form>
        </div>
        <div class="vehiculo-container">
            <form action="registrarVehiculo" method="GET">
                <input type="submit" value="Registrar Vehiculo" />
            </form>
            <form action="mostrarVehiculos" method="GET">
                <input type="submit" value="Mostrar Vehiculos" />
            </form>
        </div>
    </body>
</html>
