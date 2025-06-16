package com.mycompany.proyecto2_progra2.servlets.cliente;

import com.mycompany.proyecto2_progra2.data.ClienteData;
import com.mycompany.proyecto2_progra2.domain.Cliente;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

public class ActualizarClienteServlet extends HttpServlet {

    private ClienteData clienteData;

    @Override
    public void init() {
        try {
            clienteData = new ClienteData();
        } catch (IOException ex) {
            Logger.getLogger(ActualizarClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JDOMException ex) {
            Logger.getLogger(ActualizarClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String nombre = req.getParameter("nombre");
        String primerApellido = req.getParameter("primerApellido");
        String segundoApellido = req.getParameter("segundoApellido");
        int telefono = Integer.parseInt(req.getParameter("telefono"));
        String direccion = req.getParameter("direccion");
        String email = req.getParameter("email");
        Cliente cliente = new Cliente(id, nombre, primerApellido, segundoApellido, telefono, direccion, email);
        clienteData.actualizar(cliente);  // Método que debes tener para actualizar
        // Rediriges a la lista o confirmación
        resp.sendRedirect("mostrarClientes");
    }
}
