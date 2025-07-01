package com.mycompany.proyecto2_progra2.servlets.ordenTrabajo;

import com.mycompany.proyecto2_progra2.data.OrdenTrabajoData;
import com.mycompany.proyecto2_progra2.domain.OrdenTrabajo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

// para el historial x placa

public class HistorialClientePorPlacaServlet extends HttpServlet {

    private OrdenTrabajoData ordenTrabajoData;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String placa = req.getParameter("vehiculoPlaca");

        try {
            ordenTrabajoData = new OrdenTrabajoData();
            ArrayList<OrdenTrabajo> todasLasOrdenes = ordenTrabajoData.findAll();// metodo nosotros
            ArrayList<OrdenTrabajo> ordenesFiltradas = new ArrayList<>();

            for (OrdenTrabajo orden : todasLasOrdenes) {
                if (orden.getVehiculo().equals(placa)) {
                    ordenesFiltradas.add(orden);
                }
            }

            req.setAttribute("clienteId", placa); 
            req.setAttribute("placaSeleccionada", placa);
            req.setAttribute("historial", ordenesFiltradas);
            req.getRequestDispatcher("historialCliente.jsp").forward(req, resp);

        } catch (JDOMException ex) {
            Logger.getLogger(HistorialClientePorPlacaServlet.class.getName()).log(Level.SEVERE, "Error leyendo órdenes desde XML", ex);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar el historial.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); // opcional, para pruebas GET también
    }
}
