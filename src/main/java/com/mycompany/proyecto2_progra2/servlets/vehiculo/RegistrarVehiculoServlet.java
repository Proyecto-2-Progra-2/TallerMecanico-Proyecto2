/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto2_progra2.servlets.vehiculo;

import com.mycompany.proyecto2_progra2.data.ClienteData;
import com.mycompany.proyecto2_progra2.data.VehiculoData;
import com.mycompany.proyecto2_progra2.domain.Vehiculo;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

public class RegistrarVehiculoServlet extends HttpServlet {

    private VehiculoData vehiculoData;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registrar_vehiculo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
           this.vehiculoData = new VehiculoData();
           Vehiculo v = new Vehiculo(
                   req.getParameter("placa"), 
                   req.getParameter("color"), 
                   req.getParameter("marca"), 
                   req.getParameter("estilo"), 
                   req.getParameter("VIN"), 
                   req.getParameter("cilindraje"), 
                   Integer.parseInt(req.getParameter("annio")), 
                   new ClienteData().findOne(req.getParameter("duennio"))
           );
           
           this.vehiculoData.insertar(v);
           req.getRequestDispatcher("index.jsp").forward(req, resp);//deberia regresar al index?
       } catch (JDOMException | FileNotFoundException ex) {
           Logger.getLogger(RegistrarVehiculoServlet.class.getName()).log(Level.SEVERE, null, ex);
       }catch (IOException ex) {
            // Detecta si es el caso de vehñiculo ya registrado
            if (ex.getMessage() != null && ex.getMessage().contains("Ya existe un vehículo")) {
                req.setAttribute("error", "El vehículo con la placa " + req.getParameter("placa") + " ya está registrada.");
                req.getRequestDispatcher("registrar_vehiculo.jsp").forward(req, resp);
            } else {
                Logger.getLogger(RegistrarVehiculoServlet.class.getName()).log(Level.SEVERE, null, ex);
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al registrar el vehículo.");
            }
        } 
       
    }
    
}
