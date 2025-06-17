package com.mycompany.proyecto2_progra2.servlets.vehiculo;



import com.mycompany.proyecto2_progra2.data.ClienteData;
import com.mycompany.proyecto2_progra2.domain.Cliente;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

public class MostrarClienteServlet extends HttpServlet {

    private ClienteData clienteData;

    @Override
    public void init() {
        try {
            clienteData = new ClienteData();
        } catch (IOException | JDOMException ex) {
            Logger.getLogger(MostrarClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            Cliente cliente = clienteData.findOne(id);
            req.setAttribute("cliente", cliente);
            req.getRequestDispatcher("/ver_cliente.jsp").forward(req, resp);
        } catch (Exception ex) {
            Logger.getLogger(MostrarClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al cargar la información del cliente");
        }
    }
}
