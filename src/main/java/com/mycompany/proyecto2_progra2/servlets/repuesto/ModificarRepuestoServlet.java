/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto2_progra2.servlets.repuesto;

import com.mycompany.proyecto2_progra2.data.RepuestosData;
import com.mycompany.proyecto2_progra2.domain.Repuesto;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

/**
 *
 * @author luiss
 */
public class ModificarRepuestoServlet extends HttpServlet {

    private RepuestosData repuestosData;

    @Override
    public void init() {
        try {
            repuestosData = new RepuestosData();
        } catch (IOException | JDOMException ex) {
            Logger.getLogger(ModificarRepuestoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            Repuesto repuesto = repuestosData.findOne(id);
            req.setAttribute("repuesto", repuesto);
            // Usa ruta absoluta para evitar problemas
            req.getRequestDispatcher("/modificar_repuesto.jsp").forward(req, resp);
        } catch (Exception ex) {
            Logger.getLogger(ModificarRepuestoServlet.class.getName()).log(Level.SEVERE, null, ex);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al cargar el repuesto");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Obtener datos del formulario
            Repuesto repuesto = new Repuesto(
                req.getParameter("id"),
                req.getParameter("nombre"),             
                Integer.parseInt(req.getParameter("cantidad")),
                Double.parseDouble(req.getParameter("precio"))
            );

            // Actualizar cliente
            this.repuestosData.actualizar(repuesto);

            // Redirigir o volver al formulario con algún mensaje (aquí simplemente lo volvemos a cargar)
            req.setAttribute("repuesto", repuesto);
            req.setAttribute("mensaje", "Repuesto actualizado exitosamente");
            req.getRequestDispatcher("/modificar_repuesto.jsp").forward(req, resp);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModificarRepuestoServlet.class.getName()).log(Level.SEVERE, null, ex);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Archivo no encontrado");
        } catch (ServletException | IOException | NumberFormatException ex) {
            Logger.getLogger(ModificarRepuestoServlet.class.getName()).log(Level.SEVERE, null, ex);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error inesperado");
        }
    }

}
