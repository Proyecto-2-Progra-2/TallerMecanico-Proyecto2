package com.mycompany.proyecto2_progra2.servlets.vehiculo;

import com.mycompany.proyecto2_progra2.data.VehiculoData;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

@WebServlet("/eliminarVehiculo")
public class EliminarVehiculoServlet extends HttpServlet {

    private VehiculoData vehiculoData;

    @Override
    public void init() {
        try {
            vehiculoData = new VehiculoData();
        } catch (IOException | JDOMException ex) {
            Logger.getLogger(EliminarVehiculoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String placa = req.getParameter("placa");
        System.out.println("Eliminando vehículo con placa: " + placa);

        try {
            vehiculoData.eliminar(placa);
            resp.sendRedirect("mostrarVehiculos?mensaje=eliminado");

        } catch (Exception ex) {
            ex.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar el vehículo");
        }
    }
}
