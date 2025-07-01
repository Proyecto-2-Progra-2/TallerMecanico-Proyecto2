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

    private Repuesto repuesto;
    private RepuestosData repuestoData;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        try {
            this.repuestoData = new RepuestosData();
            this.repuesto = this.repuestoData.findOne(req.getParameter("id"));
            
            req.setAttribute("repuestoAgregado", this.repuesto);
            req.setAttribute("repuestos", this.repuestoData.findAll());
            req.getRequestDispatcher("agregar_repuestos.jsp").forward(req, response);
        } catch (JDOMException ex) {
            Logger.getLogger(IngresaListaRepuestosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
