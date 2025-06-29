<%@page import="com.mycompany.proyecto2_progra2.domain.Repuesto" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Factura de Orden de Trabajo</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 20px;
        }
        .factura-container {
            background: #fff;
            border-radius: 10px;
            padding: 30px;
            max-width: 800px;
            margin: 0 auto;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }
        h1 {
            text-align: center;
            color: #2c3e50;
        }
        .info {
            margin-bottom: 20px;
        }
        .info strong {
            display: inline-block;
            width: 200px;
            color: #555;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: left;
        }
        th {
            background-color: #3498db;
            color: white;
        }
        .total {
            text-align: right;
            font-size: 1.2em;
            font-weight: bold;
            margin-top: 20px;
            color: #2c3e50;
        }
    </style>
</head>
<body>
    <div class="factura-container">
        <h1>Factura de Orden de Trabajo</h1>

        <div class="info">
            <p><strong>ID de Orden:</strong> ${id}</p>
            <p><strong>Fecha Ingreso:</strong> ${fechaIngreso}</p>
            <p><strong>Placa Vehículo:</strong> ${vehiculo}</p>
            <p><strong>Descripción:</strong> ${descripcion}</p>
            <p><strong>Estado:</strong> ${estado}</p>
            <p><strong>Fecha Devolución:</strong> ${fechaDevolucion}</p>
            <p><strong>Detalle Recepción:</strong> ${detalleRecepcion}</p>
        </div>

        <h2>Repuestos</h2>
        <table>
            <tr>
                <th>Nombre</th>
                <th>Cantidad</th>
                <th>Precio Unitario</th>
                <th>Subtotal</th>
            </tr>
            <c:forEach var="repuesto" items="${spareParts}">
                <tr>
                    <td>${repuesto.name}</td>
                    <td>${repuesto.quantity}</td>
                    <td>₡${repuesto.price}</td>
                    <td>₡${repuesto.quantity * repuesto.price}</td>
                </tr>
            </c:forEach>
        </table>

        <h2>Servicios</h2>
        <table>
            <tr>
                <th>Nombre</th>
                <th>Precio</th>
            </tr>
            <c:forEach var="servicio" items="${services}">
                <tr>
                    <td>${servicio.name}</td>
                    <td>₡${servicio.price}</td>
                </tr>
            </c:forEach>
        </table>

        <div class="total">
            Total: ${totalCost}
        </div>
    </div>
</body>
</html>
