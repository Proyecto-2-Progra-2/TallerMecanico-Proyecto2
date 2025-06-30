/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto2_progra2.servlets.detalleOrden;

import com.mycompany.proyecto2_progra2.data.OrdenDetalleData;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

/**
 *
 * @author jeffr
 */
public class RegistrarDetalleOrdenServlet extends HttpServlet {

    private OrdenDetalleData detalleData;
    private String id;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.detalleData = new OrdenDetalleData();
            do {
                this.id = generarID();
            } while (this.detalleData.existe(this.id));
            req.setAttribute("id", this.id);
            req.getRequestDispatcher("registrar_detalle_orden.jsp").forward(req, resp);
        } catch (JDOMException ex) {
            Logger.getLogger(RegistrarDetalleOrdenServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
    private String generarID() {
        SecureRandom secureRandom = new SecureRandom();
        int numero = secureRandom.nextInt(1_000_000);
        String id = String.format("%06d", numero);
        return id;
    }
    
}
