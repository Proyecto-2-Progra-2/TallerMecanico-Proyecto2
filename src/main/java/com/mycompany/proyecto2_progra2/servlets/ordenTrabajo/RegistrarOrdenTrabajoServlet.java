package com.mycompany.proyecto2_progra2.servlets.ordenTrabajo;

import com.mycompany.proyecto2_progra2.data.OrdenTrabajoData;
import com.mycompany.proyecto2_progra2.data.VehiculoData;
import com.mycompany.proyecto2_progra2.domain.DetalleOrden;
import com.mycompany.proyecto2_progra2.domain.OrdenTrabajo;
import com.mycompany.proyecto2_progra2.domain.Repuesto;
import java.io.File; // Import for File
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.jdom2.JDOMException;

public class RegistrarOrdenTrabajoServlet extends HttpServlet {

    private OrdenTrabajoData ordenTrabajoData;
    private String id;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.ordenTrabajoData = new OrdenTrabajoData();
            do {
                this.id = generarID();
            } while (this.ordenTrabajoData.existe(this.id));

            LocalDate fechaIngreso = LocalDate.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaFormateada = fechaIngreso.format(formato);

            req.setAttribute("fechaIngreso", fechaFormateada);
            req.setAttribute("id", this.id);

            List<Repuesto> repuestosList = new ArrayList<>();
            try {
                // *** MODIFICACIÓN AQUÍ: Se usa la ruta absoluta directamente con java.io.File ***
                // ADVERTENCIA: Esta ruta es específica de tu sistema y no funcionará en otros entornos.
                String xmlFilePath = "C:\\Users\\jimen\\OneDrive\\Escritorio\\TallerMecanico\\TallerMecanico-Proyecto2\\xml\\repuestos.xml";
                File xmlFile = new File(xmlFilePath);

                if (!xmlFile.exists()) {
                    Logger.getLogger(RegistrarOrdenTrabajoServlet.class.getName())
                            .log(Level.WARNING, "XML file not found at the specified absolute path: " + xmlFilePath);
                    req.setAttribute("errorMessage", "Error: El archivo de repuestos no se encontró en la ruta especificada.");
                } else {
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(xmlFile); // Parsear directamente el objeto File
                    doc.getDocumentElement().normalize();

                    NodeList nList = doc.getElementsByTagName("repuesto");

                    for (int temp = 0; temp < nList.getLength(); temp++) {
                        Node nNode = nList.item(temp);

                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement = (Element) nNode;

                            String repuestoId = eElement.getElementsByTagName("id").item(0).getTextContent();
                            String nombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
                            int cantidad = Integer.parseInt(eElement.getElementsByTagName("cantidad").item(0).getTextContent());
                            double precio = Double.parseDouble(eElement.getElementsByTagName("precio").item(0).getTextContent());

                            // Usando el constructor de Repuesto con cantidad
                            Repuesto repuesto = new Repuesto(repuestoId, nombre, cantidad, precio);
                            repuestosList.add(repuesto);
                        }
                    }
                }
            } catch (Exception e) {
                Logger.getLogger(RegistrarOrdenTrabajoServlet.class.getName())
                        .log(Level.SEVERE, "Error al parsear el XML de repuestos desde la ruta local", e);
                req.setAttribute("errorMessage", "Error al cargar los repuestos: " + e.getMessage());
            }

            req.setAttribute("repuestosList", repuestosList);
            req.getRequestDispatcher("registrar_orden_trabajo.jsp").forward(req, resp);
        } catch (JDOMException ex) {
            Logger.getLogger(RegistrarOrdenTrabajoServlet.class.getName()).log(Level.SEVERE, null, ex);
            req.setAttribute("errorMessage", "Error interno al generar la ID de la orden.");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<Repuesto> repuestosUsadosEnOrden = new ArrayList<>();
            int i = 0;
            while (req.getParameter("spareParts[" + i + "].id") != null) {
                String repuestoId = req.getParameter("spareParts[" + i + "].id");
                String repuestoQuantityStr = req.getParameter("spareParts[" + i + "].quantity");
                String repuestoPriceStr = req.getParameter("spareParts[" + i + "].price");

                try {
                    int quantity = Integer.parseInt(repuestoQuantityStr);
                    double price = Double.parseDouble(repuestoPriceStr);

                    repuestosUsadosEnOrden.add(new Repuesto(repuestoId, "Nombre no disponible de formulario", quantity, price));
                } catch (NumberFormatException e) {
                    Logger.getLogger(RegistrarOrdenTrabajoServlet.class.getName())
                            .log(Level.WARNING, "Formato de número inválido para la cantidad o el precio del repuesto.", e);
                }
                i++;
            }

            ArrayList<DetalleOrden> serviciosUsadosEnOrden = new ArrayList<>();
            int j = 0;
            while (req.getParameter("services[" + j + "].name") != null) {
                String serviceName = req.getParameter("services[" + j + "].name");
                String servicePriceStr = req.getParameter("services[" + j + "].price");

                try {
                    double servicePrice = Double.parseDouble(servicePriceStr);

                    serviciosUsadosEnOrden.add(new DetalleOrden(null, serviceName, servicePrice, null));
                } catch (NumberFormatException e) {
                    Logger.getLogger(RegistrarOrdenTrabajoServlet.class.getName())
                            .log(Level.WARNING, "Formato de número inválido para el precio del servicio.", e);
                }
                j++;
            }

            this.ordenTrabajoData = new OrdenTrabajoData();

            String fechaDevolucion = req.getParameter("fechaDevolucion");
            LocalDate fecha = LocalDate.parse(fechaDevolucion);
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaFormateada = fecha.format(formato);

            DetalleOrden detallePrincipal = null;
            if (!serviciosUsadosEnOrden.isEmpty() || !repuestosUsadosEnOrden.isEmpty()) {
                double totalServicios = serviciosUsadosEnOrden.stream().mapToDouble(DetalleOrden::getPrecioTotal).sum();
                double totalRepuestos = repuestosUsadosEnOrden.stream().mapToDouble(r -> r.getCantidad() * r.getPrecio()).sum();
                String observacion = req.getParameter("descripcion");
                detallePrincipal = new DetalleOrden("some_detail_id", observacion, totalServicios + totalRepuestos, repuestosUsadosEnOrden);
            } else {
                detallePrincipal = new DetalleOrden("some_detail_id", "Sin detalles", 0.0, new ArrayList<>());
            }

            OrdenTrabajo orden = new OrdenTrabajo(req.getParameter("id"), req.getParameter("descripcion"),
                    req.getParameter("fechaIngreso"), req.getParameter("estado"), req.getParameter("detalleRecepcion"),
                    fechaFormateada, new VehiculoData().findOne(req.getParameter("vehiculo")),
                    detallePrincipal);
            this.ordenTrabajoData.insertar(orden);

            resp.sendRedirect("index.jsp");
        } catch (JDOMException ex) {
            Logger.getLogger(RegistrarOrdenTrabajoServlet.class.getName()).log(Level.SEVERE, null, ex);
            req.setAttribute("errorMessage", "Error al registrar la orden de trabajo.");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }

    private String generarID() {
        SecureRandom secureRandom = new SecureRandom();
        int numero = secureRandom.nextInt(1_000_000);
        String id = String.format("%06d", numero);
        return id;
    }
}