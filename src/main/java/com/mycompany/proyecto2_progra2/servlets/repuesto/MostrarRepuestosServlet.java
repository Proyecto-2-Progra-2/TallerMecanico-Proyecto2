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
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

/**
 *
 * @author luiss
 */
public class MostrarRepuestosServlet extends HttpServlet {
    
    private RepuestosData repuestosData;
    private ArrayList<Repuesto> repuestos;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.repuestosData = new RepuestosData();
            
            // => Traemos los repuestos del xml
            this.repuestos = this.repuestosData.findAll();
            
            req.setAttribute("repuesto", this.repuestos);
            req.getRequestDispatcher("mostrar_repuestos.jsp").forward(req, resp);
        } catch (JDOMException ex) {
            Logger.getLogger(MostrarRepuestosServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MostrarRepuestosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}


