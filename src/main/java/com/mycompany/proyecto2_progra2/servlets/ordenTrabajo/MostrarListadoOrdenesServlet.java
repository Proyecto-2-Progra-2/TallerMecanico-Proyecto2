package com.mycompany.proyecto2_progra2.servlets.ordenTrabajo;

import com.mycompany.proyecto2_progra2.data.OrdenTrabajoData;
import com.mycompany.proyecto2_progra2.domain.DetalleOrden;
import com.mycompany.proyecto2_progra2.domain.OrdenTrabajo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;


public class MostrarListadoOrdenesServlet extends HttpServlet {

    private OrdenTrabajoData ordenTrabajoData;

  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
        ordenTrabajoData = new OrdenTrabajoData();

        try {
            ArrayList<OrdenTrabajo> ordenesList = ordenTrabajoData.findAll();

            // Por cada orden, cargamos los repuestos asociados y los asignamos
            for (OrdenTrabajo orden : ordenesList) {
                var repuestos = ordenTrabajoData.findRepuestosPorOrden(orden.getId());
                if (orden.getDetalleOrden() == null) {
                    orden.setDetalleOrden(new DetalleOrden()); // crea detalle si es null
                }
                orden.getDetalleOrden().setRepuestos(repuestos);
            }

            req.setAttribute("ordenesList", ordenesList);
            req.getRequestDispatcher("/ordenes_listado.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "No se pudo cargar la lista de órdenes.");
        }
    } catch (JDOMException ex) {
        Logger.getLogger(MostrarListadoOrdenesServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
}

}
