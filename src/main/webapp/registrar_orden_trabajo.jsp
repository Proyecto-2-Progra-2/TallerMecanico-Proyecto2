<%@page import="com.mycompany.proyecto2_progra2.domain.Repuesto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Orden de Trabajo</title>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">
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
                flex-direction: column;
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
            input[type="date"],
            select {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 6px;
            }

            textarea {
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
            <img src="https://cdn-icons-png.flaticon.com/512/2972/2972528.png" alt="Icono de Orden de Trabajo">
            <h1>Registrar Orden de Trabajo</h1>
        </header>
        <main>
            <form action="registrarOrdenTrabajo" method="POST" class="formulario">
                <div>
                    <label for="id">ID:</label>
                    <input type="text" id="id" name="id" value="${id}" readonly required>
                </div>
                <div>
                    <label for="descripcion">Descripcion:</label>
                    <textarea id="descripcion" name="descripcion" rows="6" cols="5" required=""></textarea>
                </div>
                <div>
                    <label for="fechaIngreso">Fecha de Ingreso:</label>
                    <input type="text" id="fechaIngreso" name="fechaIngreso" value="${fechaIngreso}" readonly required>
                </div>
                <div>
                    <label for="estado">Estado:</label>
                    <select id="estado" name="estado" required>
                        <option value="diagnóstico">Diagnóstico</option>
                        <option value="en reparación">En reparación</option>
                        <option value="listo para entrega">Listo para entrega</option>
                    </select>

                </div>
                <div>
                    <label for="detalleRecepcion">Detalles en la recepcion del vehiculo:</label>
                    <textarea id="detalleRecepcion" name="detalleRecepcion" rows="6" cols="5" required=""></textarea>
                </div>
                <div>
                    <label for="fechaDevolucion">Fecha estimada de devolución del vehiculo:</label>
                    <input type="date" id="fechaDevolucion" name="fechaDevolucion" required>
                </div>
                <div>
                    <label for="vehiculo">Ingrese la placa del vehiculo:</label>
                    <input type="text" id="vehiculo" name="vehiculo" required>
                </div>

                <!-- Aquí empieza el formulario de agregar detalle de la orden -->
                <div>
                    <h3>Agregar detalle de la orden</h3>
                </div>
                <div>
                    <label for="id">ID:</label>
                    <input type="text" id="id" name="idOrden" value="${idDetalle}" readonly required>
                </div>
                <div>
                    <label for="descripcion">Observaciones:</label>
                    <textarea id="descripcion" name="observaciones" rows="6" cols="5" required=""></textarea>
                </div>
                <div>
                    <label for="precio">Precio Total de la Mano de Obra:</label>
                    <input type="number" name="precioManoObra">
                </div>
                <!-- fin formulario detalle de orden -->
                <div>
                    <label for="precio">Precio total a pagar:</label>
                    <input type="number" name="precio" value="100000" readonly>
                </div>
                <div>
                    <input type="submit" name="registrar" value="Registrar">
                </div>
            </form>
        </main>
    </body>
</html>