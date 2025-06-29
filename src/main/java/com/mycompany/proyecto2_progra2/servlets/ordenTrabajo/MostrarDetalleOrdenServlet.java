package com.mycompany.proyecto2_progra2.servlets.ordenTrabajo;


import com.mycompany.proyecto2_progra2.data.OrdenDetalleData;
import com.mycompany.proyecto2_progra2.data.OrdenTrabajoData;
import com.mycompany.proyecto2_progra2.data.RepuestosData;
import com.mycompany.proyecto2_progra2.domain.DetalleOrden;
import com.mycompany.proyecto2_progra2.domain.Repuesto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MostrarDetalleOrdenServlet extends HttpServlet {

    private OrdenDetalleData detalleData;
    private RepuestosData repuestoData;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idDetalle = req.getParameter("idDetalleOrden");

        if (idDetalle == null || idDetalle.trim().isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/listadoOrdenes?mensaje=detalleNoEncontrado");
            return;
        }

        try {
            detalleData = new OrdenDetalleData();
            repuestoData = new RepuestosData();

            DetalleOrden detalleOrden = detalleData.findOne(idDetalle.trim());

            if (detalleOrden == null) {
                resp.sendRedirect(req.getContextPath() + "/listadoOrdenes?mensaje=detalleNoEncontrado");
                return;
            }

            // Obtener los repuestos (puedes filtrar o obtener todos, según tu lógica)
            ArrayList<Repuesto> repuestosList = repuestoData.findAll();

            req.setAttribute("ordenDetalle", detalleOrden);
            req.setAttribute("repuestosList", repuestosList);

            req.getRequestDispatcher("/ordenTrabajo/ordenDetalle_view.jsp").forward(req, resp);

        } catch (Exception ex) {
            Logger.getLogger(MostrarDetalleOrdenServlet.class.getName()).log(Level.SEVERE, null, ex);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener el detalle de la orden.");
        }
    }
}
