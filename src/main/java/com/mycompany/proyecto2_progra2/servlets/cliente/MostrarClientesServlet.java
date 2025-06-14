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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

public class MostrarClientesServlet extends HttpServlet {
    
    private ClienteData clienteData;
    private ArrayList<Cliente> clientes;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.clienteData = new ClienteData();
            
            // => Traemos los clientes del xml
            this.clientes = this.clienteData.findAll();
            
            req.setAttribute("clientes", this.clientes);
            req.getRequestDispatcher("mostrar_clientes.jsp").forward(req, resp);
        } catch (JDOMException ex) {
            Logger.getLogger(MostrarClientesServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MostrarClientesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
