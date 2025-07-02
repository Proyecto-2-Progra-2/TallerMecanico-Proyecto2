/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto2_progra2.servlets.ordenTrabajo;

import com.mycompany.proyecto2_progra2.data.OrdenDetalleData;
import com.mycompany.proyecto2_progra2.domain.DetalleOrden;
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
 * @author jeffr
 */
public class MostrarDetalleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            OrdenDetalleData detalleData = new OrdenDetalleData();
            DetalleOrden d = detalleData.findOne(req.getParameter("detalle"));
            req.setAttribute("detalleOrden", d);
            
            req.getRequestDispatcher("mostrar_detalle_orden.jsp").forward(req, resp);
        } catch (JDOMException ex) {
            Logger.getLogger(MostrarDetalleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
}
