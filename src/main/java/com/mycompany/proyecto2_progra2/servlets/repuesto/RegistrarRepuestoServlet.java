/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto2_progra2.servlets.repuesto;

import com.mycompany.proyecto2_progra2.data.ClienteData;
import com.mycompany.proyecto2_progra2.data.RepuestosData;
import com.mycompany.proyecto2_progra2.domain.Cliente;
import com.mycompany.proyecto2_progra2.domain.Repuesto;
import com.mycompany.proyecto2_progra2.servlets.cliente.RegistrarClienteServlet;
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

/**
 *
 * @author luiss
 */
public class RegistrarRepuestoServlet extends HttpServlet {

    private RepuestosData repuestosData;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registrar_repuesto.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.repuestosData = new RepuestosData();
            Repuesto repuesto = new Repuesto(req.getParameter("id"), req.getParameter("nombre"), Integer.parseInt(req.getParameter("cantidad")),Double.parseDouble(req.getParameter("precio")));
            this.repuestosData.insertar(repuesto);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            //hacer una ventanaa de registrado exitoso
        } catch (JDOMException ex) {
            Logger.getLogger(RegistrarClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RegistrarClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

}
