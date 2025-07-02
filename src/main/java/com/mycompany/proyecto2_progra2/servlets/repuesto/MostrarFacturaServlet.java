/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_progra2.servlets.repuesto;


import com.mycompany.proyecto2_progra2.data.ClienteData;
import com.mycompany.proyecto2_progra2.data.RepuestosData;
import com.mycompany.proyecto2_progra2.domain.Cliente;
import com.mycompany.proyecto2_progra2.domain.Repuesto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;
import java.io.FileNotFoundException;
/**
 *
 * @author jimen
 */
public class MostrarFacturaServlet extends HttpServlet {
    
    private RepuestosData repuestosData;
    private ClienteData clienteData;
    private ArrayList<Repuesto> repuestosAgregados;

   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
        repuestosAgregados = (ArrayList<Repuesto>) req.getSession().getAttribute("repuestosAgregados");
        if (repuestosAgregados == null) {
            repuestosAgregados = new ArrayList<>();
        }

        String idCliente = req.getParameter("idCliente");
        String idOrden = req.getParameter("idOrden");

        // Inicializar clienteData
        clienteData = new ClienteData();

        // Obtener cliente con idCliente
        Cliente cliente = clienteData.findOne(idCliente);

        // Pasar atributos al JSP
        req.setAttribute("idCliente", idCliente);
        req.setAttribute("idOrden", idOrden);
        req.setAttribute("repuestosAgregados", repuestosAgregados);
        req.setAttribute("cliente", cliente);

        // Solo un forward
        req.getRequestDispatcher("facturaResumen.jsp").forward(req, resp);

    } catch (Exception ex) {
        Logger.getLogger(MostrarFacturaServlet.class.getName()).log(Level.SEVERE, null, ex);
        resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al mostrar la factura.");
    }
}
}
