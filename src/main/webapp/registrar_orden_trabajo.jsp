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
            .add-button {
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
            .add-button:hover {
                background-color: #218838;
                transform: translateY(-1px);
            }
            .remove-button {
                background-color: #dc3545;
                color: white;
                padding: 8px 12px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-size: 0.85em;
                transition: background-color 0.3s ease;
                margin-left: 10px;
            }
            .remove-button:hover {
                background-color: #c82333;
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
            <form action="registrarOrdenTrabajo" method="POST">
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
                    <textarea id="descripcion" name="descripcion" rows="4" required placeholder="Detalle los trabajos a realizar..."></textarea>
                </div>

                <div>
                    <label for="estado">Estado Actual:</label>
                    <select id="estado" name="estado" required>
                        <option value="diagnóstico">Diagnóstico</option>
                        <option value="en reparación">En reparación</option>
                        <option value="listo para entrega">Listo para entrega</option>
                        <option value="entregado">Entregado</option>
                    </select>
                </div>
                <div>
                    <label for="fechaDevolucion">Fecha Estimada de Devolución:</label>
                    <input type="date" id="fechaDevolucion" name="fechaDevolucion" required>
                </div>

                <div style="grid-column: 1 / -1;">
                    <label for="detalleRecepcion">Detalles en la Recepción del Vehículo:</label>
                    <textarea id="detalleRecepcion" name="detalleRecepcion" rows="4" required placeholder="Condición del vehículo al momento de la recepción..."></textarea>
                </div>

                <div>
                    <label for="vehiculo">Placa del Vehículo:</label>
                    <input type="text" id="vehiculo" name="vehiculo" required placeholder="Ej: ABC-123">
                </div>
                <hr>

                <div class="item-section">
                    <div class="item-header">
                        <h3>Repuestos Requeridos</h3>
                        <button type="button" class="add-button" onclick="addSparePart()">+ Agregar Repuesto</button>
                    </div>
                    <div id="sparePartsContainer"></div>
                </div>

                <div class="item-section">
                    <div class="item-header">
                        <h3>Servicios Requeridos</h3>
                        <button type="button" class="add-button" onclick="addService()">+ Agregar Servicio</button>
                    </div>
                    <div id="servicesContainer"></div>
                </div>

                <div class="total-price">
                    <label for="totalCost">Costo Total Estimado:</label>
                    <input type="text" id="totalCost" name="totalCost" value="₡0.00" readonly>
                </div>

                <div>
                    <input type="submit" name="registrar" value="Registrar Orden de Trabajo">
                </div>
            </form>
        </main>
        <script>
            let sparePartCount = 0;
            let serviceCount = 0;

            // Cargar los repuestos desde el servidor al arreglo JS
            const repuestosData = [];
            <%
                ArrayList<Repuesto> availableRepuestos = (ArrayList<Repuesto>) request.getAttribute("repuestosList");
                if (availableRepuestos == null) {
                    availableRepuestos = new ArrayList<>();
                }
                for (Repuesto r : availableRepuestos) {
            %>
                    repuestosData.push({
                        id: "<%= r.getId() %>",
                        nombre: "<%= r.getNombre() %>",
                        precio: <%= r.getPrecio() %>
                    });
            <% } %>

            /**
             * Añade una nueva fila para seleccionar un repuesto.
             */
            function addSparePart() {
                const container = document.getElementById('sparePartsContainer');
                const index = sparePartCount; // Usamos un contador para asegurar nombres únicos en el array de Spring

                const div = document.createElement('div');
                div.classList.add('item-entry');

                // Construye las opciones del select dinámicamente con los datos de repuestos
                let optionsHTML = '<option value="">Seleccione un repuesto</option>';
                repuestosData.forEach(r => {
                    optionsHTML += `<option value="${r.id}" data-price="${r.precio}">${r.nombre}</option>`;
                });

                div.innerHTML = `
                    <select name="spareParts[${index}].id" required onchange="updateSparePartPrice(this, ${index})">
                        ${optionsHTML}
                    </select>
                    <input type="number" name="spareParts[${index}].quantity" placeholder="Cantidad" min="1" value="1" required onchange="calculateTotal()">
                    <input type="number" name="spareParts[${index}].price" placeholder="Precio Unitario" min="0" step="0.01" value="0.00" readonly required>
                    <button type="button" class="remove-button" onclick="removeParent(this); calculateTotal();">X</button>
                `;

                container.appendChild(div);
                sparePartCount++; // Incrementa el contador para el siguiente repuesto
                calculateTotal(); // Recalcula el total al añadir un nuevo elemento
            }

            /**
             * Actualiza el campo de precio de un repuesto cuando se selecciona una opción en el select.
             * @param {HTMLSelectElement} selectElement - El elemento <select> que disparó el cambio.
             * @param {number} index - El índice del repuesto en el formulario (usado para el nombre del input).
             */
            function updateSparePartPrice(selectElement, index) {
                const selectedOption = selectElement.options[selectElement.selectedIndex];
                // Obtiene el precio del atributo data-price; si no es un número, usa 0
                const price = parseFloat(selectedOption.getAttribute('data-price')) || 0;

                // Encuentra el input de precio asociado a este select
                const parentDiv = selectElement.parentNode;
                const priceInput = parentDiv.querySelector(`input[name="spareParts[${index}].price"]`);

                // Actualiza el valor del input de precio y formatea a dos decimales
                priceInput.value = price.toFixed(2);
                calculateTotal(); // Recalcula el total después de actualizar el precio
            }

            /**
             * Añade una nueva fila para ingresar un servicio.
             */
            function addService() {
                const container = document.getElementById('servicesContainer');
                const index = serviceCount; // Usamos un contador para nombres únicos

                const div = document.createElement('div');
                div.classList.add('item-entry');
                div.innerHTML = `
                    <input type="text" name="services[${index}].name" placeholder="Nombre del Servicio" required>
                    <input type="number" name="services[${index}].price" placeholder="Costo del Servicio" min="0" step="0.01" value="0.00" required onchange="calculateTotal()">
                    <button type="button" class="remove-button" onclick="removeParent(this); calculateTotal();">X</button>
                `;
                container.appendChild(div);
                serviceCount++; // Incrementa el contador para el siguiente servicio
                calculateTotal(); // Recalcula el total al añadir un nuevo elemento
            }

            /**
             * Elimina el elemento padre de un botón (usado para eliminar filas de repuestos/servicios).
             * @param {HTMLButtonElement} button - El botón "X" que fue clickeado.
             */
            function removeParent(button) {
                button.parentNode.remove();
            }

            /**
             * Calcula el costo total de todos los repuestos y servicios.
             */
            function calculateTotal() {
                let total = 0;

                // Suma los costos de los repuestos
                document.querySelectorAll('#sparePartsContainer .item-entry').forEach(item => {
                    // Asegúrate de que los inputs existan antes de intentar acceder a sus valores
                    const quantityInput = item.querySelector('input[name$=".quantity"]');
                    const priceInput = item.querySelector('input[name$=".price"]');
                    
                    if (quantityInput && priceInput) {
                        const quantity = parseFloat(quantityInput.value) || 0;
                        const price = parseFloat(priceInput.value) || 0;
                        total += quantity * price;
                    }
                });

                // Suma los costos de los servicios
                document.querySelectorAll('#servicesContainer .item-entry').forEach(item => {
                    const priceInput = item.querySelector('input[name$=".price"]');
                    if (priceInput) {
                        const price = parseFloat(priceInput.value) || 0;
                        total += price;
                    }
                });

                // Actualiza el campo de costo total
                document.getElementById('totalCost').value = '₡' + total.toFixed(2);
            }

            // --- LLAMADA INICIAL AL CARGAR LA PÁGINA ---
            document.addEventListener('DOMContentLoaded', () => {
                // Asegurarse de que al menos un select de repuesto y un servicio se muestren al cargar
                addSparePart(); // Muestra el primer select de repuestos
                addService();   // Muestra el primer campo de servicio

                calculateTotal(); // Inicializa el cálculo del total

                // Este bloque para la fecha de ingreso puede permanecer si lo necesitas
                // para inicializar la fecha en el lado del cliente si el servlet no la provee.
                const fechaIngresoInput = document.getElementById('fechaIngreso');
                if (!fechaIngresoInput.value) { // Solo si el servlet no la estableció
                    const today = new Date();
                    const dd = String(today.getDate()).padStart(2, '0');
                    const mm = String(today.getMonth() + 1).padStart(2, '0');
                    const yyyy = today.getFullYear();
                    // Si 'fechaIngreso' es tipo text y el servlet no lo ha rellenado,
                    // esta línea lo formatearía para un input type="date".
                    // Como el servlet ya lo llena con "dd/MM/yyyy", esta línea no es estrictamente necesaria
                    // a menos que cambies el input a type="date".
                    // fechaIngresoInput.value = `${yyyy}-${mm}-${dd}`;
                }
            });
        </script>
    </body>
</html>