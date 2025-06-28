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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

/**
 *
 * @author jeffr
 */
public class MostrarOrdenesTrabajoServlet extends HttpServlet {
    
    private OrdenTrabajoData ordenData;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.ordenData = new OrdenTrabajoData();
            ArrayList<OrdenTrabajo> ordenes = new ArrayList<>();
            ordenes = this.ordenData.findAll();
            
            req.setAttribute("ordenes", ordenes);
            req.getRequestDispatcher("mostrar_ordenes_trabajo.jsp").forward(req, resp);
        } catch (JDOMException ex) {
            Logger.getLogger(MostrarOrdenesTrabajoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
