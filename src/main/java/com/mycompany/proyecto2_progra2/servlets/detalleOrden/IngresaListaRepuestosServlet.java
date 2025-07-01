/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto2_progra2.servlets.detalleOrden;

import com.mycompany.proyecto2_progra2.data.RepuestosData;
import com.mycompany.proyecto2_progra2.domain.Repuesto;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

/**
 *
 * @author jeffr
 */


public class IngresaListaRepuestosServlet extends HttpServlet {

    private RepuestosData repuestoData;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        try {
            this.repuestoData = new RepuestosData();

            // Obtener el ID del repuesto enviado por el botón
            String repuestoId = req.getParameter("id");
            Repuesto repuestoSeleccionado = repuestoData.findOne(repuestoId);

            // Obtener la sesión
            HttpSession session = req.getSession();

            // Obtener lista actual de repuestos agregados
            ArrayList<Repuesto> repuestosAgregados = (ArrayList<Repuesto>) session.getAttribute("repuestosAgregados");
            if (repuestosAgregados == null) {
                repuestosAgregados = new ArrayList<>();
            }

            // Evitar agregar duplicados
            boolean yaExiste = false;
            for (Repuesto r : repuestosAgregados) {
                if (r.getId().equalsIgnoreCase(repuestoId)) {
                    yaExiste = true;
                    break;
                }
            }

            if (!yaExiste && repuestoSeleccionado != null) {
                repuestosAgregados.add(repuestoSeleccionado);
            }

            // Guardar en sesión
            session.setAttribute("repuestosAgregados", repuestosAgregados);

            // Obtener todos los repuestos para la tabla general
            req.setAttribute("repuestos", repuestoData.findAll());

            // Redirigir a la interfaz
            req.getRequestDispatcher("agregar_repuestos.jsp").forward(req, response);

        } catch (JDOMException ex) {
            Logger.getLogger(IngresaListaRepuestosServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error procesando el XML.");
        }
    }
}
