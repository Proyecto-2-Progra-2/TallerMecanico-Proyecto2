/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto2_progra2.servlets.cliente;

import com.mycompany.proyecto2_progra2.data.ClienteData;
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
public class EliminarClienteServlet extends HttpServlet {

    private ClienteData clienteData;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.clienteData = new ClienteData();
            String id = req.getParameter("id");
            this.clienteData.eliminar(id);
            resp.sendRedirect("mostrarClientes?mensaje=eliminado");
        } catch (JDOMException ex) {
            Logger.getLogger(EliminarClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar el cliente");
        }
    }
    
}
