/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto2_progra2.servlets.ordenTrabajo;

import com.mycompany.proyecto2_progra2.data.OrdenTrabajoData;
import com.mycompany.proyecto2_progra2.domain.OrdenTrabajo;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

/**
 *
 * @author jeffr
 */
public class ModificarOrdenTrabajoServlet extends HttpServlet {

    private OrdenTrabajoData ordenData;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.ordenData = new OrdenTrabajoData();
            OrdenTrabajo orden = this.ordenData.findOne(req.getParameter("id"));
            
            req.setAttribute("orden", orden);
            req.getRequestDispatcher("modificar_orden_trabajo.jsp").forward(req, resp);
        } catch (JDOMException ex) {
            Logger.getLogger(ModificarOrdenTrabajoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.ordenData = new OrdenTrabajoData();
            OrdenTrabajo orden = this.ordenData.findOne(req.getParameter("id"));
            
            String fechaDevolucion = req.getParameter("fechaDevolucion");
            LocalDate fecha = LocalDate.parse(fechaDevolucion);
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaFormateada = fecha.format(formato);
            
            this.ordenData.modificar(new OrdenTrabajo(req.getParameter("id"), 
                    req.getParameter("descripcion"), orden.getFechaIngreso(), 
                    req.getParameter("estado"), req.getParameter("detalleRecepcion"), 
                    fechaFormateada, orden.getVehiculo(), orden.getDetalleOrden()));
            
            ArrayList<OrdenTrabajo> ordenes = new ArrayList<>();
            ordenes = this.ordenData.findAll();
            
            req.setAttribute("ordenes", ordenes);
            req.getRequestDispatcher("mostrar_ordenes_trabajo.jsp").forward(req, resp);
        } catch (JDOMException ex) {
            Logger.getLogger(ModificarOrdenTrabajoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
