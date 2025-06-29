package com.mycompany.proyecto2_progra2.servlets.ordenTrabajo;

import com.mycompany.proyecto2_progra2.data.OrdenTrabajoData;
import com.mycompany.proyecto2_progra2.domain.DetalleOrden;
import com.mycompany.proyecto2_progra2.domain.OrdenTrabajo;
import com.mycompany.proyecto2_progra2.domain.Repuesto;
import com.mycompany.proyecto2_progra2.domain.Servicio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

public class MostrarFacturaOrdenTrabajoServlet extends HttpServlet {

    private OrdenTrabajoData ordenTrabajoData;

    @Override
    public void init() throws ServletException {
        try {
            ordenTrabajoData = new OrdenTrabajoData();
        } catch (IOException | JDOMException ex) {
            Logger.getLogger(MostrarFacturaOrdenTrabajoServlet.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException("Error inicializando OrdenTrabajoData", ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String id = req.getParameter("id");

        if (id == null || id.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de orden no proporcionado");
            return;
        }

        try {
            OrdenTrabajo orden = ordenTrabajoData.findOne(id);

            if (orden == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Orden no encontrada");
                return;
            }

            DetalleOrden detalle = orden.getDetalleOrden();
            if (detalle == null) {
                detalle = new DetalleOrden(); 
            }

            double total = 0.0;

            for (Repuesto r : detalle.getRepuestos()) {
                total += r.getPrecio() * r.getCantidad();
            }

            for (Servicio s : detalle.getServicios()) {
                total += s.getPrecio();
            }

            // Setear datos como atributos
            req.setAttribute("id", orden.getId());
            req.setAttribute("fechaIngreso", orden.getFechaIngreso());
            req.setAttribute("vehiculo", orden.getVehiculo().getPlaca());
            req.setAttribute("descripcion", orden.getDescripcion());
            req.setAttribute("estado", orden.getEstado());
            req.setAttribute("fechaDevolucion", orden.getFechaDevolucion());
            req.setAttribute("spareParts", detalle.getRepuestos());
            req.setAttribute("services", detalle.getServicios());
            req.setAttribute("totalCost", total);

            req.getRequestDispatcher("/mostrar_ordenes_trabajo.jsp").forward(req, resp);

        } catch (Exception e) {
            Logger.getLogger(MostrarFacturaOrdenTrabajoServlet.class.getName()).log(Level.SEVERE, null, e);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar la orden");
        }
    }
}
