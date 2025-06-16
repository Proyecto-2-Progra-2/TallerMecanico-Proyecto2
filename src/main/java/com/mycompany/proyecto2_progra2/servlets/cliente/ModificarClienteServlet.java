package com.mycompany.proyecto2_progra2.servlets.cliente;

import com.mycompany.proyecto2_progra2.data.ClienteData;
import com.mycompany.proyecto2_progra2.domain.Cliente;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

public class ModificarClienteServlet extends HttpServlet {

    private ClienteData clienteData;

    @Override
    public void init() {
        try {
            clienteData = new ClienteData();
        } catch (IOException | JDOMException ex) {
            Logger.getLogger(ModificarClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            Cliente cliente = clienteData.findOne(id);
            req.setAttribute("cliente", cliente);
            // Usa ruta absoluta para evitar problemas
            req.getRequestDispatcher("/modificar_clientes.jsp").forward(req, resp);
        } catch (Exception ex) {
            Logger.getLogger(ModificarClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al cargar el cliente");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Obtener datos del formulario
            Cliente cliente = new Cliente(
                req.getParameter("id"),
                req.getParameter("nombre"),
                req.getParameter("primerApellido"),
                req.getParameter("segundoApellido"),
                Integer.parseInt(req.getParameter("telefono")),
                req.getParameter("direccion"),
                req.getParameter("email")
            );

            // Actualizar cliente
            clienteData.actualizar(cliente);

            // Redirigir o volver al formulario con algún mensaje (aquí simplemente lo volvemos a cargar)
            req.setAttribute("cliente", cliente);
            req.setAttribute("mensaje", "Cliente actualizado exitosamente");
            req.getRequestDispatcher("/modificar_clientes.jsp").forward(req, resp);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModificarClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Archivo no encontrado");
        } catch (Exception ex) {
            Logger.getLogger(ModificarClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error inesperado");
        }
    }
}
