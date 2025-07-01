/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto2_progra2.servlets.cliente;

import com.mycompany.proyecto2_progra2.data.ClienteData;
import com.mycompany.proyecto2_progra2.domain.Cliente;
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
 * @author jeffr
 */
public class RegistrarClienteServlet extends HttpServlet {

    private ClienteData clienteData;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registrar_cliente.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.clienteData = new ClienteData();
            Cliente cliente = new Cliente(
                    req.getParameter("id"), 
                    req.getParameter("nombre"), 
                    req.getParameter("primerApellido"),
                    req.getParameter("segundoApellido"), 
                    Integer.parseInt(req.getParameter("telefono")),
                    req.getParameter("direccion"), 
                    req.getParameter("email")
            );
            
            this.clienteData.insertar(cliente);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        
            //hacer una ventanaa de registrado exitoso
        }catch (JDOMException | FileNotFoundException ex) {
            Logger.getLogger(RegistrarClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            // Detecta si es el caso de cliente ya registrado
            if (ex.getMessage() != null && ex.getMessage().contains("Ya existe un cliente")) {
                req.setAttribute("error", "El cliente con ID " + req.getParameter("id") + " ya está registrado.");
                req.getRequestDispatcher("registrar_cliente.jsp").forward(req, resp);
            } else {
                Logger.getLogger(RegistrarClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al registrar el cliente.");
            }
        } 
        
    }

}
