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
                font-family: 'Roboto', sans-serif;
                background-color: #eef2f7;
                color: #333;
                line-height: 1.6;
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
                justify-content: center;
                padding: 40px 20px;
            }
            form {
                background-color: white;
                padding: 40px;
                border-radius: 12px;
                box-shadow: 0 8px 25px rgba(0,0,0,0.15);
                width: 100%;
                max-width: 800px;
                display: grid;
                grid-template-columns: 1fr 1fr;
                gap: 20px 30px;
            }
            form div {
                margin-bottom: 0;
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
            input[type="date"],
            select,
            textarea {
                width: calc(100% - 24px);
                padding: 12px;
                border: 1px solid #dcdcdc;
                border-radius: 8px;
                font-size: 1em;
                transition: border-color 0.3s ease, box-shadow 0.3s ease;
            }
            input[type="text"]:focus,
            input[type="number"]:focus,
            input[type="date"]:focus,
            select:focus,
            textarea:focus {
                border-color: #3498db;
                box-shadow: 0 0 0 3px rgba(52, 152, 219, 0.2);
                outline: none;
            }
            textarea {
                min-height: 80px;
                max-height: 200px;
                resize: vertical;
            }
            hr {
                grid-column: 1 / -1;
                border: none;
                border-top: 1px solid #eee;
                margin: 25px 0;
            }
            .item-section {
                grid-column: 1 / -1;
                border: 1px solid #e0e0e0;
                padding: 20px;
                border-radius: 10px;
                margin-top: 0;
                background-color: #fcfcfc;
            }
            .item-header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                margin-bottom: 20px;
                padding-bottom: 10px;
                border-bottom: 1px dashed #e9e9e9;
            }
            .item-header h3 {
                margin: 0;
                color: #2c3e50;
                font-size: 1.3em;
                font-weight: 700;
            }
            .add-button, .remove-button { /* Se mantienen para el estilo si no quieres quitarlos, pero ya no tienen funcionalidad JS */
                background-color: #28a745;
                color: white;
                padding: 10px 18px;
                border: none;
                border-radius: 6px;
                cursor: pointer;
                font-size: 0.95em;
                font-weight: 600;
                transition: background-color 0.3s ease, transform 0.2s ease;
            }
            .remove-button {
                background-color: #dc3545;
                margin-left: 10px;
            }
            .item-entry {
                display: flex;
                gap: 15px;
                margin-bottom: 12px;
                align-items: center;
                background-color: #ffffff;
                padding: 10px 15px;
                border-radius: 6px;
                border: 1px solid #f0f0f0;
            }
            .item-entry select,
            .item-entry input[type="number"] {
                flex: 1;
                margin: 0;
                width: auto;
            }
            .item-entry input[name$=".quantity"] {
                flex: 0.3;
            }
            .item-entry input[name$=".price"] {
                flex: 0.5;
            }
            .total-price {
                grid-column: 1 / -1;
                font-size: 1.4em;
                font-weight: 700;
                text-align: right;
                margin-top: 25px;
                padding-top: 20px;
                border-top: 2px solid #aec6e0;
                color: #2c3e50;
            }
            .total-price label {
                font-size: 1em;
                display: inline-block;
                margin-right: 15px;
                color: #2c3e50;
            }
            .total-price input {
                width: 150px;
                text-align: right;
                font-size: 1.1em;
                background-color: #eef7ff;
                border-color: #c0d9ef;
            }
            input[type="submit"] {
                grid-column: 1 / -1;
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
            @media (max-width: 768px) {
                form {
                    grid-template-columns: 1fr;
                    padding: 20px;
                    gap: 15px;
                }
                .item-entry {
                    flex-direction: column;
                    align-items: stretch;
                    gap: 8px;
                }
                .item-entry select,
                .item-entry input {
                    width: 100%;
                }
                .remove-button {
                    width: 100%;
                    margin-left: 0;
                    margin-top: 5px;
                }
            }
        </style>
    </head>
    <body>
        <header>
            <img src="https://cdn-icons-png.flaticon.com/512/2972/2972528.png" alt="Icono de Orden de Trabajo">
            <h1>Registrar Orden de Trabajo</h1>
        </header>

        <main>
            <form action="registrarOrdenTrabajo" method="POST" id="orderForm">
                <div>
                    <label for="id">ID de Orden:</label>
                    <input type="text" id="id" name="id" value="${id}" readonly required>
                </div>
                <div>
                    <label for="fechaIngreso">Fecha de Ingreso:</label>
                    <input type="text" id="fechaIngreso" name="fechaIngreso" value="${fechaIngreso}" readonly required>
                </div>

                <div style="grid-column: 1 / -1;">
                    <label for="descripcion">Descripción del Trabajo:</label>
                    <textarea id="descripcion" name="descripcion" rows="4" required placeholder="Detalle los trabajos a realizar...">${descripcion}</textarea>
                </div>

                <div>
                    <label for="estado">Estado Actual:</label>
                    <select id="estado" name="estado" required>
                        <option value="diagnóstico" ${"diagnóstico" eq estado ? 'selected' : ''}>Diagnóstico</option>
                        <option value="en reparación" ${"en reparación" eq estado ? 'selected' : ''}>En reparación</option>
                        <option value="listo para entrega" ${"listo para entrega" eq estado ? 'selected' : ''}>Listo para entrega</option>
                        <option value="entregado" ${"entregado" eq estado ? 'selected' : ''}>Entregado</option>
                    </select>
                </div>
                <div>
                    <label for="fechaDevolucion">Fecha Estimada de Devolución:</label>
                    <input type="date" id="fechaDevolucion" name="fechaDevolucion" value="${fechaDevolucion}" required>
                </div>

                <div style="grid-column: 1 / -1;">
                    <label for="detalleRecepcion">Detalles en la Recepción del Vehículo:</label>
                    <textarea id="detalleRecepcion" name="detalleRecepcion" rows="4" required placeholder="Condición del vehículo al momento de la recepción...">${detalleRecepcion}</textarea>
                </div>

                <div>
                    <label for="vehiculo">Placa del Vehículo:</label>
                    <input type="text" id="vehiculo" name="vehiculo" value="${vehiculo}" required placeholder="Ej: ABC-123">
                </div>
                <hr>

                <div class="item-section">
                    <div class="item-header">
                        <h3>Repuestos Requeridos</h3>
                        <button type="button" class="add-button" disabled>+ Agregar Repuesto</button>
                    </div>
                    <div id="sparePartsContainer">
                        <%
                            // Obtener la lista de repuestos desde el atributo de solicitud
                            ArrayList<Repuesto> availableRepuestos = (ArrayList<Repuesto>) request.getAttribute("repuestosList");
                            // Obtener los repuestos seleccionados previamente (si hay una recarga)
                            // Esto asume que el Servlet te devuelve una lista de mapas o un objeto similar que contiene
                            // los IDs de repuesto seleccionados, sus cantidades y precios actualizados.
                            // Para simplificar, aquí usaremos placeholders para los valores 'seleccionados'.
                            // En una aplicación real, tendrías que pasar estos valores de vuelta del Servlet.
                            String selectedRepuestoId = (String) request.getAttribute("selectedSparePartId");
                            double selectedRepuestoQty = (Double) request.getAttribute("selectedSparePartQuantity") != null ? (Double) request.getAttribute("selectedSparePartQuantity") : 1.0;
                            double selectedRepuestoPrice = (Double) request.getAttribute("selectedSparePartPrice") != null ? (Double) request.getAttribute("selectedSparePartPrice") : 0.0;
                        %>
                        <div class="item-entry">
                            <select name="spareParts[0].id" required onchange="this.form.submit()">
                                <option value="">Seleccione un repuesto</option>
                                <%
                                    if (availableRepuestos != null) {
                                        for (Repuesto r : availableRepuestos) {
                                            String selected = "";
                                            if (r.getId().equals(selectedRepuestoId)) {
                                                selected = "selected";
                                                selectedRepuestoPrice = r.getPrecio(); // Actualiza el precio si es el seleccionado
                                            }
                                %>
                                <option value="<%= r.getId() %>" <%= selected %>><%= r.getNombre() %></option>
                                <%
                                        }
                                    }
                                %>
                            </select>
                            <input type="number" name="spareParts[0].quantity" placeholder="Cantidad" min="1" value="<%= selectedRepuestoQty %>" required onchange="this.form.submit()">
                            <input type="number" name="spareParts[0].price" placeholder="Precio Unitario" min="0" step="0.01" value="<%= String.format("%.2f", selectedRepuestoPrice) %>" readonly required>
                            <button type="button" class="remove-button" disabled>X</button>
                        </div>
                        <%
                            // Si necesitas múltiples repuestos fijos sin JS, tendrías que duplicar el bloque de arriba
                            // y cambiar los índices (spareParts[1].id, spareParts[1].quantity, etc.)
                            // y manejar los valores seleccionados para cada uno en tu Servlet.
                        %>
                    </div>
                </div>

                <div class="item-section">
                    <div class="item-header">
                        <h3>Servicios Requeridos</h3>
                        <button type="button" class="add-button" disabled>+ Agregar Servicio</button>
                    </div>
                    <div id="servicesContainer">
                        <%
                            // Asume que los servicios también son pasados de vuelta por el Servlet
                            // de forma similar a los repuestos.
                            String serviceName1 = (String) request.getAttribute("serviceName1") != null ? (String) request.getAttribute("serviceName1") : "";
                            double servicePrice1 = (Double) request.getAttribute("servicePrice1") != null ? (Double) request.getAttribute("servicePrice1") : 0.0;
                        %>
                        <div class="item-entry">
                            <input type="text" name="services[0].name" placeholder="Nombre del Servicio" value="${serviceName1}" required>
                            <input type="number" name="services[0].price" placeholder="Costo del Servicio" min="0" step="0.01" value="<%= String.format("%.2f", servicePrice1) %>" required onchange="this.form.submit()">
                            <button type="button" class="remove-button" disabled>X</button>
                        </div>
                        <%
                            String serviceName2 = (String) request.getAttribute("serviceName2") != null ? (String) request.getAttribute("serviceName2") : "";
                            double servicePrice2 = (Double) request.getAttribute("servicePrice2") != null ? (Double) request.getAttribute("servicePrice2") : 0.0;
                        %>
                        <div class="item-entry">
                            <input type="text" name="services[1].name" placeholder="Nombre del Servicio" value="${serviceName2}" required>
                            <input type="number" name="services[1].price" placeholder="Costo del Servicio" min="0" step="0.01" value="<%= String.format("%.2f", servicePrice2) %>" required onchange="this.form.submit()">
                            <button type="button" class="remove-button" disabled>X</button>
                        </div>
                    </div>
                </div>

                <div class="total-price">
                    <label for="totalCost">Costo Total Estimado:</label>
                    <input type="text" id="totalCost" name="totalCost" value="₡<%= String.format("%.2f", (Double) (request.getAttribute("calculatedTotalCost") != null ? request.getAttribute("calculatedTotalCost") : 0.0)) %>" readonly>
                </div>

                <div>
                    <input type="submit" name="registrar" value="Registrar Orden de Trabajo">
                </div>
            </form>
        </main>
        <script>
            // Este bloque de fecha de ingreso puede permanecer si lo necesitas
            // para inicializar la fecha en el lado del cliente si el servlet no la provee.
            document.addEventListener('DOMContentLoaded', () => {
                const fechaIngresoInput = document.getElementById('fechaIngreso');
                if (!fechaIngresoInput.value) { // Solo si el servlet no la estableció
                    const today = new Date();
                    const dd = String(today.getDate()).padStart(2, '0');
                    const mm = String(today.getMonth() + 1).padStart(2, '0');
                    const yyyy = today.getFullYear();
                    // Este formato es para <input type="date">.
                    // Si 'fechaIngreso' es type="text", y el servlet no la rellena, considera cómo la formateas.
                    // fechaIngresoInput.value = `${yyyy}-${mm}-${dd}`;
                }
            });
        </script>
    </body>
</html>