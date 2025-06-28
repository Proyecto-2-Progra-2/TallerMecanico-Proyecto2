package com.mycompany.proyecto2_progra2.servlets.vehiculo;

import com.mycompany.proyecto2_progra2.data.ClienteData;
import com.mycompany.proyecto2_progra2.data.VehiculoData;
import com.mycompany.proyecto2_progra2.domain.Cliente;
import com.mycompany.proyecto2_progra2.domain.Vehiculo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

public class ModificarVehiculoServlet extends HttpServlet {

    private VehiculoData vehiculoData;

    @Override
    public void init() {
        try {
            vehiculoData = new VehiculoData();
        } catch (IOException | JDOMException ex) {
            Logger.getLogger(ModificarVehiculoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String placa = req.getParameter("placa");
        System.out.println("Placa recibida: " + placa);

        if (placa == null || placa.trim().isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parámetro placa es obligatorio");
            return;
        }

        try {
            Vehiculo vehiculo = vehiculoData.findOne(placa);
            if (vehiculo == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Vehículo no encontrado con placa: " + placa);
                return;
            }

            req.setAttribute("vehiculo", vehiculo);
            req.getRequestDispatcher("/modificar_vehiculo.jsp").forward(req, resp);

        } catch (Exception ex) {
            Logger.getLogger(ModificarVehiculoServlet.class.getName()).log(Level.SEVERE, null, ex);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al cargar el vehículo");
        }
    }

// doPost: verifica con el dueño
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String duennoId = req.getParameter("duennoId");
            ClienteData clienteData = new ClienteData();
            Cliente duenno = clienteData.findOne(duennoId);

            Vehiculo vehiculo = new Vehiculo(
                    req.getParameter("placa"),
                    req.getParameter("color"),
                    req.getParameter("marca"),
                    req.getParameter("estilo"),
                    req.getParameter("vin"),
                    req.getParameter("cilindraje"),
                    Integer.parseInt(req.getParameter("annio")),
                    duenno
            );

            vehiculoData.actualizar(vehiculo);

            req.setAttribute("vehiculo", vehiculo);
            req.setAttribute("mensaje", "Vehículo actualizado exitosamente");
            req.getRequestDispatcher("/modificar_vehiculo.jsp").forward(req, resp);

        } catch (Exception ex) {
            Logger.getLogger(ModificarVehiculoServlet.class.getName()).log(Level.SEVERE, null, ex);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error inesperado al modificar vehículo");
        }
    }
}
