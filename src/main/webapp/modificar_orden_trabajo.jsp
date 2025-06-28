<%-- 
    Document   : modificar_orden_trabajo
    Created on : 28 jun 2025, 17:08:27
    Author     : jeffr
--%>

<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.mycompany.proyecto2_progra2.domain.OrdenTrabajo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Orden de Trabajo</title>
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
            select,
            textarea,
            input[type="date"] {
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
            <h1>Modificar Orden de Trabajo</h1>
        </header>

        <% 
            OrdenTrabajo orden = (OrdenTrabajo) request.getAttribute("orden");
        %>

        <form action="modificarOrdenTrabajo" method="post">
            <div>
                <label for="placa">ID:</label>
                <input type="text" id="id" name="id" value="<%= orden.getId()%>" readonly>
            </div>
            <div>
                <label for="color">Descripción:</label>
                <input type="text" id="color" name="descripcion" value="<%= orden.getDescripcion()%>" required>
            </div>
            <div>
                <label for="marca">Estado:</label>
                <select id="estado" name="estado" required>
                    <option value="diagnóstico">Diagnóstico</option>
                    <option value="en reparación">En reparación</option>
                    <option value="listo para entrega">Listo para entrega</option>
                </select>
            </div>
            <div>
                <label for="detalleRecepcion">Detalles en la recepcion del vehiculo:</label>
                <textarea id="detalleRecepcion" name="detalleRecepcion" rows="6" cols="5" required=""><%= orden.getDetalleRecepcionVehiculo()%></textarea>
            </div>
            <div>
                <label for="fechaDevolucion">Fecha estimada de devolución del vehiculo:</label>
                <input type="date" id="fechaDevolucion" name="fechaDevolucion" required>
            </div>
            <div>
                <input type="submit" value="Guardar Cambios">
            </div>
        </form>
    </body>
</html>
