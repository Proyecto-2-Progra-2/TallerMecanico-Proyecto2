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
public class AgregarRepuestosServlet extends HttpServlet {
    
    private RepuestosData repuestosData;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.repuestosData = new RepuestosData();
            ArrayList<Repuesto> repuestos = this.repuestosData.findAll();
            
            req.setAttribute("repuestos", repuestos);
            req.getRequestDispatcher("agregar_repuestos.jsp").forward(req, resp);
        } catch (JDOMException ex) {
            Logger.getLogger(AgregarRepuestosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}