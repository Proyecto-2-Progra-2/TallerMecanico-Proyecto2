/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto2_progra2.servlets.repuesto;

import com.mycompany.proyecto2_progra2.data.RepuestosData;
import com.mycompany.proyecto2_progra2.domain.Repuesto;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

/**
 *
 * @author luiss
 */
public class ActualizarRepuestoServlet extends HttpServlet {

    private RepuestosData repuestosData;

    @Override
    public void init() {
        try {
            repuestosData = new RepuestosData();
        } catch (IOException | JDOMException ex) {
            Logger.getLogger(ActualizarRepuestoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String nombre = req.getParameter("nombre");
        int cantidad = Integer.parseInt(req.getParameter("cantidad"));
        double precio = Double.parseDouble(req.getParameter("precio"));
        
        Repuesto repuesto = new Repuesto(id, nombre, cantidad, precio);
        this.repuestosData.actualizar(repuesto);  // Método que debes tener para actualizar
        // Rediriges a la lista o confirmación
        resp.sendRedirect("mostrarRepuestos");
    }
}
