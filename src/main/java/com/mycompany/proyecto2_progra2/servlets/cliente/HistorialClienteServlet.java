package com.mycompany.proyecto2_progra2.controller;

import com.mycompany.proyecto2_progra2.data.OrdenTrabajoData;
import com.mycompany.proyecto2_progra2.domain.OrdenTrabajo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import org.jdom2.JDOMException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "HistorialClienteServlet", urlPatterns = {"/historialCliente"})
public class HistorialClienteServlet extends HttpServlet {

    private OrdenTrabajoData ordenTrabajoData;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            this.ordenTrabajoData = new OrdenTrabajoData();
            String clienteId = req.getParameter("id");

            // buscar al cliente o en nuestro caso el dueño 
            ArrayList<OrdenTrabajo> historial = this.ordenTrabajoData.findByClienteId(clienteId);

            req.setAttribute("clienteId", clienteId);
            req.setAttribute("historial", historial);
            req.getRequestDispatcher("historialCliente.jsp").forward(req, resp);

        } catch (JDOMException ex) {
            Logger.getLogger(HistorialClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HistorialClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
