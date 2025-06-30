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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        
    }
}
