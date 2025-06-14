/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto2_progra2.servlets.vehiculo;

import com.mycompany.proyecto2_progra2.data.VehiculoData;
import com.mycompany.proyecto2_progra2.domain.Vehiculo;
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

public class MostrarVehiculosServlet extends HttpServlet {

    private VehiculoData vehiculoData;
    private ArrayList<Vehiculo> vehiculos;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.vehiculoData = new VehiculoData();
            this.vehiculos = this.vehiculoData.findAll();
            
            req.setAttribute("vehiculos", this.vehiculos);
            req.getRequestDispatcher("mostrar_vehiculos.jsp").forward(req, resp);
        } catch (JDOMException ex) {
            Logger.getLogger(MostrarVehiculosServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MostrarVehiculosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
