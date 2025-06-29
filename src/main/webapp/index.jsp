<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Taller Mecánico</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #eef1f5;
            color: #333;
        }

        h1 {
            text-align: center;
            padding: 30px 0;
            background: #2c3e50;
            color: white;
            margin: 0;
            font-size: 2.5em;
        }

        .container {
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            padding: 40px;
            gap: 40px;
        }

        .box {
            background: white;
            padding: 30px 25px;
            border-radius: 12px;
            box-shadow: 0 6px 18px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 280px;
            transition: transform 0.2s ease-in-out;
        }

        .box:hover {
            transform: scale(1.03);
        }

        .box h2 {
            margin: 15px 0;
            font-size: 1.6em;
            color: #2c3e50;
        }

        .box img {
            width: 100px;
            height: 100px;
            object-fit: contain;
        }

        form {
            margin-top: 10px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 12px;
            background: #3498db;
            border: none;
            color: white;
            border-radius: 6px;
            font-size: 1em;
            cursor: pointer;
            margin-top: 10px;
            transition: background 0.3s ease;
        }

        input[type="submit"]:hover {
            background: #2980b9;
        }

        @media screen and (max-width: 600px) {
            .container {
                flex-direction: column;
                align-items: center;
            }
        }
    </style>
</head>
<body>
    <h1>Taller Mecánico</h1>
    <div class="container">

        <div class="box">
            <img src="https://cdn-icons-png.flaticon.com/512/1077/1077012.png" alt="Cliente Icono">
            <h2>Clientes</h2>
            <form action="registrarCliente" method="GET">
                <input type="submit" value="Registrar Cliente">
            </form>
            <form action="mostrarClientes" method="GET">
                <input type="submit" value="Mostrar Clientes">
            </form>
        </div>

        <div class="box">
            <img src="https://cdn-icons-png.freepik.com/512/13592/13592042.png" alt="Vehículo Mecánico">
            <h2>Vehículos</h2>
            <form action="registrarVehiculo" method="GET">
                <input type="submit" value="Registrar Vehículo">
            </form>
            <form action="mostrarVehiculos" method="GET">
                <input type="submit" value="Mostrar Vehículos">
            </form>
        </div>
        
        <div class="box">
            <img src="https://img.freepik.com/vector-premium/ilustracion-vectorial-mecanica-automotriz-escena-dibujos-animados-tipo-arreglando-coches-taller-reparacion-neumaticos-cambiando-ruedas-sosteniendo-llaves-fondo-blanco_812561-657.jpg" alt="Repuesto Icono">
            <h2>Repuestos</h2>
            <form action="registrarRepuesto" method="GET">
                <input type="submit" value="Registrar Repuesto">
            </form>
            <form action="mostrarRepuestos" method="GET">
                <input type="submit" value="Mostrar Repuestos">
            </form>
        </div>
    
        <div class="box">
            <img src="https://media.istockphoto.com/id/1409477431/es/vector/servicio-de-autom%C3%B3vil.jpg?s=612x612&w=0&k=20&c=v9Rt0Y8SRPuGJjl2nu55R5emWQxIx-SDbYzUgdcD_7U=" alt="Orden de trabajo Icono">
            <h2>Ordenes de Trabajo</h2>
            <form action="registrarOrdenTrabajo" method="GET">
                <input type="submit" value="Registrar Repuesto">
            </form>
            <form action="mostrarOrdenesTrabajo" method="GET">
                <input type="submit" value="Mostrar Repuestos">
            </form>
        </div>
        
    </div>
</body>
</html>
