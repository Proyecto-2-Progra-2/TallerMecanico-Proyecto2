package com.mycompany.proyecto2_progra2.servlets.ordenTrabajo;

import com.mycompany.proyecto2_progra2.data.VehiculoData;
import com.mycompany.proyecto2_progra2.domain.Vehiculo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;



/**
 *
 * @author jime
 */
public class MostrarVehiculoServlet extends HttpServlet { 



    private VehiculoData vehiculoData;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            this.vehiculoData = new VehiculoData();
            ArrayList<Vehiculo> vehiculos = new ArrayList<>();
            vehiculos = this.vehiculoData.findAll(); 

            req.setAttribute("vehiculos", vehiculos); 
            req.getRequestDispatcher("mostrar_vehiculos.jsp").forward(req, resp); 
        } catch (JDOMException ex) {
            Logger.getLogger(MostrarVehiculoServlet.class.getName()).log(Level.SEVERE, "Error al cargar los vehículos desde XML", ex);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error interno del servidor al intentar mostrar los vehículos.");
        } catch (Exception ex) {
            Logger.getLogger(MostrarVehiculoServlet.class.getName()).log(Level.SEVERE, "Error inesperado al intentar mostrar los vehículos", ex);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Ocurrió un error inesperado al cargar la lista de vehículos.");
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String placa = req.getParameter("vehiculoPlaca");
        try {
            this.vehiculoData = new VehiculoData();
            if (placa != null && !placa.trim().isEmpty()) {
                Vehiculo vehiculo = vehiculoData.findOne(placa.trim());
                if (vehiculo != null) {
                    // Lo metemos en una lista para reutilizar la JSP que recibe ArrayList<Vehiculo>
                    ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
                    listaVehiculos.add(vehiculo);

                    req.setAttribute("vehiculos", listaVehiculos);
                    req.getRequestDispatcher("mostrar_vehiculos.jsp").forward(req, resp);
                    return;
                }
            }
            // Si no encontró vehículo o parámetro inválido, redirigir o mostrar mensaje
            resp.sendRedirect(req.getContextPath() + "/listadoOrdenes?mensaje=vehiculoNoEncontrado");
        } catch (JDOMException ex) {
            Logger.getLogger(MostrarVehiculoServlet.class.getName()).log(Level.SEVERE, null, ex);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al buscar el vehículo.");
        }
    }

}

