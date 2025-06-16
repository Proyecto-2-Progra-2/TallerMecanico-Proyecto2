<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Cliente</title>
    </head>
    <body>
        <h1>Registrar Cliente</h1>
        <form action="registrarCliente" method="POST">
            <div>
                <label>Identificación:</label>
                <input type="text" name="id" required="true">
            </div>
            <div>
                <label>Nombre:</label>
                <input type="text" name="nombre" required="true">
            </div>
            <div>
                <label>Primer Apellido:</label>
                <input type="text" name="primerApellido" required="true">
            </div>
            <div>
                <label>Segundo Apellido:</label>
                <input type="text" name="segundoApellido" required="true">
            </div>
            <div>
                <label>Telefono:</label>
                <input type="number" name="telefono" required="true">
            </div>
            <div>
                <label>Dirección:</label>
                <input type="text" name="direccion" required="true">
            </div>
            <div>
                <label>Email:</label>
                <input type="email" name="email" required="true">
            </div>
            <div>
                <input type="submit" name="registrar" value="Registrar">
            </div>
        </form>
    </body>
</html>
